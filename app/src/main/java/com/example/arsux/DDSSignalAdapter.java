package com.example.arsux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emeasureandroidlib.EMeasure;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.measure.unit.Unit;

import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;


public class DDSSignalAdapter extends ArrayAdapter<DDS_Signal> {


    private FragmentsModel fragmentsModel;

    public DDSSignalAdapter(Context context, DDS_Signal[] dds_signals, FragmentsModel fragmentsModel) {
        super(context, 0, dds_signals);
        this.fragmentsModel = fragmentsModel;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DDS_Signal theSignal = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }
        TextView tagTextView   =  convertView.findViewById(R.id.tag_name_textview);
        TextView valueTextView =  convertView.findViewById(R.id.value_textview);
        TextView titleTextView =  convertView.findViewById(R.id.title_textView);
        ImageView icon = convertView.findViewById(R.id.imageIcon1);

        switch(theSignal.getSignalType()) {
            case information:
                tagTextView.setText("");
                valueTextView.setText("");
                titleTextView.setText(theSignal.getTagName());
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.blank_square, null));
                break;
            case fault:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.blank_square, null));
                if(theSignal.getValue() != null) {
                    valueTextView.setText(theSignal.getValue()[0].toString());
                } else {
                    valueTextView.setText("N/A");
                }
                break;
            case unknown:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.blank_square, null));
                if(theSignal.getValue() != null) {
                    valueTextView.setText(theSignal.getValue()[0].toString());
                } else {
                    valueTextView.setText("N/A");
                }
                break;
            case command:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.cmd3, null));
                if(theSignal.getValue() != null) {
                    valueTextView.setText(theSignal.getValue()[0].toString());
                } else {
                    valueTextView.setText("N/A");
                }
                break;
            case on_off_position_cmd:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
                if(theSignal.getValue() != null) {
                    EMeasure value = theSignal.geteValue()[0];
                   // setEMeasureListener(theSignal, valueTextView);
                    if(value.getNominalValue().doubleValue(Unit.ONE) == 0.0) {
                        icon.setBackground(convertView.getResources().getDrawable(R.drawable.valve_closed, null));
                        valueTextView.setText(value.toString(false));
                    } else {
                        icon.setBackground(convertView.getResources().getDrawable(R.drawable.valve_open, null));
                        valueTextView.setText(value.toString(false));
                    }

                } else {
                    icon.setBackground(convertView.getResources().getDrawable(R.drawable.valve_closed, null));
                    valueTextView.setText("N/A");
                }
                break;
            case on_off_heater_cmd:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
                if(theSignal.getValue() != null) {
                    EMeasure value = theSignal.geteValue()[0];
                   // setEMeasureListener(theSignal, valueTextView);
                    if(value.getNominalValue().doubleValue(Unit.ONE) == 0.0) {
                        icon.setBackground(convertView.getResources().getDrawable(R.drawable.heater_off, null));
                        valueTextView.setText(value.toString(false));
                    } else {
                        icon.setBackground(convertView.getResources().getDrawable(R.drawable.heater_on, null));
                        valueTextView.setText(value.toString(false));
                    }

                } else {
                    icon.setBackground(convertView.getResources().getDrawable(R.drawable.heater_off, null));
                    valueTextView.setText("N/A");
                }
                break;
            default:
                tagTextView  .setText(theSignal.getTagName());
                titleTextView.setText("");
               setSignalIcon(convertView, theSignal.getSignalType(), icon);
                //System.err.println("************************* " + theSignal.getSignalType().toString());
                //setEMeasureListener(theSignal, valueTextView);
                EMeasure[] eM = theSignal.geteValue();
                EMeasure em = eM[0];
                if(eM.length == 1) {
                    valueTextView.setText(em.toString(false));
                } else {
                    valueTextView.setText(em.toString(false) + " +");
                }
                break;
        }
        return convertView;
    }


//    private void setEMeasureListener(DDS_Signal signal, TextView textView) {
//        String listenerName = signal.getTagName()+"ListListener";
//        if(!signal.geteMeasureListeners().contains(listenerName)) {
//            signal.geteMeasureListeners().add(listenerName);
//            signal.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
//                @Override
//                public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
//                    textView.setText(signal.geteValue()[0].toString(false));
//                }
//            });
//        }
//    }

    public void setSignalIcon(View convertView, SignalType signalType, ImageView icon) {
        switch(signalType) {
            case abs_pressure_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.pressure_icon, null));
                break;
            case current_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.current_icon, null));
                break;
            case volt_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.current_icon, null));
                break;
            case power_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.current_icon, null));
                break;
            case discrete_position_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.angle_icon, null));
                break;
            case position_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.angle_icon, null));
                break;
            case argon_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case ch4_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case co2_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case water_vapor_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case gauge_pressure_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.pressure_icon, null));
                break;
            case motor_speed_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.motor_speed_icon, null));
                break;
            case n2_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case o2_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.gas_tank, null));
                break;
            case temp_sensor:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.temp_icon, null));
                break;
            default:
                icon.setBackground(convertView.getResources().getDrawable(R.drawable.telemetry_icon, null));
                break;
        }
    }

    public FragmentsModel getFragmentsModel() {
        if(fragmentsModel==null) {
            fragmentsModel = new FragmentsModel();
        }
        return fragmentsModel;
    }

}
