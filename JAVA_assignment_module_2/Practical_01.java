package JAVA_assignment_module_2;
/*
 * W.A.J.P to take three numbers from the user and print the greatest number 
 *--------------------------------------------------------------------------
 */
public class Practical_01
{
	public static void main(String[] args) 
	{
		int a=-10,b=10,c=10;
		
		if(a>b && a>c)
		{
			
			System.out.println("a variable have the greatest number");
		}
		else if(b>a && b>c)
		{
			System.out.println("b varibale have the grestest number");
		}
		else if(c>a && c>b )
		{			
			System.out.println("c varibale have the grestest number");
		}
		else
		{
			System.out.println("all the variable hva the same value");
			
		}
	}

}
