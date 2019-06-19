/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAparams;

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
public class FAparamsModel extends CompNodeDataModel {

    public FAparams topic; public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAparamsDataReader reader;
    public FAparamsDataWriter writer;
    public FAparamsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal CHXscalingfactor; // 1
    public DDS_Signal CHXcoolantpph; // 1230
    public DDS_Signal HTCOtemperatureK; //[458 474 499 515 531 539 551 566 574 614 622 646 662 663 666]
    public DDS_Signal HTCOefficiency; //[0 0.0027 0.021 0.043 0.088 0.122 0.158 0.257 0.443 0.677 0.762 0.855 0.902 0.936 0.952]
    public DDS_Signal HTCOheaterScalingFactor; //1


    public FAparamsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = FAparamsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.fAparamsDataReader;
        writer = fragmentsModel.fAparamsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("FA Params", SignalType.rootSet);
        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        state = DDS_Signal.createDDSSignal("State", SignalType.information);
        rank = DDS_Signal.createDDSSignal("Rank", SignalType.information);
        CHXscalingfactor = DDS_Signal.createDDSSignal("CHXscalingfactor", SignalType.parameter);
        CHXcoolantpph = DDS_Signal.createDDSSignal("CHXcoolantpph", SignalType.parameter);
        HTCOtemperatureK = DDS_Signal.createDDSSignal("HTCOtemperatureK", SignalType.parameter);
        HTCOefficiency = DDS_Signal.createDDSSignal("HTCOefficiency", SignalType.parameter);
        HTCOheaterScalingFactor = DDS_Signal.createDDSSignal("HTCOheaterScalingFactor", SignalType.parameter);


        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(CHXscalingfactor);
        root.getChildren().add(CHXcoolantpph);
        root.getChildren().add(HTCOtemperatureK);
        root.getChildren().add(HTCOefficiency);
        root.getChildren().add(HTCOheaterScalingFactor);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");

            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            CHXscalingfactor.setValue(new Object[]{topic.CHXscalingfactor});
            CHXcoolantpph.setValue(new Object[]{topic.CHXcoolantpph});
            HTCOtemperatureK.setValue(new Object[]{topic.HTCOtemperatureK});
            HTCOefficiency.setValue(new Object[]{topic.HTCOefficiency});
            HTCOheaterScalingFactor.setValue(new Object[]{topic.HTCOheaterScalingFactor});

        }
        this.updateEMeasures();

    }

    @Override
    public void initReader() {
        String typeName = FAparamsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        FAparamsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (FAparamsDataReader) subscriber.create_datareader(
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
            String typeName = FAparamsTypeSupport.get_type_name();
            FAparamsTypeSupport.register_type(participant, typeName);

            writer = (FAparamsDataWriter) publisher.create_datawriter(
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

            CHXscalingfactor.updateeMeasure(new Double[]{topic.CHXscalingfactor}, Unit.ONE);
            CHXcoolantpph.updateeMeasure(new Double[]{topic.CHXcoolantpph}, NonSI.POUND_PER_FOOT_HOUR);
            Double[] d = new Double[topic.HTCOtemperatureK.length];
            for(int i=0;i<topic.HTCOtemperatureK.length; i++)  {
                d[i] =   topic.HTCOtemperatureK[i];
            }
            HTCOtemperatureK.updateeMeasure(d, SI.KELVIN);
            d = new Double[topic.HTCOefficiency.length];
            for(int i=0;i<topic.HTCOefficiency.length; i++)  {
                d[i] =   topic.HTCOefficiency[i];
            }
            HTCOefficiency.updateeMeasure(d, Unit.ONE);
            HTCOheaterScalingFactor.updateeMeasure(new Double[]{topic.HTCOheaterScalingFactor}, Unit.ONE);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new FAparamsSeq();
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
                        topic = ((FAparamsSeq) dataSeq).get(i);
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

