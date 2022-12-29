package JAVA_assignment_module_2;
/*
 * Write a Java program to reverse elements in an array list. 
 */
import java.util.ArrayList;
import java.util.Collections;

public class Practical_53 
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
	
	    
	    Collections.reverse(al);
		System.out.println("after reversing size of arraylist:"+al.size());
		System.out.println("after reversing values of arraylist:"+al);
	
	}
}
