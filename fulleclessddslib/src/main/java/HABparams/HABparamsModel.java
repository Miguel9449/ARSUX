/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HABparams;

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
public class HABparamsModel extends CompNodeDataModel {

    public HABparams topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public HABparamsDataReader reader;
    public HABparamsDataWriter writer;
    public HABparamsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal AirVolume; // 55
    public DDS_Signal DistrEqLength; // 8.44
    public DDS_Signal CrewParameters; //[3,2,2,2,5,5,8,0,1.5,1.778,0,0.7]
    public DDS_Signal HabHeatTimes; //[0 12]
    public DDS_Signal HabHeat; //[1000 1000]


    public HABparamsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = HABparamsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.haBparamsDataReader;
        writer = fragmentsModel.haBparamsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("Habitat Parameter", SignalType.rootSet);


      id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        AirVolume = DDS_Signal.createDDSSignal("AirVolume", SignalType.information);
        DistrEqLength = DDS_Signal.createDDSSignal("DistrEqLength", SignalType.information);
        CrewParameters = DDS_Signal.createDDSSignal("CrewParameters", SignalType.information);
        HabHeatTimes = DDS_Signal.createDDSSignal("HabHeatTimes", SignalType.information);
        HabHeat = DDS_Signal.createDDSSignal("HabHeat", SignalType.information);

        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(AirVolume);
        root.getChildren().add(DistrEqLength);
        root.getChildren().add(CrewParameters);
        root.getChildren().add(HabHeatTimes);
        root.getChildren().add(HabHeat);


    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            AirVolume.setValue(new Object[]{topic.AirVolume});
            DistrEqLength.setValue(new Object[]{topic.DistrEqLength});
            CrewParameters.setValue(new Object[]{topic.CrewParameters});
            HabHeatTimes.setValue(new Object[]{topic.HabHeatTimes});
            HabHeat.setValue(new Object[]{topic.HabHeat});

        }

    }

    @Override
    public void initReader() {
        String typeName = HABparamsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        HABparamsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (HABparamsDataReader) subscriber.create_datareader(
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
            String typeName = HABparamsTypeSupport.get_type_name();
            HABparamsTypeSupport.register_type(participant, typeName);

            writer = (HABparamsDataWriter) publisher.create_datawriter(
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

            AirVolume.updateeMeasure(new Double[]{topic.AirVolume}, SI.CUBIC_METRE);
            DistrEqLength.updateeMeasure(new Double[]{topic.DistrEqLength}, SI.CUBIC_METRE);
            Double[] d = new Double[topic.CrewParameters.length];
            for(int i=0;i<topic.CrewParameters.length; i++)  {
                d[i] =   topic.CrewParameters[i];
            }
            CrewParameters.updateeMeasure(d, Unit.ONE);
             d = new Double[topic.HabHeatTimes.length];
            for(int i=0;i<topic.HabHeatTimes.length; i++)  {
                d[i] =   topic.HabHeatTimes[i];
            }
            HabHeatTimes.updateeMeasure(d, SI.SECOND);
            d = new Double[topic.HabHeat.length];
            for(int i=0;i<topic.HabHeat.length; i++)  {
                d[i] =   topic.HabHeat[i];
            }
            HabHeat.updateeMeasure(d, SI.WATT);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new HABparamsSeq();
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
                        topic = ((HABparamsSeq) dataSeq).get(i);
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
