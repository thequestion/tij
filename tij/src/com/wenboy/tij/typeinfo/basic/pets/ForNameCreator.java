//: typeinfo/pets/ForNameCreator.java
package com.wenboy.tij.typeinfo.basic.pets;
import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.wenboy.tij.typeinfo.basic.pets.Mutt",
    "com.wenboy.tij.typeinfo.basic.pets.Pug",
    "com.wenboy.tij.typeinfo.basic.pets.EgyptianMau",
    "com.wenboy.tij.typeinfo.basic.pets.Manx",
    "com.wenboy.tij.typeinfo.basic.pets.Cymric",
    "com.wenboy.tij.typeinfo.basic.pets.Rat",
    "com.wenboy.tij.typeinfo.basic.pets.Mouse",
    "com.wenboy.tij.typeinfo.basic.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
