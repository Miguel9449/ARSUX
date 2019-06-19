package WPcommands;
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

public class  WPcommandsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[15];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("rank", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,2 , false);__i++;
        sm[__i]=new  StructMember("WPSV01211", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("WPPM4111", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("WPSM4121", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("WPPP4117", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("WPSV01212", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("WPSV11211", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("WPSV0133", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("WPSV11212", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("WPSV0122", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,11 , false);__i++;
        sm[__i]=new  StructMember("WPSV11213", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,12 , false);__i++;
        sm[__i]=new  StructMember("WPSV1101", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,13 , false);__i++;
        sm[__i]=new  StructMember("WPSV11261", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,14 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("WPcommands", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

