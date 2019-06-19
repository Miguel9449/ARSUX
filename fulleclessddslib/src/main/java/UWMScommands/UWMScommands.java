package UWMScommands;

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

public class UWMScommands   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double SV01= 0;
    public double SV03= 0;

    public UWMScommands() {

    }
    public UWMScommands (UWMScommands other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UWMScommands self;
        self = new UWMScommands();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        SV01= 0;
        SV03= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UWMScommands otherObj = (UWMScommands)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(SV01 != otherObj.SV01) {
            return false;
        }
        if(SV03 != otherObj.SV03) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)SV01;
        __result += (int)SV03;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UWMScommandsTypeSupport</code>
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

        UWMScommands typedSrc = (UWMScommands) src;
        UWMScommands typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.SV01 = typedSrc.SV01;
        typedDst.SV03 = typedSrc.SV03;

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
        strBuffer.append("SV01: ").append(SV01).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("SV03: ").append(SV03).append("\n");  

        return strBuffer.toString();
    }

}
