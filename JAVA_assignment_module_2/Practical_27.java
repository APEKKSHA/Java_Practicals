package JAVA_assignment_module_2;
/*
 * Write a program to print the area and perimeter of a triangle having sides of
 *  3, 4 and 5 units by creating a class named 'Triangle' without any parameter in its constructor.
 */
class Triangle
{
	int s1=3,s2=4,s3=5,peri,a;
	double area;
	public Triangle() 
	{
		peri=s1+s2+s3;
		System.out.println("perimeter of Triangle:"+peri);
	
		a=peri/2;
		area=Math.sqrt((a*(a-s1)*(a-s2)*(a-s3)));
		System.out.println("area of Triangle:"+area);
	}
}

public class Practical_27 
{
	public static void main(String[] args)
	{
		Triangle t1=new Triangle();
	}
}
