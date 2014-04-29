/**
 * 
 */
package com.wenboy.tij.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author wenbyuan
 * 
 */
public class FileWriter extends Writer {

	private File file = null;

	public FileWriter(String fileName) {
		file = new File(fileName);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean writeLines(List<String> lines) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(
					file.getAbsoluteFile());
			for(String line:lines)
				out.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			if(out != null)
				out.close();
		}
		return true;
	}

	@Override
	public boolean write(String content) {
		Path path = Paths.get(file.getName());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		try {
			out.writeBytes(content);
			byte[] bytes = baos.toByteArray();

			Files.write(path, bytes, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
