package com.wenboy.tij.util;
/**
 * 
 */


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author wenbyuan
 *
 */
public class FileReader extends Reader{
	
	//private static org.apache.log4j.Logger logger = LogManager.getLogger(FileReader.class.getName());
	private File file = null;

	public FileReader(String fileName){
		this.file = new File(fileName);
		try {
			if(!file.exists())
				this.file.createNewFile();
		} catch (IOException e) {
			//logger.error("Creating file faled!");
			e.printStackTrace();
			
		}
	}

	@Override
	public List<String> readLines() {
		try {
			Path path = Paths.get(file.getName());
			return Files.readAllLines(path, Charset.defaultCharset());
		} catch (IOException e) {
			//logger.error("Reading file failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String read() {
		try {
			Path path = Paths.get(file.getName());
			return new String( Files.readAllBytes(path), Charset.defaultCharset());
		} catch (IOException e) {
			//logger.error("Reading file failed!");
			e.printStackTrace();
		}
		return null;
	}

}
