package UWMSsensors;
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

import com.rti.dds.cdr.CdrEncapsulation;
import com.rti.dds.cdr.CdrInputStream;
import com.rti.dds.cdr.CdrOutputStream;
import com.rti.dds.cdr.CdrPrimitiveType;
import com.rti.dds.cdr.IllegalCdrStateException;
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.infrastructure.RETCODE_ERROR;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.DataWriterListener;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.DataReaderListener;
import com.rti.dds.topic.DefaultEndpointData;
import com.rti.dds.topic.KeyHash_t;
import com.rti.dds.topic.PrintFormatProperty;
import com.rti.dds.topic.TypeSupportEndpointInfo;
import com.rti.dds.topic.TypeSupportImpl;
import com.rti.dds.topic.TypeSupportParticipantInfo;
import com.rti.dds.topic.TypeSupportType;
import com.rti.dds.typecode.TypeCode;

/**
* A collection of useful methods for dealing with objects of type
* UWMSsensors
*/

public class UWMSsensorsTypeSupport extends TypeSupportImpl {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final String TYPE_NAME = "UWMSsensors";

    private static final char[] PLUGIN_VERSION = {2, 0, 0, 0};     
    private static final UWMSsensorsTypeSupport _singleton
    = new UWMSsensorsTypeSupport();

    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    // --- External methods: -------------------------------------------------
    /* The methods in this section are for use by users of RTI Connext
    */

    public static String get_type_name() {
        return _singleton.get_type_nameI();
    }

    public static void register_type(DomainParticipant participant,
    String type_name) {
        _singleton.register_typeI(participant, type_name);
    }

    public static void unregister_type(DomainParticipant participant,
    String type_name) {
        _singleton.unregister_typeI(participant, type_name);
    }

    /* The methods in this section are for use by RTI Connext
    * itself and by the code generated by rtiddsgen for other types.
    * They should be used directly or modified only by advanced users and are
    * subject to change in future versions of RTI Connext.
    */
    public static UWMSsensorsTypeSupport get_instance() {
        return _singleton;
    }

    public static UWMSsensorsTypeSupport getInstance() {
        return get_instance();
    }

    public static TypeCode getTypeCode(){
        return UWMSsensorsTypeCode.VALUE;
    }

    public Object create_data() {
        return UWMSsensors.create();
    }

    public void destroy_data(Object data) {
        return;
    }
    public Object create_key() {
        return new UWMSsensors();
    }

    public void destroy_key(Object key) {
        return;
    }
    public Class get_type() {
        return UWMSsensors.class;
    }

    /**
    * This is a concrete implementation of this method inherited from the base class.
    * This method will perform a deep copy of <code>source</code> into
    * <code>destination</code>.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>destination</code>.
    * @exception NullPointerException If <code>destination</code> or 
    * <code>source</code> is null.
    * @exception ClassCastException If either <code>destination</code> or
    * <code>this</code> is not a <code>UWMSsensors</code>
    * type.
    */
    public Object copy_data(Object destination, Object source) {

        UWMSsensors typedDst = (UWMSsensors) destination;
        UWMSsensors typedSrc = (UWMSsensors) source;

        return typedDst.copy_from(typedSrc);

    }

    public long get_serialized_sample_max_size(Object endpoint_data,boolean include_encapsulation,short encapsulation_id,long currentAlignment) {
        long origAlignment = currentAlignment;
        long encapsulation_size = currentAlignment;

        if(include_encapsulation) {
            if (!CdrEncapsulation.isValidEncapsulationKind(encapsulation_id)) {
                throw new RETCODE_ERROR("Unsupported encapsulation");
            }

            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size -= currentAlignment;
            currentAlignment = 0;
            origAlignment = 0;
        } 

        currentAlignment += CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment += CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment += CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment += CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment += CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment += CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        if (include_encapsulation) {
            currentAlignment += encapsulation_size;
        }
        return  currentAlignment - origAlignment;
    }

