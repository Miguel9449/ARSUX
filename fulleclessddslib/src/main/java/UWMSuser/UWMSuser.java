package UWMSuser;

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

public class UWMSuser   implements Copyable, Serializable{

    public int id= 0;
    public double Micturition= 0;
    public double Slug= 0;

    public UWMSuser() {

    }
    public UWMSuser (UWMSuser other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        UWMSuser self;
        self = new UWMSuser();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        Micturition= 0;
        Slug= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        UWMSuser otherObj = (UWMSuser)o;

        if(id != otherObj.id) {
            return false;
        }
        if(Micturition != otherObj.Micturition) {
            return false;
        }
        if(Slug != otherObj.Slug) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)Micturition;
        __result += (int)Slug;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>UWMSuserTypeSupport</code>
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

        UWMSuser typedSrc = (UWMSuser) src;
        UWMSuser typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.Micturition = typedSrc.Micturition;
        typedDst.Slug = typedSrc.Slug;

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
        strBuffer.append("Micturition: ").append(Micturition).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("Slug: ").append(Slug).append("\n");  

        return strBuffer.toString();
    }

}
