package FAuser;

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

public class FAuser   implements Copyable, Serializable{

    public int id= 0;
    public int state= 0;
    public int rank= 0;
    public double [] HEXSetTimes=  new double [4];
    public double [] HEXSetPoints=  new double [4];
    public double Fn01rpm= 0;
    public double HEXcontrolgain= 0;

    public FAuser() {

    }
    public FAuser (FAuser other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        FAuser self;
        self = new FAuser();
        self.clear();
        return self;

    }

    public void clear() {

        id= 0;
        state= 0;
        rank= 0;
        for(int i1__ = 0; i1__< 4; ++i1__){

            HEXSetTimes[i1__] =  0;
        }

        for(int i1__ = 0; i1__< 4; ++i1__){

            HEXSetPoints[i1__] =  0;
        }

        Fn01rpm= 0;
        HEXcontrolgain= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        FAuser otherObj = (FAuser)o;

        if(id != otherObj.id) {
            return false;
        }
        if(state != otherObj.state) {
            return false;
        }
        if(rank != otherObj.rank) {
            return false;
        }
        for(int i1__ = 0; i1__< 4; ++i1__){

            if(HEXSetTimes[i1__] != otherObj.HEXSetTimes[i1__]) {
                return false;
            }
        }

        for(int i1__ = 0; i1__< 4; ++i1__){

            if(HEXSetPoints[i1__] != otherObj.HEXSetPoints[i1__]) {
                return false;
            }
        }

        if(Fn01rpm != otherObj.Fn01rpm) {
            return false;
        }
        if(HEXcontrolgain != otherObj.HEXcontrolgain) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)id;
        __result += (int)state;
        __result += (int)rank;
        for(int i1__ = 0; i1__< 4; ++i1__){

            __result += (int)HEXSetTimes[i1__];
        }

        for(int i1__ = 0; i1__< 4; ++i1__){

            __result += (int)HEXSetPoints[i1__];
        }

        __result += (int)Fn01rpm;
        __result += (int)HEXcontrolgain;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>FAuserTypeSupport</code>
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

        FAuser typedSrc = (FAuser) src;
        FAuser typedDst = this;

        typedDst.id = typedSrc.id;
        typedDst.state = typedSrc.state;
        typedDst.rank = typedSrc.rank;
        System.arraycopy(typedSrc.HEXSetTimes,0,
        typedDst.HEXSetTimes,0,
        typedSrc.HEXSetTimes.length); 

        System.arraycopy(typedSrc.HEXSetPoints,0,
        typedDst.HEXSetPoints,0,
        typedSrc.HEXSetPoints.length); 

        typedDst.Fn01rpm = typedSrc.Fn01rpm;
        typedDst.HEXcontrolgain = typedSrc.HEXcontrolgain;

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
        strBuffer.append("rank: ").append(rank).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HEXSetTimes: ");
        for(int i1__ = 0; i1__< 4; ++i1__){

            strBuffer.append(HEXSetTimes[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("HEXSetPoints: ");
        for(int i1__ = 0; i1__< 4; ++i1__){

            strBuffer.append(HEXSetPoints[i1__]).append(", ");
        }

        strBuffer.append("\n");
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("Fn01rpm: ").append(Fn01rpm).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("HEXcontrolgain: ").append(HEXcontrolgain).append("\n");  

        return strBuffer.toString();
    }

}
