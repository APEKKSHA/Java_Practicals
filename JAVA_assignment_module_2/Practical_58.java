package JAVA_assignment_module_2;
/*
 * Write a Java program to convert a hash set to an array. 
 */
import java.util.HashSet;

public class Practical_58
{
	public static void main(String[] args) {
		HashSet hs=new HashSet();
	    
	    hs.add(11);
	    hs.add(12);
	    hs.add(24);
	    hs.add(35);
	   	System.out.println("number of elements in a HashSet : "+hs.size()); 

	   	int[] arr=new int[hs.size()];
	   	hs.toArray();
	   	System.out.println("hash set into array:");
	   	for(int str:arr)
	   	{
	   		System.out.println(str);
	   	}
	   	
	   	
	}
}
