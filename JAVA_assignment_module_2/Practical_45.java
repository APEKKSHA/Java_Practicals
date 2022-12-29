package JAVA_assignment_module_2;
/*
 * Write a Java program to search an element in an array list.
 */
import java.util.ArrayList;

public class Practical_45 
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
	
	    int a1=al.indexOf(123);
	    
	    if(a1==-1)
	    {
	        System.out.println("element not found:");
	    }
	    else
	    {
	        System.out.println("index of element: "+al.get(a1)+" from arraylist: "+a1);
	    }
	    
	
	}
}
