package JAVA_assignment_module_2;
/*
 * Write a Java program to shuffle elements in an array list.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Practical_47 
{
	public static void main(String[] args)
	{
	 ArrayList al=new ArrayList();
	    al.add("red");
	    al.add("blue");
	    al.add("green");
	    al.add("yellow");
	    al.add("orange");
		System.out.println("size of arraylist one:"+al.size());
		System.out.println("values of arraylist two:"+al);
	
	   Collections.shuffle(al);
	    
		System.out.println("after shuffling array list two size of arraylist is:"+al.size());
		System.out.println("after shuffling array list two value from arraylist:"+al);
	}
}
