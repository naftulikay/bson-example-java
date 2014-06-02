package org.tkassembled.example.bson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tkassembled.example.bson.data.Article;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import de.undercouch.bson4jackson.BsonFactory;
import de.undercouch.bson4jackson.BsonModule;

public class BSONReaderApplication {

	private final static Logger logger = LoggerFactory.getLogger(BSONReaderApplication.class);
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		mapper.registerModule(new BsonModule());
		
		ObjectReader reader = mapper.reader(Article.class);
		
		final String tmpDir = System.getProperty("java.io.tmpdir");
		
		File inputFile = new File(tmpDir, "example.bson");
		
		if (!inputFile.isFile()) {
			logger.error("Input file {} doesn't exist, have you generated it yet?", 
					inputFile.getAbsolutePath());
			System.exit(1);
		}
		
		InputStream inputStream = new FileInputStream(inputFile);
		
		Article article = reader.readValue(inputStream);
		
		logger.info("Article successfully read: '{}' has {} tag(s).",
				article.getTitle(), article.getTags().size());
	}

}
