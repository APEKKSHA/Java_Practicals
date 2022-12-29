package JAVA_assignment_module_2;
/*
 * Write a Java program to iterate through all elements in a hash list. 
 */
import java.util.HashSet;
import java.util.Iterator;

public class Practical_49 
{
	public static void main(String[] args)
	{
		HashSet hs=new HashSet();
	    
	    hs.add(11);
	    hs.add("black");
	    hs.add(24.345);
	    hs.add(new Double(987654));
	   	System.out.println("Size of HashSet : "+hs.size()); 
		System.out.println("Elements in HashSet : "+hs);
		
		Iterator i1=hs.iterator();
		   System.out.println("Elements in HashSet through iterator : ");
		while(i1.hasNext())
		{   
		    System.out.println(" "+i1.next());
		}
	}
}
