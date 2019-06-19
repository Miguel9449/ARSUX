package UPAsensors;

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

import com.rti.dds.cdr.CdrHelper;
import com.rti.dds.infrastructure.Copyable;

import java.io.Serializable;

public class UPAsensors   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double WSTAkg= 0;
    public double ARFTAkg= 0;
    public double BPAkg= 0;
    public double S2= 0;
    public double S5= 0;
    public double K1= 0;
    public int fault= 0;

    public UPAsensors() {

    }
    public UPAsensors (UPAsensors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UPAsensors self;
        self = new UPAsensors();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        WSTAkg= 0;
        ARFTAkg= 0;
        BPAkg= 0;
        S2= 0;
        S5= 0;
        K1= 0;
        fault= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UPAsensors otherObj = (UPAsensors)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(WSTAkg != otherObj.WSTAkg) {
            return false;
        }
        if(ARFTAkg != otherObj.ARFTAkg) {
            return false;
        }
        if(BPAkg != otherObj.BPAkg) {
            return false;
        }
        if(S2 != otherObj.S2) {
            return false;
        }
        if(S5 != otherObj.S5) {
            return false;
        }
        if(K1 != otherObj.K1) {
            return false;
        }
        if(fault != otherObj.fault) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)WSTAkg;
        __result += (int)ARFTAkg;
        __result += (int)BPAkg;
        __result += (int)S2;
        __result += (int)S5;
        __result += (int)K1;
        __result += (int)fault;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UPAsensorsTypeSupport</code>
    * rather than here by using the <code>-noCopyable</code> option
    * to rtiddsgen.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>this</code>.
    * @exception NullPointerException If <code>src</code> is null.
    * @exception ClassCastException If <code>src</code> is not the 
    * same type as <code>this</code>.
    * @see com.rti.dds.infrastructure.Copyable#copy_from(Object)
    */
    public Object copy_from(Object src) {

        UPAsensors typedSrc = (UPAsensors) src;
        UPAsensors typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.WSTAkg = typedSrc.WSTAkg;
        typedDst.ARFTAkg = typedSrc.ARFTAkg;
        typedDst.BPAkg = typedSrc.BPAkg;
        typedDst.S2 = typedSrc.S2;
        typedDst.S5 = typedSrc.S5;
        typedDst.K1 = typedSrc.K1;
        typedDst.fault = typedSrc.fault;

        return this;
    }

    public String toString(){
        return toString("", 0);
    }

    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();        

        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }

        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("id: ").append(id).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("state: ").append(state).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WSTAkg: ").append(WSTAkg).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("ARFTAkg: ").append(ARFTAkg).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("BPAkg: ").append(BPAkg).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("S2: ").append(S2).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("S5: ").append(S5).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("K1: ").append(K1).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("fault: ").append(fault).append("\n");  

        return strBuffer.toString();
    }

}
