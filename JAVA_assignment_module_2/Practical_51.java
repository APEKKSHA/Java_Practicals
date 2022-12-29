package JAVA_assignment_module_2;
/*
 * Write a Java program to associate the specified value with the specified key in a Hash Map
 */
import java.util.HashMap;

public class Practical_51 
{
	public static void main(String[] args)
	{
	    HashMap hm=new HashMap();
	    hm.put(1,101);
	    hm.put(2,"apple");
	    hm.put(3,103.444);
	    hm.put(4,new Double(123987));
	    hm.put(5,'A');
	
	    
		System.out.println("values in hashmap:"+hm);
	}
}
