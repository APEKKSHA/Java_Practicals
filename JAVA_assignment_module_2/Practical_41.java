package JAVA_assignment_module_2;
/*
 * Write a Java program to insert an element into the array list at the first position. 
 */
import java.util.ArrayList;

public class Practical_41 
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
	
	    al.add(0,"apeksha");
	    
		System.out.println("after inserting value at first position the size of arraylist:"+al.size());
		System.out.println("after inserting value at first position values of arraylist:"+al);
	
	}

}
