/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HABfluids;

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

;

/**
 *
 * @author nextstep
 */
public class HABfluidsModel extends CompNodeDataModel {

    public HABfluids topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public HABfluidsDataReader reader;
    public HABfluidsDataWriter writer;
    public HABfluidsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal temperature; // 293.15
    public DDS_Signal pressure; // 0
    public DDS_Signal ARSOutletPressure; // 0
    public DDS_Signal HABmolefracs; // [0.21, 0.0140891, 0.0026316, 0.00002]
    public DDS_Signal WD2Habkgs; // 0
    public DDS_Signal Hab2WWkgs; // 0


    public HABfluidsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = HABfluidsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.haBfluidsDataReader;
        writer = fragmentsModel.haBfluidsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("Habitat Fluid Telemetry", SignalType.rootSet);

        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        temperature = DDS_Signal.createDDSSignal("temperature", SignalType.temp_sensor);
        pressure = DDS_Signal.createDDSSignal("pressure", SignalType.abs_pressure_sensor);
        ARSOutletPressure = DDS_Signal.createDDSSignal("ARSOutletPressure", SignalType.abs_pressure_sensor);
        HABmolefracs = DDS_Signal.createDDSSignal("HABmolefracs", SignalType.some_sensor);
        WD2Habkgs = DDS_Signal.createDDSSignal("WD2Habkgs", SignalType.mass_sensor);
        Hab2WWkgs = DDS_Signal.createDDSSignal("Hab2WWkgs", SignalType.mass_sensor);

        root.getChildren().add(temperature);
        root.getChildren().add(pressure);
        root.getChildren().add(ARSOutletPressure);
        root.getChildren().add(HABmolefracs);
        root.getChildren().add(WD2Habkgs);
        root.getChildren().add(Hab2WWkgs);

    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");

            id.setValue(new Object[]{topic.id});
            temperature.setValue(new Object[]{topic.temperature});
            pressure.setValue(new Object[]{topic.pressure});
            ARSOutletPressure.setValue(new Object[]{topic.ARSOutletPressure});
            HABmolefracs.setValue(new Object[]{topic.HABmolefracs});
            WD2Habkgs.setValue(new Object[]{topic.WD2Habkgs});
            Hab2WWkgs.setValue(new Object[]{topic.Hab2WWkgs});
        this.updateEMeasures();

        }

    }

    @Override
    public void initReader() {
        String typeName = HABfluidsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        HABfluidsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "HABfluids",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (HABfluidsDataReader) subscriber.create_datareader(
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
            String typeName = HABfluidsTypeSupport.get_type_name();
            HABfluidsTypeSupport.register_type(participant, typeName);

            writer = (HABfluidsDataWriter) publisher.create_datawriter(
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

           temperature.updateeMeasure(new Double[]{topic.temperature}, SI.KELVIN);

           pressure.updateeMeasure(new Double[]{topic.pressure}, SI.KELVIN);
           ARSOutletPressure.updateeMeasure(new Double[]{topic.ARSOutletPressure}, SI.KELVIN);
           Double[] d = new Double[topic.HABmolefracs.length];
           for(int i=0;i<topic.HABmolefracs.length; i++)  {
               d[i] =   topic.HABmolefracs[i];
           }
           HABmolefracs.updateeMeasure(d, SI.KELVIN);
           WD2Habkgs.updateeMeasure(new Double[]{topic.WD2Habkgs}, SI.KELVIN);
           Hab2WWkgs.updateeMeasure(new Double[]{topic.Hab2WWkgs}, SI.KELVIN);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new HABfluidsSeq();
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
                        topic = ((HABfluidsSeq) dataSeq).get(i);
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

