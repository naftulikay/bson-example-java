package org.tkassembled.example.bson.serialize;

import static org.apache.commons.codec.binary.Hex.encodeHexString;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BinaryObjectIdSerializer extends StdSerializer<ObjectId> {
	
	private static final Logger logger = LoggerFactory.getLogger(BinaryObjectIdSerializer.class);
	
	public BinaryObjectIdSerializer() {
		super(ObjectId.class);
	}
	
	@Override
	public void serialize(ObjectId value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		byte[] bytes = value.toByteArray();
		
		logger.debug("Writing {}-byte binary ObjectId: {}, hex: {}", bytes.length, bytes,
				encodeHexString(bytes));
		
		jgen.writeBinary(bytes);
	}
}
