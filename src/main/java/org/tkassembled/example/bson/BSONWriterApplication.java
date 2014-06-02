package org.tkassembled.example.bson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tkassembled.example.bson.data.Article;
import org.tkassembled.example.bson.data.Tag;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;
import de.undercouch.bson4jackson.BsonModule;

/**
 * A simple Java endpoint which writes a POJO to <code>${java.io.tmpdir}/example.bson</code>
 * in BSON binary format.
 * 
 * @author Naftuli Tzvi Kay
 */
public class BSONWriterApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BSONWriterApplication.class);
	
	public static void main(String[] args) throws FileNotFoundException,
			JsonMappingException, JsonGenerationException, IOException {
//		create an article object to serialize
		Article article = new Article("The Beginning of Everything", new Date(0), 
				"Wow, such much is wow yes!", Arrays.asList(new Tag("beginning"),
						new Tag("first")));
		
//		get the system's temporary directory
		final String tmpDir = System.getProperty("java.io.tmpdir");
		
		File outputFile = new File(tmpDir, "example.bson");
		
//		if the output file exists, delete it before proceeding.
		if (outputFile.isFile()) {
			logger.debug("{} exists, deleting before writing.", outputFile.getAbsolutePath());
			outputFile.delete();
		}
		
//		create an output stream pointing to $TMP/example.bson
		OutputStream outputStream = new FileOutputStream(outputFile);
//		create a mapper which converts from Java types into serialized form, in our case BSON
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		mapper.registerModule(new BsonModule());
		
		logger.info("Writing sample article to {}.", outputFile.getAbsolutePath());
		
//		write the article object to the output stream
		mapper.writeValue(outputStream, article);
	}
}