    public long get_serialized_sample_min_size(Object endpoint_data,boolean include_encapsulation,short encapsulation_id,long currentAlignment) {

        long origAlignment = currentAlignment;
        long encapsulation_size = currentAlignment;

        if(include_encapsulation) {
            if (!CdrEncapsulation.isValidEncapsulationKind(encapsulation_id)) {
                throw new RETCODE_ERROR("Unsupported encapsulation");
            }

            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size -= currentAlignment;
            currentAlignment = 0;
            origAlignment = 0;
        } 

        currentAlignment +=CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment +=CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment +=CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment +=CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment +=CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(currentAlignment) ;
        currentAlignment +=CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;

        if (include_encapsulation) {
            currentAlignment += encapsulation_size;
        }
        return  currentAlignment - origAlignment;

    }

    public long get_serialized_sample_size(
        Object endpoint_data, boolean include_encapsulation, 
        short encapsulation_id, long currentAlignment,
        Object sample) 
    {

        UWMSsensors typedSrc = (UWMSsensors) sample;
        DefaultEndpointData epd = ((DefaultEndpointData) endpoint_data) ;
        long origAlignment = currentAlignment;
        long encapsulation_size = currentAlignment;

        if(include_encapsulation) {
            if (!CdrEncapsulation.isValidEncapsulationKind(encapsulation_id)) {
                throw new RETCODE_ERROR("Unsupported encapsulation");
            }

            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size -= currentAlignment;
            currentAlignment = 0;
            origAlignment = 0;
            epd.setBaseAlignment(currentAlignment);
        } 

        currentAlignment  +=  CdrPrimitiveType.INT.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        currentAlignment  +=  CdrPrimitiveType.INT.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        currentAlignment  +=  CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        currentAlignment  +=  CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        currentAlignment  +=  CdrPrimitiveType.DOUBLE.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        currentAlignment  +=  CdrPrimitiveType.INT.getMaxSizeSerialized(epd.getAlignment(currentAlignment));

        if (include_encapsulation) {
            currentAlignment += encapsulation_size;
        }
        return currentAlignment - origAlignment;
    }

    public long get_serialized_key_max_size(
        Object endpoint_data,
        boolean include_encapsulation, 
        short encapsulation_id,
        long currentAlignment) 
    {
        long origAlignment = currentAlignment;
        long encapsulation_size = currentAlignment;

        if(include_encapsulation) {
            if (!CdrEncapsulation.isValidEncapsulationKind(encapsulation_id)) {
                throw new RETCODE_ERROR("Unsupported encapsulation");
            }

            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size += CdrPrimitiveType.SHORT.getMaxSizeSerialized(encapsulation_size);
            encapsulation_size -= currentAlignment;
            currentAlignment = 0;
            origAlignment = 0;
        } 

        currentAlignment +=  CdrPrimitiveType.INT.getMaxSizeSerialized(currentAlignment) ;
        if (include_encapsulation) {
            currentAlignment += encapsulation_size;
        }

        return currentAlignment - origAlignment;
    }

    public void serialize(Object endpoint_data,Object src, CdrOutputStream dst,boolean serialize_encapsulation,
    short encapsulation_id, boolean serialize_sample, Object endpoint_plugin_qos) {
        int position = 0;

        if(serialize_encapsulation) {
            dst.serializeAndSetCdrEncapsulation(encapsulation_id);

            position = dst.resetAlignment();

        }

        if(serialize_sample) {

            UWMSsensors typedSrc = (UWMSsensors) src;

            dst.writeInt(typedSrc.id);

            dst.writeInt(typedSrc.state);

            dst.writeDouble(typedSrc.Micturition);

            dst.writeDouble(typedSrc.P);

            dst.writeDouble(typedSrc.S01);

            dst.writeInt(typedSrc.fault);
        }

        if (serialize_encapsulation) {
            dst.restoreAlignment(position);
        }

    }
    public long serialize_to_cdr_buffer(
        byte[] buffer,
        long length,
        UWMSsensors src)
    {
        return super.serialize_to_cdr_buffer(buffer,length,src);
    }

