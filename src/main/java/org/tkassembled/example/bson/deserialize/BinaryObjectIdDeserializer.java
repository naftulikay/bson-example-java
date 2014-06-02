package org.tkassembled.example.bson.deserialize;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BinaryObjectIdDeserializer extends StdDeserializer<ObjectId> {
	
	private static final long serialVersionUID = 2075860824222316250L;

	public BinaryObjectIdDeserializer() {
		super(ObjectId.class);
	}
	
	@Override
	@SuppressWarnings("unused")
	public ObjectId deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		byte[] value = jp.getBinaryValue();
		int valueSize = value.length;
		boolean valid = ObjectId.isValid(new String(value));
		
		return new ObjectId(value);
	}
}
