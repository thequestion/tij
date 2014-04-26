/**
 * 
 */
package com.wenboy.tij.util;

import java.util.List;

/**
 * @author wenbyuan
 *
 */
public abstract class Reader {
	public abstract List<String> read();
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reader reader = new FileReader("/test");
		List<String> lines = reader.read();
		for(String line : lines){
			System.out.println(line);
		}
	}
}
