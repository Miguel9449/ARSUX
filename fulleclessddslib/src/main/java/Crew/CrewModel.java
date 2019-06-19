package Crew;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.infrastructure.ResourceLimitsQosPolicy;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.infrastructure.StringSeq;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.InstanceStateKind;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import com.rti.dds.subscription.SampleStateKind;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.subscription.ViewStateKind;
import com.rti.dds.topic.ContentFilteredTopic;
import com.rti.dds.topic.Topic;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import MySupportClasses.CompNodeDataModel;
import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import MySupportClasses.SignalType;

public class CrewModel extends CompNodeDataModel {

    public crew topic;
    public crew crew1Topic;
    public crew crew2Topic;
    public crew crew3Topic;
    public crew crew4Topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public crewDataReader reader;
    public crewDataWriter writer;
    public crewSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal crew1; // 1
    public DDS_Signal crew2; // 1
    public DDS_Signal crew3; // 1
    public DDS_Signal crew4; // 1
    public DDS_Signal timeofday;


    public CrewModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = crewTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.crewwDataReader;
        writer = fragmentsModel.crewwDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initCrew1Reader();
        this.initWriter();
    }

    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("FA Params", SignalType.rootSet);
        id = DDS_Signal.createDDSSignal("ID", SignalType.information);
        state = DDS_Signal.createDDSSignal("State", SignalType.information);
        crew1 = DDS_Signal.createDDSSignal("Sensible Heat Rate", SignalType.power_sensor);
        crew2 = DDS_Signal.createDDSSignal("Latent Heat Rate", SignalType.power_sensor);
        crew3 = DDS_Signal.createDDSSignal("O2 Consumption Rate", SignalType.massFlowRate);
        crew4 = DDS_Signal.createDDSSignal("CO2 Generation Rate", SignalType.massFlowRate);
        timeofday = DDS_Signal.createDDSSignal("Time [s]", SignalType.time_sensor);

        root.getChildren().add(id);
        root.getChildren().add(state);
        root.getChildren().add(crew1);
        root.getChildren().add(crew2);
        root.getChildren().add(crew3);
        root.getChildren().add(crew4);
        root.getChildren().add(timeofday);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
            id.setValue(new Object[]{topic.id});
            state.setValue(new Object[]{topic.state});
            crew1.setValue(new Object[]{topic.crew1});
            crew2.setValue(new Object[]{topic.crew2});
            crew3.setValue(new Object[]{topic.crew3});
            crew4.setValue(new Object[]{topic.crew4});
            timeofday.setValue(new Object[]{topic.timeofday});

        }
        this.updateEMeasures();
    }

    @Override
    public void initReader() {
        String typeName = crewTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        crewTypeSupport.register_type(participant, typeName);
        aTopic = participant.create_topic(
                "crewTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (crewDataReader) subscriber.create_datareader(
                    aTopic,
                    Subscriber.DATAREADER_QOS_DEFAULT,
                    null,
                    StatusKind.STATUS_MASK_ALL);

            if (reader == null) {
                //  System.err.println("Create " + topicName + " DataReader ERROR!\n");

            }
        }
    }

    public crewDataReader crew1Reader;
    public crewDataReader crew2Reader;
    public crewDataReader crew3Reader;
    public crewDataReader crew4Reader;

    public int initCrew1Reader() {
        String cft_param_list[] = {"1", "2", "3", "4"};
        StringSeq cft_parameters = new StringSeq(java.util.Arrays.asList(cft_param_list));
        crewTypeSupport.register_type(participant, "crew1Topic");
        ContentFilteredTopic crew1Topic = participant.create_contentfilteredtopic(
                "crew1Topic",
                aTopic,
                "id == 1",
                cft_parameters);

        if(crew1Topic == null) {
            return 1;
            //   System.err.println("Create " + topicName + " error\n");
        } else {
           crew1Reader = (crewDataReader) subscriber.create_datareader(
                   crew1Topic,
                   Subscriber.DATAREADER_QOS_DEFAULT,
                   null,
                   StatusKind.STATUS_MASK_ALL);
           return 0;
        }
    }

    @Override
    public void initWriter() {
        try {
            String typeName = crewTypeSupport.get_type_name();
            crewTypeSupport.register_type(participant, typeName);

            writer = (crewDataWriter) publisher.create_datawriter(
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
        crew1.updateeMeasure(new Double[]{topic.crew1}, NonSI.BTU.divide(NonSI.HOUR));
        crew2.updateeMeasure(new Double[]{topic.crew2}, NonSI.BTU.divide(NonSI.HOUR));
        crew3.updateeMeasure(new Double[]{topic.crew3/1000}, NonSI.POUND.divide(NonSI.MINUTE));
        crew4.updateeMeasure(new Double[]{topic.crew4/1000},  NonSI.POUND.divide(NonSI.MINUTE));
        timeofday.updateeMeasure(new Double[]{topic.timeofday}, SI.SECOND);
    }

    @Override
    public void updateTopicData() {
// System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new crewSeq();
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
                        topic = ((crewSeq) dataSeq).get(i);
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

    public void updateCrew1Topic() {
        if(crew1Reader != null) {
            dataSeq = new crewSeq();
            infoSeq = new SampleInfoSeq();

            crew1Reader.take(dataSeq, infoSeq,
                    ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                    SampleStateKind.ANY_SAMPLE_STATE,
                    ViewStateKind.ANY_VIEW_STATE,
                    InstanceStateKind.ANY_INSTANCE_STATE);
            for (int i = 0; i < dataSeq.size(); ++i) {
                info = (SampleInfo) infoSeq.get(i);
                if (info.valid_data) {
                    crew1Topic = ((crewSeq) dataSeq).get(i);
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
