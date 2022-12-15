package JAVA_assignment_module_2;
/*
 * create a class named 'Rectangle' with two data members 'length' and 'breadth' 
 * and two methods to print the area and perimeter of the rectangle respectively.
 * its constructor having parameter for length and breadth is used to initialize the 
 * length and breadth of the rectangle. 
 * class square inherits the rectangle class with its constructor having parameter 
 * for its side calling the conturctor of its  
 */
class Rectangle
{
	int length,breadth;
	int a,p;
	
	public Rectangle(int length, int breadth) 
	{
		this.length=length;
		this.breadth=breadth;
	}
	
	public int areaRect()
	{
		a=length*breadth;
		return a;
	}
	
	public int perimeterRect()
	{
		p=2*(length+breadth);
		return p;
	}
}

class Square extends Rectangle
{
	
	public Square(int length, int breadth)
	{
		super(length, breadth);
	
	}
	public int areaSquare()
	{
		a=length*length;
		return a;
		
	}
	
	public int perimeterSquare()
	{
		p=4*(length);
		return p;
	}
	
		
}

public class Practical_26
{
	public static void main(String[] args)
	{
		Square s1=new Square(10, 12);
		
		System.out.println("area of rectange"+s1.areaRect());
		System.out.println("perimeter of rectange"+s1.perimeterRect());
		System.out.println("area of square"+s1.areaSquare());
		System.out.println("perimeter of square"+s1.perimeterSquare());
	}
}
