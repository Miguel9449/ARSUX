/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAcommands;

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
public class FAcommandsModel extends CompNodeDataModel {

    public FAcommands topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAcommandsDataReader reader;
    public FAcommandsDataWriter writer;
    public FAcommandsSeq dataSeq;
    public SampleInfo info;


    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal AR_Vv02_Enable_CMD; // 0
    public DDS_Signal AR_Vv02_Direction_CMD; // -1
    public DDS_Signal AR_Fn01_Speed_CMD; // 0
    public DDS_Signal AR_Ht09_CMD; // 0
    public DDS_Signal AR_VMVv01_CMD; // 1
    public DDS_Signal AR_Fn02_Speed_CMD; // 0
    public DDS_Signal AR_Pp01_CMD; // 0
    public DDS_Signal AR_Vv03_Enable_CMD; // 0
    public DDS_Signal AR_Vv03_Direction_CMD; // -1
    public DDS_Signal AR_Ht0102_CMD; // 0
    public DDS_Signal AR_Vv04_CMD; // 0
    public DDS_Signal AR_Ht0304_CMD; // 0
    public DDS_Signal AR_Vv05_CMD; // 0
    public DDS_Signal AR_Vv06_Enable_CMD; // 0
    public DDS_Signal AR_Vv06_Direction_CMD; // -1
    public DDS_Signal AR_Vv07_CMD; // 0
    public DDS_Signal AR_Vv08_CMD; // 0
    public DDS_Signal AR_Ht0506_CMD; // 0
    public DDS_Signal AR_Ht0708_CMD; // 0
    public DDS_Signal AR_Vv09_CMD; // 0
    public DDS_Signal AR_CMP_CMD; // 0
    public DDS_Signal AR_Vv10_CMD; // 0
    public DDS_Signal motorCmd;
    public DDS_Signal otherSignals;
    public DDS_Signal heatersCommands;
    public DDS_Signal valveCommands;

public FAcommandsModel(FragmentsModel fragmentsModel) {
    super(fragmentsModel);
    this.topicName = AutomaticCurrentTypeSupport.get_type_name();
    this.setCommStatus(topicName + " not active!");
    reader = fragmentsModel.fAcommandsDataReader;
    writer = fragmentsModel.fAcommandsDataWriter;
    participant = fragmentsModel.participant;
    subscriber = fragmentsModel.subscriber;
    publisher = fragmentsModel.publisher;
    this.initSignalSet();
    this.initReader();
    this.initWriter();
}





    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("FA CommandTelemetry", SignalType.rootSet);

        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("State", SignalType.information);
        rank = DDS_Signal.createDDSSignal("Rank", SignalType.information);
        AR_Vv02_Enable_CMD = DDS_Signal.createDDSSignal("Vv02_Enable", SignalType.on_off_position_cmd);
        AR_Vv02_Direction_CMD = DDS_Signal.createDDSSignal("Vv02_Direction", SignalType.on_off_position_cmd);
        AR_Fn01_Speed_CMD = DDS_Signal.createDDSSignal("Fn01_Speed", SignalType.motor_speed_sensor);
        AR_Ht09_CMD = DDS_Signal.createDDSSignal("Ht09", SignalType.on_off_heater_cmd);
        AR_VMVv01_CMD = DDS_Signal.createDDSSignal("VMVv0", SignalType.on_off_position_cmd);
        AR_Fn02_Speed_CMD = DDS_Signal.createDDSSignal("Fn02_Speed", SignalType.motor_speed_sensor);
        AR_Pp01_CMD = DDS_Signal.createDDSSignal("Pp01_CMD", SignalType.motor_speed_sensor);
        AR_Vv03_Enable_CMD = DDS_Signal.createDDSSignal("Vv03_Enable", SignalType.on_off_position_cmd);
        AR_Vv03_Direction_CMD = DDS_Signal.createDDSSignal("AR_Vv03_Direction", SignalType.on_off_position_cmd);
        AR_Ht0102_CMD = DDS_Signal.createDDSSignal("Ht0102", SignalType.on_off_heater_cmd);
        AR_Vv04_CMD = DDS_Signal.createDDSSignal("Vv04", SignalType.on_off_position_cmd);
        AR_Ht0304_CMD = DDS_Signal.createDDSSignal("AR_Ht0304", SignalType.on_off_heater_cmd);
        AR_Vv05_CMD = DDS_Signal.createDDSSignal("Vv05_CMD", SignalType.on_off_position_cmd);
        AR_Vv06_Enable_CMD = DDS_Signal.createDDSSignal("Vv06_Enable", SignalType.on_off_position_cmd);
        AR_Vv06_Direction_CMD = DDS_Signal.createDDSSignal("AR_Vv06_Direction", SignalType.on_off_position_cmd);
        AR_Vv07_CMD = DDS_Signal.createDDSSignal("Vv07", SignalType.on_off_position_cmd);
        AR_Vv08_CMD = DDS_Signal.createDDSSignal("Vv08", SignalType.on_off_position_cmd);
        AR_Ht0506_CMD = DDS_Signal.createDDSSignal("Ht0506", SignalType.on_off_heater_cmd);
        AR_Ht0708_CMD = DDS_Signal.createDDSSignal("Ht0708", SignalType.on_off_heater_cmd);
        AR_Vv09_CMD = DDS_Signal.createDDSSignal("Vv09", SignalType.on_off_position_cmd);
        AR_CMP_CMD = DDS_Signal.createDDSSignal("CMP", SignalType.on_off_position_cmd);
        AR_Vv10_CMD = DDS_Signal.createDDSSignal("Vv10", SignalType.on_off_position_cmd);