    public void serialize_key(
        Object endpoint_data,
        Object src,
        CdrOutputStream dst,
        boolean serialize_encapsulation,
        short encapsulation_id,
        boolean serialize_key,
        Object endpoint_plugin_qos) 
    {
        int position = 0;

        if (serialize_encapsulation) {
            dst.serializeAndSetCdrEncapsulation(encapsulation_id);

            position = dst.resetAlignment();
        }

        if (serialize_key) {

            UWMSsensors typedSrc = (UWMSsensors) src;    

            dst.writeInt(typedSrc.id);

        }

        if (serialize_encapsulation) {
            dst.restoreAlignment(position);
        }
    }

    public Object deserialize_sample(
        Object endpoint_data,
        Object dst, 
        CdrInputStream src, boolean deserialize_encapsulation,
        boolean deserialize_sample,
        Object endpoint_plugin_qos) 
    {
        int position = 0;

        if(deserialize_encapsulation) {
            src.deserializeAndSetCdrEncapsulation();

            position = src.resetAlignment();
        }

        if(deserialize_sample) {

            UWMSsensors typedDst = (UWMSsensors) dst;
            typedDst.clear();      
            try{
                typedDst.id = src.readInt();
                typedDst.state = src.readInt();
                typedDst.Micturition = src.readDouble();
                typedDst.P = src.readDouble();
                typedDst.S01 = src.readDouble();
                typedDst.fault = src.readInt();
            } catch (IllegalCdrStateException stateEx) {
                if (src.available() >= CdrEncapsulation.CDR_ENCAPSULATION_PARAMETER_ID_ALIGNMENT) {
                    throw new RETCODE_ERROR("Error deserializing sample! Remainder: " + src.available() + "\n" +
                    "Exception caused by: " + stateEx.getMessage());
                }
            } catch (Exception ex) {
                throw new RETCODE_ERROR(ex.getMessage());        
            }

        }
        if (deserialize_encapsulation) {
            src.restoreAlignment(position);
        }

        return dst;
    }

    public void deserialize_from_cdr_buffer(
        UWMSsensors dst,
        byte[] buffer,
        long length) 
    {
        super.deserialize_from_cdr_buffer(dst,buffer,length);
    }

    public String data_to_string(
        UWMSsensors sample,
        PrintFormatProperty property) 
    {
        return super.data_to_string(sample, property);
    }

    public String data_to_string(
        UWMSsensors sample) 
    {
        return super.data_to_string(sample);
    }

    public Object deserialize_key_sample(
        Object endpoint_data,
        Object dst,
        CdrInputStream src,
        boolean deserialize_encapsulation,
        boolean deserialize_key,
        Object endpoint_plugin_qos) 
    {
        int position = 0;

        if(deserialize_encapsulation) {
            src.deserializeAndSetCdrEncapsulation();

            position = src.resetAlignment();
        }

        if(deserialize_key) {

            UWMSsensors typedDst = (UWMSsensors) dst;

            typedDst.id = src.readInt();

        }
        if (deserialize_encapsulation) {
            src.restoreAlignment(position);
        }

        return dst;
    }

    public void skip(Object endpoint_data, 
    CdrInputStream src,
    boolean skip_encapsulation, 
    boolean skip_sample, 
    Object endpoint_plugin_qos)
    {
        int position = 0;

        if (skip_encapsulation) {
            src.skipEncapsulation();

            position = src.resetAlignment();
        }

        if (skip_sample) {

            src.skipInt();

            src.skipInt();

            src.skipDouble();

            src.skipDouble();

            src.skipDouble();

            src.skipInt();

        }

        if (skip_encapsulation) {
            src.restoreAlignment(position);
        }
    }

