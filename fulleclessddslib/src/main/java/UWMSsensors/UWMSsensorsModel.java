/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UWMSsensors;

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
public class UWMSsensorsModel extends CompNodeDataModel {

    public UWMSsensors topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public UWMSsensorsDataReader reader;
    public UWMSsensorsDataWriter writer;
    public UWMSsensorsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal Micturition; // 0
    public DDS_Signal P; // 0
    public DDS_Signal S01; // 0
    public DDS_Signal fault;

    public DDS_Signal otherSignals;


    public UWMSsensorsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = UWMSsensorsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.uwmSsensorsDataReader;
        writer = fragmentsModel.uwmSsensorsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("UWMS Sensor Telemetry", SignalType.rootSet);
        otherSignals = DDS_Signal.createDDSSignal("Other Commands Signals", SignalType.information);

        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state = DDS_Signal.createDDSSignal("id", SignalType.information);
        Micturition = DDS_Signal.createDDSSignal("id", SignalType.information);
        P = DDS_Signal.createDDSSignal("id", SignalType.information);
        S01 = DDS_Signal.createDDSSignal("id", SignalType.information);
        fault = DDS_Signal.createDDSSignal("id", SignalType.information);


        root.getChildren().add(Micturition);
        root.getChildren().add(P);
        root.getChildren().add(S01);
        root.getChildren().add(otherSignals);
        root.getChildren().add(fault);
        root.getChildren().add(id);
        root.getChildren().add(state);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
             state.setValue(new Object[]{topic.state});
             Micturition.setValue(new Object[]{topic.Micturition});
             P.setValue(new Object[]{topic.P});
             S01.setValue(new Object[]{topic.S01});
             fault.setValue(new Object[]{topic.fault});

        }

    }

    @Override
    public void initReader() {
        String typeName = UWMSsensorsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        UWMSsensorsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (UWMSsensorsDataReader) subscriber.create_datareader(
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
            String typeName = UWMSsensorsTypeSupport.get_type_name();
            UWMSsensorsTypeSupport.register_type(participant, typeName);

            writer = (UWMSsensorsDataWriter) publisher.create_datawriter(
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
            Micturition.updateeMeasure(new Double[]{topic.Micturition}, SI.KILOGRAM);
            P.updateeMeasure(new Double[]{topic.P}, SI.KILOGRAM);
            S01.updateeMeasure(new Double[]{topic.S01}, SI.KILOGRAM);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new UWMSsensorsSeq();
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
                        topic = ((UWMSsensorsSeq) dataSeq).get(i);
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
