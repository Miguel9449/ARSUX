/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAsensors;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.infrastructure.ResourceLimitsQosPolicy;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.InstanceStateKind;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import com.rti.dds.subscription.SampleStateKind;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.subscription.ViewStateKind;
import com.rti.dds.topic.Topic;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import AutomaticCurrent.AutomaticCurrentTypeSupport;
import MySupportClasses.CompNodeDataModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;

/**
 *
 * @author nextstep
 */
public class FAsensorsModel extends CompNodeDataModel {

    public FAsensors topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAsensorsDataReader reader;
    public FAsensorsDataWriter writer;
    public FAsensorsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal AR_TS01_TP; // 300.15
    public DDS_Signal AR_TS02_TP; // 300.15
    public DDS_Signal AR_TS03_TP; // 300.15
    public DDS_Signal AR_TS04_TP; // 300.15
    public DDS_Signal AR_TS05_TP; // 300.15
    public DDS_Signal AR_TS06_TP; // 300.15
    public DDS_Signal AR_TS07_TP; // 300.15
    public DDS_Signal AR_TS08_TP; // 300.15
    public DDS_Signal AR_TS09_TP; // 300.15
    public DDS_Signal AR_TS10_TP; // 300.15
    public DDS_Signal AR_TS12_TP; // 300.15
    public DDS_Signal AR_TS15_TP; // 300.15
    public DDS_Signal AR_TS16_TP; // 300.15
    public DDS_Signal AR_TS18_TP; // 300.15
    public DDS_Signal AR_TS19_TP; // 300.15
    public DDS_Signal AR_TS20_TP; // 278
    public DDS_Signal AR_TS21_TP; // 300.15
    public DDS_Signal AR_TC5_TP; // 300.15
    public DDS_Signal AR_TC4_TP; // 300.15
    public DDS_Signal AR_TC3_TP; // 300.15
    public DDS_Signal AR_TC2_TP; // 300.15
    public DDS_Signal AR_TS39_TP; // 300.15
    public DDS_Signal AR_TS40_TP; // 300.15
    public DDS_Signal AR_TS_Fn01_TP; // 300.15
    public DDS_Signal AR_TS_Fn02_TP; // 300.15
    public DDS_Signal AR_PS01_TP; // 101325
    public DDS_Signal AR_PS02_TP; // 101325
    public DDS_Signal AR_DP_Fn01_TP; // 0
    public DDS_Signal AR_IS_Fn01_TP; // 0
    public DDS_Signal AR_NS_Fn01_TP; // 0
    public DDS_Signal AR_DP_Fn02_TP; // 0
    public DDS_Signal AR_IS_Fn02_TP; // 0
    public DDS_Signal AR_NS_Fn02_TP; // 0
    public DDS_Signal AR_CO01_TP; // 0
    public DDS_Signal AR_PI02_TP; // 1.33
    public DDS_Signal AR_PI03_TP; // 0.73
    public DDS_Signal AR_IS_Pp01_TP; // 0
    public DDS_Signal AR_F_Vv01_TP; // 1
    public DDS_Signal AR_DP_01_TP; // 0
    public DDS_Signal AR_Sn01N2Pa_TP; // 0
    public DDS_Signal AR_Sn01O2Pa_TP; // 21300
    public DDS_Signal AR_Sn01H2OPa_TP; // 0
    public DDS_Signal AR_Sn01ArPa_TP; // 0
    public DDS_Signal AR_Sn01CO2Pa_TP; // 267
    public DDS_Signal AR_Sn01CH4_TP; // 0.00002
    public DDS_Signal AR_TC1_TP; // 300.15
    public DDS_Signal AR_TC7_TP; // 300.15
    public DDS_Signal AR_TC6_TP; // 300.15
    public DDS_Signal AR_PI06_TP; // 0.729855
    public DDS_Signal AR_TS47; // 300.15
    public DDS_Signal AR_TS48; // 300.15
    public DDS_Signal AR_TS49; // 300.15
    public DDS_Signal AR_TS50; // 300.15
    public DDS_Signal AR_TS52; // 300.15
    public DDS_Signal AR_TS55; // 300.15
    public DDS_Signal AR_TS56; // 300.15
    public DDS_Signal AR_TS58; // 300.15
    public DDS_Signal AR_PS03; // 101325
    public DDS_Signal AR_PS04; // 101325
    public DDS_Signal AR_PS70; // 101325
    public DDS_Signal AR_TS70; // 300.15
    public DDS_Signal AR_PS71; // 101325
    public DDS_Signal AR_TS71; // 300.15
    public DDS_Signal AR_PS72; // 101325
    public DDS_Signal AR_FM72; // 0
    public DDS_Signal fault;



