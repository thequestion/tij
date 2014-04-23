//: typeinfo/Shapes.java
package com.wenboy.tij.typeinfo.basic;
import static com.wenboy.tij.util.Print.print;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	boolean highlighted = false;
  void draw() { System.out.println(this + ".draw()"); }
  abstract public String toString();;
}

class Circle extends Shape {
  public String toString() { return "Circle Highlighted: " + highlighted; }
}

class Square extends Shape {
  public String toString() { return "Square Highlighted: " + highlighted; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle Highlighted: " + highlighted; }
}	

class Rhomboid extends Shape {
	public String toString() { return "Rhomboid Highlighted: " + highlighted; }
}

public class Shapes {
	static void printHierarchy(Shape shape) throws InstantiationException, IllegalAccessException{
		for(Class<?> i : shape.getClass().getInterfaces()){
			print(i.getName());
		}
		if( shape.getClass().getGenericSuperclass() != null){
			print(shape.getClass().getSuperclass().getName());
		}
		
	}
	static void highlight(Shape shape){
		if(shape instanceof Circle){
			shape.highlighted = true;
		}
		print(shape.toString());
	}
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle()
    );
    for(Shape shape : shapeList)
      shape.draw();
    
    
    print("Up cast: ");
    Shape p = (Shape) new Rhomboid();
    print("Down cast: ");
    if(p instanceof Circle){
    	Circle rh = (Circle) p;
    }
    
    for(Shape shape : shapeList){
    	highlight(shape);
    }
    
    Shape p2 = new Circle();
    printHierarchy(p2);
    
  }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
