/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlannedMetRates;

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
public class PlannedMetRatesModel extends CompNodeDataModel {

    public PlannedMetRates topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public PlannedMetRatesDataReader reader;
    public PlannedMetRatesDataWriter writer;
    public PlannedMetRatesSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal CrewTimes; //
    public DDS_Signal WaterVaporKGS;
    public DDS_Signal SensibleWatts;
    public DDS_Signal O2KGS; // [0 0
    public DDS_Signal CO2KGS; // [0


    public PlannedMetRatesModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = PlannedMetRatesTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.plannedMetRatesDataReader;
        writer = fragmentsModel.plannedMetRatesDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("Planne Metabolic Rates", SignalType.rootSet);


         id = DDS_Signal.createDDSSignal("id", SignalType.information);
        CrewTimes = DDS_Signal.createDDSSignal("id", SignalType.information);
        WaterVaporKGS = DDS_Signal.createDDSSignal("id", SignalType.information);
        SensibleWatts = DDS_Signal.createDDSSignal("id", SignalType.information);
        O2KGS = DDS_Signal.createDDSSignal("id", SignalType.information);
        CO2KGS = DDS_Signal.createDDSSignal("id", SignalType.information);

        root.getChildren().add(id);
        root.getChildren().add(CrewTimes);
        root.getChildren().add(WaterVaporKGS);
        root.getChildren().add(SensibleWatts);
        root.getChildren().add(O2KGS);
        root.getChildren().add(CO2KGS);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            CrewTimes.setValue(new Object[]{topic.CrewTimes});
            WaterVaporKGS.setValue(new Object[]{topic.WaterVaporKGS});
            SensibleWatts.setValue(new Object[]{topic.SensibleWatts});
            O2KGS.setValue(new Object[]{topic.O2KGS});
            CO2KGS.setValue(new Object[]{topic.CO2KGS});
        }

    }

    @Override
    public void initReader() {
        String typeName = PlannedMetRatesTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        PlannedMetRatesTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (PlannedMetRatesDataReader) subscriber.create_datareader(
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
            String typeName = PlannedMetRatesTypeSupport.get_type_name();
            PlannedMetRatesTypeSupport.register_type(participant, typeName);

            writer = (PlannedMetRatesDataWriter) publisher.create_datawriter(
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
            Double[] d = new Double[topic.CrewTimes.length];
            for(int i=0;i<topic.CrewTimes.length; i++)  {
                d[i] =   topic.CrewTimes[i];
            }
            CrewTimes.updateeMeasure(d, SI.SECOND);
            d = new Double[topic.WaterVaporKGS.length];
            for(int i=0;i<topic.WaterVaporKGS.length; i++)  {
                d[i] =   topic.WaterVaporKGS[i];
            }
            WaterVaporKGS.updateeMeasure(d, SI.SECOND);
            d = new Double[topic.SensibleWatts.length];
            for(int i=0;i<topic.SensibleWatts.length; i++)  {
                d[i] =   topic.SensibleWatts[i];
            }
            SensibleWatts.updateeMeasure(d, SI.SECOND);
             d = new Double[topic.O2KGS.length];
            for(int i=0;i<topic.O2KGS.length; i++)  {
                d[i] =   topic.O2KGS[i];
            }
            O2KGS.updateeMeasure(d, SI.SECOND);
           d = new Double[topic.CO2KGS.length];
            for(int i=0;i<topic.CO2KGS.length; i++)  {
                d[i] =   topic.CO2KGS[i];
            }
            CO2KGS.updateeMeasure(d, SI.SECOND);
        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new PlannedMetRatesSeq();
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
                        topic = ((PlannedMetRatesSeq) dataSeq).get(i);
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
