/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UPAsensors;

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
public class UPAsensorsModel extends CompNodeDataModel {

    public UPAsensors topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public UPAsensorsDataReader reader;
    public UPAsensorsDataWriter writer;
    public UPAsensorsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal WSTAkg; // 0.1
    public DDS_Signal ARFTAkg; // 1.1
    public DDS_Signal BPAkg; // 0.1
    public DDS_Signal S2; // 0
    public DDS_Signal S5; // 0
    public DDS_Signal K1; // 200
    public DDS_Signal fault;

    public DDS_Signal otherSignals;
    public DDS_Signal massQuantity;

    public UPAsensorsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = UPAsensorsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.upAsensorsDataReader;
        writer = fragmentsModel.upAsensorsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("UPA Sensor Telemetry", SignalType.rootSet);
        otherSignals = DDS_Signal.createDDSSignal("Other Signals", SignalType.information);
        massQuantity = DDS_Signal.createDDSSignal("Mass Quantities", SignalType.information);

        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
         id = DDS_Signal.createDDSSignal("id", SignalType.information);
         state = DDS_Signal.createDDSSignal("state", SignalType.information);
         WSTAkg = DDS_Signal.createDDSSignal("WSTAkg", SignalType.mass_sensor);
         ARFTAkg = DDS_Signal.createDDSSignal("ARFTAkg", SignalType.mass_sensor);
         BPAkg = DDS_Signal.createDDSSignal("BPAkg", SignalType.mass_sensor);
         S2 = DDS_Signal.createDDSSignal("S2", SignalType.some_sensor);
         S5 = DDS_Signal.createDDSSignal("S5", SignalType.some_sensor);
         K1 = DDS_Signal.createDDSSignal("K1", SignalType.some_sensor);
         fault = DDS_Signal.createDDSSignal("fault", SignalType.information);

        root.getChildren().add(massQuantity);
        root.getChildren().add(WSTAkg);
        root.getChildren().add(ARFTAkg);
        root.getChildren().add(BPAkg);


        root.getChildren().add(S2);
        root.getChildren().add(S5);
        root.getChildren().add(K1);

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
            WSTAkg.setValue(new Object[]{topic.WSTAkg});
            ARFTAkg.setValue(new Object[]{topic.ARFTAkg});
            BPAkg.setValue(new Object[]{topic.BPAkg});
            S2.setValue(new Object[]{topic.S2});
            S5.setValue(new Object[]{topic.S5});
            K1.setValue(new Object[]{topic.K1});
            fault.setValue(new Object[]{topic.fault});
        }

    }

    @Override
    public void initReader() {
        String typeName = UPAsensorsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        UPAsensorsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "UPAsensorTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (UPAsensorsDataReader) subscriber.create_datareader(
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
            String typeName = UPAsensorsTypeSupport.get_type_name();
            UPAsensorsTypeSupport.register_type(participant, typeName);

            writer = (UPAsensorsDataWriter) publisher.create_datawriter(
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

           WSTAkg.updateeMeasure(new Double[]{topic.WSTAkg}, SI.KILOGRAM);
           ARFTAkg.updateeMeasure(new Double[]{topic.WSTAkg}, SI.KILOGRAM);
           BPAkg.updateeMeasure(new Double[]{topic.WSTAkg}, SI.KILOGRAM);
           S2.updateeMeasure(new Double[]{topic.WSTAkg}, Unit.ONE);
           S5.updateeMeasure(new Double[]{topic.WSTAkg}, Unit.ONE);
           K1.updateeMeasure(new Double[]{topic.WSTAkg}, Unit.ONE);
           //fault);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new UPAsensorsSeq();
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
                        topic = ((UPAsensorsSeq) dataSeq).get(i);
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
