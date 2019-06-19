package OGcomands;

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

public class OGcommands   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double OGPM4051= 0;
    public double OGSM4052= 0;
    public double OGSV01312= 0;
    public double OGSV0122= 0;
    public double OGSV0581= 0;
    public double OGStackCurrent= 0;
    public double OGSV0322= 0;
    public double OGSV03212= 0;
    public double OGSV03213= 0;
    public double OGSV16421= 0;
    public double OGSV02211= 0;
    public double OGSV02212= 0;
    public double OGHTR8095= 0;

    public OGcommands() {

    }
    public OGcommands (OGcommands other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        OGcommands self;
        self = new OGcommands();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        OGPM4051= 0;
        OGSM4052= 0;
        OGSV01312= 0;
        OGSV0122= 0;
        OGSV0581= 0;
        OGStackCurrent= 0;
        OGSV0322= 0;
        OGSV03212= 0;
        OGSV03213= 0;
        OGSV16421= 0;
        OGSV02211= 0;
        OGSV02212= 0;
        OGHTR8095= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        OGcommands otherObj = (OGcommands)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(OGPM4051 != otherObj.OGPM4051) {
            return false;
        }
        if(OGSM4052 != otherObj.OGSM4052) {
            return false;
        }
        if(OGSV01312 != otherObj.OGSV01312) {
            return false;
        }
        if(OGSV0122 != otherObj.OGSV0122) {
            return false;
        }
        if(OGSV0581 != otherObj.OGSV0581) {
            return false;
        }
        if(OGStackCurrent != otherObj.OGStackCurrent) {
            return false;
        }
        if(OGSV0322 != otherObj.OGSV0322) {
            return false;
        }
        if(OGSV03212 != otherObj.OGSV03212) {
            return false;
        }
        if(OGSV03213 != otherObj.OGSV03213) {
            return false;
        }
        if(OGSV16421 != otherObj.OGSV16421) {
            return false;
        }
        if(OGSV02211 != otherObj.OGSV02211) {
            return false;
        }
        if(OGSV02212 != otherObj.OGSV02212) {
            return false;
        }
        if(OGHTR8095 != otherObj.OGHTR8095) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)OGPM4051;
        __result += (int)OGSM4052;
        __result += (int)OGSV01312;
        __result += (int)OGSV0122;
        __result += (int)OGSV0581;
        __result += (int)OGStackCurrent;
        __result += (int)OGSV0322;
        __result += (int)OGSV03212;
        __result += (int)OGSV03213;
        __result += (int)OGSV16421;
        __result += (int)OGSV02211;
        __result += (int)OGSV02212;
        __result += (int)OGHTR8095;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>OGcommandsTypeSupport</code>
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

        OGcommands typedSrc = (OGcommands) src;
        OGcommands typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.OGPM4051 = typedSrc.OGPM4051;
        typedDst.OGSM4052 = typedSrc.OGSM4052;
        typedDst.OGSV01312 = typedSrc.OGSV01312;
        typedDst.OGSV0122 = typedSrc.OGSV0122;
        typedDst.OGSV0581 = typedSrc.OGSV0581;
        typedDst.OGStackCurrent = typedSrc.OGStackCurrent;
        typedDst.OGSV0322 = typedSrc.OGSV0322;
        typedDst.OGSV03212 = typedSrc.OGSV03212;
        typedDst.OGSV03213 = typedSrc.OGSV03213;
        typedDst.OGSV16421 = typedSrc.OGSV16421;
        typedDst.OGSV02211 = typedSrc.OGSV02211;
        typedDst.OGSV02212 = typedSrc.OGSV02212;
        typedDst.OGHTR8095 = typedSrc.OGHTR8095;

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
        strBuffer.append("OGPM4051: ").append(OGPM4051).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSM4052: ").append(OGSM4052).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV01312: ").append(OGSV01312).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV0122: ").append(OGSV0122).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV0581: ").append(OGSV0581).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGStackCurrent: ").append(OGStackCurrent).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV0322: ").append(OGSV0322).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV03212: ").append(OGSV03212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV03213: ").append(OGSV03213).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV16421: ").append(OGSV16421).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV02211: ").append(OGSV02211).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGSV02212: ").append(OGSV02212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("OGHTR8095: ").append(OGHTR8095).append("\n");  

        return strBuffer.toString();
    }

}
