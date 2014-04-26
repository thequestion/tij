/**
 * 
 */
package com.wenboy.tij.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenbyuan
 * Calculates the frequency of words in given document
 */
public class FrequencyCounter extends HashMap<String, Integer>{
	public void count(String word){
		Integer frequency = get(word);
		put(word, frequency == null ? 1 : frequency + 1);
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer("{");
		for(Map.Entry<String, Integer> pair : entrySet()){
			result.append(pair.getKey());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		result.delete(result.length()-2, result.length());
		result.append("}");
		return result.toString();
	}
	
	public static void main(String[] args){
		String test = "This is a beautiful hat This one has green color on it";
		String[] tests = test.split(" ");
		FrequencyCounter counter = new FrequencyCounter();
		for(String s: tests)
			counter.count(s);
		System.out.println(counter);
	}
}
