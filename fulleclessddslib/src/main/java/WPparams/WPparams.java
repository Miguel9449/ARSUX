package WPparams;

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

public class WPparams   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double T_MTCL_K= 0;
    public double PROCESSkgs= 0;
    public double DELIVERYkgs= 0;

    public WPparams() {

    }
    public WPparams (WPparams other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WPparams self;
        self = new WPparams();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        T_MTCL_K= 0;
        PROCESSkgs= 0;
        DELIVERYkgs= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WPparams otherObj = (WPparams)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(T_MTCL_K != otherObj.T_MTCL_K) {
            return false;
        }
        if(PROCESSkgs != otherObj.PROCESSkgs) {
            return false;
        }
        if(DELIVERYkgs != otherObj.DELIVERYkgs) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)T_MTCL_K;
        __result += (int)PROCESSkgs;
        __result += (int)DELIVERYkgs;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WPparamsTypeSupport</code>
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

        WPparams typedSrc = (WPparams) src;
        WPparams typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.T_MTCL_K = typedSrc.T_MTCL_K;
        typedDst.PROCESSkgs = typedSrc.PROCESSkgs;
        typedDst.DELIVERYkgs = typedSrc.DELIVERYkgs;

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
        strBuffer.append("T_MTCL_K: ").append(T_MTCL_K).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("PROCESSkgs: ").append(PROCESSkgs).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("DELIVERYkgs: ").append(DELIVERYkgs).append("\n");  

        return strBuffer.toString();
    }

}
