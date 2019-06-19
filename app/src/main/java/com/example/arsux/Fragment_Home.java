package com.example.arsux;

import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emeasureandroidlib.EMeasure;
import com.rti.dds.infrastructure.Time_t;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.measure.unit.NonSI;

import FAsensors.FAsensorsModel;
import MySupportClasses.FragmentsModel;
import de.nitri.gauge.Gauge;



public class Fragment_Home extends Fragment {


    private FragmentsModel fragmentsModel;

    private Gauge tempGauge;
    private Gauge humGauge;
    private Gauge dewGauge;
    private Gauge co2Gauge;



    public static Fragment_Home newInstance() {
        return new Fragment_Home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            getFragmentsModel();
            initSensorSignals();
            initGauges();
            initUXupdateAnimator();

    }

    private ValueAnimator simulator;
    private void initUXupdateAnimator() {
        simulator = ValueAnimator.ofInt(0, 1000);
        simulator.setDuration(1000000);

        simulator.setInterpolator(new LinearInterpolator());
        simulator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                updateUX(valueAnimator);
            }
        });
        simulator.start();
    }

    private void initGauges() {

        // Temperature Gauge
        tempGauge = this.getActivity().findViewById(R.id.gauge_temp);
        tempGauge.setMinValue(0.0f);
        tempGauge.setMaxValue(100.0f);
        tempGauge.setValuePerNick(5.0f);
        tempGauge.setMajorNickInterval(5);
        tempGauge.setTotalNicks(30);
        tempGauge.setUpperText("Temperature");
        EMeasure eM = fragmentsModel.fAsensorsModel.AR_TS01_TP.geteValue()[0];
        tempGauge.setLowerText(eM.toString(false));
        tempGauge.setValue(eM.getNominalValue().floatValue(NonSI.FAHRENHEIT));

        fragmentsModel.fAsensorsModel.AR_TS01_TP.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                EMeasure eM = fragmentsModel.fAsensorsModel.AR_TS01_TP.geteValue()[0];
                tempGauge.setLowerText(eM.toString(false));
                tempGauge.setValue(eM.getNominalValue().floatValue(NonSI.FAHRENHEIT));
            }
        });



        humGauge = this.getActivity().findViewById(R.id.gauge_humidity);
        humGauge.setMinValue(0.0f);
        humGauge.setMaxValue(100.0f);
        humGauge.setValuePerNick(5.0f);
        humGauge.setMajorNickInterval(5);
        humGauge.setTotalNicks(30);

        EMeasure eMhum = PhysicsCalculator.getHumidity(fragmentsModel.fAsensorsModel.AR_TS01_TP, fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP);
        humGauge.setValue(eMhum.getNominalValue().floatValue(NonSI.PERCENT));
        humGauge.setLowerText(eMhum.toString(false));
        humGauge.setUpperText("Humidity");
        fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                EMeasure eM = PhysicsCalculator.getHumidity(fragmentsModel.fAsensorsModel.AR_TS01_TP, fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP);
                humGauge.setValue(eM.getNominalValue().floatValue(NonSI.PERCENT));
                humGauge.setLowerText(eM.toString(false));
            }
        });

        dewGauge = this.getActivity().findViewById(R.id.gauge_dewpoint);
        dewGauge.setMinValue(0.0f);
        dewGauge.setMaxValue(100.0f);
        dewGauge.setValuePerNick(5.0f);
        dewGauge.setMajorNickInterval(5);
        dewGauge.setTotalNicks(30);
        EMeasure eMdew = PhysicsCalculator.getDewpoint(fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP);
        dewGauge.setValue(eMdew.getNominalValue().floatValue(NonSI.FAHRENHEIT));
        dewGauge.setLowerText(eMdew.toString(false));
        dewGauge.setUpperText("Dew Point");
        fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                EMeasure eM = PhysicsCalculator.getDewpoint(fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP);
                dewGauge.setValue(eM.getNominalValue().floatValue(NonSI.FAHRENHEIT));
                dewGauge.setLowerText(eM.toString(false));
            }
        });


        co2Gauge = this.getActivity().findViewById(R.id.gauge_co2);
        co2Gauge.setMinValue(0.0f);
        co2Gauge.setMaxValue(10.0f);
        co2Gauge.setValuePerNick(0.5f);
        co2Gauge.setMajorNickInterval(2);
        co2Gauge.setTotalNicks(30);
        co2Gauge.setUpperText("CO2");
        EMeasure eMco2 = fragmentsModel.fAsensorsModel.AR_CO01_TP.geteValue()[0];
        co2Gauge.setValue(eMco2.getNominalValue().floatValue(NonSI.MILLIMETER_OF_MERCURY));
        co2Gauge.setLowerText(eMco2.toString(false));
        fragmentsModel.fAsensorsModel.AR_CO01_TP.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                EMeasure eM = fragmentsModel.fAsensorsModel.AR_CO01_TP.geteValue()[0];
                co2Gauge.setValue(eM.getNominalValue().floatValue(NonSI.MILLIMETER_OF_MERCURY));
                co2Gauge.setLowerText(eM.toString(false));
            }
        });




    }

    private void initSensorSignals() {
        if (fragmentsModel.fAsensorsModel == null) {
            fragmentsModel.fAsensorsModel = new FAsensorsModel(fragmentsModel);
        }
    }

    private void updateUX(ValueAnimator valueAnimator) {
        fragmentsModel.fAsensorsModel.updateSignalSet();
        if(this.getActivity() != null) {
            TextView tView = this.getActivity().findViewById(R.id.comm_text);
            if (fragmentsModel.fAsensorsModel.isCommActive()) {
                tView.setText("Communication: Nominal");
                if (fragmentsModel.startTime == null) {

                    fragmentsModel.startTime = fragmentsModel.fAsensorsModel.info.source_timestamp.sec;
                }
                // update the sensor signals
                fragmentsModel.fAsensorsModel.updateSignalSet();
                int time = fragmentsModel.fAsensorsModel.info.source_timestamp.sec - fragmentsModel.startTime;
                TextView textView = this.getActivity().findViewById(R.id.time_text);
                textView.setText("Time: "+ time + " [s]");
//                System.out.println("Time: " + time);
            } else {
                tView.setText("Communication: Not Available");
            }
        }
    }

    public FragmentsModel getFragmentsModel() {
        if (fragmentsModel == null) {
            fragmentsModel = new FragmentsModel();
        }
        return fragmentsModel;
    }

    public void setFragmentsModel(FragmentsModel fragmentsModel) {
        this.fragmentsModel = fragmentsModel;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        simulator.cancel();
    }

}
