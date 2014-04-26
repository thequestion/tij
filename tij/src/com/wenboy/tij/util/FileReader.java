/**
 * 
 */
package com.wenboy.tij.util;

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
	
	File file = null;

	public FileReader(String fileName){
		this.file = new File(fileName);
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!file.exists())
			System.out.println("file not created");
	}

	@Override
	public List<String> read() {
		try {
			Path path = Paths.get(file.getName());
			return Files.readAllLines(path, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
