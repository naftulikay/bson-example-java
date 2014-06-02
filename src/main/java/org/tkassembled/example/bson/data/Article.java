package org.tkassembled.example.bson.data;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.tkassembled.example.bson.deserialize.BinaryObjectIdDeserializer;
import org.tkassembled.example.bson.serialize.BinaryObjectIdSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect
@JsonPropertyOrder({"_id", "title", "date", "tags", "body"})
public class Article {
	
	@JsonProperty("_id")
	@JsonSerialize(using=BinaryObjectIdSerializer.class)
	@JsonDeserialize(using=BinaryObjectIdDeserializer.class)
	private ObjectId id;
	
	private String title;
	
	private Date date;
	
	private String body;
	
	private List<Tag> tags;
	
	public Article() {
		super();
	}
	
	public Article(String title, Date date, String body, List<Tag> tags) {
		super();
		this.id = new ObjectId();
		this.title = title;
		this.date = date;
		this.body = body;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public ObjectId getId() {
		return id;
	}
	
	
}
