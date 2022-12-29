package JAVA_assignment_module_2;
/*
 * Write a Java program to retrieve an element (at a specified index) from a given array list. 
 */
import java.util.ArrayList;

public class Practical_42 
{
	public static void main(String[] args) 
	{
		ArrayList al=new ArrayList();
	    al.add("red");
	    al.add(123);
	    al.add(22.21323);
	    al.add(new Double(34567));
	    al.add("orange");
		System.out.println("size of arraylist:"+al.size());
		System.out.println("values of arraylist:"+al);
	   
		System.out.println("retrieve an element (at a specified index)from a given arraylist.:"+al.get(4));
	}
}
