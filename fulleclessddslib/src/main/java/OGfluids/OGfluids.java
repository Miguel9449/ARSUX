package OGfluids;

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

public class OGfluids   implements Copyable, Serializable{

    public int id= 0;
    public double WD2OGkgs= 0;
    public double OG2WWkgs= 0;
    public double OG2WWkelvins= 0;
    public double OGO2kgs= 0;
    public double [] OGO2molpers=  new double [4];
    public double OGO2kelvins= 0;
    public double FA2SAkgs= 0;
    public double OG2HabHeatW= 0;
    public double OGH2kelvins= 0;
    public double SA2WWkgs= 0;
    public double SA2WWkelvins= 0;

    public OGfluids() {

    }
    public OGfluids (OGfluids other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        OGfluids self;
        self = new OGfluids();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        WD2OGkgs= 0;
        OG2WWkgs= 0;
        OG2WWkelvins= 0;
        OGO2kgs= 0;
        for(int i1__ = 0; i1__< 4; ++i1__){

            OGO2molpers[i1__] =  0;
        }

        OGO2kelvins= 0;
        FA2SAkgs= 0;
        OG2HabHeatW= 0;
        OGH2kelvins= 0;
        SA2WWkgs= 0;
        SA2WWkelvins= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        OGfluids otherObj = (OGfluids)o;

        if(id != otherObj.id) {
            return false;
        }
        if(WD2OGkgs != otherObj.WD2OGkgs) {
            return false;
        }
        if(OG2WWkgs != otherObj.OG2WWkgs) {
            return false;
        }
        if(OG2WWkelvins != otherObj.OG2WWkelvins) {
            return false;
        }
        if(OGO2kgs != otherObj.OGO2kgs) {
            return false;
        }
        for(int i1__ = 0; i1__< 4; ++i1__){

            if(OGO2molpers[i1__] != otherObj.OGO2molpers[i1__]) {
                return false;
            }
        }

        if(OGO2kelvins != otherObj.OGO2kelvins) {
            return false;
        }
        if(FA2SAkgs != otherObj.FA2SAkgs) {
            return false;
        }
        if(OG2HabHeatW != otherObj.OG2HabHeatW) {
            return false;
        }
        if(OGH2kelvins != otherObj.OGH2kelvins) {
            return false;
        }
        if(SA2WWkgs != otherObj.SA2WWkgs) {
            return false;
        }
        if(SA2WWkelvins != otherObj.SA2WWkelvins) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)WD2OGkgs;
        __result += (int)OG2WWkgs;
        __result += (int)OG2WWkelvins;
        __result += (int)OGO2kgs;
        for(int i1__ = 0; i1__< 4; ++i1__){

            __result += (int)OGO2molpers[i1__];
        }

        __result += (int)OGO2kelvins;
        __result += (int)FA2SAkgs;
        __result += (int)OG2HabHeatW;
        __result += (int)OGH2kelvins;
        __result += (int)SA2WWkgs;
        __result += (int)SA2WWkelvins;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>OGfluidsTypeSupport</code>
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

        OGfluids typedSrc = (OGfluids) src;
        OGfluids typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.WD2OGkgs = typedSrc.WD2OGkgs;
        typedDst.OG2WWkgs = typedSrc.OG2WWkgs;
        typedDst.OG2WWkelvins = typedSrc.OG2WWkelvins;
        typedDst.OGO2kgs = typedSrc.OGO2kgs;
        System.arraycopy(typedSrc.OGO2molpers,0,
        typedDst.OGO2molpers,0,
        typedSrc.OGO2molpers.length); 

        typedDst.OGO2kelvins = typedSrc.OGO2kelvins;
        typedDst.FA2SAkgs = typedSrc.FA2SAkgs;
        typedDst.OG2HabHeatW = typedSrc.OG2HabHeatW;
        typedDst.OGH2kelvins = typedSrc.OGH2kelvins;
        typedDst.SA2WWkgs = typedSrc.SA2WWkgs;
        typedDst.SA2WWkelvins = typedSrc.SA2WWkelvins;

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
        strBuffer.append("WD2OGkgs: ").append(WD2OGkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OG2WWkgs: ").append(OG2WWkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OG2WWkelvins: ").append(OG2WWkelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGO2kgs: ").append(OGO2kgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("OGO2molpers: ");
        for(int i1__ = 0; i1__< 4; ++i1__){

            strBuffer.append(OGO2molpers[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGO2kelvins: ").append(OGO2kelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("FA2SAkgs: ").append(FA2SAkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OG2HabHeatW: ").append(OG2HabHeatW).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGH2kelvins: ").append(OGH2kelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("SA2WWkgs: ").append(SA2WWkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("SA2WWkelvins: ").append(SA2WWkelvins).append("\n");  

        return strBuffer.toString();
    }

}
