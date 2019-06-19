package UPAcommands;

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

public class UPAcommands   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double BPA= 0;
    public boolean Replace= false;
    public double M1= 0;
    public double M2= 0;
    public double M4= 0;
    public boolean DrainARFTA= false;

    public UPAcommands() {

    }
    public UPAcommands (UPAcommands other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UPAcommands self;
        self = new UPAcommands();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        BPA= 0;
        Replace= false;
        M1= 0;
        M2= 0;
        M4= 0;
        DrainARFTA= false;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UPAcommands otherObj = (UPAcommands)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(BPA != otherObj.BPA) {
            return false;
        }
        if(Replace != otherObj.Replace) {
            return false;
        }
        if(M1 != otherObj.M1) {
            return false;
        }
        if(M2 != otherObj.M2) {
            return false;
        }
        if(M4 != otherObj.M4) {
            return false;
        }
        if(DrainARFTA != otherObj.DrainARFTA) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)BPA;
        __result += (Replace == true)?1:0;
        __result += (int)M1;
        __result += (int)M2;
        __result += (int)M4;
        __result += (DrainARFTA == true)?1:0;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UPAcommandsTypeSupport</code>
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

        UPAcommands typedSrc = (UPAcommands) src;
        UPAcommands typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.BPA = typedSrc.BPA;
        typedDst.Replace = typedSrc.Replace;
        typedDst.M1 = typedSrc.M1;
        typedDst.M2 = typedSrc.M2;
        typedDst.M4 = typedSrc.M4;
        typedDst.DrainARFTA = typedSrc.DrainARFTA;

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
        strBuffer.append("BPA: ").append(BPA).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("Replace: ").append(Replace).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("M1: ").append(M1).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("M2: ").append(M2).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("M4: ").append(M4).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("DrainARFTA: ").append(DrainARFTA).append("\n");  

        return strBuffer.toString();
    }

}
