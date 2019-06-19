/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySupportClasses;


import android.graphics.Color;

import com.rti.dds.subscription.DataReaderImpl;
import com.rti.dds.subscription.SampleInfoSeq;

import java.io.Serializable;

//import javafx.scene.control.TreeItem;
//import javafx.scene.paint.Color;

/**
 *
 * @author miguel
 */
public abstract class CompNodeDataModel implements Serializable {
    

    public String commStatus;
    public SampleInfoSeq infoSeq;
    public DataReaderImpl dataReader;
    public String topicName;
    public DDS_Signal root;

    public FragmentsModel fragmentsModel;

    
    
//    public CompNodeDataModel(int domainId, DomainParticipant participant, Subscriber subscriber, Publisher publisher) {
//        this.domainId = domainId;
//        this.participant = participant;
//        this.subscriber = subscriber;
//        this.publisher = publisher;
//        commStatus = new String();
//
//    }

    public CompNodeDataModel(FragmentsModel fragmentsModel) {
        this.fragmentsModel = fragmentsModel;
    }
    
  public void writeCommand(String signalName, Object command) {
        // to do;
    }
    
    
    public abstract void initSignalSet();   

    public abstract void updateSignalSet();

    public abstract void initReader();

    public abstract void initWriter();

    public abstract void updateEMeasures();
    
    public abstract void updateTopicData();

    public abstract void deleteWriterReader();
    
    
    public String getTopicName() {
        return topicName;
    };

   

   public DDS_Signal getSignalSet() {
        if (root == null) {
            this.initSignalSet();
        }
        return root;
    }

   
    
    public String getCommStatus() {
        return this.commStatus;
    }
    
    public void setCommStatus(String status) {
        this.commStatus = status;
    }
    
    public Color getCommStatusColor() {
       return null;
//        if (this.getCommStatus().getValue().endsWith("ACTIVE")) {
//            return Color.ommStatus().getValue().endsWith("No DATA")  ) {
//            return Color.valueOf(1.0f, 0.0f, 0.0f);
//        } else {
//            return Color.valueOf(0.0f, 0.0f, 0.0f);
//        }
    }

    public DDS_Signal getRoot() {
        return root;
    }


}

