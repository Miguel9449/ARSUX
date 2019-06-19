/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstantMetRates;

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
public class InstantMetRatesModel extends CompNodeDataModel {

    public InstantMetRates topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public InstantMetRatesDataReader reader;
    public InstantMetRatesDataWriter writer;
    public InstantMetRatesSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal water; // 0.00007037
    public DDS_Signal SensibleWatts; // 178.8881
    public DDS_Signal oxygen; // 0.00002404
    public DDS_Signal CO2; // 0.00003069
    public DDS_Signal Micturition; // 0
    public DDS_Signal WaterUsekgs; // 0
    public DDS_Signal HabHeatWatts; // 1000


    public InstantMetRatesModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = InstantMetRatesTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.instantMetRatesDataReader;
        writer = fragmentsModel.instantMetRatesDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("Instant Metalobic Rates", SignalType.rootSet);
        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        water = DDS_Signal.createDDSSignal("water", SignalType.massFlowRate);
        SensibleWatts = DDS_Signal.createDDSSignal("SensibleWatts", SignalType.power_sensor);
        oxygen = DDS_Signal.createDDSSignal("oxygen", SignalType.massFlowRate);
        CO2 = DDS_Signal.createDDSSignal("CO2", SignalType.massFlowRate);
        Micturition = DDS_Signal.createDDSSignal("Micturition", SignalType.massFlowRate);
        WaterUsekgs = DDS_Signal.createDDSSignal("WaterUsekgs", SignalType.mass_sensor);
        HabHeatWatts = DDS_Signal.createDDSSignal("HabHeatWatts", SignalType.power_sensor);

        root.getChildren().add(id);
        root.getChildren().add(water);
        root.getChildren().add(SensibleWatts);
        root.getChildren().add(oxygen);
        root.getChildren().add(CO2);
        root.getChildren().add(Micturition);
        root.getChildren().add(WaterUsekgs);
        root.getChildren().add(HabHeatWatts);


    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            water.setValue(new Object[]{topic.water});
            SensibleWatts.setValue(new Object[]{topic.SensibleWatts});
            oxygen.setValue(new Object[]{topic.oxygen});
            CO2.setValue(new Object[]{topic.CO2});
            Micturition.setValue(new Object[]{topic.Micturition});
            WaterUsekgs.setValue(new Object[]{topic.WaterUsekgs});
            HabHeatWatts.setValue(new Object[]{topic.HabHeatWatts});

        }

    }

    @Override
    public void initReader() {
        String typeName = InstantMetRatesTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        InstantMetRatesTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (InstantMetRatesDataReader) subscriber.create_datareader(
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
            String typeName = InstantMetRatesTypeSupport.get_type_name();
            InstantMetRatesTypeSupport.register_type(participant, typeName);

            writer = (InstantMetRatesDataWriter) publisher.create_datawriter(
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
            water.updateeMeasure(new Double[]{topic.water}, SI.KILOGRAM);
            SensibleWatts.updateeMeasure(new Double[]{topic.SensibleWatts}, SI.WATT);
            oxygen.updateeMeasure(new Double[]{topic.oxygen}, SI.PASCAL);
            CO2.updateeMeasure(new Double[]{topic.CO2}, SI.PASCAL);
            Micturition.updateeMeasure(new Double[]{topic.Micturition}, SI.KILOGRAM);
            WaterUsekgs.updateeMeasure(new Double[]{topic.WaterUsekgs}, SI.KILOGRAM);
            HabHeatWatts.updateeMeasure(new Double[]{topic.HabHeatWatts}, SI.WATT);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new InstantMetRatesSeq();
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
                        topic = ((InstantMetRatesSeq) dataSeq).get(i);
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

