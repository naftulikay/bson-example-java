package org.tkassembled.example.bson.data;

import org.bson.types.ObjectId;
import org.tkassembled.example.bson.deserialize.BinaryObjectIdDeserializer;
import org.tkassembled.example.bson.serialize.BinaryObjectIdSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Tag {
	
	@JsonProperty("_id")
	@JsonSerialize(using=BinaryObjectIdSerializer.class)
	@JsonDeserialize(using=BinaryObjectIdDeserializer.class)
	private ObjectId id;
	
	private String name;
	
	public Tag(String name) {
		super();
		this.id = new ObjectId();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ObjectId getId() {
		return this.id;
	}
}
