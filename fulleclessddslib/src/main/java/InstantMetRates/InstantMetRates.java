package InstantMetRates;

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

public class InstantMetRates   implements Copyable, Serializable{

    public int id= 0;
    public double water= 0;
    public double SensibleWatts= 0;
    public double oxygen= 0;
    public double CO2= 0;
    public double Micturition= 0;
    public double WaterUsekgs= 0;
    public double HabHeatWatts= 0;

    public InstantMetRates() {

    }
    public InstantMetRates (InstantMetRates other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        InstantMetRates self;
        self = new InstantMetRates();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        water= 0;
        SensibleWatts= 0;
        oxygen= 0;
        CO2= 0;
        Micturition= 0;
        WaterUsekgs= 0;
        HabHeatWatts= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        InstantMetRates otherObj = (InstantMetRates)o;

        if(id != otherObj.id) {
            return false;
        }
        if(water != otherObj.water) {
            return false;
        }
        if(SensibleWatts != otherObj.SensibleWatts) {
            return false;
        }
        if(oxygen != otherObj.oxygen) {
            return false;
        }
        if(CO2 != otherObj.CO2) {
            return false;
        }
        if(Micturition != otherObj.Micturition) {
            return false;
        }
        if(WaterUsekgs != otherObj.WaterUsekgs) {
            return false;
        }
        if(HabHeatWatts != otherObj.HabHeatWatts) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)water;
        __result += (int)SensibleWatts;
        __result += (int)oxygen;
        __result += (int)CO2;
        __result += (int)Micturition;
        __result += (int)WaterUsekgs;
        __result += (int)HabHeatWatts;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>InstantMetRatesTypeSupport</code>
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

        InstantMetRates typedSrc = (InstantMetRates) src;
        InstantMetRates typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.water = typedSrc.water;
        typedDst.SensibleWatts = typedSrc.SensibleWatts;
        typedDst.oxygen = typedSrc.oxygen;
        typedDst.CO2 = typedSrc.CO2;
        typedDst.Micturition = typedSrc.Micturition;
        typedDst.WaterUsekgs = typedSrc.WaterUsekgs;
        typedDst.HabHeatWatts = typedSrc.HabHeatWatts;

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
        strBuffer.append("water: ").append(water).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("SensibleWatts: ").append(SensibleWatts).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("oxygen: ").append(oxygen).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("CO2: ").append(CO2).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("Micturition: ").append(Micturition).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WaterUsekgs: ").append(WaterUsekgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("HabHeatWatts: ").append(HabHeatWatts).append("\n");  

        return strBuffer.toString();
    }

}
