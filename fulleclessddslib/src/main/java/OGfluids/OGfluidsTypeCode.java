package OGfluids;
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

public class  OGfluidsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[12];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("WD2OGkgs", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,1 , false);__i++;
        sm[__i]=new  StructMember("OG2WWkgs", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,2 , false);__i++;
        sm[__i]=new  StructMember("OG2WWkelvins", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,3 , false);__i++;
        sm[__i]=new  StructMember("OGO2kgs", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,4 , false);__i++;
        sm[__i]=new  StructMember("OGO2molpers", false, (short)-1,  false,(TypeCode) new TypeCode(new int[] {4}, TypeCode.TC_DOUBLE),5 , false);__i++;
        sm[__i]=new  StructMember("OGO2kelvins", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;
        sm[__i]=new  StructMember("FA2SAkgs", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,7 , false);__i++;
        sm[__i]=new  StructMember("OG2HabHeatW", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,8 , false);__i++;
        sm[__i]=new  StructMember("OGH2kelvins", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,9 , false);__i++;
        sm[__i]=new  StructMember("SA2WWkgs", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,10 , false);__i++;
        sm[__i]=new  StructMember("SA2WWkelvins", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,11 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("OGfluids", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

