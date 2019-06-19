/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAuser;

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
public class FAuserModel extends CompNodeDataModel {

    public FAuser topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAuserDataReader reader;
    public FAuserDataWriter writer;
    public FAuserSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal HEXSetTimes; //[0 28800 39600 86399.9]
    public DDS_Signal HEXSetPoints; //[300.15 300.15 300.15 300.15]
    public DDS_Signal Fn01rpm; //14000
    public DDS_Signal HEXcontrolgain; //0.0001


    public FAuserModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = FAuserTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.fAuserDataReader;
        writer = fragmentsModel.fAuserDataWriter;
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


        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        HEXSetTimes = DDS_Signal.createDDSSignal("HEXSetTimes", SignalType.information);
        HEXSetPoints = DDS_Signal.createDDSSignal("HEXSetPoints", SignalType.information);
        Fn01rpm = DDS_Signal.createDDSSignal("Fn01rpm", SignalType.information);
        HEXcontrolgain = DDS_Signal.createDDSSignal("HEXcontrolgain", SignalType.information);

        root.getChildren().add(root);
        state.getChildren().add(state);
        rank.getChildren().add(rank);
        HEXSetTimes.getChildren().add(HEXSetTimes);
        HEXSetPoints.getChildren().add(HEXSetPoints);
        Fn01rpm.getChildren().add(Fn01rpm);
        HEXcontrolgain.getChildren().add(HEXcontrolgain);
         }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
           this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
           id.setValue(new Object[]{topic.id});
           state.setValue(new Object[]{topic.state});
           rank.setValue(new Object[]{topic.rank});
           HEXSetTimes.setValue(new Object[]{topic.HEXSetTimes});
           HEXSetPoints.setValue(new Object[]{topic.HEXSetPoints});
           Fn01rpm.setValue(new Object[]{topic.Fn01rpm});
           HEXcontrolgain.setValue(new Object[]{topic.HEXcontrolgain});



        }

    }

    @Override
    public void initReader() {
        String typeName = FAuserTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        FAuserTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (FAuserDataReader) subscriber.create_datareader(
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
            String typeName = FAuserTypeSupport.get_type_name();
            FAuserTypeSupport.register_type(participant, typeName);

            writer = (FAuserDataWriter) publisher.create_datawriter(
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
            Double[] d = new Double[topic.HEXSetTimes.length];
            for(int i=0;i<topic.HEXSetTimes.length; i++)  {
                d[i] =   topic.HEXSetTimes[0];
            }
            HEXSetTimes.updateeMeasure(d, SI.SECOND);
             d = new Double[topic.HEXSetPoints.length];
            for(int i=0;i<topic.HEXSetPoints.length; i++)  {
                d[i] =   topic.HEXSetPoints[i];
            }
            HEXSetPoints.updateeMeasure(d, Unit.ONE);

             Fn01rpm.updateeMeasure(new Double[]{topic.Fn01rpm}, NonSI.rpm);
             HEXcontrolgain.updateeMeasure(new Double[]{topic.HEXcontrolgain}, Unit.ONE);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new FAuserSeq();
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
                        topic = ((FAuserSeq) dataSeq).get(i);
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
