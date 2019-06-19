package com.example.arsux;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.measure.unit.NonSI;

import FAsensors.FAsensorsModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import de.nitri.gauge.Gauge;

public class Fragment_ARS extends Fragment {


    private FragmentsModel fragmentsModel;

    public static Fragment_ARS newInstance() {
        return new Fragment_ARS();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__ar_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getFragmentsModel();
        initTelemetrySignals();
        initSensorListView();
        initSensorUX();
        setFanAnimation();
        initUXupdateAnimator();
    }


    public void initSensorValues() {

          ((TextView)this.getActivity().findViewById(R.id.ts02_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS02_TP.geteValue()[0].toString(false));
          ((TextView)this.getActivity().findViewById(R.id.ts21_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS21_TP.geteValue()[0].toString(false));
          ((TextView)this.getActivity().findViewById(R.id.ts20_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS20_TP.geteValue()[0].toString(false));
          ((TextView)this.getActivity().findViewById(R.id.ts19_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS19_TP.geteValue()[0].toString(false));
          ((TextView)this.getActivity().findViewById(R.id.ts01_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS01_TP.geteValue()[0].toString(false));


          ((TextView)this.getActivity().findViewById(R.id.ns01_sensor).findViewById(R.id.textViewdp)).setText(fragmentsModel.fAsensorsModel.AR_DP_Fn01_TP.geteValue()[0].toString(false));
          ((TextView)this.getActivity().findViewById(R.id.ns01_sensor).findViewById(R.id.textViewspeed)).setText(fragmentsModel.fAsensorsModel.AR_NS_Fn01_TP.geteValue()[0].toString(false));
            ((TextView)this.getActivity().findViewById(R.id.ts04_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TS04_TP .geteValue()[0].toString(false));
            ((TextView)this.getActivity().findViewById(R.id.co01_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_CO01_TP .geteValue()[0].toString(false));
            ((TextView)this.getActivity().findViewById(R.id.dp01_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_DP_01_TP.geteValue()[0].toString(false));
            ((TextView)this.getActivity().findViewById(R.id.dp01_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_DP_01_TP.geteValue()[0].toString(false));
            ((TextView)this.getActivity().findViewById(R.id.tc03_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_TC3_TP  .geteValue()[0].toString(false));

             ((TextView)this.getActivity().findViewById(R.id.ns02_sensor).findViewById(R.id.textViewdp)).setText(fragmentsModel.fAsensorsModel.AR_DP_Fn02_TP  .geteValue()[0].toString(false));
             ((TextView)this.getActivity().findViewById(R.id.ns02_sensor).findViewById(R.id.textViewspeed)).setText(fragmentsModel.fAsensorsModel.AR_NS_Fn02_TP  .geteValue()[0].toString(false));

        ((TextView)this.getActivity().findViewById(R.id.ps02_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_PS02_TP  .geteValue()[0].toString(false));
        ((TextView)this.getActivity().findViewById(R.id.ps01_sensor).findViewById(R.id.textViewvalue)).setText(fragmentsModel.fAsensorsModel.AR_PS01_TP  .geteValue()[0].toString(false));

         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewar)).setText(fragmentsModel.fAsensorsModel.AR_Sn01ArPa_TP .geteValue()[0].toString(false));
         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewco2)).setText(fragmentsModel.fAsensorsModel.AR_Sn01CO2Pa_TP .geteValue()[0].toString(false));
         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewh2o)).setText(fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP .geteValue()[0].toString(false));
         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewn2)).setText(fragmentsModel.fAsensorsModel.AR_Sn01N2Pa_TP .geteValue()[0].toString(false));
         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewo2)).setText(fragmentsModel.fAsensorsModel.AR_Sn01O2Pa_TP .geteValue()[0].toString(false));
         ((TextView)this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewch4)).setText(fragmentsModel.fAsensorsModel.AR_Sn01CH4_TP   .geteValue()[0].toString(false));


    }

