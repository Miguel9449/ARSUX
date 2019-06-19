/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WPsensors;

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
public class WPsensorsModel extends CompNodeDataModel {

    public WPsensors topic;
    public Topic aTopic;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;
    public WPsensorsDataReader reader;
    public WPsensorsDataWriter writer;
    public WPsensorsSeq dataSeq;
    public SampleInfo info;

    public DDS_Signal id; //@key
    public DDS_Signal state;
    public DDS_Signal WPQ71831; // 2
    public DDS_Signal WPQ71832; // 2
    public DDS_Signal WPQ71833; // 2
    public DDS_Signal WPQ71834; // 2
    public DDS_Signal WPPG71171; // 103451
    public DDS_Signal WPPG71172; // 103451
    public DDS_Signal WPC71912; // 0.000025
    public DDS_Signal WPC71943; // 0.000004
    public DDS_Signal WPG81481; // 1
    public DDS_Signal WPLLLS; // TRUE
    public DDS_Signal WPLLS; // TRUE
    public DDS_Signal WPHLS; // FALSE
    public DDS_Signal WPHHLS; // FALSE
    public DDS_Signal WPN8005; // FALSE
    public DDS_Signal WPN8004; // FALSE
    public DDS_Signal WPT71441; // 385
    public DDS_Signal WPT71442; // 385
    public DDS_Signal WPT70475; // 293
    public DDS_Signal WPT70476; // 293
    public DDS_Signal WPN8008; // 0
    public DDS_Signal WPPG71131; // 115142
    public DDS_Signal WPT70471; // 293.14
    public DDS_Signal WPPG71124; // 137895
    public DDS_Signal kgMakeup; //0
    public DDS_Signal fault;

    public DDS_Signal otherSignals;
    public DDS_Signal motorSpeedSignals;
    public DDS_Signal unknownTypeSignals;
    public DDS_Signal quantitySignals;
    public DDS_Signal pressureSignals;
    public DDS_Signal sensedTempSignals;




    public WPsensorsModel(FragmentsModel fragmentsModel) {
        super(fragmentsModel);
        this.topicName = WPsensorsTypeSupport.get_type_name();
        this.setCommStatus(topicName + " not active!");
        reader = fragmentsModel.wPsensorsDataReader;
        writer = fragmentsModel.wPsensorsDataWriter;
        participant = fragmentsModel.participant;
        subscriber = fragmentsModel.subscriber;
        publisher = fragmentsModel.publisher;
        this.initSignalSet();
        this.initReader();
        this.initWriter();
    }


