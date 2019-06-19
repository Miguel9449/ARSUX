/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WPusers;

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
public class WPuserModel extends CompNodeDataModel {

    public WPuser topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public WPuserDataReader reader;
    public WPuserDataWriter writer;
    public WPuserSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal rank;
    public DDS_Signal WWkgMin; //2
    public DDS_Signal WWkgTrip; //11
    public DDS_Signal WSkgMin; //2
    public DDS_Signal WSkgTrip; //45
    public DDS_Signal WSkgMax; //54



    public WPuserModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = WPuserTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.wPuserDataReader;
        writer = fragmentsModel.wPuserDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }




    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("WPA User Command", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id       = DDS_Signal.createDDSSignal(" id       ", SignalType.information);
        state    = DDS_Signal.createDDSSignal(" state    ", SignalType.information);
        rank     = DDS_Signal.createDDSSignal(" rank     ", SignalType.command);
        WWkgMin  = DDS_Signal.createDDSSignal(" WWkgMin  ", SignalType.command);
        WWkgTrip = DDS_Signal.createDDSSignal(" WWkgTrip ", SignalType.command);
        WSkgMin  = DDS_Signal.createDDSSignal(" WSkgMin  ", SignalType.command);
        WSkgTrip = DDS_Signal.createDDSSignal(" WSkgTrip ", SignalType.command);
        WSkgMax  = DDS_Signal.createDDSSignal(" WSkgMax  ", SignalType.command);

        //sample: root.getChildren().add(co2SetLabel);
        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(rank);
        root.getChildren().add(WWkgMin);
        root.getChildren().add(WWkgTrip);
        root.getChildren().add(WSkgMin);
        root.getChildren().add(WSkgTrip);
        root.getChildren().add(WSkgMax);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            //Sample: ARm_TS01_TP.setValue(topic.ARm_TS01_TP);
            id      .setValue(new Object[]{topic.id      });
            state   .setValue(new Object[]{topic.state   });
            rank    .setValue(new Object[]{topic.rank    });
            WWkgMin .setValue(new Object[]{topic.WWkgMin });
            WWkgTrip.setValue(new Object[]{topic.WWkgTrip});
            WSkgMin .setValue(new Object[]{topic.WSkgMin });
            WSkgTrip.setValue(new Object[]{topic.WSkgTrip});
            WSkgMax .setValue(new Object[]{topic.WSkgMax });


        }

    }

    @Override
    public void initReader() {
        String typeName = WPuserTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        WPuserTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (WPuserDataReader) subscriber.create_datareader(
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
            String typeName = WPuserTypeSupport.get_type_name();
            WPuserTypeSupport.register_type(fragmentsModel.participant, typeName);

            writer = (WPuserDataWriter) fragmentsModel.publisher.create_datawriter(
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
            WWkgMin .updateeMeasure(new Double[]{topic.WWkgMin }, SI.KILOGRAM);
            WWkgTrip.updateeMeasure(new Double[]{topic.WWkgTrip}, SI.KILOGRAM);
            WSkgMin .updateeMeasure(new Double[]{topic.WSkgMin }, SI.KILOGRAM);
            WSkgTrip.updateeMeasure(new Double[]{topic.WSkgTrip}, SI.KILOGRAM);
            WSkgMax .updateeMeasure(new Double[]{topic.WSkgMax }, SI.KILOGRAM);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new WPuserSeq();
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
                        topic = ((WPuserSeq) dataSeq).get(i);
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

