package JAVA_assignment_module_2;
/*
 * Write a Java program to sort a given array list. 
 */
import java.util.ArrayList;
import java.util.Comparator;

public class Practical_46
{
	public static void main(String[] args) 
	{
	    ArrayList al=new ArrayList();
	    al.add("red");
	    al.add("blue");
	    al.add("green");
	    al.add("yellow");
	    al.add("orange");
		System.out.println("size of arraylist:"+al.size());
		System.out.println("values of arraylist:"+al);
	
	    al.sort(Comparator.naturalOrder());
	    
		System.out.println("after sorting  size of arraylist is:"+al.size());
		System.out.println("after sorting value from arraylist:"+al);
	}
}
