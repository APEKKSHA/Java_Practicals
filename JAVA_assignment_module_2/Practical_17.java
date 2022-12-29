package JAVA_assignment_module_2;
/*
 * W.A.J.P to check whether a given string ends with the contents of another string. 
 * "Java Exercises" ends with "se"? False 
 * "Java Exercise" ends with "se"? True 
 */
public class Practical_17 
{
	public static void main(String[] args) 
	{
	    String s1="Java Exercicses", s2="Java Exercises";
	    System.out.println("String s1= Java Exercises ends with es:"+s1.endsWith("se"));
		System.out.println("String s2= Java Exercise ends with se:"+s2.endsWith("es"));
	}
}
