/**
 * 
 */
package com.wenboy.tij.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenbyuan
 * Counts instances of a type family
 */
public class TypeCounter extends HashMap<Class<?>, Integer>{

	private Class<?> baseType;
	
	public TypeCounter(Class<?> baseType){
		this.baseType = baseType;
	}
	
	public void count(Object obj){
		Class<?> type = obj.getClass();
		if( !baseType.isAssignableFrom(type) ){
			throw new RuntimeException(obj + " incorrect type: "
					+ type + ", shoulbe type or subtype of " + baseType);
		}
		countClass(type);
	}
	
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		//Count total
		Class<?> superClass = type.getSuperclass();
		if(superClass != null && 
				baseType.isAssignableFrom(superClass))
			countClass(superClass);
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer("{");
		for(Map.Entry<Class<?>, Integer> pair : entrySet()){
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		if(result.length() < 2) return null;
		result.delete(result.length()-2, result.length());
		result.append("}");
		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
