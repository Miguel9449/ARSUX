package MySupportClasses;
//
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//



import android.view.View;
import android.widget.TextView;

import com.example.emeasureandroidlib.EMeasure;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.measure.Measure;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;


/**
 *
 * @author miguel
 */
public class DDS_Signal {
    
    private String tagName;
    
    private EMeasure[] eValue;
    private SignalStatus status;
    private String description;
    private String source;
    private Class dataType;
    private Object[] value;
   
    private SignalType signalType;
    private SignalSource signalSource;

    private List<DDS_Signal> children;

    private final List<String> eMeasureListeners = new ArrayList<>();



    public DDS_Signal() {
        this.initMe();
    }
    
     public DDS_Signal(String tagName, Class dataType, String source) {
        this.initMe();
        this.tagName = tagName;
        this.dataType = dataType;
        this.source = source;
    }

    public DDS_Signal(String tagName, Class dataType, String description, String source) {
        this.initMe();
        this.tagName = tagName;
        this.dataType = dataType;
        this.description = description;
        this.source = source;
    }
    
    public DDS_Signal(String tagName, Class dataType, String description, String source, SignalType sType, SignalSource sSource) {
        this.initMe();
        this.tagName = tagName;
        this.dataType = dataType;
        this.description = description;
        this.source = source;
        this.signalType = sType;
        this.signalSource = sSource;
    }


    
     private void initMe() {
        tagName = "";
        // eValue = new EMeasure("Signal", SI.CYCLE);
        status = SignalStatus.UNKNOWN;
        description = "A DDS Signal";
        source = "Unknown:";
        dataType = null;
        value = new Object[]{13.31};
        signalType = SignalType.unknown;

        
    }
     
       // Factories

