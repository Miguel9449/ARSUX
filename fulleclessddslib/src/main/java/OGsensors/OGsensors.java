package OGsensors;

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

public class OGsensors   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double OGP73211= 0;
    public double OGP73212= 0;
    public double OGT75411= 0;
    public double OGT75412= 0;
    public double OGDP7131= 0;
    public double OGN80011= 0;
    public double OGF75311= 0;
    public double OGF75313= 0;
    public double OGP7111= 0;
    public double OGRSAquantity= 0;
    public double OGG82421= 0;
    public double OGCS71912= 0;
    public double OGN80012= 0;
    public double OGP7312= 0;
    public double OGP73113= 0;
    public double OGP71211= 0;
    public double OGP71212= 0;
    public double OGT72411= 0;
    public double OGT72412= 0;
    public int fault= 0;

    public OGsensors() {

    }
    public OGsensors (OGsensors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        OGsensors self;
        self = new OGsensors();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        OGP73211= 0;
        OGP73212= 0;
        OGT75411= 0;
        OGT75412= 0;
        OGDP7131= 0;
        OGN80011= 0;
        OGF75311= 0;
        OGF75313= 0;
        OGP7111= 0;
        OGRSAquantity= 0;
        OGG82421= 0;
        OGCS71912= 0;
        OGN80012= 0;
        OGP7312= 0;
        OGP73113= 0;
        OGP71211= 0;
        OGP71212= 0;
        OGT72411= 0;
        OGT72412= 0;
        fault= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        OGsensors otherObj = (OGsensors)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(OGP73211 != otherObj.OGP73211) {
            return false;
        }
        if(OGP73212 != otherObj.OGP73212) {
            return false;
        }
        if(OGT75411 != otherObj.OGT75411) {
            return false;
        }
        if(OGT75412 != otherObj.OGT75412) {
            return false;
        }
        if(OGDP7131 != otherObj.OGDP7131) {
            return false;
        }
        if(OGN80011 != otherObj.OGN80011) {
            return false;
        }
        if(OGF75311 != otherObj.OGF75311) {
            return false;
        }
        if(OGF75313 != otherObj.OGF75313) {
            return false;
        }
        if(OGP7111 != otherObj.OGP7111) {
            return false;
        }
        if(OGRSAquantity != otherObj.OGRSAquantity) {
            return false;
        }
        if(OGG82421 != otherObj.OGG82421) {
            return false;
        }
        if(OGCS71912 != otherObj.OGCS71912) {
            return false;
        }
        if(OGN80012 != otherObj.OGN80012) {
            return false;
        }
        if(OGP7312 != otherObj.OGP7312) {
            return false;
        }
        if(OGP73113 != otherObj.OGP73113) {
            return false;
        }
        if(OGP71211 != otherObj.OGP71211) {
            return false;
        }
        if(OGP71212 != otherObj.OGP71212) {
            return false;
        }
        if(OGT72411 != otherObj.OGT72411) {
            return false;
        }
        if(OGT72412 != otherObj.OGT72412) {
            return false;
        }
        if(fault != otherObj.fault) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)OGP73211;
        __result += (int)OGP73212;
        __result += (int)OGT75411;
        __result += (int)OGT75412;
        __result += (int)OGDP7131;
        __result += (int)OGN80011;
        __result += (int)OGF75311;
        __result += (int)OGF75313;
        __result += (int)OGP7111;
        __result += (int)OGRSAquantity;
        __result += (int)OGG82421;
        __result += (int)OGCS71912;
        __result += (int)OGN80012;
        __result += (int)OGP7312;
        __result += (int)OGP73113;
        __result += (int)OGP71211;
        __result += (int)OGP71212;
        __result += (int)OGT72411;
        __result += (int)OGT72412;
        __result += (int)fault;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>OGsensorsTypeSupport</code>
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

        OGsensors typedSrc = (OGsensors) src;
        OGsensors typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.OGP73211 = typedSrc.OGP73211;
        typedDst.OGP73212 = typedSrc.OGP73212;
        typedDst.OGT75411 = typedSrc.OGT75411;
        typedDst.OGT75412 = typedSrc.OGT75412;
        typedDst.OGDP7131 = typedSrc.OGDP7131;
        typedDst.OGN80011 = typedSrc.OGN80011;
        typedDst.OGF75311 = typedSrc.OGF75311;
        typedDst.OGF75313 = typedSrc.OGF75313;
        typedDst.OGP7111 = typedSrc.OGP7111;
        typedDst.OGRSAquantity = typedSrc.OGRSAquantity;
        typedDst.OGG82421 = typedSrc.OGG82421;
        typedDst.OGCS71912 = typedSrc.OGCS71912;
        typedDst.OGN80012 = typedSrc.OGN80012;
        typedDst.OGP7312 = typedSrc.OGP7312;
        typedDst.OGP73113 = typedSrc.OGP73113;
        typedDst.OGP71211 = typedSrc.OGP71211;
        typedDst.OGP71212 = typedSrc.OGP71212;
        typedDst.OGT72411 = typedSrc.OGT72411;
        typedDst.OGT72412 = typedSrc.OGT72412;
        typedDst.fault = typedSrc.fault;

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
        strBuffer.append("OGP73211: ").append(OGP73211).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP73212: ").append(OGP73212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGT75411: ").append(OGT75411).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGT75412: ").append(OGT75412).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGDP7131: ").append(OGDP7131).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGN80011: ").append(OGN80011).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGF75311: ").append(OGF75311).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGF75313: ").append(OGF75313).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP7111: ").append(OGP7111).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGRSAquantity: ").append(OGRSAquantity).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGG82421: ").append(OGG82421).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGCS71912: ").append(OGCS71912).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGN80012: ").append(OGN80012).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP7312: ").append(OGP7312).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP73113: ").append(OGP73113).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP71211: ").append(OGP71211).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGP71212: ").append(OGP71212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGT72411: ").append(OGT72411).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGT72412: ").append(OGT72412).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("fault: ").append(fault).append("\n");  

        return strBuffer.toString();
    }

}
