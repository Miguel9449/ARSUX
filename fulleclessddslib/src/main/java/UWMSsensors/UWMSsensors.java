package UWMSsensors;

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

public class UWMSsensors   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double Micturition= 0;
    public double P= 0;
    public double S01= 0;
    public int fault= 0;

    public UWMSsensors() {

    }
    public UWMSsensors (UWMSsensors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UWMSsensors self;
        self = new UWMSsensors();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        Micturition= 0;
        P= 0;
        S01= 0;
        fault= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UWMSsensors otherObj = (UWMSsensors)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(Micturition != otherObj.Micturition) {
            return false;
        }
        if(P != otherObj.P) {
            return false;
        }
        if(S01 != otherObj.S01) {
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
        __result += (int)Micturition;
        __result += (int)P;
        __result += (int)S01;
        __result += (int)fault;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UWMSsensorsTypeSupport</code>
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

        UWMSsensors typedSrc = (UWMSsensors) src;
        UWMSsensors typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.Micturition = typedSrc.Micturition;
        typedDst.P = typedSrc.P;
        typedDst.S01 = typedSrc.S01;
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
        strBuffer.append("Micturition: ").append(Micturition).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("P: ").append(P).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("S01: ").append(S01).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("fault: ").append(fault).append("\n");  

        return strBuffer.toString();
    }

}