        motorCmd = DDS_Signal.createDDSSignal("Motor Speed Cmd", SignalType.information);
        otherSignals = DDS_Signal.createDDSSignal("Other Cmd Signals", SignalType.information);
        heatersCommands = DDS_Signal.createDDSSignal("Heater Commands", SignalType.information);
        valveCommands = DDS_Signal.createDDSSignal("Valve Commands", SignalType.information);



        root.getChildren().add(motorCmd);
        root.getChildren().add(AR_Fn01_Speed_CMD);
        root.getChildren().add(AR_Fn02_Speed_CMD);
        root.getChildren().add(AR_Pp01_CMD);

        root.getChildren().add(valveCommands);
        root.getChildren().add(AR_VMVv01_CMD);
        root.getChildren().add(AR_Vv02_Enable_CMD);
        root.getChildren().add(AR_Vv02_Direction_CMD);
        root.getChildren().add(AR_Vv03_Enable_CMD);
        root.getChildren().add(AR_Vv03_Direction_CMD);
        root.getChildren().add(AR_Vv04_CMD);
        root.getChildren().add(AR_Vv05_CMD);
        root.getChildren().add(AR_Vv06_Enable_CMD);
        root.getChildren().add(AR_Vv06_Direction_CMD);
        root.getChildren().add(AR_Vv07_CMD);
        root.getChildren().add(AR_Vv08_CMD);
        root.getChildren().add(AR_Vv09_CMD);
        root.getChildren().add(AR_Vv10_CMD);

        root.getChildren().add(heatersCommands);
        root.getChildren().add(AR_Ht0102_CMD);
        root.getChildren().add(AR_Ht0304_CMD);
        root.getChildren().add(AR_Ht0506_CMD);
        root.getChildren().add(AR_Ht0708_CMD);
        root.getChildren().add(AR_Ht09_CMD);



