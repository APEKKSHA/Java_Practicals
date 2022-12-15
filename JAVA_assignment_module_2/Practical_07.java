package JAVA_assignment_module_2;
/*
 * W.A.J.P to print right angle triangle with number increased by 1
 * 
 * 1
 * 23
 * 456
 * 78910
 * -------------------------------------------------------------------
 */
public class Practical_07
{
	public static void main(String[] args)
	{
		int x=1;
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(x+" ");
				x++;
			}
			System.out.println();
		}
	}
	
}
