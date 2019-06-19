package UPAfluids;

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

public class UPAfluids   implements Copyable, Serializable{

    public int id= 0;
    public double UPA2WWkelvins= 0;
    public double UPA2WWkgs= 0;
    public double BPAVaporkgs= 0;
    public double BPA2HabHeatW= 0;

    public UPAfluids() {

    }
    public UPAfluids (UPAfluids other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UPAfluids self;
        self = new UPAfluids();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        UPA2WWkelvins= 0;
        UPA2WWkgs= 0;
        BPAVaporkgs= 0;
        BPA2HabHeatW= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UPAfluids otherObj = (UPAfluids)o;

        if(id != otherObj.id) {
            return false;
        }
        if(UPA2WWkelvins != otherObj.UPA2WWkelvins) {
            return false;
        }
        if(UPA2WWkgs != otherObj.UPA2WWkgs) {
            return false;
        }
        if(BPAVaporkgs != otherObj.BPAVaporkgs) {
            return false;
        }
        if(BPA2HabHeatW != otherObj.BPA2HabHeatW) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)UPA2WWkelvins;
        __result += (int)UPA2WWkgs;
        __result += (int)BPAVaporkgs;
        __result += (int)BPA2HabHeatW;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UPAfluidsTypeSupport</code>
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

        UPAfluids typedSrc = (UPAfluids) src;
        UPAfluids typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.UPA2WWkelvins = typedSrc.UPA2WWkelvins;
        typedDst.UPA2WWkgs = typedSrc.UPA2WWkgs;
        typedDst.BPAVaporkgs = typedSrc.BPAVaporkgs;
        typedDst.BPA2HabHeatW = typedSrc.BPA2HabHeatW;

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
        strBuffer.append("UPA2WWkelvins: ").append(UPA2WWkelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("UPA2WWkgs: ").append(UPA2WWkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("BPAVaporkgs: ").append(BPAVaporkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("BPA2HabHeatW: ").append(BPA2HabHeatW).append("\n");  

        return strBuffer.toString();
    }

}
