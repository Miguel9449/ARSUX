package FAparams;

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

public class FAparams   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double CHXscalingfactor= 0;
    public double CHXcoolantpph= 0;
    public double [] HTCOtemperatureK=  new double [15];
    public double [] HTCOefficiency=  new double [15];
    public double HTCOheaterScalingFactor= 0;

    public FAparams() {

    }
    public FAparams (FAparams other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        FAparams self;
        self = new FAparams();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        CHXscalingfactor= 0;
        CHXcoolantpph= 0;
        for(int i1__ = 0; i1__< 15; ++i1__){

            HTCOtemperatureK[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 15; ++i1__){

            HTCOefficiency[i1__] =  0;
        }

        HTCOheaterScalingFactor= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        FAparams otherObj = (FAparams)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(CHXscalingfactor != otherObj.CHXscalingfactor) {
            return false;
        }
        if(CHXcoolantpph != otherObj.CHXcoolantpph) {
            return false;
        }
        for(int i1__ = 0; i1__< 15; ++i1__){

            if(HTCOtemperatureK[i1__] != otherObj.HTCOtemperatureK[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 15; ++i1__){

            if(HTCOefficiency[i1__] != otherObj.HTCOefficiency[i1__]) {
                return false;
            }
        }

        if(HTCOheaterScalingFactor != otherObj.HTCOheaterScalingFactor) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)CHXscalingfactor;
        __result += (int)CHXcoolantpph;
        for(int i1__ = 0; i1__< 15; ++i1__){

            __result += (int)HTCOtemperatureK[i1__];
        }

        for(int i1__ = 0; i1__< 15; ++i1__){

            __result += (int)HTCOefficiency[i1__];
        }

        __result += (int)HTCOheaterScalingFactor;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>FAparamsTypeSupport</code>
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

        FAparams typedSrc = (FAparams) src;
        FAparams typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.CHXscalingfactor = typedSrc.CHXscalingfactor;
        typedDst.CHXcoolantpph = typedSrc.CHXcoolantpph;
        System.arraycopy(typedSrc.HTCOtemperatureK,0,
        typedDst.HTCOtemperatureK,0,
        typedSrc.HTCOtemperatureK.length); 

        System.arraycopy(typedSrc.HTCOefficiency,0,
        typedDst.HTCOefficiency,0,
        typedSrc.HTCOefficiency.length); 

        typedDst.HTCOheaterScalingFactor = typedSrc.HTCOheaterScalingFactor;

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
        strBuffer.append("CHXscalingfactor: ").append(CHXscalingfactor).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("CHXcoolantpph: ").append(CHXcoolantpph).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HTCOtemperatureK: ");
        for(int i1__ = 0; i1__< 15; ++i1__){

            strBuffer.append(HTCOtemperatureK[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HTCOefficiency: ");
        for(int i1__ = 0; i1__< 15; ++i1__){

            strBuffer.append(HTCOefficiency[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("HTCOheaterScalingFactor: ").append(HTCOheaterScalingFactor).append("\n");  

        return strBuffer.toString();
    }

}
