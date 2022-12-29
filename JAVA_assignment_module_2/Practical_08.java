package JAVA_assignment_module_2;
/*
 * W.A.J.P that reads a positive integer 
 * and count the number of digits in the number
 * ex:
 * input and integer number less than ten billion:12345
 * Number of digits in the number:6
 * -------------------------------------------------------
 */
public class Practical_08 
{	
	public static void main(String[] args)
	{
		int n=-1234;
		int r,count=0;
		if(n>0)
		{
			while(n>0)
			{
				r=n%10;
				count++;
				n/=10;
			}
			System.out.println("the given number have "+count+" digits");
		}
		else
		{
			System.out.println("given number is negative");
		}
	}

}
