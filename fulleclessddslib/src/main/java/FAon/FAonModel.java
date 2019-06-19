/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAon;

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

import static MySupportClasses.DDS_Signal.createDDSSignal;

/**
 *
 * @author nextstep
 */
public class FAonModel extends CompNodeDataModel {

    public FAon topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAonDataReader reader;
    public FAonDataWriter writer;
    public FAonSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal FAon; // 0


    public FAonModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = FAonTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.fAonDataReader;
        writer = fragmentsModel.fAonDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = createDDSSignal("FA on Telemetry", SignalType.rootSet);
        state = createDDSSignal("State", SignalType.command);
        rank = createDDSSignal("Rank", SignalType.command);
        FAon = createDDSSignal("On", SignalType.command);

        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(FAon);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");

            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            FAon.setValue(new Object[]{topic.FAon});

        }

    }

    @Override
    public void initReader() {
        String typeName = FAonTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        FAonTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (FAonDataReader) subscriber.create_datareader(
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
            String typeName = FAonTypeSupport.get_type_name();
            FAonTypeSupport.register_type(participant, typeName);

            writer = (FAonDataWriter) publisher.create_datawriter(
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
            //state.updateeMeasure(topic.ARm_TS01_TP, SI.KELVIN);
            //rank.updateeMeasure(topic.ARm_TS01_TP, SI.KELVIN);
            FAon.updateeMeasure(new Double[]{topic.FAon}, Unit.ONE);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        //   System.err.println("***********************************just entered the if in updatetopicdata \n");
        if (reader != null) try {
            dataSeq = new FAonSeq();
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
                    topic = ((FAonSeq) dataSeq).get(i);
                    if (topic == null) {
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
    @Override
    public void deleteWriterReader() {
        System.out.println("Hold on ... shutting down DDS!");
        subscriber.delete_datareader(reader);
        publisher.delete_datawriter(writer);
        System.out.println("Participant deleted!");
    }


}
