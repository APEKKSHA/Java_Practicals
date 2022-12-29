package JAVA_assignment_module_2;
/*
 * Create a class named 'Shape' with a method to print "This is this is shape". 
 * Then create two other classes named 'Rectangle', 'Circle' inheriting the Shape class, both having a method to print "This is rectangular shape" and "This is circular shape" respectively. 
 * Create a subclass 'Square' of 'Rectangle' having a method to print "Square is a rectangle". 
 * Now call the method of 'Shape' and 'Rectangle' class by the object of 'Square' class.
 */
class ShapeDemo
{
	public void displayShape()
	{
		System.out.println("this is shape");
	}
}
class RectangleDemo extends ShapeDemo
{
	public void displayRect()
	{
		System.out.println("this is Rectangle");
	}
}
class Circle extends ShapeDemo
{
	public void displayCircle()
	{
		System.out.println("this is Circle");
	}
}

class SquareRect extends RectangleDemo
{
	public void displayData()
	{
		System.out.println("Square is rectangle");
	}
}
public class Practical_34 
{
	public static void main(String[] args)
	{
		SquareRect s1=new SquareRect();
		s1.displayShape();
		s1.displayRect();
	}
}