    public Object serialized_sample_to_key(
        Object endpoint_data,
        Object sample,
        CdrInputStream src, 
        boolean deserialize_encapsulation,  
        boolean deserialize_key, 
        Object endpoint_plugin_qos) 
    {

        int position = 0;

        if(deserialize_encapsulation) {
            src.deserializeAndSetCdrEncapsulation();

            position = src.resetAlignment();
        }

        if (deserialize_key) {

            UWMSsensors typedDst = (UWMSsensors) sample;

            typedDst.id = src.readInt();

            src.skipInt();

            src.skipDouble();

            src.skipDouble();

            src.skipDouble();

            src.skipInt();

        }

        if (deserialize_encapsulation) {
            src.restoreAlignment(position);
        }

        return sample;
    }

    /* Fill in the key fields of the given instance sample based on the key.
    */
    public void key_to_instance(Object endpoint_data,
    Object instance,
    Object key) {
        UWMSsensors typedDst
        = (UWMSsensors) instance;
        UWMSsensors typedSrc
        = (UWMSsensors) key;
        typedDst.id = typedSrc.id;

    }

    /* Fill in the given key based on the key fields of the given instance
    * sample.
    */
    public void instance_to_key(Object endpoint_data,
    Object key,
    Object instance) {
        UWMSsensors typedDst
        = (UWMSsensors)key;
        UWMSsensors typedSrc
        = (UWMSsensors) instance;
        typedDst.id = typedSrc.id;

    }

    public void serialized_sample_to_keyhash(
        Object endpoint_data,
        CdrInputStream src,
        KeyHash_t keyhash,
        boolean include_encapsulation,
        Object endpoint_plugin_qos)
    {
        int position = 0;

        DefaultEndpointData endpointData = (DefaultEndpointData) endpoint_data;
        Object sample = null;

        sample = endpointData.get_sample();

        if (sample == null) {
            throw new RETCODE_ERROR("Missing intermediate sample");
        }

        UWMSsensors typedDst = (UWMSsensors) sample;

        if (include_encapsulation) {
            src.deserializeAndSetCdrEncapsulation();

            position = src.resetAlignment();
        }

        typedDst.id = src.readInt();

        if (include_encapsulation) {
            src.restoreAlignment(position);
        }

        instance_to_keyhash(endpoint_data, keyhash, sample);
    }

    // -----------------------------------------------------------------------
    // Callbacks
    // -----------------------------------------------------------------------
    public Object on_participant_attached(Object registration_data,
    TypeSupportParticipantInfo participant_info,
    boolean top_level_registration,
    Object container_plugin_context,
    TypeCode type_code) {
        return super.on_participant_attached(
            registration_data, participant_info, top_level_registration,
            container_plugin_context, type_code);
    }

    public void on_participant_detached(Object participant_data) {
        super.on_participant_detached(participant_data);
    }

    public Object on_endpoint_attached(Object participantData,
    TypeSupportEndpointInfo endpoint_info,
    boolean top_level_registration,
    Object container_plugin_context) {
        return super.on_endpoint_attached(
            participantData,  endpoint_info,  
            top_level_registration, container_plugin_context);        
    }

    public void on_endpoint_detached(Object endpoint_data) {
        super.on_endpoint_detached(endpoint_data);
    }
    // -----------------------------------------------------------------------
    // Protected Methods
    // -----------------------------------------------------------------------

    protected DataWriter create_datawriter(long native_writer,
    DataWriterListener listener,
    int mask) {
        return new UWMSsensorsDataWriter(native_writer, listener, mask, this);
    }

    protected DataReader create_datareader(long native_reader,
    DataReaderListener listener,
    int mask) {

        return new UWMSsensorsDataReader(native_reader, listener, mask, this);   

    }

    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    protected UWMSsensorsTypeSupport() {

        /* If the user data type supports keys, then the second argument
        to the constructor below should be true.  Otherwise it should
        be false. */        

        super(TYPE_NAME,true,UWMSsensorsTypeCode.VALUE,UWMSsensors.class,TypeSupportType.TST_STRUCT, PLUGIN_VERSION);

    }

    protected UWMSsensorsTypeSupport (boolean enableKeySupport) {

        super(TYPE_NAME, enableKeySupport,UWMSsensorsTypeCode.VALUE,UWMSsensors.class,TypeSupportType.TST_STRUCT, PLUGIN_VERSION);
    }
}

