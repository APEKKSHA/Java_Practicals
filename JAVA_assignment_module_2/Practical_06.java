package JAVA_assignment_module_2;
/*
 * W.A.J.P to print right angle triangle with number
 * 
 * 1
 * 12
 * 123
 * 1234
 * 12345 
 * ---------------------------------------------------
 */
public class Practical_06 
{
	public static void main(String[] args) 
	{
		for (int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}
}