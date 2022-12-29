package JAVA_assignment_module_2;
/*
 * Write a Java program to convert a hash set to a List/Array List. 
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Practical_59 
{
	public static void main(String[] args) {
		HashSet al=new HashSet();
	    al.add("red");
	    al.add(123);
	    al.add(22.21323);
	    al.add(new Double(34567));
	    al.add("orange");
		System.out.println("size of hashset:"+al.size());
		System.out.println("values of hashset:"+al);
		
		ArrayList al1=new ArrayList(al);
		System.out.println("size of arraylist:"+al1.size());
		System.out.println("values of arraylist:"+al1);
		
	}
}
