package JAVA_assignment_module_2;
/*
 *     
 */
import java.util.Scanner;

class AgeValidation extends Exception 
{
	String a;
	public AgeValidation(String a)
	{
		this.a=a;
	}
}

class AgeCheck
{
//	double balance;
//	public void deposit(double amount)
//	{
//		balance=balance+amount;
//		System.out.println(amount+" rs deposited");
//		
//	}
	public void checkValidAge(int a) throws AgeValidation
	{
		if(a >=18)
		{
//			balance = balance - amount;
			System.out.println(a+" age is valid");
		}
		else
		{
			String a="invalid age";
			throw new AgeValidation(a);
		}
	}
}

public class Practical_61 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		AgeCheck a1=new AgeCheck();
		System.out.println("enter age:");
		int a=sc.nextInt();
		
		try
		{
			a1.checkValidAge(a);;
		}
		catch(AgeValidation e)
		{
			e.printStackTrace();
		}
	}
}
