package JAVA_assignment_module_2;
/*
 * Write a Java program to create a new array list, add some colors (string) and print out the collection.
 */
import java.util.ArrayList;

public class Practical_40 
{
	public static void main(String[] args) 
	{
	    
	    ArrayList al=new ArrayList();
	    al.add("red");
	    al.add("blue");
	    al.add("green");
	    al.add("Yellow");
	    al.add("orange");
		System.out.println("size of arraylist:"+al.size());
		System.out.println("values of arraylist:"+al);
		
	}
}
