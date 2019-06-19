/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WPfluids;

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
public class WPfluidsModel extends CompNodeDataModel {

    public WPfluids topic;
    public Topic aTopic;
    public WPfluidsDataReader reader;
    public WPfluidsDataWriter writer;
    public WPfluidsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal WDPa; // 210000
    public DDS_Signal WDkelvins; // 293.15
    public DDS_Signal WWPa; // 101325
    public DDS_Signal WPAvapor; // 0.000000013622


    public WPfluidsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = WPfluidsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }



    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("WPA Fluids", SignalType.rootSet);


        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        WDPa = DDS_Signal.createDDSSignal("id", SignalType.abs_pressure_sensor);
        WDkelvins = DDS_Signal.createDDSSignal("id", SignalType.temp_sensor);
        WWPa = DDS_Signal.createDDSSignal("id", SignalType.abs_pressure_sensor);
        WPAvapor = DDS_Signal.createDDSSignal("id", SignalType.some_sensor);

        root.getChildren().add(id);
        root.getChildren().add(WDPa);
        root.getChildren().add(WDkelvins);
        root.getChildren().add(WWPa);
        root.getChildren().add(WPAvapor);


    }

    @Override
    public void updateSignalSet() {
        this.updateTopicData();
        if (topic != null) {
            this.setCommStatus("Topic: " + this.getTopicName() + " ACTIVE");
           id.setValue(new Object[]{topic.id});
      WDPa.setValue(new Object[]{topic.WDPa});
      WDkelvins.setValue(new Object[]{topic.WDkelvins});
      WWPa.setValue(new Object[]{topic.WWPa});
      WPAvapor.setValue(new Object[]{topic.WPAvapor});

        }

    }

    @Override
    public void initReader() {
        String typeName = WPfluidsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        WPfluidsTypeSupport.register_type(fragmentsModel.participant, typeName);

        aTopic = fragmentsModel.participant.create_topic(
                "ARSSignalTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (WPfluidsDataReader) fragmentsModel.subscriber.create_datareader(
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
            String typeName = WPfluidsTypeSupport.get_type_name();
            WPfluidsTypeSupport.register_type(fragmentsModel.participant, typeName);

            writer = (WPfluidsDataWriter) fragmentsModel.publisher.create_datawriter(
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
            WDPa.updateeMeasure(new Double[]{topic.WDPa}, SI.PASCAL);
            WDkelvins.updateeMeasure(new Double[]{topic.WDPa}, SI.KELVIN);
            WWPa.updateeMeasure(new Double[]{topic.WDPa}, SI.PASCAL);
            WPAvapor.updateeMeasure(new Double[]{topic.WDPa}, SI.PASCAL);


        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new WPfluidsSeq();
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
                        topic = ((WPfluidsSeq) dataSeq).get(i);
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
