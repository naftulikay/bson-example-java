package org.tkassembled.example.bson.data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonAutoDetect
@JsonPropertyOrder({"title", "date", "tags", "body"})
public class Article {
	
	private String title;
	
	private Date date;
	
	private String body;
	
	private List<Tag> tags;
	
	public Article(String title, Date date, String body, List<Tag> tags) {
		super();
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
	
	
}
