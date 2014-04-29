/**
 * 
 */
package com.wenboy.tij.util;

import java.util.List;


/**
 * @author wenbyuan
 *
 */
public abstract class Writer {
	public abstract boolean writeLines(List<String> lines);
	public abstract boolean write(String content);
}
