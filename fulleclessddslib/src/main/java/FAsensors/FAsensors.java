package FAsensors;

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

public class FAsensors   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public double AR_TS01_TP= 0;
    public double AR_TS02_TP= 0;
    public double AR_TS03_TP= 0;
    public double AR_TS04_TP= 0;
    public double AR_TS05_TP= 0;
    public double AR_TS06_TP= 0;
    public double AR_TS07_TP= 0;
    public double AR_TS08_TP= 0;
    public double AR_TS09_TP= 0;
    public double AR_TS10_TP= 0;
    public double AR_TS12_TP= 0;
    public double AR_TS15_TP= 0;
    public double AR_TS16_TP= 0;
    public double AR_TS18_TP= 0;
    public double AR_TS19_TP= 0;
    public double AR_TS20_TP= 0;
    public double AR_TS21_TP= 0;
    public double AR_TC5_TP= 0;
    public double AR_TC4_TP= 0;
    public double AR_TC3_TP= 0;
    public double AR_TC2_TP= 0;
    public double AR_TS39_TP= 0;
    public double AR_TS40_TP= 0;
    public double AR_TS_Fn01_TP= 0;
    public double AR_TS_Fn02_TP= 0;
    public double AR_PS01_TP= 0;
    public double AR_PS02_TP= 0;
    public double AR_DP_Fn01_TP= 0;
    public double AR_IS_Fn01_TP= 0;
    public double AR_NS_Fn01_TP= 0;
    public double AR_DP_Fn02_TP= 0;
    public double AR_IS_Fn02_TP= 0;
    public double AR_NS_Fn02_TP= 0;
    public double AR_CO01_TP= 0;
    public double AR_PI02_TP= 0;
    public double AR_PI03_TP= 0;
    public double AR_IS_Pp01_TP= 0;
    public double AR_F_Vv01_TP= 0;
    public double AR_DP_01_TP= 0;
    public double AR_Sn01N2Pa_TP= 0;
    public double AR_Sn01O2Pa_TP= 0;
    public double AR_Sn01H2OPa_TP= 0;
    public double AR_Sn01ArPa_TP= 0;
    public double AR_Sn01CO2Pa_TP= 0;
    public double AR_Sn01CH4_TP= 0;
    public double AR_TC1_TP= 0;
    public double AR_TC7_TP= 0;
    public double AR_TC6_TP= 0;
    public double AR_PI06_TP= 0;
    public double AR_TS47= 0;
    public double AR_TS48= 0;
    public double AR_TS49= 0;
    public double AR_TS50= 0;
    public double AR_TS52= 0;
    public double AR_TS55= 0;
    public double AR_TS56= 0;
    public double AR_TS58= 0;
    public double AR_PS03= 0;
    public double AR_PS04= 0;
    public double AR_PS70= 0;
    public double AR_TS70= 0;
    public double AR_PS71= 0;
    public double AR_TS71= 0;
    public double AR_PS72= 0;
    public double AR_FM72= 0;
    public int fault= 0;

    public FAsensors() {

    }
    public FAsensors (FAsensors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        FAsensors self;
        self = new FAsensors();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        AR_TS01_TP= 0;
        AR_TS02_TP= 0;
        AR_TS03_TP= 0;
        AR_TS04_TP= 0;
        AR_TS05_TP= 0;
        AR_TS06_TP= 0;
        AR_TS07_TP= 0;
        AR_TS08_TP= 0;
        AR_TS09_TP= 0;
        AR_TS10_TP= 0;
        AR_TS12_TP= 0;
        AR_TS15_TP= 0;
        AR_TS16_TP= 0;
        AR_TS18_TP= 0;
        AR_TS19_TP= 0;
        AR_TS20_TP= 0;
        AR_TS21_TP= 0;
        AR_TC5_TP= 0;
        AR_TC4_TP= 0;
        AR_TC3_TP= 0;
        AR_TC2_TP= 0;
        AR_TS39_TP= 0;
        AR_TS40_TP= 0;
        AR_TS_Fn01_TP= 0;
        AR_TS_Fn02_TP= 0;
        AR_PS01_TP= 0;
        AR_PS02_TP= 0;
        AR_DP_Fn01_TP= 0;
        AR_IS_Fn01_TP= 0;
        AR_NS_Fn01_TP= 0;
        AR_DP_Fn02_TP= 0;
        AR_IS_Fn02_TP= 0;
        AR_NS_Fn02_TP= 0;
        AR_CO01_TP= 0;
        AR_PI02_TP= 0;
        AR_PI03_TP= 0;
        AR_IS_Pp01_TP= 0;
        AR_F_Vv01_TP= 0;
        AR_DP_01_TP= 0;
        AR_Sn01N2Pa_TP= 0;
        AR_Sn01O2Pa_TP= 0;
        AR_Sn01H2OPa_TP= 0;
        AR_Sn01ArPa_TP= 0;
        AR_Sn01CO2Pa_TP= 0;
        AR_Sn01CH4_TP= 0;
        AR_TC1_TP= 0;
        AR_TC7_TP= 0;
        AR_TC6_TP= 0;
        AR_PI06_TP= 0;
        AR_TS47= 0;
        AR_TS48= 0;
        AR_TS49= 0;
        AR_TS50= 0;
        AR_TS52= 0;
        AR_TS55= 0;
        AR_TS56= 0;
        AR_TS58= 0;
        AR_PS03= 0;
        AR_PS04= 0;
        AR_PS70= 0;
        AR_TS70= 0;
        AR_PS71= 0;
        AR_TS71= 0;
        AR_PS72= 0;
        AR_FM72= 0;
        fault= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        FAsensors otherObj = (FAsensors)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(AR_TS01_TP != otherObj.AR_TS01_TP) {
            return false;
        }
        if(AR_TS02_TP != otherObj.AR_TS02_TP) {
            return false;
        }
        if(AR_TS03_TP != otherObj.AR_TS03_TP) {
            return false;
        }
        if(AR_TS04_TP != otherObj.AR_TS04_TP) {
            return false;
        }
        if(AR_TS05_TP != otherObj.AR_TS05_TP) {
            return false;
        }
        if(AR_TS06_TP != otherObj.AR_TS06_TP) {
            return false;
        }
        if(AR_TS07_TP != otherObj.AR_TS07_TP) {
            return false;
        }
        if(AR_TS08_TP != otherObj.AR_TS08_TP) {
            return false;
        }
        if(AR_TS09_TP != otherObj.AR_TS09_TP) {
            return false;
        }
        if(AR_TS10_TP != otherObj.AR_TS10_TP) {
            return false;
        }
        if(AR_TS12_TP != otherObj.AR_TS12_TP) {
            return false;
        }
        if(AR_TS15_TP != otherObj.AR_TS15_TP) {
            return false;
        }
        if(AR_TS16_TP != otherObj.AR_TS16_TP) {
            return false;
        }
        if(AR_TS18_TP != otherObj.AR_TS18_TP) {
            return false;
        }
        if(AR_TS19_TP != otherObj.AR_TS19_TP) {
            return false;
        }
        if(AR_TS20_TP != otherObj.AR_TS20_TP) {
            return false;
        }
        if(AR_TS21_TP != otherObj.AR_TS21_TP) {
            return false;
        }
        if(AR_TC5_TP != otherObj.AR_TC5_TP) {
            return false;
        }
        if(AR_TC4_TP != otherObj.AR_TC4_TP) {
            return false;
        }
        if(AR_TC3_TP != otherObj.AR_TC3_TP) {
            return false;
        }
        if(AR_TC2_TP != otherObj.AR_TC2_TP) {
            return false;
        }
        if(AR_TS39_TP != otherObj.AR_TS39_TP) {
            return false;
        }
        if(AR_TS40_TP != otherObj.AR_TS40_TP) {
            return false;
        }
        if(AR_TS_Fn01_TP != otherObj.AR_TS_Fn01_TP) {
            return false;
        }
        if(AR_TS_Fn02_TP != otherObj.AR_TS_Fn02_TP) {
            return false;
        }
        if(AR_PS01_TP != otherObj.AR_PS01_TP) {
            return false;
        }
        if(AR_PS02_TP != otherObj.AR_PS02_TP) {
            return false;
        }
        if(AR_DP_Fn01_TP != otherObj.AR_DP_Fn01_TP) {
            return false;
        }
        if(AR_IS_Fn01_TP != otherObj.AR_IS_Fn01_TP) {
            return false;
        }
        if(AR_NS_Fn01_TP != otherObj.AR_NS_Fn01_TP) {
            return false;
        }
        if(AR_DP_Fn02_TP != otherObj.AR_DP_Fn02_TP) {
            return false;
        }
        if(AR_IS_Fn02_TP != otherObj.AR_IS_Fn02_TP) {
            return false;
        }
        if(AR_NS_Fn02_TP != otherObj.AR_NS_Fn02_TP) {
            return false;
        }
        if(AR_CO01_TP != otherObj.AR_CO01_TP) {
            return false;
        }
        if(AR_PI02_TP != otherObj.AR_PI02_TP) {
            return false;
        }
        if(AR_PI03_TP != otherObj.AR_PI03_TP) {
            return false;
        }
        if(AR_IS_Pp01_TP != otherObj.AR_IS_Pp01_TP) {
            return false;
        }
        if(AR_F_Vv01_TP != otherObj.AR_F_Vv01_TP) {
            return false;
        }
        if(AR_DP_01_TP != otherObj.AR_DP_01_TP) {
            return false;
        }
        if(AR_Sn01N2Pa_TP != otherObj.AR_Sn01N2Pa_TP) {
            return false;
        }
        if(AR_Sn01O2Pa_TP != otherObj.AR_Sn01O2Pa_TP) {
            return false;
        }
        if(AR_Sn01H2OPa_TP != otherObj.AR_Sn01H2OPa_TP) {
            return false;
        }
        if(AR_Sn01ArPa_TP != otherObj.AR_Sn01ArPa_TP) {
            return false;
        }
        if(AR_Sn01CO2Pa_TP != otherObj.AR_Sn01CO2Pa_TP) {
            return false;
        }
        if(AR_Sn01CH4_TP != otherObj.AR_Sn01CH4_TP) {
            return false;
        }
        if(AR_TC1_TP != otherObj.AR_TC1_TP) {
            return false;
        }
        if(AR_TC7_TP != otherObj.AR_TC7_TP) {
            return false;
        }
        if(AR_TC6_TP != otherObj.AR_TC6_TP) {
            return false;
        }
        if(AR_PI06_TP != otherObj.AR_PI06_TP) {
            return false;
        }
        if(AR_TS47 != otherObj.AR_TS47) {
            return false;
        }
        if(AR_TS48 != otherObj.AR_TS48) {
            return false;
        }
        if(AR_TS49 != otherObj.AR_TS49) {
            return false;
        }
        if(AR_TS50 != otherObj.AR_TS50) {
            return false;
        }
        if(AR_TS52 != otherObj.AR_TS52) {
            return false;
        }
        if(AR_TS55 != otherObj.AR_TS55) {
            return false;
        }
        if(AR_TS56 != otherObj.AR_TS56) {
            return false;
        }
        if(AR_TS58 != otherObj.AR_TS58) {
            return false;
        }
        if(AR_PS03 != otherObj.AR_PS03) {
            return false;
        }
        if(AR_PS04 != otherObj.AR_PS04) {
            return false;
        }
        if(AR_PS70 != otherObj.AR_PS70) {
            return false;
        }
        if(AR_TS70 != otherObj.AR_TS70) {
            return false;
        }
        if(AR_PS71 != otherObj.AR_PS71) {
            return false;
        }
        if(AR_TS71 != otherObj.AR_TS71) {
            return false;
        }
        if(AR_PS72 != otherObj.AR_PS72) {
            return false;
        }
        if(AR_FM72 != otherObj.AR_FM72) {
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
        __result += (int)AR_TS01_TP;
        __result += (int)AR_TS02_TP;
        __result += (int)AR_TS03_TP;
        __result += (int)AR_TS04_TP;
        __result += (int)AR_TS05_TP;
        __result += (int)AR_TS06_TP;
        __result += (int)AR_TS07_TP;
        __result += (int)AR_TS08_TP;
        __result += (int)AR_TS09_TP;
        __result += (int)AR_TS10_TP;
        __result += (int)AR_TS12_TP;
        __result += (int)AR_TS15_TP;
        __result += (int)AR_TS16_TP;
        __result += (int)AR_TS18_TP;
        __result += (int)AR_TS19_TP;
        __result += (int)AR_TS20_TP;
        __result += (int)AR_TS21_TP;
        __result += (int)AR_TC5_TP;
        __result += (int)AR_TC4_TP;
        __result += (int)AR_TC3_TP;
        __result += (int)AR_TC2_TP;
        __result += (int)AR_TS39_TP;
        __result += (int)AR_TS40_TP;
        __result += (int)AR_TS_Fn01_TP;
        __result += (int)AR_TS_Fn02_TP;
        __result += (int)AR_PS01_TP;
        __result += (int)AR_PS02_TP;
        __result += (int)AR_DP_Fn01_TP;
        __result += (int)AR_IS_Fn01_TP;
        __result += (int)AR_NS_Fn01_TP;
        __result += (int)AR_DP_Fn02_TP;
        __result += (int)AR_IS_Fn02_TP;
        __result += (int)AR_NS_Fn02_TP;
        __result += (int)AR_CO01_TP;
        __result += (int)AR_PI02_TP;
        __result += (int)AR_PI03_TP;
        __result += (int)AR_IS_Pp01_TP;
        __result += (int)AR_F_Vv01_TP;
        __result += (int)AR_DP_01_TP;
        __result += (int)AR_Sn01N2Pa_TP;
        __result += (int)AR_Sn01O2Pa_TP;
        __result += (int)AR_Sn01H2OPa_TP;
        __result += (int)AR_Sn01ArPa_TP;
        __result += (int)AR_Sn01CO2Pa_TP;
        __result += (int)AR_Sn01CH4_TP;
        __result += (int)AR_TC1_TP;
        __result += (int)AR_TC7_TP;
        __result += (int)AR_TC6_TP;
        __result += (int)AR_PI06_TP;
        __result += (int)AR_TS47;
        __result += (int)AR_TS48;
        __result += (int)AR_TS49;
        __result += (int)AR_TS50;
        __result += (int)AR_TS52;
        __result += (int)AR_TS55;
        __result += (int)AR_TS56;
        __result += (int)AR_TS58;
        __result += (int)AR_PS03;
        __result += (int)AR_PS04;
        __result += (int)AR_PS70;
        __result += (int)AR_TS70;
        __result += (int)AR_PS71;
        __result += (int)AR_TS71;
        __result += (int)AR_PS72;
        __result += (int)AR_FM72;
        __result += (int)fault;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>FAsensorsTypeSupport</code>
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

        FAsensors typedSrc = (FAsensors) src;
        FAsensors typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.AR_TS01_TP = typedSrc.AR_TS01_TP;
        typedDst.AR_TS02_TP = typedSrc.AR_TS02_TP;
        typedDst.AR_TS03_TP = typedSrc.AR_TS03_TP;
        typedDst.AR_TS04_TP = typedSrc.AR_TS04_TP;
        typedDst.AR_TS05_TP = typedSrc.AR_TS05_TP;
        typedDst.AR_TS06_TP = typedSrc.AR_TS06_TP;
        typedDst.AR_TS07_TP = typedSrc.AR_TS07_TP;
        typedDst.AR_TS08_TP = typedSrc.AR_TS08_TP;
        typedDst.AR_TS09_TP = typedSrc.AR_TS09_TP;
        typedDst.AR_TS10_TP = typedSrc.AR_TS10_TP;
        typedDst.AR_TS12_TP = typedSrc.AR_TS12_TP;
        typedDst.AR_TS15_TP = typedSrc.AR_TS15_TP;
        typedDst.AR_TS16_TP = typedSrc.AR_TS16_TP;
        typedDst.AR_TS18_TP = typedSrc.AR_TS18_TP;
        typedDst.AR_TS19_TP = typedSrc.AR_TS19_TP;
        typedDst.AR_TS20_TP = typedSrc.AR_TS20_TP;
        typedDst.AR_TS21_TP = typedSrc.AR_TS21_TP;
        typedDst.AR_TC5_TP = typedSrc.AR_TC5_TP;
        typedDst.AR_TC4_TP = typedSrc.AR_TC4_TP;
        typedDst.AR_TC3_TP = typedSrc.AR_TC3_TP;
        typedDst.AR_TC2_TP = typedSrc.AR_TC2_TP;
        typedDst.AR_TS39_TP = typedSrc.AR_TS39_TP;
        typedDst.AR_TS40_TP = typedSrc.AR_TS40_TP;
        typedDst.AR_TS_Fn01_TP = typedSrc.AR_TS_Fn01_TP;
        typedDst.AR_TS_Fn02_TP = typedSrc.AR_TS_Fn02_TP;
        typedDst.AR_PS01_TP = typedSrc.AR_PS01_TP;
        typedDst.AR_PS02_TP = typedSrc.AR_PS02_TP;
        typedDst.AR_DP_Fn01_TP = typedSrc.AR_DP_Fn01_TP;
        typedDst.AR_IS_Fn01_TP = typedSrc.AR_IS_Fn01_TP;
        typedDst.AR_NS_Fn01_TP = typedSrc.AR_NS_Fn01_TP;
        typedDst.AR_DP_Fn02_TP = typedSrc.AR_DP_Fn02_TP;
        typedDst.AR_IS_Fn02_TP = typedSrc.AR_IS_Fn02_TP;
        typedDst.AR_NS_Fn02_TP = typedSrc.AR_NS_Fn02_TP;
        typedDst.AR_CO01_TP = typedSrc.AR_CO01_TP;
        typedDst.AR_PI02_TP = typedSrc.AR_PI02_TP;
        typedDst.AR_PI03_TP = typedSrc.AR_PI03_TP;
        typedDst.AR_IS_Pp01_TP = typedSrc.AR_IS_Pp01_TP;
        typedDst.AR_F_Vv01_TP = typedSrc.AR_F_Vv01_TP;
        typedDst.AR_DP_01_TP = typedSrc.AR_DP_01_TP;
        typedDst.AR_Sn01N2Pa_TP = typedSrc.AR_Sn01N2Pa_TP;
        typedDst.AR_Sn01O2Pa_TP = typedSrc.AR_Sn01O2Pa_TP;
        typedDst.AR_Sn01H2OPa_TP = typedSrc.AR_Sn01H2OPa_TP;
        typedDst.AR_Sn01ArPa_TP = typedSrc.AR_Sn01ArPa_TP;
        typedDst.AR_Sn01CO2Pa_TP = typedSrc.AR_Sn01CO2Pa_TP;
        typedDst.AR_Sn01CH4_TP = typedSrc.AR_Sn01CH4_TP;
        typedDst.AR_TC1_TP = typedSrc.AR_TC1_TP;
        typedDst.AR_TC7_TP = typedSrc.AR_TC7_TP;
        typedDst.AR_TC6_TP = typedSrc.AR_TC6_TP;
        typedDst.AR_PI06_TP = typedSrc.AR_PI06_TP;
        typedDst.AR_TS47 = typedSrc.AR_TS47;
        typedDst.AR_TS48 = typedSrc.AR_TS48;
        typedDst.AR_TS49 = typedSrc.AR_TS49;
        typedDst.AR_TS50 = typedSrc.AR_TS50;
        typedDst.AR_TS52 = typedSrc.AR_TS52;
        typedDst.AR_TS55 = typedSrc.AR_TS55;
        typedDst.AR_TS56 = typedSrc.AR_TS56;
        typedDst.AR_TS58 = typedSrc.AR_TS58;
        typedDst.AR_PS03 = typedSrc.AR_PS03;
        typedDst.AR_PS04 = typedSrc.AR_PS04;
        typedDst.AR_PS70 = typedSrc.AR_PS70;
        typedDst.AR_TS70 = typedSrc.AR_TS70;
        typedDst.AR_PS71 = typedSrc.AR_PS71;
        typedDst.AR_TS71 = typedSrc.AR_TS71;
        typedDst.AR_PS72 = typedSrc.AR_PS72;
        typedDst.AR_FM72 = typedSrc.AR_FM72;
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
        strBuffer.append("AR_TS01_TP: ").append(AR_TS01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS02_TP: ").append(AR_TS02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS03_TP: ").append(AR_TS03_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS04_TP: ").append(AR_TS04_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS05_TP: ").append(AR_TS05_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS06_TP: ").append(AR_TS06_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS07_TP: ").append(AR_TS07_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS08_TP: ").append(AR_TS08_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS09_TP: ").append(AR_TS09_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS10_TP: ").append(AR_TS10_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS12_TP: ").append(AR_TS12_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS15_TP: ").append(AR_TS15_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS16_TP: ").append(AR_TS16_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS18_TP: ").append(AR_TS18_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS19_TP: ").append(AR_TS19_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS20_TP: ").append(AR_TS20_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS21_TP: ").append(AR_TS21_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC5_TP: ").append(AR_TC5_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC4_TP: ").append(AR_TC4_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC3_TP: ").append(AR_TC3_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC2_TP: ").append(AR_TC2_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS39_TP: ").append(AR_TS39_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS40_TP: ").append(AR_TS40_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS_Fn01_TP: ").append(AR_TS_Fn01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS_Fn02_TP: ").append(AR_TS_Fn02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS01_TP: ").append(AR_PS01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS02_TP: ").append(AR_PS02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_DP_Fn01_TP: ").append(AR_DP_Fn01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_IS_Fn01_TP: ").append(AR_IS_Fn01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_NS_Fn01_TP: ").append(AR_NS_Fn01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_DP_Fn02_TP: ").append(AR_DP_Fn02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_IS_Fn02_TP: ").append(AR_IS_Fn02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_NS_Fn02_TP: ").append(AR_NS_Fn02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_CO01_TP: ").append(AR_CO01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PI02_TP: ").append(AR_PI02_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PI03_TP: ").append(AR_PI03_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_IS_Pp01_TP: ").append(AR_IS_Pp01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_F_Vv01_TP: ").append(AR_F_Vv01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_DP_01_TP: ").append(AR_DP_01_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01N2Pa_TP: ").append(AR_Sn01N2Pa_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01O2Pa_TP: ").append(AR_Sn01O2Pa_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01H2OPa_TP: ").append(AR_Sn01H2OPa_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01ArPa_TP: ").append(AR_Sn01ArPa_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01CO2Pa_TP: ").append(AR_Sn01CO2Pa_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_Sn01CH4_TP: ").append(AR_Sn01CH4_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC1_TP: ").append(AR_TC1_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC7_TP: ").append(AR_TC7_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TC6_TP: ").append(AR_TC6_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PI06_TP: ").append(AR_PI06_TP).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS47: ").append(AR_TS47).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS48: ").append(AR_TS48).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS49: ").append(AR_TS49).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS50: ").append(AR_TS50).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS52: ").append(AR_TS52).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS55: ").append(AR_TS55).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS56: ").append(AR_TS56).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS58: ").append(AR_TS58).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS03: ").append(AR_PS03).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS04: ").append(AR_PS04).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS70: ").append(AR_PS70).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS70: ").append(AR_TS70).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS71: ").append(AR_PS71).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_TS71: ").append(AR_TS71).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_PS72: ").append(AR_PS72).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("AR_FM72: ").append(AR_FM72).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("fault: ").append(fault).append("\n");  

        return strBuffer.toString();
    }

}
