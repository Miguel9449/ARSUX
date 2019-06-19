package WPsensors;
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

public class  WPsensorsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[27];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("WPQ71831", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,2 , false);__i++;
        sm[__i]=new  StructMember("WPQ71832", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("WPQ71833", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("WPQ71834", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("WPPG71171", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("WPPG71172", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("WPC71912", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("WPC71943", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("WPG81481", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("WPLLLS", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,11 , false);__i++;
        sm[__i]=new  StructMember("WPLLS", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,12 , false);__i++;
        sm[__i]=new  StructMember("WPHLS", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,13 , false);__i++;
        sm[__i]=new  StructMember("WPHHLS", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,14 , false);__i++;
        sm[__i]=new  StructMember("WPN8005", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,15 , false);__i++;
        sm[__i]=new  StructMember("WPN8004", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,16 , false);__i++;
        sm[__i]=new  StructMember("WPT71441", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,17 , false);__i++;
        sm[__i]=new  StructMember("WPT71442", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,18 , false);__i++;
        sm[__i]=new  StructMember("WPT70475", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,19 , false);__i++;
        sm[__i]=new  StructMember("WPT70476", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,20 , false);__i++;
        sm[__i]=new  StructMember("WPN8008", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,21 , false);__i++;
        sm[__i]=new  StructMember("WPPG71131", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,22 , false);__i++;
        sm[__i]=new  StructMember("WPT70471", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,23 , false);__i++;
        sm[__i]=new  StructMember("WPPG71124", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,24 , false);__i++;
        sm[__i]=new  StructMember("kgMakeup", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,25 , false);__i++;
        sm[__i]=new  StructMember("fault", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,26 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("WPsensors", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

