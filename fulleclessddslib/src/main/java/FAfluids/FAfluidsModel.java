/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAfluids;

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
public class FAfluidsModel extends CompNodeDataModel {

    public FAfluids topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public FAfluidsDataReader reader;
    public FAfluidsDataWriter writer;
    public FAfluidsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal flowIn; // 0
    public DDS_Signal flowout; // 0
    public DDS_Signal temperatureOut; // 293.15
    public DDS_Signal ARSmolefracs; // [0.21, 0.0140891, 0.0026316, 0.00002]
    public DDS_Signal condensationKGS; // 0
    public DDS_Signal CO2kelvins; // 300.15
    public DDS_Signal CO2Pa; // 101325


    public FAfluidsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = FAfluidsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.fAfluidsDataReader;
        writer = fragmentsModel.fAfluidsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("FA Sensor Telemetry", SignalType.rootSet);
        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        flowIn = DDS_Signal.createDDSSignal("flowIn", SignalType.physical);
        flowout = DDS_Signal.createDDSSignal("flowout", SignalType.physical);
        temperatureOut = DDS_Signal.createDDSSignal("temperatureOut", SignalType.physical);

        ARSmolefracs = DDS_Signal.createDDSSignal("ARSmolefracs", SignalType.physical);

        condensationKGS = DDS_Signal.createDDSSignal("condensationKGS", SignalType.physical);
        CO2kelvins = DDS_Signal.createDDSSignal("CO2kelvins", SignalType.physical);
        CO2Pa = DDS_Signal.createDDSSignal("CO2Pa", SignalType.physical);


        root.getChildren().add(id);
        root.getChildren().add(flowIn);
        root.getChildren().add(flowout);
        root.getChildren().add(temperatureOut);
        root.getChildren().add(ARSmolefracs);
        root.getChildren().add(condensationKGS);
        root.getChildren().add(CO2kelvins);
        root.getChildren().add(CO2Pa);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            flowIn.setValue(new Object[]{topic.flowIn});
            flowout.setValue(new Object[]{topic.flowout});
            temperatureOut.setValue(new Object[]{topic.temperatureOut});
            ARSmolefracs.setValue(new Object[]{topic.ARSmolefracs});
            condensationKGS.setValue(new Object[]{topic.condensationKGS});
            CO2kelvins.setValue(new Object[]{topic.CO2kelvins});
            CO2Pa.setValue(new Object[]{topic.CO2Pa});



        }

    }

    @Override
    public void initReader() {
        String typeName = FAfluidsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        FAfluidsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (FAfluidsDataReader) subscriber.create_datareader(
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
            String typeName = FAfluidsTypeSupport.get_type_name();
            FAfluidsTypeSupport.register_type(participant, typeName);

            writer = (FAfluidsDataWriter) publisher.create_datawriter(
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
            flowIn.updateeMeasure(new Double[]{topic.flowIn}, SI.KILOGRAM_PER_SECOND);
            flowout.updateeMeasure(new Double[]{topic.flowout}, SI.KILOGRAM_PER_SECOND);
            temperatureOut.updateeMeasure(new Double[]{topic.temperatureOut}, SI.KELVIN);
            Double[] d = new Double[topic.ARSmolefracs.length];
            for(int i=0;i<topic.ARSmolefracs.length; i++)  {
                d[i] =   topic.ARSmolefracs[i];
            }
            ARSmolefracs.updateeMeasure(d, Unit.ONE);  ; // [0.21, 0.0140891, 0.0026316, 0.00002]

            condensationKGS.updateeMeasure(new Double[]{topic.condensationKGS}, SI.KILOGRAM_PER_SECOND);
            CO2kelvins.updateeMeasure(new Double[]{topic.CO2kelvins}, SI.KELVIN);
            CO2Pa.updateeMeasure(new Double[]{topic.CO2Pa}, SI.PASCAL);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new FAfluidsSeq();
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
                        topic = ((FAfluidsSeq) dataSeq).get(i);
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

