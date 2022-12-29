package JAVA_assignment_module_2;
/*
 * Write a Java program to get the number of elements in a hash set.
 */
import java.util.HashSet;

public class Practical_50
{
	public static void main(String[] args) 
	{
	
		HashSet hs=new HashSet();
	    
	    hs.add(11);
	    hs.add("black");
	    hs.add(24.345);
	    hs.add(new Double(987654));
	   	System.out.println("number of elements in a HashSet : "+hs.size()); 
	   	
	    
	}
}
