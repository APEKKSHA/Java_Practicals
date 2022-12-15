package JAVA_assignment_module_2;
import java.util.Scanner;
class Factorial
{
    int n,sum=1;
    public int number(int n)
    {
        this.n=n;
        
        for(int i=1;i<=n;i++)
        {
            sum=sum*i;
        }
        
        return sum;
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
