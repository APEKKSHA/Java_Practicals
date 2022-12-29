package JAVA_assignment_module_2;
/*
 * Write a Java program to join two array lists.
 */
import java.util.ArrayList;

public class Practical_57 
{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
	    al.add("red");
	    al.add(123);
	    al.add(22.21323);
	    al.add(new Double(34567));
	    al.add("orange");
		System.out.println("size of arraylist one :"+al.size());
		System.out.println("values of arraylist one :"+al);
		
		ArrayList al1=new ArrayList();
	    al1.add("red");
	    al1.add("blue");
	    al1.add("green");
	    al1.add("yellow");
	    al1.add("orange");

		System.out.println("size of arraylist two"+al1.size());
		System.out.println("values of arraylist two:"+al1);
		
		al.addAll(al1);
		System.out.println("after joining two arraylist:"+al);
	}
}
