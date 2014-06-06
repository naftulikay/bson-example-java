package org.tkassembled.example.bson.deserialize;

import static org.apache.commons.codec.binary.Hex.encodeHexString;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BinaryObjectIdDeserializer extends StdDeserializer<ObjectId> {
	
	private static final long serialVersionUID = 2075860824222316250L;

	private static final Logger logger = LoggerFactory.getLogger(BinaryObjectIdDeserializer.class);
	
	public BinaryObjectIdDeserializer() {
		super(ObjectId.class);
	}
	
	@Override
	public ObjectId deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
//		jp.read
		byte[] value = (byte[]) jp.getBinaryValue();
		
		logger.debug("Read {}-byte ObjectId: {}; hex: {}", value.length, value, 
				encodeHexString(value));
		
		return new ObjectId(value);
	}
}
