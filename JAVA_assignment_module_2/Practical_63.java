package JAVA_assignment_module_2;
/*
 * Write a Java program to iterate through all elements in an array list. 
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Practical_63 
{
	public static void main(String[] args) 
	{
		ArrayList al=new ArrayList();
	    al.add("red");
	    al.add(123);
	    al.add(22.21323);
	    al.add(new Double(34567));
	    al.add("orange");
		System.out.println("size of arraylist:"+al.size());
		System.out.println("values of arraylist:"+al);
		al.add(0,"apeksha");
		
		Iterator it=al.iterator();
		System.out.println("values using Iterator:");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
