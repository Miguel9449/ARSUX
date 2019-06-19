/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WPcommands;



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

import javax.measure.unit.Unit;

import MySupportClasses.CompNodeDataModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;

/**
 *
 * @author nextstep
 */
public class WPcommandsModel extends CompNodeDataModel {

    public WPcommands topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public WPcommandsDataReader reader;
    public WPcommandsDataWriter writer;
    public WPcommandsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal WPSV01211; // 0
    public DDS_Signal WPPM4111; // 0
    public DDS_Signal WPSM4121; // 0
    public DDS_Signal WPPP4117; // 0
    public DDS_Signal WPSV01212; // 0
    public DDS_Signal WPSV11211; // 0
    public DDS_Signal WPSV0133; // 0
    public DDS_Signal WPSV11212; // 0
    public DDS_Signal WPSV0122; // 0
    public DDS_Signal WPSV11213; // 0
    public DDS_Signal WPSV1101; // 0
    public DDS_Signal WPSV11261; // 0


    public WPcommandsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = WPcommandsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("WPA Commands", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        WPSV01211 = DDS_Signal.createDDSSignal("WPSV01211", SignalType.on_off_position_cmd);
        WPPM4111 = DDS_Signal.createDDSSignal("WPPM4111", SignalType.on_off_position_cmd);
        WPSM4121 = DDS_Signal.createDDSSignal("WPSM4121", SignalType.on_off_position_cmd);
        WPPP4117 = DDS_Signal.createDDSSignal("WPPP4117", SignalType.on_off_position_cmd);
        WPSV01212 = DDS_Signal.createDDSSignal("WPSV01212", SignalType.on_off_position_cmd);
        WPSV11211 = DDS_Signal.createDDSSignal("WPSV11211", SignalType.on_off_position_cmd);
        WPSV0133 = DDS_Signal.createDDSSignal("WPSV0133", SignalType.on_off_position_cmd);
        WPSV11212 = DDS_Signal.createDDSSignal("WPSV11212", SignalType.on_off_position_cmd);
        WPSV0122 = DDS_Signal.createDDSSignal("WPSV0122", SignalType.on_off_position_cmd);
        WPSV11213 = DDS_Signal.createDDSSignal("WPSV11213", SignalType.on_off_position_cmd);
        WPSV1101 = DDS_Signal.createDDSSignal("WPSV1101", SignalType.on_off_position_cmd);
        WPSV11261 = DDS_Signal.createDDSSignal("WPSV11261", SignalType.on_off_position_cmd);



        root.getChildren().add(WPSV01211);
        root.getChildren().add(WPPM4111);
        root.getChildren().add(WPSM4121);
        root.getChildren().add(WPPP4117);
        root.getChildren().add(WPSV01212);
        root.getChildren().add(WPSV11211);
        root.getChildren().add(WPSV0133);
        root.getChildren().add(WPSV11212);
        root.getChildren().add(WPSV0122);
        root.getChildren().add(WPSV11213);
        root.getChildren().add(WPSV1101);
        root.getChildren().add(WPSV11261);
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
            WPSV01211.setValue(new Object[]{topic.WPSV01211});;
            WPPM4111.setValue(new Object[]{topic.WPPM4111});
            WPSM4121.setValue(new Object[]{topic.WPSM4121});
            WPPP4117.setValue(new Object[]{topic.WPSV01212});
            WPSV01212.setValue(new Object[]{topic.WPSV01212});
            WPSV11211.setValue(new Object[]{topic.WPSV11211});
            WPSV0133.setValue(new Object[]{topic.WPSV0133});
            WPSV11212.setValue(new Object[]{topic.WPSV11212});
            WPSV0122.setValue(new Object[]{topic.WPSV0122});
            WPSV11213.setValue(new Object[]{topic.WPSV11213});
            WPSV1101.setValue(new Object[]{topic.WPSV1101});
            WPSV11261.setValue(new Object[]{topic.WPSV11261});

        }

    }

    @Override
    public void initReader() {
        String typeName = WPcommandsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        WPcommandsTypeSupport.register_type(fragmentsModel.participant, typeName);

        aTopic = fragmentsModel.participant.create_topic(
                "WPcommands",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (WPcommandsDataReader) fragmentsModel.subscriber.create_datareader(
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
            String typeName = WPcommandsTypeSupport.get_type_name();
            WPcommandsTypeSupport.register_type(fragmentsModel.participant, typeName);

            writer = (WPcommandsDataWriter) fragmentsModel.publisher.create_datawriter(
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
            // sample:  ARm_TS01_TP.updateeMeasure(topic.ARm_TS01_TP, SI.KELVIN);
            WPSV01211.updateeMeasure(new Double[]{topic.WPSV01211}, Unit.ONE);
            WPPM4111.updateeMeasure(new Double[]{topic.WPPM4111}, Unit.ONE);
            WPSM4121.updateeMeasure(new Double[]{topic.WPSM4121}, Unit.ONE);
            WPPP4117.updateeMeasure(new Double[]{topic.WPPP4117}, Unit.ONE);
            WPSV01212.updateeMeasure(new Double[]{topic.WPSV01212}, Unit.ONE);
            WPSV11211.updateeMeasure(new Double[]{topic.WPSV11211}, Unit.ONE);
            WPSV0133.updateeMeasure(new Double[]{topic.WPSV0133}, Unit.ONE);
            WPSV11212.updateeMeasure(new Double[]{topic.WPSV11212}, Unit.ONE);
            WPSV0122.updateeMeasure(new Double[]{topic.WPSV0122}, Unit.ONE);
            WPSV11213.updateeMeasure(new Double[]{topic.WPSV11213}, Unit.ONE);
            WPSV1101.updateeMeasure(new Double[]{topic.WPSV1101}, Unit.ONE);
            WPSV11261.updateeMeasure(new Double[]{topic.WPSV11261}, Unit.ONE);


        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new WPcommandsSeq();
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
                        topic = ((WPcommandsSeq) dataSeq).get(i);
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
        fragmentsModel.subscriber.delete_datareader(reader);
        fragmentsModel.publisher.delete_datawriter(writer);
        System.out.println("Participant deleted!");
    }

}

