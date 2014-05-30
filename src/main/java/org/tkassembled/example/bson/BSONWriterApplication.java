package org.tkassembled.example.bson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

import org.tkassembled.example.bson.data.Article;
import org.tkassembled.example.bson.data.Tag;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;

/**
 * A simple Java endpoint which writes a POJO to <code>${java.io.tmpdir}/example.bson</code>
 * in BSON binary format.
 * 
 * @author Naftuli Tzvi Kay
 */
public class BSONWriterApplication {
	
	public static void main(String[] args) throws FileNotFoundException,
			JsonMappingException, JsonGenerationException, IOException {
//		create an article object to serialize
		Article article = new Article("The Beginning of Everything", new Date(0), 
				"Wow, such much is wow yes!", Arrays.asList(new Tag("beginning"),
						new Tag("first")));
		
//		get the system's temporary directory
		final String tmpDir = System.getProperty("java.io.tmpdir");
		
//		create an output stream pointing to $TMP/example.bson
		OutputStream outputStream = new FileOutputStream(new File(tmpDir, "example.bson"));
//		create a mapper which converts from Java types into serialized form, in our case BSON
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
//		write the article object to the output stream
		mapper.writeValue(outputStream, article);
	}
}
