package JAVA_assignment_module_2;
/*
 * Write a Java program to append the specified element to the end of a hash set. 
 */
import java.util.HashSet;

public class Practical_48 
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
	}
}