        root.getChildren().add(otherSignals);
        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(AR_CMP_CMD);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            AR_Vv02_Enable_CMD.setValue(new Object[]{topic.AR_Vv02_Enable_CMD});
            AR_Vv02_Direction_CMD.setValue(new Object[]{topic.AR_Vv02_Direction_CMD});
            AR_Fn01_Speed_CMD.setValue(new Object[]{topic.AR_Fn01_Speed_CMD});
            AR_Ht09_CMD.setValue(new Object[]{topic.AR_Ht09_CMD});
            AR_VMVv01_CMD.setValue(new Object[]{topic.AR_VMVv01_CMD});
            AR_Fn02_Speed_CMD.setValue(new Object[]{topic.AR_Fn02_Speed_CMD});
            AR_Pp01_CMD.setValue(new Object[]{topic.AR_Pp01_CMD});
            AR_Vv03_Enable_CMD.setValue(new Object[]{topic.AR_Vv03_Enable_CMD});
            AR_Vv03_Direction_CMD.setValue(new Object[]{topic.AR_Vv03_Direction_CMD});
            AR_Ht0102_CMD.setValue(new Object[]{topic.AR_Ht0102_CMD});
            AR_Vv04_CMD.setValue(new Object[]{topic.AR_Vv04_CMD});
            AR_Ht0304_CMD.setValue(new Object[]{topic.AR_Ht0304_CMD});
            AR_Vv05_CMD.setValue(new Object[]{topic.AR_Vv05_CMD});
            AR_Vv06_Enable_CMD.setValue(new Object[]{topic.AR_Vv06_Enable_CMD});
            AR_Vv06_Direction_CMD.setValue(new Object[]{topic.AR_Vv06_Direction_CMD});
            AR_Vv07_CMD.setValue(new Object[]{topic.AR_Vv07_CMD});
            AR_Vv08_CMD.setValue(new Object[]{topic.AR_Vv08_CMD});
            AR_Ht0506_CMD.setValue(new Object[]{topic.AR_Ht0506_CMD});
            AR_Ht0708_CMD.setValue(new Object[]{topic.AR_Ht0708_CMD});
            AR_Vv09_CMD.setValue(new Object[]{topic.AR_Vv09_CMD});
            AR_CMP_CMD.setValue(new Object[]{topic.AR_CMP_CMD});
            AR_Vv10_CMD.setValue(new Object[]{topic.AR_Vv10_CMD});

        }
        this.updateEMeasures();

    }

    @Override
    public void initReader() {
        if(reader == null) {
            String typeName = FAcommandsTypeSupport.get_type_name();
            FAcommandsTypeSupport.register_type(participant, typeName);
            //System.out.println("************************* TypeName " +typeName+"\n");
            //System.out.println("************************* StatusKind " +StatusKind.STATUS_MASK_NONE+"\n");
            aTopic = participant.create_topic(
                    "FAcommands",
                    typeName,
                    DomainParticipant.TOPIC_QOS_DEFAULT,
                    null /* listener */,
                    StatusKind.STATUS_MASK_NONE);

            if (aTopic == null) {
                //   System.err.println("Create " + topicName + " error\n");
            } else {
                reader = (FAcommandsDataReader) subscriber.create_datareader(
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
            String typeName = FAcommandsTypeSupport.get_type_name();
            FAcommandsTypeSupport.register_type(participant, typeName);

            writer = (FAcommandsDataWriter) publisher.create_datawriter(
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

            AR_Vv02_Enable_CMD.updateeMeasure(new Double[]{topic.AR_Vv02_Enable_CMD}, Unit.ONE);
            AR_Vv02_Direction_CMD.updateeMeasure(new Double[]{topic.AR_Vv02_Direction_CMD}, Unit.ONE);
            AR_Fn01_Speed_CMD.updateeMeasure(new Double[]{topic.AR_Fn01_Speed_CMD}, NonSI.rpm);
            AR_Ht09_CMD.updateeMeasure(new Double[]{topic.AR_Ht09_CMD}, Unit.ONE);
            AR_VMVv01_CMD.updateeMeasure(new Double[]{topic.AR_VMVv01_CMD}, Unit.ONE);
            AR_Fn02_Speed_CMD.updateeMeasure(new Double[]{topic.AR_Fn02_Speed_CMD},  NonSI.rpm);
            AR_Pp01_CMD.updateeMeasure(new Double[]{topic.AR_Pp01_CMD},  NonSI.rpm);
            AR_Vv03_Enable_CMD.updateeMeasure(new Double[]{topic.AR_Vv03_Enable_CMD}, Unit.ONE);
            AR_Vv03_Direction_CMD.updateeMeasure(new Double[]{topic.AR_Vv03_Direction_CMD}, Unit.ONE);
            AR_Ht0102_CMD.updateeMeasure(new Double[]{topic.AR_Ht0102_CMD}, Unit.ONE);
            AR_Vv04_CMD.updateeMeasure(new Double[]{topic.AR_Vv04_CMD}, Unit.ONE);
            AR_Ht0304_CMD.updateeMeasure(new Double[]{topic.AR_Ht0304_CMD}, Unit.ONE);
            AR_Vv05_CMD.updateeMeasure(new Double[]{topic.AR_Vv05_CMD}, Unit.ONE);
            AR_Vv06_Enable_CMD.updateeMeasure(new Double[]{topic.AR_Vv06_Enable_CMD}, Unit.ONE);
            AR_Vv06_Direction_CMD.updateeMeasure(new Double[]{topic.AR_Vv06_Direction_CMD}, Unit.ONE);
            AR_Vv07_CMD.updateeMeasure(new Double[]{topic.AR_Vv07_CMD}, Unit.ONE);
            AR_Vv08_CMD.updateeMeasure(new Double[]{topic.AR_Vv08_CMD}, Unit.ONE);
            AR_Ht0506_CMD.updateeMeasure(new Double[]{topic.AR_Ht0506_CMD}, Unit.ONE);
            AR_Ht0708_CMD.updateeMeasure(new Double[]{topic.AR_Ht0708_CMD}, Unit.ONE);
            AR_Vv09_CMD.updateeMeasure(new Double[]{topic.AR_Vv09_CMD}, Unit.ONE);
            AR_CMP_CMD.updateeMeasure(new Double[]{topic.AR_CMP_CMD}, Unit.ONE);
            AR_Vv10_CMD.updateeMeasure(new Double[]{topic.AR_Vv10_CMD}, Unit.ONE);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new FAcommandsSeq();
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
                        topic = ((FAcommandsSeq) dataSeq).get(i);
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

//    @Override
//    public void deleteWriterReader() {
//        System.out.println("Hold on ... shutting down DDS!");
//        subscriber.delete_datareader(reader);
//        publisher.delete_datawriter(writer);
//        System.out.println("Participant deleted!");
//    }


    @Override
    public void deleteWriterReader() {

    }
}

