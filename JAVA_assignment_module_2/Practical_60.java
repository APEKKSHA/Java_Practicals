package JAVA_assignment_module_2;
/*
 * Write a Java program to check whether a map contains key-value mappings (empty) or not
 */
import java.util.HashMap;

public class Practical_60 
{
	public static void main(String[] args) {
		
	
	HashMap hm=new HashMap();
    hm.put(1,101);
    hm.put(2,"apple");
    hm.put(3,103.444);
    hm.put(4,new Double(123987));
    hm.put(5,'A');
	
    System.out.println("The hasmap contain key-value is empy to not:"+hm.isEmpty());
	
	}
	
}