    @Override
    public void initSignalSet() {
        root = DDS_Signal.createDDSSignal("WPA Sensor Telemetry", SignalType.rootSet);

        otherSignals        = DDS_Signal.createDDSSignal("Other Signals", SignalType.information);
        motorSpeedSignals   = DDS_Signal.createDDSSignal("Motor Speed Signals", SignalType.information);
        unknownTypeSignals  = DDS_Signal.createDDSSignal("Unknown Type Signals", SignalType.information);
        quantitySignals     = DDS_Signal.createDDSSignal("Quantity Signals", SignalType.information);
        pressureSignals     = DDS_Signal.createDDSSignal("Pressure Signals", SignalType.information);
        sensedTempSignals   = DDS_Signal.createDDSSignal("Temperature Signals", SignalType.information);

        //sample: co2SetLabel = DDS_Signal.createDDSSignal("CO2 Sensors", SignalType.information);
        id = DDS_Signal.createDDSSignal("id", SignalType.information);
        state     = DDS_Signal.createDDSSignal("state    ", SignalType.information);
        WPQ71831  = DDS_Signal.createDDSSignal("WPQ71831 ", SignalType.mass_sensor);  //kg waste water
        WPQ71832  = DDS_Signal.createDDSSignal("WPQ71832 ", SignalType.mass_sensor);  // same as bove
        WPQ71833  = DDS_Signal.createDDSSignal("WPQ71833 ", SignalType.mass_sensor);  // kg water storage tank
        WPQ71834  = DDS_Signal.createDDSSignal("WPQ71834 ", SignalType.mass_sensor); // same
        WPPG71171 = DDS_Signal.createDDSSignal("WPPG71171", SignalType.gauge_pressure_sensor);  //wate delivery pressure [pascals]
        WPPG71172 = DDS_Signal.createDDSSignal("WPPG71172", SignalType.gauge_pressure_sensor);  // same
        WPC71912  = DDS_Signal.createDDSSignal("WPC71912 ", SignalType.conductivity_sensor);  // conductivity sensor upstream of ix bex  semens/cm
        WPC71943  = DDS_Signal.createDDSSignal("WPC71943 ", SignalType.conductivity_sensor);  //  conductivty sensor downstream of the ix bex
        WPG81481  = DDS_Signal.createDDSSignal("WPG81481 ", SignalType.gauge_pressure_sensor);  // gas sensor [volts]
        WPLLLS    = DDS_Signal.createDDSSignal("WPLLLS   ", SignalType.on_off_position_cmd); //low low level sensor in the mostly liquid separator
        WPLLS     = DDS_Signal.createDDSSignal("WPLLS    ", SignalType.on_off_position_cmd);  // low
        WPHLS     = DDS_Signal.createDDSSignal("WPHLS    ", SignalType.on_off_position_cmd);  // high
        WPHHLS    = DDS_Signal.createDDSSignal("WPHHLS   ", SignalType.on_off_position_cmd);  // high high
        WPN8005   = DDS_Signal.createDDSSignal("WPN8005  ", SignalType.motor_speed_sensor); // speed sensors mls mostly liquid separator speed
        WPN8004   = DDS_Signal.createDDSSignal("WPN8004  ", SignalType.motor_speed_sensor);  // process pump speed
        WPT71441  = DDS_Signal.createDDSSignal("WPT71441 ", SignalType.temp_sensor);  // temp
        WPT71442  = DDS_Signal.createDDSSignal("WPT71442 ", SignalType.temp_sensor);
        WPT70475  = DDS_Signal.createDDSSignal("WPT70475 ", SignalType.temp_sensor);
        WPT70476  = DDS_Signal.createDDSSignal("WPT70476 ", SignalType.temp_sensor);
        WPN8008   = DDS_Signal.createDDSSignal("WPN8008  ", SignalType.motor_speed_sensor); // delivery pump speed
        WPPG71131 = DDS_Signal.createDDSSignal("WPPG71131", SignalType.gauge_pressure_sensor);
        WPT70471  = DDS_Signal.createDDSSignal("WPT70471 ", SignalType.temp_sensor);
        WPPG71124 = DDS_Signal.createDDSSignal("WPPG71124", SignalType.gauge_pressure_sensor);
        kgMakeup  = DDS_Signal.createDDSSignal("kgMakeup ", SignalType.mass_sensor);
        fault     = DDS_Signal.createDDSSignal("fault    ", SignalType.information);


        //sample: root.getChildren().add(co2SetLabel);
        root.getChildren().add(sensedTempSignals);
        root.getChildren().add(WPT71441);
        root.getChildren().add(WPT71442);
        root.getChildren().add(WPT70475);
        root.getChildren().add(WPT70476);
        root.getChildren().add(WPT70471);

        root.getChildren().add(pressureSignals);
        root.getChildren().add(WPPG71171);
        root.getChildren().add(WPPG71172);
        root.getChildren().add(WPPG71131);
        root.getChildren().add(WPPG71124);
        root.getChildren().add(WPG81481);

        root.getChildren().add(quantitySignals);
        root.getChildren().add(WPQ71831);
        root.getChildren().add(WPQ71832);
        root.getChildren().add(WPQ71833);
        root.getChildren().add(WPQ71834);
        root.getChildren().add(kgMakeup);


        root.getChildren().add(unknownTypeSignals);
        root.getChildren().add(WPC71912);
        root.getChildren().add(WPC71943);





        root.getChildren().add(WPLLLS);
        root.getChildren().add(WPLLS);

        root.getChildren().add(WPHLS);
        root.getChildren().add(WPHHLS);

        root.getChildren().add(motorSpeedSignals);
        root.getChildren().add(WPN8005);
        root.getChildren().add(WPN8004);
        root.getChildren().add(WPN8008);



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
            //Sample: ARm_TS01_TP.setValue(topic.ARm_TS01_TP);
            id       .setValue(new Object[]{topic.id});
            state    .setValue(new Object[]{topic.state    });
            WPQ71831 .setValue(new Object[]{topic.WPQ71831 });
            WPQ71832 .setValue(new Object[]{topic.WPQ71832 });
            WPQ71833 .setValue(new Object[]{topic.WPQ71833 });
            WPQ71834 .setValue(new Object[]{topic.WPQ71834 });
            WPPG71171.setValue(new Object[]{topic.WPPG71171});
            WPPG71172.setValue(new Object[]{topic.WPPG71172});
            WPC71912 .setValue(new Object[]{topic.WPC71912 });
            WPC71943 .setValue(new Object[]{topic.WPC71943 });
            WPG81481 .setValue(new Object[]{topic.WPG81481 });
            WPLLLS   .setValue(new Object[]{topic.WPLLLS   });
            WPLLS    .setValue(new Object[]{topic.WPLLS    });
            WPHLS    .setValue(new Object[]{topic.WPHLS    });
            WPHHLS   .setValue(new Object[]{topic.WPHHLS   });
            WPN8005  .setValue(new Object[]{topic.WPN8005  });
            WPN8004  .setValue(new Object[]{topic.WPN8004  });
            WPT71441 .setValue(new Object[]{topic.WPT71441 });
            WPT71442 .setValue(new Object[]{topic.WPT71442 });
            WPT70475 .setValue(new Object[]{topic.WPT70475 });
            WPT70476 .setValue(new Object[]{topic.WPT70476 });
            WPN8008  .setValue(new Object[]{topic.WPN8008  });
            WPPG71131.setValue(new Object[]{topic.WPPG71131});
            WPT70471 .setValue(new Object[]{topic.WPT70471 });
            WPPG71124.setValue(new Object[]{topic.WPPG71124});
            kgMakeup .setValue(new Object[]{topic.kgMakeup });
            fault    .setValue(new Object[]{topic.fault    });


        }

    }

    @Override
    public void initReader() {
        String typeName = WPsensorsTypeSupport.get_type_name();
        //System.out.println("************************* TypeName " +typeName+"\n");
        WPsensorsTypeSupport.register_type(participant, typeName);

        aTopic = participant.create_topic(
                "WPsensorsTopic",
                typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT,
                null /* listener */,
                StatusKind.STATUS_MASK_NONE);

        if (aTopic == null) {
            //   System.err.println("Create " + topicName + " error\n");
        } else {
            reader = (WPsensorsDataReader) subscriber.create_datareader(
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
            String typeName = WPsensorsTypeSupport.get_type_name();
            WPsensorsTypeSupport.register_type(participant, typeName);

            writer = (WPsensorsDataWriter) publisher.create_datawriter(
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
            WPQ71831 .updateeMeasure(new Double[]{topic.WPQ71831 }, Unit.ONE);
            WPQ71832 .updateeMeasure(new Double[]{topic.WPQ71832 }, Unit.ONE);
            WPQ71833 .updateeMeasure(new Double[]{topic.WPQ71833 }, Unit.ONE);
            WPQ71834 .updateeMeasure(new Double[]{topic.WPQ71834 }, Unit.ONE);
            WPPG71171.updateeMeasure(new Double[]{topic.WPPG71171}, Unit.ONE);
            WPPG71172.updateeMeasure(new Double[]{topic.WPPG71172}, Unit.ONE);
            WPC71912 .updateeMeasure(new Double[]{topic.WPC71912 }, Unit.ONE);
            WPC71943 .updateeMeasure(new Double[]{topic.WPC71943 }, Unit.ONE);
            WPG81481 .updateeMeasure(new Double[]{topic.WPG81481 }, Unit.ONE);

            // Booleans
//            WPLLLS   .updateeMeasure(new Double[]{topic.WPLLLS   }, Unit.ONE);
//            WPLLS    .updateeMeasure(new Double[]{topic.WPLLS    }, Unit.ONE);
//            WPHLS    .updateeMeasure(new Double[]{topic.WPHLS    }, Unit.ONE);
//            WPHHLS   .updateeMeasure(new Double[]{topic.WPHHLS   }, Unit.ONE);
//            WPN8005  .updateeMeasure(new Double[]{topic.WPN8005  }, Unit.ONE);
//            WPN8004  .updateeMeasure(new Double[]{topic.WPN8004  }, Unit.ONE);
            WPT71441 .updateeMeasure(new Double[]{topic.WPT71441 }, Unit.ONE);
            WPT71442 .updateeMeasure(new Double[]{topic.WPT71442 }, Unit.ONE);
            WPT70475 .updateeMeasure(new Double[]{topic.WPT70475 }, Unit.ONE);
            WPT70476 .updateeMeasure(new Double[]{topic.WPT70476 }, Unit.ONE);
            WPN8008  .updateeMeasure(new Double[]{topic.WPN8008  }, Unit.ONE);
            WPPG71131.updateeMeasure(new Double[]{topic.WPPG71131}, Unit.ONE);
            WPT70471 .updateeMeasure(new Double[]{topic.WPT70471 }, Unit.ONE);
            WPPG71124.updateeMeasure(new Double[]{topic.WPPG71124}, Unit.ONE);
            kgMakeup .updateeMeasure(new Double[]{topic.kgMakeup }, SI.KILOGRAM);

        }
    }

    @Override
    public void updateTopicData() {
        // System.err.println("***********************************just entered the updatetopicdata \n");
        if (reader != null) {
            //   System.err.println("***********************************just entered the if in updatetopicdata \n");
            try {
                dataSeq = new WPsensorsSeq();
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
                        topic = ((WPsensorsSeq) dataSeq).get(i);
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

