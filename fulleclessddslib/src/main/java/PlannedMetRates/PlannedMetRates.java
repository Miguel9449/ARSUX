package PlannedMetRates;

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

public class PlannedMetRates   implements Copyable, Serializable{

    public int id= 0;
    public double [] CrewTimes=  new double [96];
    public double [] WaterVaporKGS=  new double [96];
    public double [] SensibleWatts=  new double [96];
    public double [] O2KGS=  new double [96];
    public double [] CO2KGS=  new double [96];

    public PlannedMetRates() {

    }
    public PlannedMetRates (PlannedMetRates other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        PlannedMetRates self;
        self = new PlannedMetRates();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        for(int i1__ = 0; i1__< 96; ++i1__){

            CrewTimes[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            WaterVaporKGS[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            SensibleWatts[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            O2KGS[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            CO2KGS[i1__] =  0;
        }

    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        PlannedMetRates otherObj = (PlannedMetRates)o;

        if(id != otherObj.id) {
            return false;
        }
        for(int i1__ = 0; i1__< 96; ++i1__){

            if(CrewTimes[i1__] != otherObj.CrewTimes[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            if(WaterVaporKGS[i1__] != otherObj.WaterVaporKGS[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            if(SensibleWatts[i1__] != otherObj.SensibleWatts[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            if(O2KGS[i1__] != otherObj.O2KGS[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            if(CO2KGS[i1__] != otherObj.CO2KGS[i1__]) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        for(int i1__ = 0; i1__< 96; ++i1__){

            __result += (int)CrewTimes[i1__];
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            __result += (int)WaterVaporKGS[i1__];
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            __result += (int)SensibleWatts[i1__];
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            __result += (int)O2KGS[i1__];
        }

        for(int i1__ = 0; i1__< 96; ++i1__){

            __result += (int)CO2KGS[i1__];
        }

        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>PlannedMetRatesTypeSupport</code>
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

        PlannedMetRates typedSrc = (PlannedMetRates) src;
        PlannedMetRates typedDst = this;

        typedDst.id = typedSrc.id;
        System.arraycopy(typedSrc.CrewTimes,0,
        typedDst.CrewTimes,0,
        typedSrc.CrewTimes.length); 

        System.arraycopy(typedSrc.WaterVaporKGS,0,
        typedDst.WaterVaporKGS,0,
        typedSrc.WaterVaporKGS.length); 

        System.arraycopy(typedSrc.SensibleWatts,0,
        typedDst.SensibleWatts,0,
        typedSrc.SensibleWatts.length); 

        System.arraycopy(typedSrc.O2KGS,0,
        typedDst.O2KGS,0,
        typedSrc.O2KGS.length); 

        System.arraycopy(typedSrc.CO2KGS,0,
        typedDst.CO2KGS,0,
        typedSrc.CO2KGS.length); 

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
        strBuffer.append("CrewTimes: ");
        for(int i1__ = 0; i1__< 96; ++i1__){

            strBuffer.append(CrewTimes[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("WaterVaporKGS: ");
        for(int i1__ = 0; i1__< 96; ++i1__){

            strBuffer.append(WaterVaporKGS[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("SensibleWatts: ");
        for(int i1__ = 0; i1__< 96; ++i1__){

            strBuffer.append(SensibleWatts[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("O2KGS: ");
        for(int i1__ = 0; i1__< 96; ++i1__){

            strBuffer.append(O2KGS[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("CO2KGS: ");
        for(int i1__ = 0; i1__< 96; ++i1__){

            strBuffer.append(CO2KGS[i1__]).append(", ");
        }

        strBuffer.append("\n");

        return strBuffer.toString();
    }

}
