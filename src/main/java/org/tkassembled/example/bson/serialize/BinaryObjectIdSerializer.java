package org.tkassembled.example.bson.serialize;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BinaryObjectIdSerializer extends StdSerializer<ObjectId> {
	
	public BinaryObjectIdSerializer() {
		super(ObjectId.class);
	}
	
	@Override
	@SuppressWarnings("unused")
	public void serialize(ObjectId value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		byte[] bytes = value.toByteArray();
		int byteSize = bytes.length;
		byte[] stringBytes = value.toHexString().getBytes();
		int stringBytesSize = stringBytes.length;
		jgen.writeBinary(bytes);
	}
}
