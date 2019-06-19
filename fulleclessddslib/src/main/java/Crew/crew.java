package Crew;

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

public class crew   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double crew1= 0;
    public double crew2= 0;
    public double crew3= 0;
    public double crew4= 0;
    public double timeofday= 0;

    public crew() {

    }
    public crew (crew other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        crew self;
        self = new crew();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        crew1= 0;
        crew2= 0;
        crew3= 0;
        crew4= 0;
        timeofday= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        crew otherObj = (crew)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(crew1 != otherObj.crew1) {
            return false;
        }
        if(crew2 != otherObj.crew2) {
            return false;
        }
        if(crew3 != otherObj.crew3) {
            return false;
        }
        if(crew4 != otherObj.crew4) {
            return false;
        }
        if(timeofday != otherObj.timeofday) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)crew1;
        __result += (int)crew2;
        __result += (int)crew3;
        __result += (int)crew4;
        __result += (int)timeofday;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>crewTypeSupport</code>
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

        crew typedSrc = (crew) src;
        crew typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.crew1 = typedSrc.crew1;
        typedDst.crew2 = typedSrc.crew2;
        typedDst.crew3 = typedSrc.crew3;
        typedDst.crew4 = typedSrc.crew4;
        typedDst.timeofday = typedSrc.timeofday;

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
        strBuffer.append("crew1: ").append(crew1).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("crew2: ").append(crew2).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("crew3: ").append(crew3).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("crew4: ").append(crew4).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timeofday: ").append(timeofday).append("\n");  

        return strBuffer.toString();
    }

}
