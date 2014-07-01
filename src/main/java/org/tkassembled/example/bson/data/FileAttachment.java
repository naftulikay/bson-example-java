package org.tkassembled.example.bson.data;

import org.bson.types.ObjectId;
import org.tkassembled.example.bson.deserialize.BinaryObjectIdDeserializer;
import org.tkassembled.example.bson.serialize.BinaryObjectIdSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect
@JsonPropertyOrder({"_id", "filename", "data"})
public class FileAttachment {
	
	@JsonProperty("_id")
	@JsonSerialize(using=BinaryObjectIdSerializer.class)
	@JsonDeserialize(using=BinaryObjectIdDeserializer.class)
	private ObjectId id;
	
	private String filename;
	
	private byte[] data;
	
	public FileAttachment() {
		super();
	}
	
	public FileAttachment(String filename, byte[] data) {
		super();
		this.id = new ObjectId();
		this.filename = filename;
		this.data = data;
	}
	
	public FileAttachment(ObjectId id, String filename, byte[] data) {
		super();
		this.id = id;
		this.filename = filename;
		this.data = data;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
