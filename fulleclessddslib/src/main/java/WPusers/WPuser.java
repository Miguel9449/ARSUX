package WPusers;

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

public class WPuser   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double WWkgMin= 0;
    public double WWkgTrip= 0;
    public double WSkgMin= 0;
    public double WSkgTrip= 0;
    public double WSkgMax= 0;

    public WPuser() {

    }
    public WPuser (WPuser other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WPuser self;
        self = new WPuser();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        WWkgMin= 0;
        WWkgTrip= 0;
        WSkgMin= 0;
        WSkgTrip= 0;
        WSkgMax= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WPuser otherObj = (WPuser)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        if(WWkgMin != otherObj.WWkgMin) {
            return false;
        }
        if(WWkgTrip != otherObj.WWkgTrip) {
            return false;
        }
        if(WSkgMin != otherObj.WSkgMin) {
            return false;
        }
        if(WSkgTrip != otherObj.WSkgTrip) {
            return false;
        }
        if(WSkgMax != otherObj.WSkgMax) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        __result += (int)WWkgMin;
        __result += (int)WWkgTrip;
        __result += (int)WSkgMin;
        __result += (int)WSkgTrip;
        __result += (int)WSkgMax;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WPuserTypeSupport</code>
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

        WPuser typedSrc = (WPuser) src;
        WPuser typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        typedDst.WWkgMin = typedSrc.WWkgMin;
        typedDst.WWkgTrip = typedSrc.WWkgTrip;
        typedDst.WSkgMin = typedSrc.WSkgMin;
        typedDst.WSkgTrip = typedSrc.WSkgTrip;
        typedDst.WSkgMax = typedSrc.WSkgMax;

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
        strBuffer.append("WWkgMin: ").append(WWkgMin).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WWkgTrip: ").append(WWkgTrip).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WSkgMin: ").append(WSkgMin).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WSkgTrip: ").append(WSkgTrip).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WSkgMax: ").append(WSkgMax).append("\n");  

        return strBuffer.toString();
    }

}
