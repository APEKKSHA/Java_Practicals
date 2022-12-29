package JAVA_assignment_module_2;
/*
 * W.A.J.P to compare a given string to the specified character sequence. 
 * Comparing topsint.com and topsint.com: true 
 * Comparing Topsint.com and topsint.com: false 
 */
public class Practical_16 
{
	public static void main(String[] args) 
	{
	    String s1="topsint.com", s2="topsint.com",s3="Topsint.com";
	    System.out.println("Comparing topsint.com and topsint.com:"+s1.equals(s2));
		System.out.println("Comparing topsint.com and Topsint.com:"+s1.equals(s3));
	}
}
