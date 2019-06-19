package OGsensors;
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

public class  OGsensorsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[22];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("OGP73211", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,2 , false);__i++;
        sm[__i]=new  StructMember("OGP73212", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("OGT75411", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("OGT75412", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("OGDP7131", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("OGN80011", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("OGF75311", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("OGF75313", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("OGP7111", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("OGRSAquantity", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,11 , false);__i++;
        sm[__i]=new  StructMember("OGG82421", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,12 , false);__i++;
        sm[__i]=new  StructMember("OGCS71912", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,13 , false);__i++;
        sm[__i]=new  StructMember("OGN80012", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,14 , false);__i++;
        sm[__i]=new  StructMember("OGP7312", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,15 , false);__i++;
        sm[__i]=new  StructMember("OGP73113", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,16 , false);__i++;
        sm[__i]=new  StructMember("OGP71211", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,17 , false);__i++;
        sm[__i]=new  StructMember("OGP71212", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,18 , false);__i++;
        sm[__i]=new  StructMember("OGT72411", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,19 , false);__i++;
        sm[__i]=new  StructMember("OGT72412", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,20 , false);__i++;
        sm[__i]=new  StructMember("fault", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,21 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("OGsensors", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

