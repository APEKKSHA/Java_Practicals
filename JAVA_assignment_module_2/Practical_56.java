package JAVA_assignment_module_2;

/*
 * Write a Java program of swap two elements in an array list. 
 */
import java.util.ArrayList;
import java.util.Collections;

public class Practical_56 
{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
	    al.add("red");
	    al.add(123);
	    al.add(22.21323);
	    al.add(new Double(34567));
	    al.add("orange");
		System.out.println("size of arraylist:"+al.size());
		System.out.println("values of arraylist:"+al);
		
		Collections.swap(al, 2, 3);
		System.out.println("after swapping size of arraylist:"+al.size());
		System.out.println("after swapping values of arraylist:"+al);
		
	}
}
