/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WPparams;

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
public class WPparamsModel extends CompNodeDataModel {

    public WPparams topic;
    public Topic aTopic;
    public WPparamsDataReader reader;
    public WPparamsDataWriter writer;
    public WPparamsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal T_MTCL_K; // 289.81667
    public DDS_Signal PROCESSkgs; // 0.00063000
    public DDS_Signal DELIVERYkgs; // 0.090719


    public WPparamsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = WPparamsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("WPA Parameters", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("state", SignalType.information);
        rank = DDS_Signal.createDDSSignal("rank", SignalType.information);
        T_MTCL_K = DDS_Signal.createDDSSignal("T_MTCL_K", SignalType.parameter);
        PROCESSkgs = DDS_Signal.createDDSSignal("PROCESSkgs", SignalType.parameter);
        DELIVERYkgs = DDS_Signal.createDDSSignal("DELIVERYkgs", SignalType.parameter);

        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(T_MTCL_K);
        root.getChildren().add(PROCESSkgs);
        root.getChildren().add(DELIVERYkgs);




    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            rank.setValue(new Object[]{topic.rank});
            T_MTCL_K.setValue(new Object[]{topic.T_MTCL_K});
            PROCESSkgs.setValue(new Object[]{topic.PROCESSkgs});
            DELIVERYkgs.setValue(new Object[]{topic.DELIVERYkgs});


        }

    }

    @Override
    public void initReader() {
        String typeName = WPparamsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        WPparamsTypeSupport.register_type(fragmentsModel.participant, typeName);

        aTopic = fragmentsModel.participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (WPparamsDataReader) fragmentsModel.subscriber.create_datareader(
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
            String typeName = WPparamsTypeSupport.get_type_name();
            WPparamsTypeSupport.register_type(fragmentsModel.participant, typeName);

            writer = (WPparamsDataWriter) fragmentsModel.publisher.create_datawriter(
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
            T_MTCL_K.updateeMeasure(new Double[]{topic.T_MTCL_K}, Unit.ONE);
            PROCESSkgs.updateeMeasure(new Double[]{topic.PROCESSkgs}, SI.KILOGRAM);
            DELIVERYkgs.updateeMeasure(new Double[]{topic.DELIVERYkgs}, SI.KILOGRAM);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new WPparamsSeq();
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
                        topic = ((WPparamsSeq) dataSeq).get(i);
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