    public void initSensorUX() {
        initSensorValues();
        fragmentsModel.fAsensorsModel.AR_TS02_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts02_sensor), this.getActivity().findViewById(R.id.ts02_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_TS21_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts21_sensor), this.getActivity().findViewById(R.id.ts21_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_TS20_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts20_sensor), this.getActivity().findViewById(R.id.ts20_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_TS19_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts19_sensor), this.getActivity().findViewById(R.id.ts19_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_TS01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts01_sensor), this.getActivity().findViewById(R.id.ts01_sensor).findViewById(R.id.textViewvalue));

        //Fan 1
        fragmentsModel.fAsensorsModel.AR_DP_Fn01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ns01_sensor), this.getActivity().findViewById(R.id.ns01_sensor).findViewById(R.id.textViewdp));
        //  sensorSignals.ARm_IS57_TP.setFrameViewandTextView(findViewById(R.id.ns01_sensor), findViewById(R.id.ns01_sensor).findViewById(R.id.textViewcurr));
        fragmentsModel.fAsensorsModel.AR_NS_Fn01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ns01_sensor), this.getActivity().findViewById(R.id.ns01_sensor).findViewById(R.id.textViewspeed));

        fragmentsModel.fAsensorsModel.AR_TS04_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ts04_sensor), this.getActivity().findViewById(R.id.ts04_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_CO01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.co01_sensor), this.getActivity().findViewById(R.id.co01_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_DP_01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.dp01_sensor), this.getActivity().findViewById(R.id.dp01_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_DP_01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.dp01_sensor), this.getActivity().findViewById(R.id.dp01_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_TC3_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.tc03_sensor), this.getActivity().findViewById(R.id.tc03_sensor).findViewById(R.id.textViewvalue));

        // Fan 2
        fragmentsModel.fAsensorsModel.AR_DP_Fn02_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ns02_sensor), this.getActivity().findViewById(R.id.ns02_sensor).findViewById(R.id.textViewdp));
        //arsSignalModel.ARm_IS58_TP.setFrameViewandTextView(findViewById(R.id.ns02_sensor), findViewById(R.id.ns02_sensor).findViewById(R.id.textViewcurr));
        fragmentsModel.fAsensorsModel.AR_NS_Fn02_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ns02_sensor), this.getActivity().findViewById(R.id.ns02_sensor).findViewById(R.id.textViewspeed));

        // Fan 3
        // fAsensorsModel.AR_NS03_TP.setFrameViewandTextView(findViewById(R.id.ns03_sensor), findViewById(R.id.ns03_sensor).findViewById(R.id.textViewspeed));
       // fragmentsModel.fAsensorsModel.AR_TS39_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ns03_sensor), this.getActivity().findViewById(R.id.ns03_sensor).findViewById(R.id.textViewdp));
        // sensorSignals.ARS_IXxx.setFrameViewandTextView(findViewById(R.id.ns03_sensor), findViewById(R.id.ns03_sensor).findViewById(R.id.textViewcurr));


        fragmentsModel.fAsensorsModel.AR_PS02_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ps02_sensor), this.getActivity().findViewById(R.id.ps02_sensor).findViewById(R.id.textViewvalue));
        fragmentsModel.fAsensorsModel.AR_PS01_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.ps01_sensor), this.getActivity().findViewById(R.id.ps01_sensor).findViewById(R.id.textViewvalue));
        // sensorSignals.ARm_TS07.setFrameViewandTextView(findViewById(R.id.ps01_sensor), findViewById(R.id.ps01_sensor).findViewById(R.id.textViewvalue));

        fragmentsModel.fAsensorsModel.AR_Sn01ArPa_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewar));
        fragmentsModel.fAsensorsModel.AR_Sn01CO2Pa_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewco2));
        fragmentsModel.fAsensorsModel.AR_Sn01H2OPa_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewh2o));
        fragmentsModel.fAsensorsModel.AR_Sn01N2Pa_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewn2));
        fragmentsModel.fAsensorsModel.AR_Sn01O2Pa_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewo2));
        fragmentsModel.fAsensorsModel.AR_Sn01CH4_TP.setFrameViewandTextView(this.getActivity().findViewById(R.id.sam_sensor), this.getActivity().findViewById(R.id.sam_sensor).findViewById(R.id.textViewch4));


        if (fragmentsModel.fAsensorsModel.AR_PS01_TP.geteValue() != null) {
            fragmentsModel.fAsensorsModel.AR_PS01_TP.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                    double x = (double) fragmentsModel.fAsensorsModel.AR_PS01_TP.geteValue()[0].getNominalValue().doubleValue(NonSI.POUND_PER_SQUARE_INCH_A);
                    if(x < 12.0 && x > 1.3) {
                        //transitioning
                        updateBedUX(-1);
                    } else if (x > 12.0 ) {
                        updateBedUX(0);
                    } else {
                        updateBedUX(1);
                    }
                }
            });
        }

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

    private void updateUX(ValueAnimator valueAnimator) {
        // update the sensor signals
        fragmentsModel.fAsensorsModel.updateSignalSet();


    }

    private void initTelemetrySignals() {
        if (fragmentsModel.fAsensorsModel == null) {
            fragmentsModel.fAsensorsModel = new FAsensorsModel(fragmentsModel);
        }
    }

    private void initSensorListView() {
        ListView ars_sensor_list = this.getActivity().findViewById(R.id.ars_signal_listview);
        DDS_Signal[] array = fragmentsModel.fAsensorsModel.getRoot().getSignalsAsArray();
        DDSSignalAdapter ddsSignalAdapter = new DDSSignalAdapter(this.getContext(), array, fragmentsModel);
        ars_sensor_list.setAdapter(ddsSignalAdapter);
        ars_sensor_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getContext(), signals[position], Toast.LENGTH_SHORT).show();
            }


        });
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

    private ImageView fan1;
    private ImageView fan2;

    private void setFanAnimation() {
        fan1 = this.getActivity().findViewById(R.id.fan1);
        Animation fan1animation = AnimationUtils.loadAnimation(this.getActivity().getApplicationContext(), R.anim.fan1_animation);
        fan1.startAnimation(fan1animation);

        fan2 = this.getActivity().findViewById(R.id.fan2);
        Animation fan2animation = AnimationUtils.loadAnimation(this.getActivity().getApplicationContext(), R.anim.fan2_animation);
        fan2.startAnimation(fan2animation);

    }

    public void updateBedUX(int bed) {
       // System.out.println("in UpdateBedUX " + this.getActivity());
        if (this.getActivity()!=null) {

            View bedA = this.getActivity().findViewById(R.id.co2_bed_a);
            View bedB = this.getActivity().findViewById(R.id.co2_bed_b);
            TextView textViewA = this.getActivity().findViewById(R.id.co2_bed_a).findViewById(R.id.textViewsorbing);
            TextView textViewA1 = this.getActivity().findViewById(R.id.co2_bed_a).findViewById(R.id.textViewbedid);
            TextView textViewB = this.getActivity().findViewById(R.id.co2_bed_b).findViewById(R.id.textViewsorbing);
            TextView textViewB1 = this.getActivity().findViewById(R.id.co2_bed_b).findViewById(R.id.textViewbedid);
            if (bed < 0) {
                bedA.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.transitionBedColor));
                bedB.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.transitionBedColor));
                textViewA1.setText("Bed A");
                textViewA.setText("Transitioning");

                textViewB1.setText("Bed B");
                textViewB.setText("Transitioning");
            } else if (bed == 0) {
                bedA.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.coolBedColor));
                bedB.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.hotBedColor));
                textViewA1.setText("Bed A");
                textViewA.setText("Adsorbing CO2");

                textViewB1.setText("Bed B");
                textViewB.setText("Desorbing CO2");

            } else {
                bedA.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.hotBedColor));
                bedB.findViewById(R.id.bedcolor_frame).setBackgroundColor(getResources().getColor(R.color.coolBedColor));
                textViewA1.setText("Bed A");
                textViewA.setText("Desorbing CO2");

                textViewB1.setText("Bed B");
                textViewB.setText("Adsorbing CO2");

            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        simulator.cancel();
    }

}
