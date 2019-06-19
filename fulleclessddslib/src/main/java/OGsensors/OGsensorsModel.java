/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OGsensors;
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

import MySupportClasses.CompNodeDataModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;

/**
 *
 * @author nextstep
 */
public class OGsensorsModel extends CompNodeDataModel {

    public OGsensors topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public OGsensorsDataReader reader;
    public OGsensorsDataWriter writer;
    public OGsensorsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal OGP73211; // 165480
    public DDS_Signal OGP73212; // 165480
    public DDS_Signal OGT75411; // 293.15
    public DDS_Signal OGT75412; // 293.15
    public DDS_Signal OGDP7131; // 0
    public DDS_Signal OGN80011; // 0
    public DDS_Signal OGF75311; // 0
    public DDS_Signal OGF75313; // 0
    public DDS_Signal OGP7111; // 165480
    public DDS_Signal OGRSAquantity; // 29
    public DDS_Signal OGG82421; // 1
    public DDS_Signal OGCS71912; // 0.1
    public DDS_Signal OGN80012; // 0
    public DDS_Signal OGP7312; // 100
    public DDS_Signal OGP73113; // 101325
    public DDS_Signal OGP71211; // 101325
    public DDS_Signal OGP71212; // 101325
    public DDS_Signal OGT72411; // 293.15
    public DDS_Signal OGT72412; // 293.15
    public DDS_Signal fault;

    public DDS_Signal otherSignals;
    public DDS_Signal motorSpeedSignals;
    public DDS_Signal PressSignals;
    public DDS_Signal TempSignals;


    public OGsensorsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = OGsensorsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.oGsensorsDataReader;
        writer = fragmentsModel.oGsensorsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("OGA Sensor Telemetry", SignalType.rootSet);
        otherSignals = DDS_Signal.createDDSSignal("Other Signals", SignalType.information);

        motorSpeedSignals = DDS_Signal.createDDSSignal("Motor Speed Signals", SignalType.information);
        PressSignals = DDS_Signal.createDDSSignal("Pressure Signals", SignalType.information);
        TempSignals = DDS_Signal.createDDSSignal("Temperature Signals", SignalType.information);

        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        OGP73211 = DDS_Signal.createDDSSignal("OGP73211", SignalType.abs_pressure_sensor);
        OGP73212 = DDS_Signal.createDDSSignal("OGP73212", SignalType.abs_pressure_sensor);
        OGT75411 = DDS_Signal.createDDSSignal("OGT75411", SignalType.temp_sensor);
        OGT75412 = DDS_Signal.createDDSSignal("OGT75412", SignalType.temp_sensor);
        OGDP7131 = DDS_Signal.createDDSSignal("OGDP7131", SignalType.abs_pressure_sensor);
        OGN80011 = DDS_Signal.createDDSSignal("OGN80011", SignalType.motor_speed_sensor);
        OGF75311 = DDS_Signal.createDDSSignal("OGF75311", SignalType.massFlowRate);
        OGF75313 = DDS_Signal.createDDSSignal("OGF75313", SignalType.temp_sensor);
        OGP7111 = DDS_Signal.createDDSSignal("OGP7111", SignalType.abs_pressure_sensor);
        OGRSAquantity = DDS_Signal.createDDSSignal("OGRSAquantity", SignalType.information);
        OGG82421 = DDS_Signal.createDDSSignal("OGG82421", SignalType.volt_sensor);
        OGCS71912 = DDS_Signal.createDDSSignal("OGCS71912", SignalType.abs_pressure_sensor);
        OGN80012 = DDS_Signal.createDDSSignal("OGN80012", SignalType.n2_sensor);
        OGP7312 = DDS_Signal.createDDSSignal("OGP7312", SignalType.abs_pressure_sensor);
        OGP73113 = DDS_Signal.createDDSSignal("OGP73113", SignalType.abs_pressure_sensor);
        OGP71211 = DDS_Signal.createDDSSignal("OGP71211", SignalType.abs_pressure_sensor);
        OGP71212 = DDS_Signal.createDDSSignal("OGP71212", SignalType.abs_pressure_sensor);
        OGT72411 = DDS_Signal.createDDSSignal("OGT72411", SignalType.temp_sensor);
        OGT72412 = DDS_Signal.createDDSSignal("OGT72412", SignalType.temp_sensor);
        fault = DDS_Signal.createDDSSignal("fault", SignalType.information);


        root.getChildren().add(TempSignals);
        root.getChildren().add(OGT72411);
        root.getChildren().add(OGT72412);
        root.getChildren().add(OGT75411);
        root.getChildren().add(OGT75412);

        root.getChildren().add(PressSignals);
        root.getChildren().add(OGP73211);
        root.getChildren().add(OGP73212);
        root.getChildren().add(OGDP7131);
        root.getChildren().add(OGP7111);
        root.getChildren().add(OGP7312);
        root.getChildren().add(OGP73113);
        root.getChildren().add(OGP71211);
        root.getChildren().add(OGP71212);

        root.getChildren().add(motorSpeedSignals);
        root.getChildren().add(OGN80011);
        root.getChildren().add(OGN80012);

