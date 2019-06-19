package WPfluids;

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

public class WPfluids   implements Copyable, Serializable{

    public int id= 0;
    public double WDPa= 0;
    public double WDkelvins= 0;
    public double WWPa= 0;
    public double WPAvapor= 0;

    public WPfluids() {

    }
    public WPfluids (WPfluids other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WPfluids self;
        self = new WPfluids();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        WDPa= 0;
        WDkelvins= 0;
        WWPa= 0;
        WPAvapor= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WPfluids otherObj = (WPfluids)o;

        if(id != otherObj.id) {
            return false;
        }
        if(WDPa != otherObj.WDPa) {
            return false;
        }
        if(WDkelvins != otherObj.WDkelvins) {
            return false;
        }
        if(WWPa != otherObj.WWPa) {
            return false;
        }
        if(WPAvapor != otherObj.WPAvapor) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)WDPa;
        __result += (int)WDkelvins;
        __result += (int)WWPa;
        __result += (int)WPAvapor;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WPfluidsTypeSupport</code>
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

        WPfluids typedSrc = (WPfluids) src;
        WPfluids typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.WDPa = typedSrc.WDPa;
        typedDst.WDkelvins = typedSrc.WDkelvins;
        typedDst.WWPa = typedSrc.WWPa;
        typedDst.WPAvapor = typedSrc.WPAvapor;

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
        strBuffer.append("WDPa: ").append(WDPa).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WDkelvins: ").append(WDkelvins).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WWPa: ").append(WWPa).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPAvapor: ").append(WPAvapor).append("\n");  

        return strBuffer.toString();
    }

}