    public static DDS_Signal createDDSSignal(String tagName, SignalType signalType) {
        DDS_Signal dds_Signal = new DDS_Signal();
        dds_Signal.setTagName(tagName);
        dds_Signal.setSignalType(signalType);
        EMeasure[] eM = new EMeasure[1];
        eM[0] = new EMeasure();
        dds_Signal.seteValue(eM);
        switch(signalType) {
            case rootSet:
                break;
            case command:
                eM[0].setName(tagName);
                eM[0].setUnit(Unit.ONE);
                eM[0].setNominalValue(Measure.valueOf(68.3,Unit.ONE));
                break;
            case temp_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.FAHRENHEIT);
                eM[0].setNominalValue(Measure.valueOf(68.3,NonSI.FAHRENHEIT ));
                break;
            case abs_pressure_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.POUND_PER_SQUARE_INCH_A );
                eM[0].setNominalValue(Measure.valueOf(13.3,NonSI.POUND_PER_SQUARE_INCH_A ));
                break;
            case gauge_pressure_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.INCH_OF_WATER);
                eM[0].setNominalValue(Measure.valueOf(1.2,NonSI.INCH_OF_WATER));
                break;
            case position_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.DEGREE_ANGLE);
                eM[0].setNominalValue(Measure.valueOf(25.0,NonSI.DEGREE_ANGLE));
                break;
            case discrete_position_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(Unit.ONE);
                eM[0].setNominalValue(Measure.valueOf(25.0,Unit.ONE));
                break;
            case motor_speed_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.KILO_RPM);
                eM[0].setNominalValue(Measure.valueOf(12.0,NonSI.KILO_RPM));
                break;
            case co2_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.MILLIMETER_OF_MERCURY);
                eM[0].setNominalValue(Measure.valueOf(6.2,NonSI.MILLIMETER_OF_MERCURY));
                break;
            case current_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.AMPERE);
                eM[0].setNominalValue(Measure.valueOf(0.613,SI.AMPERE));
                break;
            case n2_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.MILLIMETER_OF_MERCURY);
                eM[0].setNominalValue(Measure.valueOf(5.2,NonSI.MILLIMETER_OF_MERCURY));
                break;
            case o2_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.MILLIMETER_OF_MERCURY);
                eM[0].setNominalValue(Measure.valueOf(4.2,NonSI.MILLIMETER_OF_MERCURY));
                break;
            case ch4_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.PPM);
                eM[0].setNominalValue(Measure.valueOf(3.2,NonSI.PPM));
                break;
            case argon_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.MILLIMETER_OF_MERCURY);
                eM[0].setNominalValue(Measure.valueOf(2.2,NonSI.MILLIMETER_OF_MERCURY));
                break;
            case water_vapor_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(NonSI.MILLIMETER_OF_MERCURY);
                eM[0].setNominalValue(Measure.valueOf(1.2,NonSI.MILLIMETER_OF_MERCURY));
                break;
            case some_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(Unit.ONE);
                eM[0].setNominalValue(Measure.valueOf(1.2,Unit.ONE));
                break;
            case mass_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.KILOGRAM);
                eM[0].setNominalValue(Measure.valueOf(1.2,SI.KILOGRAM));
                break;
            case massFlowRate:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.KILOGRAM_PER_SECOND);
                eM[0].setNominalValue(Measure.valueOf(1.2,SI.KILOGRAM_PER_SECOND));
                break;
            case on_off_position_cmd:
                eM[0].setName(tagName);
                eM[0].setUnit(Unit.ONE);
                eM[0].setNominalValue(Measure.valueOf(0,Unit.ONE));
                eM[0].setDecimalPlaces(0);
                break;
            case on_off_heater_cmd:
                eM[0].setName(tagName);
                eM[0].setUnit(Unit.ONE);
                eM[0].setNominalValue(Measure.valueOf(0,Unit.ONE));
                eM[0].setDecimalPlaces(0);
                break;
            case power_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.WATT);
                eM[0].setNominalValue(Measure.valueOf(0,SI.WATT));
                eM[0].setDecimalPlaces(0);
                break;
            case volt_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.VOLT);
                eM[0].setNominalValue(Measure.valueOf(0,SI.VOLT));
                eM[0].setDecimalPlaces(0);
                break;
            case conductivity_sensor:
                eM[0].setName(tagName);
                eM[0].setUnit(SI.SIEMENS.divide(SI.CENTIMETER));
                eM[0].setNominalValue(Measure.valueOf(0,SI.SIEMENS.divide(SI.CENTIMETER)));
                eM[0].setDecimalPlaces(0);
                break;
            default:
                dds_Signal.seteValue(null);
            case physical:
                break;


        }

        //System.out.println("************************* Signal" + tagName + " ," + signalType +  );
        return dds_Signal;
    }


    public void updateeMeasure(Double[] value, Unit unit) {
        if(value[0].getClass().isAssignableFrom(Double.class)) {
            switch (signalType) {
                case command:
                    if (unit.isCompatible(Unit.ONE)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                        }
                    }
                    break;
                case temp_sensor:
                    if (unit.isCompatible(SI.KELVIN)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                        }
                    }
                    break;
                case abs_pressure_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                        }
                    }
                    break;
                case gauge_pressure_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case position_sensor:
                    if (unit.isCompatible(NonSI.DEGREE_ANGLE)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case motor_speed_sensor:
                    if (unit.isCompatible(NonSI.KILO_RPM)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case co2_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case current_sensor:
                    if (unit.isCompatible(SI.AMPERE)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case n2_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case o2_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case ch4_sensor:
                    if (unit.isCompatible(NonSI.PPM)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case argon_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }


                    }
                    break;
                case water_vapor_sensor:
                    if (unit.isCompatible(SI.PASCAL)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                    }
                    break;
                case power_sensor:
                if (unit.isCompatible(SI.WATT)) {
                    for(int i=0;i< eValue.length;i++) {
                        this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                    }

                }
                break;
                case massFlowRate:
                    if (unit.isCompatible(SI.KILOGRAM_PER_SECOND)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                        }

                    }
                    break;
                case discrete_position_sensor:
                    if (unit.isCompatible(Unit.ONE)) {
                        for(int i=0;i< eValue.length;i++) {
                            this.eValue[i].setNominalValue(Measure.valueOf(value[i], unit));
                        }

                    }
                    break;


                default:
                    break;
            }

        }

    }

    // getters & setters

    public SignalType getSignalType() {
        return signalType;
    }

    public void setSignalType(SignalType signalType) {
        this.signalType = signalType;
    }

    public SignalSource getSignalSource() {
        return signalSource;
    }

    public void setSignalSource(SignalSource signalSource) {
        this.signalSource = signalSource;
    }
    
    

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public EMeasure[] geteValue() {
        return eValue;
    }

    public void seteValue(EMeasure[] eValue) {
        this.eValue = eValue;
    }

    public SignalStatus getStatus() {
        return status;
    }

    public void setStatus(SignalStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Class getDataType() {
        return dataType;
    }

    public void setDataType(Class dataType) {
        this.dataType = dataType;
    }

    public Object[] getValue() {
        return value;
    }

    public void setValue(Object[] value) {
        this.value = value;
    }

    public List<DDS_Signal> getChildren() {
        if(children == null) {
            children = new ArrayList<>();
        }
         return children;
    }

    public void setFrameViewandTextView(View frame, final TextView textView) {

        this.geteValue()[0].addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                textView.setText(geteValue()[0].toString(false));
            }
        });

    }

    public List<String> geteMeasureListeners() {
        return eMeasureListeners;
    }
    
     public void setValueAndSignalStatus(Object[] value, SignalStatus status) {
        this.setValue(value);
        this.setStatus(status);
    }


    public DDS_Signal[] getSignalsAsArray() {
        DDS_Signal[] signals = null;

        if(children != null) {
            signals = new DDS_Signal[this.getChildren().size()];
            for (int i = 0; i < this.getChildren().size(); i++) {
                signals[i] = this.getChildren().get(i);
            }
        }
        return signals;
    }
    
    
}
