package JAVA_assignment_module_2;
/*
 * Write a Java program to extract a portion of an array list.
 */
import java.util.ArrayList;
import java.util.List;

public class Practical_54
{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
	    al.add("red");
	    al.add("blue");
	    al.add("green");
	    al.add("yellow");
	    al.add("orange");
		System.out.println("size of arraylist one:"+al.size());
		System.out.println("values of arraylist two:"+al);
	
		List al1=al.subList(1, 3);
		
		System.out.println("after extraction size of arraylist one:"+al1.size());
		System.out.println("after extraction values of arraylist one:"+al1);
	
	}
}
