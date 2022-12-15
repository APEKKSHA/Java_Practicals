package JAVA_assignment_module_2;

import java.util.Scanner;

public class Practical_36
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("enter array size:");
			
			int[] a=new int[5];
			
			a[5]=15/0;
		
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
