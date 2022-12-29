package JAVA_assignment_module_2;
/*
 * Write a Java program to remove the third element from an array list. 
 */
import java.util.ArrayList;

public class Practical_44 
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
	
	    al.remove(Double.valueOf(22.21323));
	    
		System.out.println("after  removing value  size of arraylist is:"+al.size());
		System.out.println("after removing value from arraylist:"+al);
	}
}
