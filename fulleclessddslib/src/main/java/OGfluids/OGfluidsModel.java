/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OGfluids;


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
public class OGfluidsModel extends CompNodeDataModel {

    public OGfluids topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public OGfluidsDataReader reader;
    public OGfluidsDataWriter writer;
    public OGfluidsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal WD2OGkgs; // 0
    public DDS_Signal OG2WWkgs; // 0
    public DDS_Signal OG2WWkelvins; // 293.15
    public DDS_Signal OGO2kgs; // 0
    public DDS_Signal OGO2molpers; // [0, 0, 0, 0]
    public DDS_Signal OGO2kelvins; // 293.15
    public DDS_Signal FA2SAkgs; // 0
    public DDS_Signal OG2HabHeatW; // 70
    public DDS_Signal OGH2kelvins; // 293.15
    public DDS_Signal SA2WWkgs; // 0
    public DDS_Signal SA2WWkelvins; // 290


    public OGfluidsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = OGfluidsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.oGfluidsDataReader;
        writer = fragmentsModel.oGfluidsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("OGA Fluids", SignalType.rootSet);


        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        WD2OGkgs = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OG2WWkgs = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OG2WWkelvins = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OGO2kgs = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OGO2molpers = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OGO2kelvins = DDS_Signal.createDDSSignal("id", SignalType.physical);
        FA2SAkgs = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OG2HabHeatW = DDS_Signal.createDDSSignal("id", SignalType.physical);
        OGH2kelvins = DDS_Signal.createDDSSignal("id", SignalType.physical);
        SA2WWkgs = DDS_Signal.createDDSSignal("id", SignalType.physical);
        SA2WWkelvins = DDS_Signal.createDDSSignal("id", SignalType.physical);

        root.getChildren().add(id);
        root.getChildren().add(WD2OGkgs);
        root.getChildren().add(OG2WWkgs);
        root.getChildren().add(OG2WWkelvins);
        root.getChildren().add(OGO2kgs);
        root.getChildren().add(OGO2molpers);
        root.getChildren().add(OGO2kelvins);
        root.getChildren().add(FA2SAkgs);
        root.getChildren().add(OG2HabHeatW);
        root.getChildren().add(OGH2kelvins);
        root.getChildren().add(SA2WWkgs);
        root.getChildren().add(SA2WWkelvins);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            WD2OGkgs.setValue(new Object[]{topic.WD2OGkgs});
            OG2WWkgs.setValue(new Object[]{topic.OG2WWkgs});
            OG2WWkelvins.setValue(new Object[]{topic.OG2WWkelvins});
            OGO2kgs.setValue(new Object[]{topic.OGO2kgs});
            OGO2molpers.setValue(new Object[]{topic.OGO2molpers});
            OGO2kelvins.setValue(new Object[]{topic.OGO2kelvins});
            FA2SAkgs.setValue(new Object[]{topic.FA2SAkgs});
            OG2HabHeatW.setValue(new Object[]{topic.OG2HabHeatW});
            OGH2kelvins.setValue(new Object[]{topic.OGH2kelvins});
            SA2WWkgs.setValue(new Object[]{topic.SA2WWkgs});
            SA2WWkelvins.setValue(new Object[]{topic.SA2WWkelvins});

        }

    }

    @Override
    public void initReader() {
        String typeName = OGfluidsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        OGfluidsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (OGfluidsDataReader) subscriber.create_datareader(
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
            String typeName = OGfluidsTypeSupport.get_type_name();
            OGfluidsTypeSupport.register_type(participant, typeName);

            writer = (OGfluidsDataWriter) publisher.create_datawriter(
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
            WD2OGkgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            WD2OGkgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            OG2WWkgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            OG2WWkelvins.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KELVIN);
            OGO2kgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            OGO2molpers.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.MOLE.divide(SI.SECOND));
            OGO2kelvins.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KELVIN);
            FA2SAkgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            OG2HabHeatW.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.WATT);
            OGH2kelvins.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KELVIN);
            SA2WWkgs.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KILOGRAM);
            SA2WWkelvins.updateeMeasure(new Double[]{topic.WD2OGkgs}, SI.KELVIN);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new OGfluidsSeq();
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
                        topic = ((OGfluidsSeq) dataSeq).get(i);
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
