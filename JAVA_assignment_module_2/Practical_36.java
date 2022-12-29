package JAVA_assignment_module_2;
/*
 * W.A.J. P to demonstrate multiple catch blocks, 
 * (one is to handle divide by zero exception and 
 * another one is to handle ArrayIndexOutOfBoundException) int a [] =new int [5]; a [5]=30/0
 */
public class Practical_36
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("enter array size:");
			
			int[] a=new int[5];
			
			a[5]=30/0;
		
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
