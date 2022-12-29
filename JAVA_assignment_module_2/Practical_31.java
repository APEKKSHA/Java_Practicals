package JAVA_assignment_module_2;
import java.util.Scanner;
/*
 * Write a program to print the factorial of a number by defining a method named 
 * 'Factorial'. Factorial of any number n is represented by n! And is equal to 1*2*3*...*(n-1) *n.
 * E.g.-4! = 1*2*3*4 = 24 
 *		3! = 3*2*1 = 6 
 *		2! = 2*1 = 2 
 *Also, 1! = 1 
 *		0! = 0
 */
class Factorial
{
    int n,sum=1;
    public int number(int n)
    {
        this.n=n;
        
        if(n==0)
        {
        	sum*=n;
        	return sum;
        }
        
        else
        {
	        for(int i=1;i<=n;i++)
	        {
	            sum=sum*i;
	        }
	        
	        return sum;
	    }
    }
}

public class Practical_31 
{
	public static void main(String[] args) 
	{  
	   Scanner sc=new Scanner(System.in);
	   int n;
	   System.out.println("enter any integer number:");
	   n=sc.nextInt();
	   
	   Factorial f1=new Factorial();
	   System.out.println("Factorial of entered number is:"+f1.number(n));
	    
}
}
