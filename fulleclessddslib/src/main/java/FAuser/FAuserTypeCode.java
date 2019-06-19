package FAuser;
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

public class  FAuserTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[7];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("state", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,1 , false);__i++;
        sm[__i]=new  StructMember("rank", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,2 , false);__i++;
        sm[__i]=new  StructMember("HEXSetTimes", false, (short)-1,  false,(TypeCode) new TypeCode(new int[] {4}, TypeCode.TC_DOUBLE),3 , false);__i++;
        sm[__i]=new  StructMember("HEXSetPoints", false, (short)-1,  false,(TypeCode) new TypeCode(new int[] {4}, TypeCode.TC_DOUBLE),4 , false);__i++;
        sm[__i]=new  StructMember("Fn01rpm", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,5 , false);__i++;
        sm[__i]=new  StructMember("HEXcontrolgain", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,6 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("FAuser", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

