package JAVA_assignment_module_2;
/*
 * W.A.J. P to demonstrate try catch block, 
 * Take two numbers from the user and perform the division operation and 
 * handle Arithmetic Exception. O/P- Enter two numbers: 10 0
 * Exception in thread main java.lang.ArithmeticException:/ by zero
 */
import java.util.Scanner;

public class Practical_35 
{	public static void main(String[] args) 
	{
		try 
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter no1.:");
			int a=sc.nextInt();
			System.out.println("enter no2.:");
			int b=sc.nextInt();
			
			int c=a/b;
			
			System.out.println("division is:"+c);
			System.out.println("your program is compiled");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
