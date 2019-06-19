package WPcommands;

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

public class WPcommands   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double WPSV01211= 0;
    public double WPPM4111= 0;
    public double WPSM4121= 0;
    public double WPPP4117= 0;
    public double WPSV01212= 0;
    public double WPSV11211= 0;
    public double WPSV0133= 0;
    public double WPSV11212= 0;
    public double WPSV0122= 0;
    public double WPSV11213= 0;
    public double WPSV1101= 0;
    public double WPSV11261= 0;

    public WPcommands() {

    }
    public WPcommands (WPcommands other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WPcommands self;
        self = new WPcommands();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        WPSV01211= 0;
        WPPM4111= 0;
        WPSM4121= 0;
        WPPP4117= 0;
        WPSV01212= 0;
        WPSV11211= 0;
        WPSV0133= 0;
        WPSV11212= 0;
        WPSV0122= 0;
        WPSV11213= 0;
        WPSV1101= 0;
        WPSV11261= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WPcommands otherObj = (WPcommands)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(WPSV01211 != otherObj.WPSV01211) {
            return false;
        }
        if(WPPM4111 != otherObj.WPPM4111) {
            return false;
        }
        if(WPSM4121 != otherObj.WPSM4121) {
            return false;
        }
        if(WPPP4117 != otherObj.WPPP4117) {
            return false;
        }
        if(WPSV01212 != otherObj.WPSV01212) {
            return false;
        }
        if(WPSV11211 != otherObj.WPSV11211) {
            return false;
        }
        if(WPSV0133 != otherObj.WPSV0133) {
            return false;
        }
        if(WPSV11212 != otherObj.WPSV11212) {
            return false;
        }
        if(WPSV0122 != otherObj.WPSV0122) {
            return false;
        }
        if(WPSV11213 != otherObj.WPSV11213) {
            return false;
        }
        if(WPSV1101 != otherObj.WPSV1101) {
            return false;
        }
        if(WPSV11261 != otherObj.WPSV11261) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)WPSV01211;
        __result += (int)WPPM4111;
        __result += (int)WPSM4121;
        __result += (int)WPPP4117;
        __result += (int)WPSV01212;
        __result += (int)WPSV11211;
        __result += (int)WPSV0133;
        __result += (int)WPSV11212;
        __result += (int)WPSV0122;
        __result += (int)WPSV11213;
        __result += (int)WPSV1101;
        __result += (int)WPSV11261;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WPcommandsTypeSupport</code>
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

        WPcommands typedSrc = (WPcommands) src;
        WPcommands typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.WPSV01211 = typedSrc.WPSV01211;
        typedDst.WPPM4111 = typedSrc.WPPM4111;
        typedDst.WPSM4121 = typedSrc.WPSM4121;
        typedDst.WPPP4117 = typedSrc.WPPP4117;
        typedDst.WPSV01212 = typedSrc.WPSV01212;
        typedDst.WPSV11211 = typedSrc.WPSV11211;
        typedDst.WPSV0133 = typedSrc.WPSV0133;
        typedDst.WPSV11212 = typedSrc.WPSV11212;
        typedDst.WPSV0122 = typedSrc.WPSV0122;
        typedDst.WPSV11213 = typedSrc.WPSV11213;
        typedDst.WPSV1101 = typedSrc.WPSV1101;
        typedDst.WPSV11261 = typedSrc.WPSV11261;

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
        strBuffer.append("WPSV01211: ").append(WPSV01211).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPM4111: ").append(WPPM4111).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSM4121: ").append(WPSM4121).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPP4117: ").append(WPPP4117).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV01212: ").append(WPSV01212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV11211: ").append(WPSV11211).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV0133: ").append(WPSV0133).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV11212: ").append(WPSV11212).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV0122: ").append(WPSV0122).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV11213: ").append(WPSV11213).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV1101: ").append(WPSV1101).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPSV11261: ").append(WPSV11261).append("\n");  

        return strBuffer.toString();
    }

}
