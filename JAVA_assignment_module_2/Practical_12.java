package JAVA_assignment_module_2;
/*
 *  W.A.J.P to print number between 1 to 100 which are divisible by 3,5 and by both
 *----------------------------------------------------------------------------------
 */
public class Practical_12 
{
	public static void main(String[] args)
	{
	
		int i;
		for(i=1;i<=100;i++)
		{
			if(i%3==0 && i%5==0)
			{
				System.out.println(i+" number is divisible by both 3 and 5");
			}
			else if(i%3==0)
			{
				System.out.println(i+" number is divisible by 3");
			}
			else if(i%5==0)
			{
				System.out.println(i+" number is divisibe by 5");
			}
			
		}
	}

}
