package HABfluids;

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

public class HABfluids   implements Copyable, Serializable{

    public int id= 0;
    public double temperature= 0;
    public double pressure= 0;
    public double ARSOutletPressure= 0;
    public double [] HABmolefracs=  new double [4];
    public double WD2Habkgs= 0;
    public double Hab2WWkgs= 0;

    public HABfluids() {

    }
    public HABfluids (HABfluids other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        HABfluids self;
        self = new HABfluids();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        temperature= 0;
        pressure= 0;
        ARSOutletPressure= 0;
        for(int i1__ = 0; i1__< 4; ++i1__){

            HABmolefracs[i1__] =  0;
        }

        WD2Habkgs= 0;
        Hab2WWkgs= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        HABfluids otherObj = (HABfluids)o;

        if(id != otherObj.id) {
            return false;
        }
        if(temperature != otherObj.temperature) {
            return false;
        }
        if(pressure != otherObj.pressure) {
            return false;
        }
        if(ARSOutletPressure != otherObj.ARSOutletPressure) {
            return false;
        }
        for(int i1__ = 0; i1__< 4; ++i1__){

            if(HABmolefracs[i1__] != otherObj.HABmolefracs[i1__]) {
                return false;
            }
        }

        if(WD2Habkgs != otherObj.WD2Habkgs) {
            return false;
        }
        if(Hab2WWkgs != otherObj.Hab2WWkgs) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)temperature;
        __result += (int)pressure;
        __result += (int)ARSOutletPressure;
        for(int i1__ = 0; i1__< 4; ++i1__){

            __result += (int)HABmolefracs[i1__];
        }

        __result += (int)WD2Habkgs;
        __result += (int)Hab2WWkgs;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>HABfluidsTypeSupport</code>
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

        HABfluids typedSrc = (HABfluids) src;
        HABfluids typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.temperature = typedSrc.temperature;
        typedDst.pressure = typedSrc.pressure;
        typedDst.ARSOutletPressure = typedSrc.ARSOutletPressure;
        System.arraycopy(typedSrc.HABmolefracs,0,
        typedDst.HABmolefracs,0,
        typedSrc.HABmolefracs.length); 

        typedDst.WD2Habkgs = typedSrc.WD2Habkgs;
        typedDst.Hab2WWkgs = typedSrc.Hab2WWkgs;

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
        strBuffer.append("temperature: ").append(temperature).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("pressure: ").append(pressure).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("ARSOutletPressure: ").append(ARSOutletPressure).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HABmolefracs: ");
        for(int i1__ = 0; i1__< 4; ++i1__){

            strBuffer.append(HABmolefracs[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WD2Habkgs: ").append(WD2Habkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("Hab2WWkgs: ").append(Hab2WWkgs).append("\n");  

        return strBuffer.toString();
    }

}
