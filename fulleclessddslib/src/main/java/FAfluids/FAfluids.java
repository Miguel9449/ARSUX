package FAfluids;

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

public class FAfluids   implements Copyable, Serializable{

    public int id= 0;
    public double flowIn= 0;
    public double flowout= 0;
    public double temperatureOut= 0;
    public double [] ARSmolefracs=  new double [4];
    public double condensationKGS= 0;
    public double CO2kelvins= 0;
    public double CO2Pa= 0;

    public FAfluids() {

    }
    public FAfluids (FAfluids other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        FAfluids self;
        self = new FAfluids();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        flowIn= 0;
        flowout= 0;
        temperatureOut= 0;
        for(int i1__ = 0; i1__< 4; ++i1__){

            ARSmolefracs[i1__] =  0;
        }

        condensationKGS= 0;
        CO2kelvins= 0;
        CO2Pa= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        FAfluids otherObj = (FAfluids)o;

        if(id != otherObj.id) {
            return false;
        }
        if(flowIn != otherObj.flowIn) {
            return false;
        }
        if(flowout != otherObj.flowout) {
            return false;
        }
        if(temperatureOut != otherObj.temperatureOut) {
            return false;
        }
        for(int i1__ = 0; i1__< 4; ++i1__){

            if(ARSmolefracs[i1__] != otherObj.ARSmolefracs[i1__]) {
                return false;
            }
        }

        if(condensationKGS != otherObj.condensationKGS) {
            return false;
        }
        if(CO2kelvins != otherObj.CO2kelvins) {
            return false;
        }
        if(CO2Pa != otherObj.CO2Pa) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)flowIn;
        __result += (int)flowout;
        __result += (int)temperatureOut;
        for(int i1__ = 0; i1__< 4; ++i1__){

            __result += (int)ARSmolefracs[i1__];
        }

        __result += (int)condensationKGS;
        __result += (int)CO2kelvins;
        __result += (int)CO2Pa;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>FAfluidsTypeSupport</code>
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

        FAfluids typedSrc = (FAfluids) src;
        FAfluids typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.flowIn = typedSrc.flowIn;
        typedDst.flowout = typedSrc.flowout;
        typedDst.temperatureOut = typedSrc.temperatureOut;
        System.arraycopy(typedSrc.ARSmolefracs,0,
        typedDst.ARSmolefracs,0,
        typedSrc.ARSmolefracs.length); 

        typedDst.condensationKGS = typedSrc.condensationKGS;
        typedDst.CO2kelvins = typedSrc.CO2kelvins;
        typedDst.CO2Pa = typedSrc.CO2Pa;

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
        strBuffer.append("flowIn: ").append(flowIn).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("flowout: ").append(flowout).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("temperatureOut: ").append(temperatureOut).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("ARSmolefracs: ");
        for(int i1__ = 0; i1__< 4; ++i1__){

            strBuffer.append(ARSmolefracs[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("condensationKGS: ").append(condensationKGS).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("CO2kelvins: ").append(CO2kelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("CO2Pa: ").append(CO2Pa).append("\n");  

        return strBuffer.toString();
    }

}
