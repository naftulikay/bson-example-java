# bson-example-java

An example project in Java demonstrating the reading and writing of BSON using Jackson.

## Building

Check out the project using Git:

    git clone https://github.com/rfkrocktk/bson-example-java.git
    cd bson-example-java

This project is built using Apache Maven. Simply run the following in the project home directory:

    mvn install

A jar will be built in the `target/` directory in the project home directory. This jar can then be run following the examples in the reading and writing sections of this README. 

This project is also Eclipse-ready and can be easy run in Eclipse provided that the m2eclipse plugin is installed in Eclipse for Maven integration. 

## Reading

The `org.tkassembled.example.bson.BSONReaderApplication` class is a Java main class which can be run from Eclipse or the command line. It will look at `${java.io.tmpdir}/example.bson` for a BSON file to display the contents of.

Simply run this class as a Java application in Eclipse or from the command line by specifying the class and including the Maven classpath.

## Writing

The `org.tkassembled.example.bson.BSONWriterApplication` class is a Java main class which can be run from Eclipse or the command line. It will write a tree of POJOs as a BSON object to `${java.io.tmpdir}/example.bson` to be read by the reader application.

Simply run this class as a Java application in Eclipse or from the command line by specifying the class and including the Maven classpath.