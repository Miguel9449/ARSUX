package HABparams;

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

public class HABparams   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double AirVolume= 0;
    public double DistrEqLength= 0;
    public double [] CrewParameters=  new double [12];
    public double [] HabHeatTimes=  new double [2];
    public double [] HabHeat=  new double [2];

    public HABparams() {

    }
    public HABparams (HABparams other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        HABparams self;
        self = new HABparams();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        AirVolume= 0;
        DistrEqLength= 0;
        for(int i1__ = 0; i1__< 12; ++i1__){

            CrewParameters[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            HabHeatTimes[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            HabHeat[i1__] =  0;
        }

    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        HABparams otherObj = (HABparams)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(AirVolume != otherObj.AirVolume) {
            return false;
        }
        if(DistrEqLength != otherObj.DistrEqLength) {
            return false;
        }
        for(int i1__ = 0; i1__< 12; ++i1__){

            if(CrewParameters[i1__] != otherObj.CrewParameters[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            if(HabHeatTimes[i1__] != otherObj.HabHeatTimes[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            if(HabHeat[i1__] != otherObj.HabHeat[i1__]) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)AirVolume;
        __result += (int)DistrEqLength;
        for(int i1__ = 0; i1__< 12; ++i1__){

            __result += (int)CrewParameters[i1__];
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            __result += (int)HabHeatTimes[i1__];
        }

        for(int i1__ = 0; i1__< 2; ++i1__){

            __result += (int)HabHeat[i1__];
        }

        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>HABparamsTypeSupport</code>
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

        HABparams typedSrc = (HABparams) src;
        HABparams typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.AirVolume = typedSrc.AirVolume;
        typedDst.DistrEqLength = typedSrc.DistrEqLength;
        System.arraycopy(typedSrc.CrewParameters,0,
        typedDst.CrewParameters,0,
        typedSrc.CrewParameters.length); 

        System.arraycopy(typedSrc.HabHeatTimes,0,
        typedDst.HabHeatTimes,0,
        typedSrc.HabHeatTimes.length); 

        System.arraycopy(typedSrc.HabHeat,0,
        typedDst.HabHeat,0,
        typedSrc.HabHeat.length); 

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
        strBuffer.append("AirVolume: ").append(AirVolume).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("DistrEqLength: ").append(DistrEqLength).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("CrewParameters: ");
        for(int i1__ = 0; i1__< 12; ++i1__){

            strBuffer.append(CrewParameters[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HabHeatTimes: ");
        for(int i1__ = 0; i1__< 2; ++i1__){

            strBuffer.append(HabHeatTimes[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HabHeat: ");
        for(int i1__ = 0; i1__< 2; ++i1__){

            strBuffer.append(HabHeat[i1__]).append(", ");
        }

        strBuffer.append("\n");

        return strBuffer.toString();
    }

}
