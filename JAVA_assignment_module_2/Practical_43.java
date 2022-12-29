package JAVA_assignment_module_2;
/*
 * Write a Java program to update specific array element by given element. 
 */
import java.util.ArrayList;

public class Practical_43 
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
	
	    al.set(2,"apple");
	    
		System.out.println("after  updating new value  arraylist is:"+al.size());
		System.out.println("after updating value at first position values of arraylist:"+al);
	}
}
