package JAVA_assignment_module_2;
/*
 * W.A.J.P to check whether a given string starts with the contents of another string. 
 * Red is favorite color. 
 * Starts with Red? True 
 * Orange is also my favorite color. Starts with Red? False I3.
 */
public class Practical_18 
{
	public static void main(String[] args) 
	{
		String s1="Red is favorite color", s2="Orange is  also favorite color";
	    System.out.println("String s1= Red  is favorite color starts with Red:"+s1.startsWith("Red"));
		System.out.println("String s2= Orange is also favorite color starts with Red:"+s2.startsWith("Red"));
	}
}
