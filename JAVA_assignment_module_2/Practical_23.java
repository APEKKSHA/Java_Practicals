package JAVA_assignment_module_2;
/*
 * Create a class to print the area of a square and a rectangle.
 * the class has two methods with same name but different number of parameters.
 * The method for printing area of a rectangle has two parameters which are length 
 * and breadth respectively while the other methods for printing area of square has 
 * one parameter which is side of square.
 */

import java.util.Scanner;
class Squaredemo
{
    int a;
    
    public int area(int l,int b)
    {
       
        a=l*b;
        return a;
    }
    
    public int area(int l)
    {
        System.out.println("area of square is:");
        return (a=l*l);
    }
}
public class Practical_23 
{
	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		Squaredemo sd=new Squaredemo();
		
		int l,b,a1;
	    System.out.println("enter length and breadth for rectange:");
	    l=sc.nextInt();
	    b=sc.nextInt();
	    
	    a1=sd.area(l,b);
	    System.out.println("area of rectangle is"+a1);
	    
	    System.out.println("enter length for square:");
	    l=sc.nextInt();
	    a1=sd.area(l,b);
	    System.out.println("area of square is"+a1);
	    
	    
		
	}
}

