package WPsensors;

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

public class WPsensors   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double WPQ71831= 0;
    public double WPQ71832= 0;
    public double WPQ71833= 0;
    public double WPQ71834= 0;
    public double WPPG71171= 0;
    public double WPPG71172= 0;
    public double WPC71912= 0;
    public double WPC71943= 0;
    public double WPG81481= 0;
    public boolean WPLLLS= false;
    public boolean WPLLS= false;
    public boolean WPHLS= false;
    public boolean WPHHLS= false;
    public boolean WPN8005= false;
    public boolean WPN8004= false;
    public double WPT71441= 0;
    public double WPT71442= 0;
    public double WPT70475= 0;
    public double WPT70476= 0;
    public double WPN8008= 0;
    public double WPPG71131= 0;
    public double WPT70471= 0;
    public double WPPG71124= 0;
    public double kgMakeup= 0;
    public int fault= 0;

    public WPsensors() {

    }
    public WPsensors (WPsensors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WPsensors self;
        self = new WPsensors();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        WPQ71831= 0;
        WPQ71832= 0;
        WPQ71833= 0;
        WPQ71834= 0;
        WPPG71171= 0;
        WPPG71172= 0;
        WPC71912= 0;
        WPC71943= 0;
        WPG81481= 0;
        WPLLLS= false;
        WPLLS= false;
        WPHLS= false;
        WPHHLS= false;
        WPN8005= false;
        WPN8004= false;
        WPT71441= 0;
        WPT71442= 0;
        WPT70475= 0;
        WPT70476= 0;
        WPN8008= 0;
        WPPG71131= 0;
        WPT70471= 0;
        WPPG71124= 0;
        kgMakeup= 0;
        fault= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WPsensors otherObj = (WPsensors)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(WPQ71831 != otherObj.WPQ71831) {
            return false;
        }
        if(WPQ71832 != otherObj.WPQ71832) {
            return false;
        }
        if(WPQ71833 != otherObj.WPQ71833) {
            return false;
        }
        if(WPQ71834 != otherObj.WPQ71834) {
            return false;
        }
        if(WPPG71171 != otherObj.WPPG71171) {
            return false;
        }
        if(WPPG71172 != otherObj.WPPG71172) {
            return false;
        }
        if(WPC71912 != otherObj.WPC71912) {
            return false;
        }
        if(WPC71943 != otherObj.WPC71943) {
            return false;
        }
        if(WPG81481 != otherObj.WPG81481) {
            return false;
        }
        if(WPLLLS != otherObj.WPLLLS) {
            return false;
        }
        if(WPLLS != otherObj.WPLLS) {
            return false;
        }
        if(WPHLS != otherObj.WPHLS) {
            return false;
        }
        if(WPHHLS != otherObj.WPHHLS) {
            return false;
        }
        if(WPN8005 != otherObj.WPN8005) {
            return false;
        }
        if(WPN8004 != otherObj.WPN8004) {
            return false;
        }
        if(WPT71441 != otherObj.WPT71441) {
            return false;
        }
        if(WPT71442 != otherObj.WPT71442) {
            return false;
        }
        if(WPT70475 != otherObj.WPT70475) {
            return false;
        }
        if(WPT70476 != otherObj.WPT70476) {
            return false;
        }
        if(WPN8008 != otherObj.WPN8008) {
            return false;
        }
        if(WPPG71131 != otherObj.WPPG71131) {
            return false;
        }
        if(WPT70471 != otherObj.WPT70471) {
            return false;
        }
        if(WPPG71124 != otherObj.WPPG71124) {
            return false;
        }
        if(kgMakeup != otherObj.kgMakeup) {
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
        __result += (int)WPQ71831;
        __result += (int)WPQ71832;
        __result += (int)WPQ71833;
        __result += (int)WPQ71834;
        __result += (int)WPPG71171;
        __result += (int)WPPG71172;
        __result += (int)WPC71912;
        __result += (int)WPC71943;
        __result += (int)WPG81481;
        __result += (WPLLLS == true)?1:0;
        __result += (WPLLS == true)?1:0;
        __result += (WPHLS == true)?1:0;
        __result += (WPHHLS == true)?1:0;
        __result += (WPN8005 == true)?1:0;
        __result += (WPN8004 == true)?1:0;
        __result += (int)WPT71441;
        __result += (int)WPT71442;
        __result += (int)WPT70475;
        __result += (int)WPT70476;
        __result += (int)WPN8008;
        __result += (int)WPPG71131;
        __result += (int)WPT70471;
        __result += (int)WPPG71124;
        __result += (int)kgMakeup;
        __result += (int)fault;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WPsensorsTypeSupport</code>
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

        WPsensors typedSrc = (WPsensors) src;
        WPsensors typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.WPQ71831 = typedSrc.WPQ71831;
        typedDst.WPQ71832 = typedSrc.WPQ71832;
        typedDst.WPQ71833 = typedSrc.WPQ71833;
        typedDst.WPQ71834 = typedSrc.WPQ71834;
        typedDst.WPPG71171 = typedSrc.WPPG71171;
        typedDst.WPPG71172 = typedSrc.WPPG71172;
        typedDst.WPC71912 = typedSrc.WPC71912;
        typedDst.WPC71943 = typedSrc.WPC71943;
        typedDst.WPG81481 = typedSrc.WPG81481;
        typedDst.WPLLLS = typedSrc.WPLLLS;
        typedDst.WPLLS = typedSrc.WPLLS;
        typedDst.WPHLS = typedSrc.WPHLS;
        typedDst.WPHHLS = typedSrc.WPHHLS;
        typedDst.WPN8005 = typedSrc.WPN8005;
        typedDst.WPN8004 = typedSrc.WPN8004;
        typedDst.WPT71441 = typedSrc.WPT71441;
        typedDst.WPT71442 = typedSrc.WPT71442;
        typedDst.WPT70475 = typedSrc.WPT70475;
        typedDst.WPT70476 = typedSrc.WPT70476;
        typedDst.WPN8008 = typedSrc.WPN8008;
        typedDst.WPPG71131 = typedSrc.WPPG71131;
        typedDst.WPT70471 = typedSrc.WPT70471;
        typedDst.WPPG71124 = typedSrc.WPPG71124;
        typedDst.kgMakeup = typedSrc.kgMakeup;
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
        strBuffer.append("WPQ71831: ").append(WPQ71831).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPQ71832: ").append(WPQ71832).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPQ71833: ").append(WPQ71833).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPQ71834: ").append(WPQ71834).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPG71171: ").append(WPPG71171).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPG71172: ").append(WPPG71172).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPC71912: ").append(WPC71912).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPC71943: ").append(WPC71943).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPG81481: ").append(WPG81481).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPLLLS: ").append(WPLLLS).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPLLS: ").append(WPLLS).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPHLS: ").append(WPHLS).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPHHLS: ").append(WPHHLS).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPN8005: ").append(WPN8005).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPN8004: ").append(WPN8004).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPT71441: ").append(WPT71441).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPT71442: ").append(WPT71442).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPT70475: ").append(WPT70475).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPT70476: ").append(WPT70476).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPN8008: ").append(WPN8008).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPG71131: ").append(WPPG71131).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPT70471: ").append(WPT70471).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("WPPG71124: ").append(WPPG71124).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("kgMakeup: ").append(kgMakeup).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("fault: ").append(fault).append("\n");  

        return strBuffer.toString();
    }

}
