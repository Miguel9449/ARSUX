/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OGcomands;

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
public class OGcommandsModel extends CompNodeDataModel {

    public OGcommands topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public OGcommandsDataReader reader;
    public OGcommandsDataWriter writer;
    public OGcommandsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal OGPM4051; // 0
    public DDS_Signal OGSM4052; // 0
    public DDS_Signal OGSV01312; // 0
    public DDS_Signal OGSV0122; // 0
    public DDS_Signal OGSV0581; // 0
    public DDS_Signal OGStackCurrent; // 0
    public DDS_Signal OGSV0322; // 0
    public DDS_Signal OGSV03212; // 0
    public DDS_Signal OGSV03213; // 0
    public DDS_Signal OGSV16421; // 0
    public DDS_Signal OGSV02211; // 0
    public DDS_Signal OGSV02212; // 0
    public DDS_Signal OGHTR8095; // 0

    public DDS_Signal otherSignals;
    public DDS_Signal valveCmds;
    public DDS_Signal currentCmds;


    public OGcommandsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = OGcommandsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.oGcommandsDataReader;
        writer = fragmentsModel.oGcommandsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();

    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("OGA Commands", SignalType.rootSet);


        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        otherSignals = DDS_Signal.createDDSSignal("Other Signals", SignalType.information);

        valveCmds = DDS_Signal.createDDSSignal("Valve Cmds", SignalType.information);
        currentCmds = DDS_Signal.createDDSSignal("Power/Current Cmds", SignalType.information);

        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        OGPM4051 = DDS_Signal.createDDSSignal("OGPM4051", SignalType.on_off_position_cmd);
        OGSM4052 = DDS_Signal.createDDSSignal( "OGSM4052", SignalType.on_off_position_cmd);
        OGSV01312 = DDS_Signal.createDDSSignal("OGSV01312", SignalType.current_sensor);
        OGSV0122 = DDS_Signal.createDDSSignal("OGSV0122", SignalType.on_off_position_cmd);
        OGSV0581 = DDS_Signal.createDDSSignal("OGSV0581", SignalType.on_off_position_cmd);
        OGStackCurrent = DDS_Signal.createDDSSignal("OGStackCurrent", SignalType.current_sensor);
        OGSV0322 = DDS_Signal.createDDSSignal("OGSV0322", SignalType.on_off_position_cmd);
        OGSV03212 = DDS_Signal.createDDSSignal("OGSV03212", SignalType.on_off_position_cmd);
        OGSV03213 = DDS_Signal.createDDSSignal("OGSV03213", SignalType.on_off_position_cmd);
        OGSV16421 = DDS_Signal.createDDSSignal("OGSV16421", SignalType.on_off_position_cmd);
        OGSV02211 = DDS_Signal.createDDSSignal("OGSV02211", SignalType.on_off_position_cmd);
        OGSV02212 = DDS_Signal.createDDSSignal("OGSV02212", SignalType.on_off_position_cmd);
        OGHTR8095 = DDS_Signal.createDDSSignal("OGHTR8095", SignalType.power_sensor);


        root.getChildren().add(valveCmds);
        root.getChildren().add(OGPM4051);
        root.getChildren().add(OGSM4052);
        root.getChildren().add(OGSV0122);
        root.getChildren().add(OGSV0581);
        root.getChildren().add(OGSV0322);
        root.getChildren().add(OGSV03212);
        root.getChildren().add(OGSV03213);
        root.getChildren().add(OGSV16421);
        root.getChildren().add(OGSV02211);
        root.getChildren().add(OGSV02212);

        root.getChildren().add(currentCmds);
        root.getChildren().add(OGStackCurrent);
        root.getChildren().add(OGHTR8095);
        root.getChildren().add(OGSV01312);

        root.getChildren().add(otherSignals);
        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            OGPM4051.setValue(new Object[]{topic.OGPM4051});
            OGSM4052.setValue(new Object[]{topic.OGSM4052});
            OGSV01312.setValue(new Object[]{topic.OGSV01312});
            OGSV0122.setValue(new Object[]{topic.OGSV0122});
            OGSV0581.setValue(new Object[]{topic.OGSV0581});
            OGStackCurrent.setValue(new Object[]{topic.OGStackCurrent});
            OGSV0322.setValue(new Object[]{topic.OGSV0322});
            OGSV03212.setValue(new Object[]{topic.OGSV03212});
            OGSV03213.setValue(new Object[]{topic.OGSV03213});
            OGSV16421.setValue(new Object[]{topic.OGSV16421});
            OGSV02211.setValue(new Object[]{topic.OGSV02211});
            OGSV02212.setValue(new Object[]{topic.OGSV02212});
            OGHTR8095.setValue(new Object[]{topic.OGHTR8095});

        }

    }

    @Override
    public void initReader() {
        if(participant !=null) {
            String typeName = OGcommandsTypeSupport.get_type_name();
           // System.out.println("************************* TypeName " + typeName + "\n");

            OGcommandsTypeSupport.register_type(participant, typeName);

            aTopic = participant.create_topic(
                    "OGcommands",
                    typeName,
                    DomainParticipant.TOPIC_QOS_DEFAULT,
                    null /* listener */,
                    StatusKind.STATUS_MASK_NONE);

            if (aTopic == null) {
                //   System.err.println("Create " + topicName + " error\n");
            } else {
                reader = (OGcommandsDataReader) subscriber.create_datareader(
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
        if(participant !=null) {
            try {
                String typeName = OGcommandsTypeSupport.get_type_name();
                OGcommandsTypeSupport.register_type(participant, typeName);

                writer = (OGcommandsDataWriter) publisher.create_datawriter(
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
    }

    @Override
    public void updateEMeasures() {
        if(topic !=null) {
            // System.out.println("******************************Topic not null")  ;
            OGPM4051.updateeMeasure(new Double[]{topic.OGPM4051}, Unit.ONE);
            OGSM4052.updateeMeasure(new Double[]{topic.OGSM4052}, Unit.ONE);
            OGSV01312.updateeMeasure(new Double[]{topic.OGSV01312},SI.AMPERE);
            OGSV0122.updateeMeasure(new Double[]{topic.OGSV0122}, Unit.ONE);
            OGSV0581.updateeMeasure(new Double[]{topic.OGSV0581}, Unit.ONE);
            OGStackCurrent.updateeMeasure(new Double[]{topic.OGStackCurrent}, SI.AMPERE);
            OGSV0322.updateeMeasure(new Double[]{topic.OGSV0322}, Unit.ONE);
            OGSV03212.updateeMeasure(new Double[]{topic.OGSV03212}, Unit.ONE);
            OGSV03213.updateeMeasure(new Double[]{topic.OGSV03213}, Unit.ONE);
            OGSV16421.updateeMeasure(new Double[]{topic.OGSV16421}, Unit.ONE);
            OGSV02211.updateeMeasure(new Double[]{topic.OGSV02211}, Unit.ONE);
            OGSV02212.updateeMeasure(new Double[]{topic.OGSV02212}, Unit.ONE);
            OGHTR8095.updateeMeasure(new Double[]{topic.OGHTR8095}, SI.WATT);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new OGcommandsSeq();
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
                        topic = ((OGcommandsSeq) dataSeq).get(i);
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

