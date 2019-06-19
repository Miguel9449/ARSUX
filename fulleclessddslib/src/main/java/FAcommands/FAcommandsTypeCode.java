package FAcommands;
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

public class  FAcommandsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[25];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("rank", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,2 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv02_Enable_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv02_Direction_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("AR_Fn01_Speed_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("AR_Ht09_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("AR_VMVv01_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("AR_Fn02_Speed_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("AR_Pp01_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv03_Enable_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv03_Direction_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,11 , false);__i++;
        sm[__i]=new  StructMember("AR_Ht0102_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,12 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv04_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,13 , false);__i++;
        sm[__i]=new  StructMember("AR_Ht0304_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,14 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv05_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,15 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv06_Enable_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,16 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv06_Direction_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,17 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv07_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,18 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv08_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,19 , false);__i++;
        sm[__i]=new  StructMember("AR_Ht0506_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,20 , false);__i++;
        sm[__i]=new  StructMember("AR_Ht0708_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,21 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv09_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,22 , false);__i++;
        sm[__i]=new  StructMember("AR_CMP_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,23 , false);__i++;
        sm[__i]=new  StructMember("AR_Vv10_CMD", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,24 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("FAcommands", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