    public DDS_Signal co2Signals;
    public DDS_Signal samSignals;
    public DDS_Signal sensedTempSignals;
    public DDS_Signal unsensedTempSignals;
    public DDS_Signal motorSpeedSignals;
    public DDS_Signal sensedPressSignals;
    public DDS_Signal unsensedPressSignals;
    public DDS_Signal otherSignals;
    public DDS_Signal posIndiatorsSignals;
    public DDS_Signal currents;


//    public FAsensorsModel(int domainId, DomainParticipant participant, Subscriber subscriber, Publisher publisher) {
//        super(domainId, participant, subscriber, publisher);
//        this.topicName = FAsensorsTypeSupport.get_type_name();
//        this.setCommStatus(topicName + " not active!");
//    }

    public FAsensorsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);this.topicName = AutomaticCurrentTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.fAsensorsDataReader;
        writer = fragmentsModel.fAsensorsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();


    }


    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("ARS Sensor Telemetry", SignalType.rootSet);

        co2Signals  = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        samSignals  = DDS_Signal.createDDSSignal("SAM Sensors", SignalType.information);
        sensedTempSignals  = DDS_Signal.createDDSSignal("Sensed Temperatures", SignalType.information);
        unsensedTempSignals   = DDS_Signal.createDDSSignal("Unsensed Temperatures", SignalType.information);
        motorSpeedSignals  = DDS_Signal.createDDSSignal("Motor Speeds", SignalType.information);
        sensedPressSignals  = DDS_Signal.createDDSSignal("Sensed Pressures", SignalType.information);
        unsensedPressSignals = DDS_Signal.createDDSSignal("Unsensed Pressures", SignalType.information);
        otherSignals = DDS_Signal.createDDSSignal("Other Signals", SignalType.information);
        posIndiatorsSignals = DDS_Signal.createDDSSignal("Valves Positions", SignalType.information);
        unsensedPressSignals = DDS_Signal.createDDSSignal("Unsenced Pressures", SignalType.information);
        currents = DDS_Signal.createDDSSignal("Currents", SignalType.information);

        id = DDS_Signal.createDDSSignal("id", SignalType.unknown);
        state = DDS_Signal.createDDSSignal("state", SignalType.unknown);
        AR_TS01_TP = DDS_Signal.createDDSSignal("TS01", SignalType.temp_sensor);
        AR_TS02_TP = DDS_Signal.createDDSSignal("TS02", SignalType.temp_sensor);
        AR_TS03_TP = DDS_Signal.createDDSSignal("TS03", SignalType.temp_sensor);
        AR_TS04_TP = DDS_Signal.createDDSSignal("TS04", SignalType.temp_sensor);
        AR_TS05_TP = DDS_Signal.createDDSSignal("TS05_", SignalType.temp_sensor);
        AR_TS06_TP = DDS_Signal.createDDSSignal("TS06", SignalType.temp_sensor);
        AR_TS07_TP = DDS_Signal.createDDSSignal("TS07", SignalType.temp_sensor);
        AR_TS08_TP = DDS_Signal.createDDSSignal("TS08_", SignalType.temp_sensor);
        AR_TS09_TP = DDS_Signal.createDDSSignal("TS09", SignalType.temp_sensor);
        AR_TS10_TP = DDS_Signal.createDDSSignal("TS10", SignalType.temp_sensor);
        AR_TS12_TP = DDS_Signal.createDDSSignal("TS12", SignalType.temp_sensor);
        AR_TS15_TP = DDS_Signal.createDDSSignal("TS15", SignalType.temp_sensor);
        AR_TS16_TP = DDS_Signal.createDDSSignal("TS16", SignalType.temp_sensor);
        AR_TS18_TP = DDS_Signal.createDDSSignal("TS18", SignalType.temp_sensor);
        AR_TS19_TP = DDS_Signal.createDDSSignal("TS19", SignalType.temp_sensor);
        AR_TS20_TP = DDS_Signal.createDDSSignal("TS20", SignalType.temp_sensor);
        AR_TS21_TP = DDS_Signal.createDDSSignal("TS21", SignalType.temp_sensor);
        AR_TC5_TP = DDS_Signal.createDDSSignal("TC5", SignalType.temp_sensor);
        AR_TC4_TP = DDS_Signal.createDDSSignal("TC4", SignalType.temp_sensor);
        AR_TC3_TP = DDS_Signal.createDDSSignal("TC3", SignalType.temp_sensor);
        AR_TC2_TP = DDS_Signal.createDDSSignal("TC2", SignalType.temp_sensor);
        AR_TS39_TP = DDS_Signal.createDDSSignal("TS39", SignalType.temp_sensor);
        AR_TS40_TP = DDS_Signal.createDDSSignal("TS40", SignalType.temp_sensor);

        AR_TS_Fn01_TP = DDS_Signal.createDDSSignal("TS_Fn01", SignalType.temp_sensor);
        AR_TS_Fn02_TP = DDS_Signal.createDDSSignal("TS_Fn02", SignalType.temp_sensor);

        AR_PS01_TP = DDS_Signal.createDDSSignal("PS01", SignalType.abs_pressure_sensor);
        AR_PS02_TP = DDS_Signal.createDDSSignal("PS02", SignalType.abs_pressure_sensor);
        AR_DP_Fn01_TP = DDS_Signal.createDDSSignal("DP_Fn01", SignalType.gauge_pressure_sensor);

        AR_IS_Fn01_TP = DDS_Signal.createDDSSignal("IS_Fn01", SignalType.current_sensor);
        AR_NS_Fn01_TP = DDS_Signal.createDDSSignal("NS_Fn01", SignalType.motor_speed_sensor);
        AR_DP_Fn02_TP = DDS_Signal.createDDSSignal("DP_Fn02", SignalType.gauge_pressure_sensor);
        AR_IS_Fn02_TP = DDS_Signal.createDDSSignal("IS_Fn02", SignalType.current_sensor);
        AR_NS_Fn02_TP = DDS_Signal.createDDSSignal("NS_Fn02", SignalType.motor_speed_sensor);
        AR_CO01_TP = DDS_Signal.createDDSSignal("CO01", SignalType.co2_sensor);
        AR_PI02_TP = DDS_Signal.createDDSSignal("PI02", SignalType.volt_sensor);
        AR_PI03_TP = DDS_Signal.createDDSSignal("PI03", SignalType.discrete_position_sensor);
        AR_IS_Pp01_TP = DDS_Signal.createDDSSignal("IS_Pp01", SignalType.current_sensor);
        AR_F_Vv01_TP = DDS_Signal.createDDSSignal("F_Vv01", SignalType.position_sensor);
        AR_DP_01_TP = DDS_Signal.createDDSSignal("DP_01", SignalType.gauge_pressure_sensor);
        AR_Sn01N2Pa_TP = DDS_Signal.createDDSSignal("Sn01N2", SignalType.n2_sensor);
        AR_Sn01O2Pa_TP = DDS_Signal.createDDSSignal("Sn01O2", SignalType.o2_sensor);
        AR_Sn01H2OPa_TP = DDS_Signal.createDDSSignal("Sn01H2O", SignalType.water_vapor_sensor);
        AR_Sn01ArPa_TP = DDS_Signal.createDDSSignal("Sn01Ar", SignalType.argon_sensor);
        AR_Sn01CO2Pa_TP = DDS_Signal.createDDSSignal("Sn01CO2", SignalType.co2_sensor);
        AR_Sn01CH4_TP = DDS_Signal.createDDSSignal("Sn01CH4", SignalType.ch4_sensor);
        AR_TC1_TP = DDS_Signal.createDDSSignal("TC1", SignalType.temp_sensor);
        AR_TC7_TP = DDS_Signal.createDDSSignal("TC7", SignalType.temp_sensor);
        AR_TC6_TP = DDS_Signal.createDDSSignal("TC6", SignalType.temp_sensor);
        AR_PI06_TP = DDS_Signal.createDDSSignal("PI06", SignalType.position_sensor);
        AR_TS47 = DDS_Signal.createDDSSignal("TS47", SignalType.temp_sensor);
        AR_TS48 = DDS_Signal.createDDSSignal("TS48", SignalType.temp_sensor);
        AR_TS49 = DDS_Signal.createDDSSignal("TS49", SignalType.temp_sensor);
        AR_TS50 = DDS_Signal.createDDSSignal("TS50", SignalType.temp_sensor);
        AR_TS52 = DDS_Signal.createDDSSignal("TS52", SignalType.temp_sensor);
        AR_TS55 = DDS_Signal.createDDSSignal("TS55", SignalType.temp_sensor);
        AR_TS56 = DDS_Signal.createDDSSignal("TS56", SignalType.temp_sensor);
        AR_TS58 = DDS_Signal.createDDSSignal("TS58", SignalType.temp_sensor);
        AR_PS03 = DDS_Signal.createDDSSignal("PS03", SignalType.abs_pressure_sensor);
        AR_PS04 = DDS_Signal.createDDSSignal("PS04", SignalType.abs_pressure_sensor);
        AR_PS70 = DDS_Signal.createDDSSignal("PS70", SignalType.abs_pressure_sensor);
        AR_TS70 = DDS_Signal.createDDSSignal("TS70", SignalType.temp_sensor);
        AR_PS71 = DDS_Signal.createDDSSignal("PS71", SignalType.abs_pressure_sensor);
        AR_TS71 = DDS_Signal.createDDSSignal("TS71", SignalType.temp_sensor);
        AR_PS72 = DDS_Signal.createDDSSignal("PS72", SignalType.abs_pressure_sensor);
        AR_FM72 = DDS_Signal.createDDSSignal("FM72", SignalType.temp_sensor);
        fault   = DDS_Signal.createDDSSignal("fault", SignalType.fault);



        root.getChildren().add(co2Signals);
        root.getChildren().add(AR_CO01_TP);

        root.getChildren().add(samSignals);
        root.getChildren().add(AR_Sn01N2Pa_TP);
        root.getChildren().add(AR_Sn01O2Pa_TP);
        root.getChildren().add(AR_Sn01CO2Pa_TP);
        root.getChildren().add(AR_Sn01H2OPa_TP);
        root.getChildren().add(AR_Sn01ArPa_TP);
        root.getChildren().add(AR_Sn01CH4_TP);


        root.getChildren().add(sensedTempSignals);
        root.getChildren().add(AR_TS01_TP);
        root.getChildren().add(AR_TS02_TP);
        root.getChildren().add(AR_TS03_TP);
        root.getChildren().add(AR_TS04_TP);
        root.getChildren().add(AR_TS05_TP);
        root.getChildren().add(AR_TS06_TP);
        root.getChildren().add(AR_TS07_TP);
        root.getChildren().add(AR_TS08_TP);
        root.getChildren().add(AR_TS09_TP);
        root.getChildren().add(AR_TS10_TP);
        root.getChildren().add(AR_TS12_TP);
        root.getChildren().add(AR_TS15_TP);
        root.getChildren().add(AR_TS16_TP);
        root.getChildren().add(AR_TS18_TP);
        root.getChildren().add(AR_TS19_TP);
        root.getChildren().add(AR_TS20_TP);
        root.getChildren().add(AR_TS21_TP);
        root.getChildren().add(AR_TC1_TP);
        root.getChildren().add(AR_TC2_TP);
        root.getChildren().add(AR_TC3_TP);
        root.getChildren().add(AR_TC4_TP);
        root.getChildren().add(AR_TC5_TP);
        root.getChildren().add(AR_TC6_TP);
        root.getChildren().add(AR_TC7_TP);
        root.getChildren().add(AR_TS39_TP);
        root.getChildren().add(AR_TS40_TP);
        root.getChildren().add(AR_TS_Fn01_TP);
        root.getChildren().add(AR_TS_Fn02_TP);
        root.getChildren().add(unsensedTempSignals);
        root.getChildren().add(AR_TS47);
        root.getChildren().add(AR_TS48);
        root.getChildren().add(AR_TS49);
        root.getChildren().add(AR_TS50);
        root.getChildren().add(AR_TS52);
        root.getChildren().add(AR_TS55);
        root.getChildren().add(AR_TS56);
        root.getChildren().add(AR_TS58);
        root.getChildren().add(AR_TS70);
        root.getChildren().add(AR_TS71);

        root.getChildren().add(currents);
        root.getChildren().add(AR_IS_Fn01_TP);
        root.getChildren().add(AR_IS_Fn02_TP);
        root.getChildren().add(AR_IS_Pp01_TP);

        root.getChildren().add(motorSpeedSignals);
        root.getChildren().add(AR_NS_Fn01_TP);
        root.getChildren().add(AR_NS_Fn02_TP);

        root.getChildren().add(sensedPressSignals);
        root.getChildren().add(AR_PS01_TP);
        root.getChildren().add(AR_PS02_TP);
        root.getChildren().add(AR_DP_01_TP);
        root.getChildren().add(AR_DP_Fn01_TP);
        root.getChildren().add(AR_DP_Fn02_TP);

        root.getChildren().add(unsensedPressSignals);
        root.getChildren().add(AR_PS03);
        root.getChildren().add(AR_PS04);
        root.getChildren().add(AR_PS70);
        root.getChildren().add(AR_PS71);
        root.getChildren().add(AR_PS72);

        root.getChildren().add(posIndiatorsSignals);
        root.getChildren().add(AR_PI02_TP);
        root.getChildren().add(AR_PI03_TP);
        root.getChildren().add(AR_PI06_TP);
        root.getChildren().add(AR_F_Vv01_TP);

        root.getChildren().add(otherSignals);

       // root.getChildren().add(AR_FM72);
        root.getChildren().add(fault);
        root.getChildren().add(id);
        root.getChildren().add(state);


    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
           id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            AR_TS01_TP.setValue(new Object[]{topic. AR_TS01_TP});
            AR_TS02_TP.setValue(new Object[]{topic. AR_TS02_TP});
            AR_TS03_TP.setValue(new Object[]{topic. AR_TS03_TP});
            AR_TS04_TP.setValue(new Object[]{topic. AR_TS04_TP});
            AR_TS05_TP.setValue(new Object[]{topic. AR_TS05_TP});
            AR_TS06_TP.setValue(new Object[]{topic. AR_TS06_TP});
            AR_TS07_TP.setValue(new Object[]{topic. AR_TS07_TP});
            AR_TS08_TP.setValue(new Object[]{topic. AR_TS08_TP});
            AR_TS09_TP.setValue(new Object[]{topic. AR_TS09_TP});
            AR_TS10_TP.setValue(new Object[]{topic. AR_TS10_TP});
            AR_TS12_TP.setValue(new Object[]{topic. AR_TS12_TP});
            AR_TS15_TP.setValue(new Object[]{topic. AR_TS15_TP});
            AR_TS16_TP.setValue(new Object[]{topic. AR_TS16_TP});
            AR_TS18_TP.setValue(new Object[]{topic. AR_TS18_TP});
            AR_TS19_TP.setValue(new Object[]{topic. AR_TS19_TP});
            AR_TS20_TP.setValue(new Object[]{topic. AR_TS20_TP});
            AR_TS21_TP.setValue(new Object[]{topic. AR_TS21_TP});
            AR_TC5_TP.setValue(new Object[]{topic.AR_TC5_TP});
            AR_TC4_TP.setValue(new Object[]{topic.AR_TC4_TP});
            AR_TC3_TP.setValue(new Object[]{topic.AR_TC3_TP});
            AR_TC2_TP.setValue(new Object[]{topic.AR_TC2_TP});
            AR_TS39_TP.setValue(new Object[]{topic.AR_TS39_TP});
            AR_TS40_TP.setValue(new Object[]{topic.AR_TS40_TP});
            AR_TS_Fn01_TP.setValue(new Object[]{topic.AR_TS_Fn01_TP});
            AR_TS_Fn02_TP.setValue(new Object[]{topic.AR_TS_Fn02_TP});
            AR_PS01_TP.setValue(new Object[]{topic.AR_PS01_TP});
            AR_PS02_TP.setValue(new Object[]{topic.AR_PS02_TP});
            AR_DP_Fn01_TP.setValue(new Object[]{topic.AR_IS_Fn01_TP});
            AR_IS_Fn01_TP.setValue(new Object[]{topic.AR_NS_Fn01_TP});
            AR_NS_Fn01_TP.setValue(new Object[]{topic.AR_DP_Fn01_TP});
            AR_DP_Fn02_TP.setValue(new Object[]{topic.AR_IS_Fn02_TP});
            AR_IS_Fn02_TP.setValue(new Object[]{topic.AR_NS_Fn02_TP});
            AR_NS_Fn02_TP.setValue(new Object[]{topic.AR_DP_Fn02_TP});
            AR_CO01_TP.setValue(new Object[]{topic.AR_CO01_TP});
            AR_PI02_TP.setValue(new Object[]{topic.AR_PI02_TP});
            AR_PI03_TP.setValue(new Object[]{topic.AR_PI03_TP});

           // System.out.println("********************* AR_PI03 = " + topic.AR_PI03_TP);
            AR_IS_Pp01_TP.setValue(new Object[]{topic.AR_IS_Pp01_TP});
            AR_F_Vv01_TP.setValue(new Object[]{topic.AR_F_Vv01_TP});
            AR_DP_01_TP.setValue(new Object[]{topic.AR_DP_01_TP});
            AR_Sn01N2Pa_TP.setValue(new Object[]{topic.AR_Sn01N2Pa_TP});
            AR_Sn01O2Pa_TP.setValue(new Object[]{topic.AR_Sn01O2Pa_TP});
            AR_Sn01H2OPa_TP.setValue(new Object[]{topic.AR_Sn01H2OPa_TP});
            AR_Sn01ArPa_TP.setValue(new Object[]{topic.AR_Sn01ArPa_TP});
            AR_Sn01CO2Pa_TP.setValue(new Object[]{topic.AR_Sn01CO2Pa_TP});
            AR_Sn01CH4_TP.setValue(new Object[]{topic.AR_Sn01CH4_TP});
            AR_TC1_TP.setValue(new Object[]{AR_TC1_TP});
            AR_TC7_TP.setValue(new Object[]{AR_TC7_TP});
            AR_TC6_TP.setValue(new Object[]{AR_TC6_TP});
            AR_PI06_TP.setValue(new Object[]{AR_PI06_TP});
            AR_TS47.setValue(new Object[]{topic.AR_TS47});
            AR_TS48.setValue(new Object[]{topic.AR_TS48});
            AR_TS49.setValue(new Object[]{topic.AR_TS49});
            AR_TS50.setValue(new Object[]{topic.AR_TS50});
            AR_TS52.setValue(new Object[]{topic.AR_TS52});
            AR_TS55.setValue(new Object[]{topic.AR_TS55});
            AR_TS56.setValue(new Object[]{topic.AR_TS56});
            AR_TS58.setValue(new Object[]{topic.AR_TS58});
            AR_PS03.setValue(new Object[]{topic.AR_PS03});
            AR_PS04.setValue(new Object[]{topic.AR_PS04});
            AR_PS70.setValue(new Object[]{topic.AR_PS70});
            AR_TS70.setValue(new Object[]{topic.AR_TS70});
            AR_PS71.setValue(new Object[]{topic.AR_PS71});
            AR_TS71.setValue(new Object[]{topic.AR_TS71});
            AR_PS72.setValue(new Object[]{topic.AR_PS72});
            AR_FM72.setValue(new Object[]{topic.AR_FM72});
            fault.setValue(new Object[]{topic.fault});
            updateEMeasures();
        }

    }

    @Override
    public void initReader() {
        if(reader == null) {
            String typeName = FAsensorsTypeSupport.get_type_name();

            FAsensorsTypeSupport.register_type(participant, typeName);

            aTopic = participant.create_topic(
                    "FAsensors",
                    typeName,
                    DomainParticipant.TOPIC_QOS_DEFAULT,
                    null /* listener */,
                    StatusKind.STATUS_MASK_NONE);

            if (aTopic == null) {
                //   System.err.println("Create " + topicName + " error\n");
            } else {
                reader = (FAsensorsDataReader) subscriber.create_datareader(
                        aTopic,
                        Subscriber.DATAREADER_QOS_DEFAULT,
                        null,
                        StatusKind.STATUS_MASK_ALL);

                if (reader == null) {
                    //  System.err.println("Create " + topicName + " DataReader ERROR!\n");

                }
            }

        }
    }

    @Override
    public void initWriter() {
        try {

            // --- Create topic --- //

            /* Register type before creating topic */
            String typeName = FAsensorsTypeSupport.get_type_name();
            FAsensorsTypeSupport.register_type(participant, typeName);
            System.out.println("************** Publisher in initwriter: " + publisher.toString()+ " \n");
            writer = (FAsensorsDataWriter) publisher.create_datawriter(
                    aTopic, Publisher.DATAWRITER_QOS_DEFAULT,
                    null /* listener */, StatusKind.STATUS_MASK_NONE);
            if (writer == null) {
                System.err.println("Create_datawriter error\n");
                return;
            }

        } finally {
            // Do nothing.

        }
    }

    @Override
    public void updateEMeasures() {
        if(topic !=null) {
            // System.out.println("******************************Topic not null")  ;
            AR_TS01_TP.updateeMeasure(new Double[]{topic.AR_TS01_TP}, SI.KELVIN);
            AR_TS01_TP.updateeMeasure(new Double[]{topic.AR_TS01_TP}, SI.KELVIN);
            AR_TS02_TP.updateeMeasure(new Double[]{topic.AR_TS02_TP}, SI.KELVIN);
            AR_TS03_TP.updateeMeasure(new Double[]{topic.AR_TS03_TP}, SI.KELVIN);
            AR_TS04_TP.updateeMeasure(new Double[]{topic.AR_TS04_TP}, SI.KELVIN);
            AR_TS05_TP.updateeMeasure(new Double[]{topic.AR_TS05_TP}, SI.KELVIN);
            AR_TS06_TP.updateeMeasure(new Double[]{topic.AR_TS06_TP}, SI.KELVIN);
            AR_TS07_TP.updateeMeasure(new Double[]{topic.AR_TS07_TP}, SI.KELVIN);
            AR_TS08_TP.updateeMeasure(new Double[]{topic.AR_TS08_TP}, SI.KELVIN);
            AR_TS09_TP.updateeMeasure(new Double[]{topic.AR_TS09_TP}, SI.KELVIN);
            AR_TS10_TP.updateeMeasure(new Double[]{topic.AR_TS10_TP}, SI.KELVIN);
            AR_TS12_TP.updateeMeasure(new Double[]{topic.AR_TS12_TP}, SI.KELVIN);
            AR_TS15_TP.updateeMeasure(new Double[]{topic.AR_TS15_TP}, SI.KELVIN);
            AR_TS16_TP.updateeMeasure(new Double[]{topic.AR_TS16_TP}, SI.KELVIN);
            AR_TS18_TP.updateeMeasure(new Double[]{topic.AR_TS18_TP}, SI.KELVIN);
            AR_TS19_TP.updateeMeasure(new Double[]{topic.AR_TS19_TP}, SI.KELVIN);
            AR_TS20_TP.updateeMeasure(new Double[]{topic.AR_TS20_TP}, SI.KELVIN);
            AR_TS21_TP.updateeMeasure(new Double[]{topic.AR_TS21_TP}, SI.KELVIN);
            AR_TC5_TP.updateeMeasure(new Double[]{topic.AR_TC5_TP}, SI.KELVIN);
            AR_TC4_TP.updateeMeasure(new Double[]{topic.AR_TC4_TP}, SI.KELVIN);
            AR_TC3_TP.updateeMeasure(new Double[]{topic.AR_TC3_TP}, SI.KELVIN);
            AR_TC2_TP.updateeMeasure(new Double[]{topic.AR_TC2_TP}, SI.KELVIN);
            AR_TS39_TP.updateeMeasure(new Double[]{topic.AR_TS39_TP}, SI.KELVIN);
            AR_TS40_TP.updateeMeasure(new Double[]{topic.AR_TS40_TP}, SI.KELVIN);
            AR_TS_Fn01_TP.updateeMeasure(new Double[]{topic.AR_TS_Fn01_TP}, SI.KELVIN);
            AR_TS_Fn02_TP.updateeMeasure(new Double[]{topic.AR_TS_Fn02_TP}, SI.KELVIN);
            AR_PS01_TP.updateeMeasure(new Double[]{topic.AR_PS01_TP}, SI.PASCAL);
            AR_PS02_TP.updateeMeasure(new Double[]{topic.AR_PS02_TP}, SI.PASCAL);
            AR_DP_Fn01_TP.updateeMeasure(new Double[]{topic.AR_DP_Fn01_TP}, SI.PASCAL);
            AR_IS_Fn01_TP.updateeMeasure(new Double[]{topic.AR_IS_Fn01_TP}, SI.AMPERE);
            AR_NS_Fn01_TP.updateeMeasure(new Double[]{topic.AR_NS_Fn01_TP}, NonSI.rpm);
            AR_DP_Fn02_TP.updateeMeasure(new Double[]{topic.AR_DP_Fn02_TP}, SI.PASCAL);
            AR_IS_Fn02_TP.updateeMeasure(new Double[]{topic.AR_IS_Fn02_TP}, SI.AMPERE);
            AR_NS_Fn02_TP.updateeMeasure(new Double[]{topic.AR_NS_Fn02_TP}, NonSI.rpm);
            AR_CO01_TP.updateeMeasure(new Double[]{topic.AR_CO01_TP}, SI.PASCAL);
            AR_PI02_TP.updateeMeasure(new Double[]{topic.AR_PI02_TP}, SI.VOLT);
            AR_PI03_TP.updateeMeasure(new Double[]{topic.AR_PI03_TP},  Unit.ONE);
            AR_IS_Pp01_TP.updateeMeasure(new Double[]{topic.AR_IS_Pp01_TP}, SI.AMPERE);
            AR_F_Vv01_TP.updateeMeasure(new Double[]{topic.AR_F_Vv01_TP}, Unit.ONE);
            AR_DP_01_TP.updateeMeasure(new Double[]{topic.AR_DP_01_TP}, SI.PASCAL);
            AR_Sn01N2Pa_TP.updateeMeasure(new Double[]{topic.AR_Sn01N2Pa_TP}, SI.PASCAL);
            AR_Sn01O2Pa_TP.updateeMeasure(new Double[]{topic.AR_Sn01O2Pa_TP}, SI.PASCAL);
            AR_Sn01H2OPa_TP.updateeMeasure(new Double[]{topic.AR_Sn01H2OPa_TP}, SI.PASCAL);
            AR_Sn01CO2Pa_TP.updateeMeasure(new Double[]{topic.AR_Sn01CO2Pa_TP}, SI.PASCAL);


            AR_Sn01CH4_TP.updateeMeasure(new Double[]{topic.AR_Sn01CH4_TP*1000000}, NonSI.PPM);
            AR_Sn01ArPa_TP.updateeMeasure(new Double[]{topic.AR_Sn01ArPa_TP}, SI.PASCAL);

           // AR_Sn01CH4_TP.updateeMeasure(new Double[]{0.0}, NonSI.PPM);
           // AR_Sn01ArPa_TP.updateeMeasure(new Double[]{0.0}, SI.PASCAL);


            AR_TC1_TP.updateeMeasure(new Double[]{topic.AR_TC1_TP}, SI.KELVIN);
            AR_TC7_TP.updateeMeasure(new Double[]{topic.AR_TC7_TP}, SI.KELVIN);
            AR_TC6_TP.updateeMeasure(new Double[]{topic.AR_TC6_TP}, SI.KELVIN);
            AR_PI06_TP.updateeMeasure(new Double[]{topic.AR_PI06_TP}, Unit.ONE);
            AR_TS47.updateeMeasure(new Double[]{topic.AR_TS47}, SI.KELVIN);
            AR_TS48.updateeMeasure(new Double[]{topic.AR_TS48}, SI.KELVIN);
            AR_TS49.updateeMeasure(new Double[]{topic.AR_TS49}, SI.KELVIN);
            AR_TS50.updateeMeasure(new Double[]{topic.AR_TS50}, SI.KELVIN);
            AR_TS52.updateeMeasure(new Double[]{topic.AR_TS52}, SI.KELVIN);
            AR_TS55.updateeMeasure(new Double[]{topic.AR_TS55}, SI.KELVIN);
            AR_TS56.updateeMeasure(new Double[]{topic.AR_TS56}, SI.KELVIN);
            AR_TS58.updateeMeasure(new Double[]{topic.AR_TS58}, SI.KELVIN);
            AR_PS03.updateeMeasure(new Double[]{topic.AR_PS03}, SI.PASCAL);
            AR_PS04.updateeMeasure(new Double[]{topic.AR_PS04}, SI.PASCAL);
            AR_PS70.updateeMeasure(new Double[]{topic.AR_PS70}, SI.PASCAL);
            AR_TS70.updateeMeasure(new Double[]{topic.AR_TS70}, SI.KELVIN);
            AR_PS71.updateeMeasure(new Double[]{topic.AR_PS71}, SI.PASCAL);
            AR_TS71.updateeMeasure(new Double[]{topic.AR_TS71}, SI.KELVIN);
            AR_PS72.updateeMeasure(new Double[]{topic.AR_PS72}, SI.PASCAL);
            AR_FM72.updateeMeasure(new Double[]{topic.AR_FM72}, SI.KELVIN);
            //fault.updateeMeasure(new Double[]{topic.fault}, SI.KELVIN);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new FAsensorsSeq();
                infoSeq = new SampleInfoSeq();

                reader.take(dataSeq, infoSeq,
                        ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                        SampleStateKind.ANY_SAMPLE_STATE,
                        ViewStateKind.ANY_VIEW_STATE,
                        InstanceStateKind.ANY_INSTANCE_STATE);
//   System.err.println("***********************************in updatetopicdata, the infoSeq.size is "+ dataSeq.size()+"\n");
                for (int i = 0; i < dataSeq.size(); ++i) {
                    info = infoSeq.get(i);
                    //System.out.println("in the data reading loop Reading 1A Data");
                    if (info.valid_data) {
                        topic = dataSeq.get(i);
                        if(topic == null)  {
                            //       System.out.println("topic is null");
                        } else {
                            //       System.out.println("Reading 1A Data");
                        }
                    }
                }
                //  System.err.println(this.getTopicName() + " Communication Status: OK\n");
                this.setCommStatus(this.getTopicName() + " Communication Status: OK");

            } catch (RETCODE_NO_DATA noData) {
                // No data to process
                //System.out.println("No data to process: " + noData.getMessage());
                this.setCommStatus(this.getTopicName() + " Communication Status: NO DATA");

            } finally {
                if (reader != null) {
                    reader.return_loan(dataSeq, infoSeq);
                }
            }
        }
    }

    @Override
    public void deleteWriterReader() {
        System.out.println("Hold on ... shutting down DDS!");
        subscriber.delete_datareader(reader);
        publisher.delete_datawriter(writer);
        System.out.println("Participant deleted!");
    }

    public boolean isCommActive() {
        if(info != null) {
            return true;
        } else {
            return false;
        }
    }


}

