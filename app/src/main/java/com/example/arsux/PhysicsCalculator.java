package com.example.arsux;




import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.emeasureandroidlib.EMeasure;
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.StatusKind;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.measure.Measure;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import de.nitri.gauge.Gauge;


public class PhysicsCalculator {

    public static EMeasure getHumidity(DDS_Signal tempSignal, DDS_Signal pressSignal) {
        double t = tempSignal.geteValue()[0].getNominalValue().doubleValue(SI.CELSIUS);

        double ps = 611.21*Math.exp((18.678 - (t/234.5))*(t/(257.14+t)));

        EMeasure psat =  new EMeasure("P saturation", SI.PASCAL);
        psat.setNominalValue(Measure.valueOf(ps, SI.PASCAL ));
        double ps_psia = psat.getNominalValue().doubleValue(NonSI.POUND_PER_SQUARE_INCH_A);
        double pwater = pressSignal.geteValue()[0].getNominalValue().doubleValue(NonSI.POUND_PER_SQUARE_INCH_A);
        double rh = 100.0*pwater/ps_psia;
        //System.out.println("T = "+ t + " ps_psia = "+ ps_psia + " ps = " + ps + " rh = " + rh + " pwater = " + pwater);
        EMeasure rheM = new EMeasure("Relative Humidity", NonSI.PERCENT);
        rheM.setNominalValue(Measure.valueOf(rh, NonSI.PERCENT ));
        return rheM;
    }

    public static EMeasure getDewpoint(DDS_Signal pressSignal) {
        double p = pressSignal.geteValue()[0].getNominalValue().doubleValue(NonSI.POUND_PER_SQUARE_INCH_A);
        double tsat = 281.36-Math.sqrt(-12429*Math.log(p/13.202));
        EMeasure dew = new EMeasure("Dew Point", NonSI.FAHRENHEIT);
        dew.setNominalValue(Measure.valueOf(tsat, NonSI.FAHRENHEIT ));
        return dew;
    }


    public static int initDDS(FragmentsModel fragmentsModel) {
        int i = PhysicsCalculator.initParticipant(fragmentsModel);
        int j = PhysicsCalculator.initSubscriber(fragmentsModel);
        int k = PhysicsCalculator.initPublisher(fragmentsModel);
        return i + j + k;
    }


    public static int initParticipant(FragmentsModel fragmentsModel) {
        int e = 0;
        fragmentsModel.participant = DomainParticipantFactory.TheParticipantFactory.
                create_participant(
                        fragmentsModel.domainId,
                        DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT,
                        null /* listener */,
                        StatusKind.STATUS_MASK_NONE);
        // System.out.println("Participant: " + participant.toString());
        if (fragmentsModel.participant == null) {
            //  System.err.println("Create Participant ERROR!\n");
            e = 1;
        }
        return e;
    }

    public static int initSubscriber(FragmentsModel fragmentsModel) {
        int e = 0;
        if(fragmentsModel.participant != null) {
            fragmentsModel.subscriber = fragmentsModel.participant.create_subscriber(
                    DomainParticipant.SUBSCRIBER_QOS_DEFAULT,
                    null /* listener */,
                    StatusKind.STATUS_MASK_NONE);
            // System.out.println("subscriber: " + subscriber.toString());
        }
        if (fragmentsModel.subscriber == null) {
            // System.err.println("Create Subscriber ERROR!\n");
            e = 1;
        }
        return e;

    }

    public static int initPublisher(FragmentsModel fragmentsModel) {
        int e = 0;
        if(fragmentsModel.participant != null) {
            fragmentsModel.publisher = fragmentsModel.participant.create_publisher(
                    DomainParticipant.PUBLISHER_QOS_DEFAULT, null /* listener */,
                    StatusKind.STATUS_MASK_NONE);
            // System.out.println("publisher: " + publisher.toString());
        }
        if (fragmentsModel.publisher == null) {
            // System.err.println("Create publisher ERROR!\n");
            e = 1;

        }
        return e;
    }

    public static void displaySchematicItemInfo(DDS_Signal signal, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.sensor_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.diag_description);
        Gauge gauge = (Gauge) dialog.findViewById(R.id.sensor_dialog_gauge);
        TextView value = (TextView)dialog.findViewById(R.id.sensor_dialog_value);
        Button button = dialog.findViewById(R.id.diag_dismiss_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.setTitle("Sensor: " + signal.getTagName());
        text.setText(signal.getDescription());
        gauge.setValue(signal.geteValue()[0].getNominalValue().floatValue(signal.geteValue()[0].getUnit()));
        value.setText(signal.geteValue()[0].toString(false));
        //System.out.println("Temperature Sensor 1");
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                value.setText(signal.geteValue()[0].toString(false));
                gauge.setValue(signal.geteValue()[0].getNominalValue().floatValue(signal.geteValue()[0].getUnit()));
            }
        };
        signal.geteValue()[0].addPropertyChangeListener(listener);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                signal.geteValue()[0].removePropertyChangeListener(listener);
            }
        });
        dialog.show();
    }



} //end of class

