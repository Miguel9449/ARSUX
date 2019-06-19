/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UPAfluids;

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

import MySupportClasses.CompNodeDataModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;

/**
 *
 * @author nextstep
 */
public class UPAfluidsModel extends CompNodeDataModel {

    public UPAfluids topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public UPAfluidsDataReader reader;
    public UPAfluidsDataWriter writer;
    public UPAfluidsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal UPA2WWkelvins; // 310.15
    public DDS_Signal UPA2WWkgs; // 0
    public DDS_Signal BPAVaporkgs; // 0
    public DDS_Signal BPA2HabHeatW; // 0


    public UPAfluidsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = UPAfluidsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.upAfluidsDataReader;
        writer = fragmentsModel.upAfluidsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("UPA Fluids", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id= DDS_Signal.createDDSSignal("id", SignalType.information);
        UPA2WWkelvins= DDS_Signal.createDDSSignal("id", SignalType.physical);
        UPA2WWkgs= DDS_Signal.createDDSSignal("id", SignalType.physical);
        BPAVaporkgs= DDS_Signal.createDDSSignal("id", SignalType.physical);
        BPA2HabHeatW= DDS_Signal.createDDSSignal("id", SignalType.physical);

         root.getChildren().add(id);
         root.getChildren().add(UPA2WWkelvins);
         root.getChildren().add(UPA2WWkgs);
         root.getChildren().add(BPAVaporkgs);
         root.getChildren().add(BPA2HabHeatW);
    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            UPA2WWkelvins.setValue(new Object[]{topic.UPA2WWkelvins});
            UPA2WWkgs.setValue(new Object[]{topic.UPA2WWkgs});
            BPAVaporkgs.setValue(new Object[]{topic.BPAVaporkgs});
            BPA2HabHeatW.setValue(new Object[]{topic.BPA2HabHeatW});




        }

    }

    @Override
    public void initReader() {
        String typeName = UPAfluidsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        UPAfluidsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (UPAfluidsDataReader) subscriber.create_datareader(
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
            String typeName = UPAfluidsTypeSupport.get_type_name();
            UPAfluidsTypeSupport.register_type(participant, typeName);

            writer = (UPAfluidsDataWriter) publisher.create_datawriter(
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
            UPA2WWkelvins.updateeMeasure(new Double[]{topic.UPA2WWkelvins}, SI.KELVIN);
            UPA2WWkgs.updateeMeasure(new Double[]{topic.UPA2WWkgs}, SI.KILOGRAM_PER_SECOND);
            BPAVaporkgs.updateeMeasure(new Double[]{topic.BPAVaporkgs}, SI.KILOGRAM_PER_SECOND);
            BPA2HabHeatW.updateeMeasure(new Double[]{topic.BPA2HabHeatW}, SI.WATT);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new UPAfluidsSeq();
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
                        topic = ((UPAfluidsSeq) dataSeq).get(i);
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

