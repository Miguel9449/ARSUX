/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UPAcommands;

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
public class UPAcommandsModel extends CompNodeDataModel {

    public UPAcommands topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public UPAcommandsDataReader reader;
    public UPAcommandsDataWriter writer;
    public UPAcommandsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal BPA; // 0
    public DDS_Signal Replace; // FALSE
    public DDS_Signal M1; // 0
    public DDS_Signal M2; // 0
    public DDS_Signal M4; // 50
    public DDS_Signal DrainARFTA; // FALSE


    public UPAcommandsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = UPAcommandsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.upAcommandsDataReader;
        writer = fragmentsModel.upAcommandsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("UPA Commands", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        BPA = DDS_Signal.createDDSSignal("BPA", SignalType.command);
        Replace = DDS_Signal.createDDSSignal("Replace", SignalType.command);
        M1 = DDS_Signal.createDDSSignal("M1", SignalType.command);
        M2 = DDS_Signal.createDDSSignal("M2", SignalType.command);
        M4 = DDS_Signal.createDDSSignal("M3", SignalType.command);
        DrainARFTA = DDS_Signal.createDDSSignal("DrainARFTA", SignalType.command);



        root.getChildren().add(BPA);
        root.getChildren().add(Replace);
        root.getChildren().add(M1);
        root.getChildren().add(M2);
        root.getChildren().add(M4);
        root.getChildren().add(DrainARFTA);
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
            BPA.setValue(new Object[]{topic.BPA});
            Replace.setValue(new Object[]{topic.Replace});
            M1.setValue(new Object[]{topic.M1});
            M2.setValue(new Object[]{topic.M2});
            M4.setValue(new Object[]{topic.M4});
            DrainARFTA.setValue(new Object[]{topic.DrainARFTA});

        }

    }

    @Override
    public void initReader() {
        String typeName = UPAcommandsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        UPAcommandsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "UPAcommandslTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (UPAcommandsDataReader) subscriber.create_datareader(
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
            String typeName = UPAcommandsTypeSupport.get_type_name();
            UPAcommandsTypeSupport.register_type(participant, typeName);

            writer = (UPAcommandsDataWriter) publisher.create_datawriter(
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
            BPA.updateeMeasure(new Double[]{topic.BPA}, Unit.ONE);
           // boolean Replace.updateeMeasure(new Double[]{topic.Replace}, Unit.ONE);
            M1.updateeMeasure(new Double[]{topic.M1}, Unit.ONE);
            M2.updateeMeasure(new Double[]{topic.M2}, Unit.ONE);
            M4.updateeMeasure(new Double[]{topic.M4}, Unit.ONE);
           // Boolean DrainARFTA.updateeMeasure(new Double[]{topic.DrainARFTA}, Unit.ONE);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new UPAcommandsSeq();
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
                        topic = ((UPAcommandsSeq) dataSeq).get(i);
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
