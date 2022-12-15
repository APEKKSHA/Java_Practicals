package JAVA_assignment_module_2;

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