        root.getChildren().add(otherSignals);
        root.getChildren().add(OGF75311);
        root.getChildren().add(OGF75313);
        root.getChildren().add(OGG82421);
        root.getChildren().add(OGCS71912);
        root.getChildren().add(OGRSAquantity);
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
            OGP73211.setValue(new Object[]{topic.OGP73211});
            OGP73212.setValue(new Object[]{topic.OGP73212});
            OGT75411.setValue(new Object[]{topic.OGT75411});
            OGT75412.setValue(new Object[]{topic.OGT75412});
            OGDP7131.setValue(new Object[]{topic.OGDP7131});
            OGN80011.setValue(new Object[]{topic.OGN80011});
            OGF75311.setValue(new Object[]{topic.OGF75311});
            OGF75313.setValue(new Object[]{topic.OGF75313});
            OGP7111.setValue(new Object[]{topic.OGP7111});
            OGRSAquantity .setValue(new Object[]{topic.OGRSAquantity});
            OGG82421.setValue(new Object[]{topic.OGG82421});
            OGCS71912.setValue(new Object[]{topic.OGCS71912});
            OGN80012.setValue(new Object[]{topic.OGN80012});
            OGP7312.setValue(new Object[]{topic.OGP7312});
            OGP73113.setValue(new Object[]{topic. OGP73113});
            OGP71211.setValue(new Object[]{topic. OGP71211});
            OGP71212.setValue(new Object[]{topic. OGP71212});
            OGT72411.setValue(new Object[]{topic. OGT72411});
            OGT72412.setValue(new Object[]{topic. OGT72412});
            fault.setValue(new Object[]{topic.fault});

        }

    }

    @Override
    public void initReader() {
        String typeName = OGsensorsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        OGsensorsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (OGsensorsDataReader) subscriber.create_datareader(
                    aTopic,
                    Subscriber.DATAREADER_QOS_DEFAULT,
                    null,
                    StatusKind.STATUS_MASK_ALL);

            if (reader == null) {
                //  System.err.println("Create " + topicName + " DataReader ERROR!\n");

            }
        }
    }

    @Override
    public void initWriter() {
        try {

            // --- Create topic --- //

            /* Register type before creating topic */
            String typeName = OGsensorsTypeSupport.get_type_name();
            OGsensorsTypeSupport.register_type(participant, typeName);

            writer = (OGsensorsDataWriter) publisher.create_datawriter(
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
            OGP73211.updateeMeasure(new Double[]{topic.OGP73211}, SI.PASCAL);
            OGP73212.updateeMeasure(new Double[]{topic.OGP73212}, SI.PASCAL);
            OGT75411.updateeMeasure(new Double[]{topic.OGT75411}, SI.KELVIN);
            OGT75412.updateeMeasure(new Double[]{topic.OGT75412}, SI.KELVIN);
            OGDP7131.updateeMeasure(new Double[]{topic.OGDP7131}, SI.PASCAL);
            OGN80011.updateeMeasure(new Double[]{topic.OGN80011}, NonSI.rpm);
            OGF75311.updateeMeasure(new Double[]{topic.OGF75311}, SI.KILOGRAM_PER_SECOND);
            OGF75313.updateeMeasure(new Double[]{topic.OGF75313}, Unit.ONE);
            OGP7111.updateeMeasure(new Double[]{topic.OGP7111}, SI.PASCAL);
            OGRSAquantity.updateeMeasure(new Double[]{topic.OGRSAquantity}, SI.PASCAL);
            OGG82421.updateeMeasure(new Double[]{topic.OGG82421}, SI.PASCAL);
            OGCS71912.updateeMeasure(new Double[]{topic.OGCS71912}, Unit.ONE);
            OGN80012.updateeMeasure(new Double[]{topic.OGN80012}, NonSI.rpm);
            OGP7312.updateeMeasure(new Double[]{topic.OGP7312}, SI.PASCAL);
            OGP73113.updateeMeasure(new Double[]{topic.OGP73113}, SI.PASCAL);
            OGP71211.updateeMeasure(new Double[]{topic.OGP71211}, SI.PASCAL);
            OGP71212.updateeMeasure(new Double[]{topic.OGP71212}, SI.PASCAL);
            OGT72411.updateeMeasure(new Double[]{topic.OGT72411}, SI.KELVIN);
            OGT72412.updateeMeasure(new Double[]{topic.OGT72412}, SI.KELVIN);
            //fault.updateeMeasure(new Double[]{topic.fault}, SI.PASCAL);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new OGsensorsSeq();
                infoSeq = new SampleInfoSeq();

                reader.take(dataSeq, infoSeq,
                        ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                        SampleStateKind.ANY_SAMPLE_STATE,
                        ViewStateKind.ANY_VIEW_STATE,
                        InstanceStateKind.ANY_INSTANCE_STATE);
//   System.err.println("***********************************in updatetopicdata, the infoSeq.size is "+ dataSeq.size()+"\n");
                for (int i = 0; i < dataSeq.size(); ++i) {
                    info = (SampleInfo) infoSeq.get(i);
                    //System.out.println("in the data reading loop Reading 1A Data");
                    if (info.valid_data) {
                        topic = ((OGsensorsSeq) dataSeq).get(i);
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
}
