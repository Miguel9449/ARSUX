package FAcommands;

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

public class FAcommands   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double AR_Vv02_Enable_CMD= 0;
    public double AR_Vv02_Direction_CMD= 0;
    public double AR_Fn01_Speed_CMD= 0;
    public double AR_Ht09_CMD= 0;
    public double AR_VMVv01_CMD= 0;
    public double AR_Fn02_Speed_CMD= 0;
    public double AR_Pp01_CMD= 0;
    public double AR_Vv03_Enable_CMD= 0;
    public double AR_Vv03_Direction_CMD= 0;
    public double AR_Ht0102_CMD= 0;
    public double AR_Vv04_CMD= 0;
    public double AR_Ht0304_CMD= 0;
    public double AR_Vv05_CMD= 0;
    public double AR_Vv06_Enable_CMD= 0;
    public double AR_Vv06_Direction_CMD= 0;
    public double AR_Vv07_CMD= 0;
    public double AR_Vv08_CMD= 0;
    public double AR_Ht0506_CMD= 0;
    public double AR_Ht0708_CMD= 0;
    public double AR_Vv09_CMD= 0;
    public double AR_CMP_CMD= 0;
    public double AR_Vv10_CMD= 0;

    public FAcommands() {

    }
    public FAcommands (FAcommands other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        FAcommands self;
        self = new FAcommands();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        AR_Vv02_Enable_CMD= 0;
        AR_Vv02_Direction_CMD= 0;
        AR_Fn01_Speed_CMD= 0;
        AR_Ht09_CMD= 0;
        AR_VMVv01_CMD= 0;
        AR_Fn02_Speed_CMD= 0;
        AR_Pp01_CMD= 0;
        AR_Vv03_Enable_CMD= 0;
        AR_Vv03_Direction_CMD= 0;
        AR_Ht0102_CMD= 0;
        AR_Vv04_CMD= 0;
        AR_Ht0304_CMD= 0;
        AR_Vv05_CMD= 0;
        AR_Vv06_Enable_CMD= 0;
        AR_Vv06_Direction_CMD= 0;
        AR_Vv07_CMD= 0;
        AR_Vv08_CMD= 0;
        AR_Ht0506_CMD= 0;
        AR_Ht0708_CMD= 0;
        AR_Vv09_CMD= 0;
        AR_CMP_CMD= 0;
        AR_Vv10_CMD= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        FAcommands otherObj = (FAcommands)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(AR_Vv02_Enable_CMD != otherObj.AR_Vv02_Enable_CMD) {
            return false;
        }
        if(AR_Vv02_Direction_CMD != otherObj.AR_Vv02_Direction_CMD) {
            return false;
        }
        if(AR_Fn01_Speed_CMD != otherObj.AR_Fn01_Speed_CMD) {
            return false;
        }
        if(AR_Ht09_CMD != otherObj.AR_Ht09_CMD) {
            return false;
        }
        if(AR_VMVv01_CMD != otherObj.AR_VMVv01_CMD) {
            return false;
        }
        if(AR_Fn02_Speed_CMD != otherObj.AR_Fn02_Speed_CMD) {
            return false;
        }
        if(AR_Pp01_CMD != otherObj.AR_Pp01_CMD) {
            return false;
        }
        if(AR_Vv03_Enable_CMD != otherObj.AR_Vv03_Enable_CMD) {
            return false;
        }
        if(AR_Vv03_Direction_CMD != otherObj.AR_Vv03_Direction_CMD) {
            return false;
        }
        if(AR_Ht0102_CMD != otherObj.AR_Ht0102_CMD) {
            return false;
        }
        if(AR_Vv04_CMD != otherObj.AR_Vv04_CMD) {
            return false;
        }
        if(AR_Ht0304_CMD != otherObj.AR_Ht0304_CMD) {
            return false;
        }
        if(AR_Vv05_CMD != otherObj.AR_Vv05_CMD) {
            return false;
        }
        if(AR_Vv06_Enable_CMD != otherObj.AR_Vv06_Enable_CMD) {
            return false;
        }
        if(AR_Vv06_Direction_CMD != otherObj.AR_Vv06_Direction_CMD) {
            return false;
        }
        if(AR_Vv07_CMD != otherObj.AR_Vv07_CMD) {
            return false;
        }
        if(AR_Vv08_CMD != otherObj.AR_Vv08_CMD) {
            return false;
        }
        if(AR_Ht0506_CMD != otherObj.AR_Ht0506_CMD) {
            return false;
        }
        if(AR_Ht0708_CMD != otherObj.AR_Ht0708_CMD) {
            return false;
        }
        if(AR_Vv09_CMD != otherObj.AR_Vv09_CMD) {
            return false;
        }
        if(AR_CMP_CMD != otherObj.AR_CMP_CMD) {
            return false;
        }
        if(AR_Vv10_CMD != otherObj.AR_Vv10_CMD) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)AR_Vv02_Enable_CMD;
        __result += (int)AR_Vv02_Direction_CMD;
        __result += (int)AR_Fn01_Speed_CMD;
        __result += (int)AR_Ht09_CMD;
        __result += (int)AR_VMVv01_CMD;
        __result += (int)AR_Fn02_Speed_CMD;
        __result += (int)AR_Pp01_CMD;
        __result += (int)AR_Vv03_Enable_CMD;
        __result += (int)AR_Vv03_Direction_CMD;
        __result += (int)AR_Ht0102_CMD;
        __result += (int)AR_Vv04_CMD;
        __result += (int)AR_Ht0304_CMD;
        __result += (int)AR_Vv05_CMD;
        __result += (int)AR_Vv06_Enable_CMD;
        __result += (int)AR_Vv06_Direction_CMD;
        __result += (int)AR_Vv07_CMD;
        __result += (int)AR_Vv08_CMD;
        __result += (int)AR_Ht0506_CMD;
        __result += (int)AR_Ht0708_CMD;
        __result += (int)AR_Vv09_CMD;
        __result += (int)AR_CMP_CMD;
        __result += (int)AR_Vv10_CMD;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>FAcommandsTypeSupport</code>
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

        FAcommands typedSrc = (FAcommands) src;
        FAcommands typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.AR_Vv02_Enable_CMD = typedSrc.AR_Vv02_Enable_CMD;
        typedDst.AR_Vv02_Direction_CMD = typedSrc.AR_Vv02_Direction_CMD;
        typedDst.AR_Fn01_Speed_CMD = typedSrc.AR_Fn01_Speed_CMD;
        typedDst.AR_Ht09_CMD = typedSrc.AR_Ht09_CMD;
        typedDst.AR_VMVv01_CMD = typedSrc.AR_VMVv01_CMD;
        typedDst.AR_Fn02_Speed_CMD = typedSrc.AR_Fn02_Speed_CMD;
        typedDst.AR_Pp01_CMD = typedSrc.AR_Pp01_CMD;
        typedDst.AR_Vv03_Enable_CMD = typedSrc.AR_Vv03_Enable_CMD;
        typedDst.AR_Vv03_Direction_CMD = typedSrc.AR_Vv03_Direction_CMD;
        typedDst.AR_Ht0102_CMD = typedSrc.AR_Ht0102_CMD;
        typedDst.AR_Vv04_CMD = typedSrc.AR_Vv04_CMD;
        typedDst.AR_Ht0304_CMD = typedSrc.AR_Ht0304_CMD;
        typedDst.AR_Vv05_CMD = typedSrc.AR_Vv05_CMD;
        typedDst.AR_Vv06_Enable_CMD = typedSrc.AR_Vv06_Enable_CMD;
        typedDst.AR_Vv06_Direction_CMD = typedSrc.AR_Vv06_Direction_CMD;
        typedDst.AR_Vv07_CMD = typedSrc.AR_Vv07_CMD;
        typedDst.AR_Vv08_CMD = typedSrc.AR_Vv08_CMD;
        typedDst.AR_Ht0506_CMD = typedSrc.AR_Ht0506_CMD;
        typedDst.AR_Ht0708_CMD = typedSrc.AR_Ht0708_CMD;
        typedDst.AR_Vv09_CMD = typedSrc.AR_Vv09_CMD;
        typedDst.AR_CMP_CMD = typedSrc.AR_CMP_CMD;
        typedDst.AR_Vv10_CMD = typedSrc.AR_Vv10_CMD;

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
        strBuffer.append("rank: ").append(rank).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv02_Enable_CMD: ").append(AR_Vv02_Enable_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv02_Direction_CMD: ").append(AR_Vv02_Direction_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Fn01_Speed_CMD: ").append(AR_Fn01_Speed_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Ht09_CMD: ").append(AR_Ht09_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_VMVv01_CMD: ").append(AR_VMVv01_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Fn02_Speed_CMD: ").append(AR_Fn02_Speed_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Pp01_CMD: ").append(AR_Pp01_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv03_Enable_CMD: ").append(AR_Vv03_Enable_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv03_Direction_CMD: ").append(AR_Vv03_Direction_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Ht0102_CMD: ").append(AR_Ht0102_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv04_CMD: ").append(AR_Vv04_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Ht0304_CMD: ").append(AR_Ht0304_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv05_CMD: ").append(AR_Vv05_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv06_Enable_CMD: ").append(AR_Vv06_Enable_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv06_Direction_CMD: ").append(AR_Vv06_Direction_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv07_CMD: ").append(AR_Vv07_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv08_CMD: ").append(AR_Vv08_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Ht0506_CMD: ").append(AR_Ht0506_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Ht0708_CMD: ").append(AR_Ht0708_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv09_CMD: ").append(AR_Vv09_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_CMP_CMD: ").append(AR_CMP_CMD).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Vv10_CMD: ").append(AR_Vv10_CMD).append("\n");  

        return strBuffer.toString();
    }

}
