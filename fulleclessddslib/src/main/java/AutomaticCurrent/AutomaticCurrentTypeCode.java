package AutomaticCurrent;
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

public class  AutomaticCurrentTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[2];

        sm[__i]=new  StructMember("id", false, (short)-1, true,(TypeCode) TypeCode.TC_LONG,0 , false);__i++;
        sm[__i]=new  StructMember("current", false, (short)-1,  false,(TypeCode) TypeCode.TC_DOUBLE,1 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("AutomaticCurrent", ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);
        return tc;
    }
}

