package FAsensors;
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

import com.rti.dds.typecode.ExtensibilityKind;
import com.rti.dds.typecode.StructMember;
import com.rti.dds.typecode.TypeCode;
import com.rti.dds.typecode.TypeCodeFactory;

public class  FAsensorsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[68];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("AR_TS01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,2 , false);__i++;
        sm[__i]=new  StructMember("AR_TS02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("AR_TS03_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("AR_TS04_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("AR_TS05_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("AR_TS06_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("AR_TS07_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("AR_TS08_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("AR_TS09_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("AR_TS10_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,11 , false);__i++;
        sm[__i]=new  StructMember("AR_TS12_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,12 , false);__i++;
        sm[__i]=new  StructMember("AR_TS15_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,13 , false);__i++;
        sm[__i]=new  StructMember("AR_TS16_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,14 , false);__i++;
        sm[__i]=new  StructMember("AR_TS18_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,15 , false);__i++;
        sm[__i]=new  StructMember("AR_TS19_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,16 , false);__i++;
        sm[__i]=new  StructMember("AR_TS20_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,17 , false);__i++;
        sm[__i]=new  StructMember("AR_TS21_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,18 , false);__i++;
        sm[__i]=new  StructMember("AR_TC5_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,19 , false);__i++;
        sm[__i]=new  StructMember("AR_TC4_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,20 , false);__i++;
        sm[__i]=new  StructMember("AR_TC3_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,21 , false);__i++;
        sm[__i]=new  StructMember("AR_TC2_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,22 , false);__i++;
        sm[__i]=new  StructMember("AR_TS39_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,23 , false);__i++;
        sm[__i]=new  StructMember("AR_TS40_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,24 , false);__i++;
        sm[__i]=new  StructMember("AR_TS_Fn01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,25 , false);__i++;
        sm[__i]=new  StructMember("AR_TS_Fn02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,26 , false);__i++;
        sm[__i]=new  StructMember("AR_PS01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,27 , false);__i++;
        sm[__i]=new  StructMember("AR_PS02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,28 , false);__i++;
        sm[__i]=new  StructMember("AR_DP_Fn01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,29 , false);__i++;
        sm[__i]=new  StructMember("AR_IS_Fn01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,30 , false);__i++;
        sm[__i]=new  StructMember("AR_NS_Fn01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,31 , false);__i++;
        sm[__i]=new  StructMember("AR_DP_Fn02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,32 , false);__i++;
        sm[__i]=new  StructMember("AR_IS_Fn02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,33 , false);__i++;
        sm[__i]=new  StructMember("AR_NS_Fn02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,34 , false);__i++;
        sm[__i]=new  StructMember("AR_CO01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,35 , false);__i++;
        sm[__i]=new  StructMember("AR_PI02_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,36 , false);__i++;
        sm[__i]=new  StructMember("AR_PI03_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,37 , false);__i++;
        sm[__i]=new  StructMember("AR_IS_Pp01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,38 , false);__i++;
        sm[__i]=new  StructMember("AR_F_Vv01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,39 , false);__i++;
        sm[__i]=new  StructMember("AR_DP_01_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,40 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01N2Pa_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,41 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01O2Pa_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,42 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01H2OPa_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,43 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01ArPa_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,44 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01CO2Pa_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,45 , false);__i++;
        sm[__i]=new  StructMember("AR_Sn01CH4_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,46 , false);__i++;
        sm[__i]=new  StructMember("AR_TC1_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,47 , false);__i++;
        sm[__i]=new  StructMember("AR_TC7_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,48 , false);__i++;
        sm[__i]=new  StructMember("AR_TC6_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,49 , false);__i++;
        sm[__i]=new  StructMember("AR_PI06_TP", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,50 , false);__i++;
        sm[__i]=new  StructMember("AR_TS47", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,51 , false);__i++;
        sm[__i]=new  StructMember("AR_TS48", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,52 , false);__i++;
        sm[__i]=new  StructMember("AR_TS49", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,53 , false);__i++;
        sm[__i]=new  StructMember("AR_TS50", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,54 , false);__i++;
        sm[__i]=new  StructMember("AR_TS52", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,55 , false);__i++;
        sm[__i]=new  StructMember("AR_TS55", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,56 , false);__i++;
        sm[__i]=new  StructMember("AR_TS56", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,57 , false);__i++;
        sm[__i]=new  StructMember("AR_TS58", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,58 , false);__i++;
        sm[__i]=new  StructMember("AR_PS03", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,59 , false);__i++;
        sm[__i]=new  StructMember("AR_PS04", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,60 , false);__i++;
        sm[__i]=new  StructMember("AR_PS70", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,61 , false);__i++;
        sm[__i]=new  StructMember("AR_TS70", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,62 , false);__i++;
        sm[__i]=new  StructMember("AR_PS71", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,63 , false);__i++;
        sm[__i]=new  StructMember("AR_TS71", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,64 , false);__i++;
        sm[__i]=new  StructMember("AR_PS72", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,65 , false);__i++;
        sm[__i]=new  StructMember("AR_FM72", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,66 , false);__i++;
        sm[__i]=new  StructMember("fault", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,67 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("FAsensors", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

