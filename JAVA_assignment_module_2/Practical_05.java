package JAVA_assignment_module_2;
/*
 * W.A.J.P to input 5 numbers from keyboard and 
 * find their sum and average using loop
 * ---------------------------------------------
 */
public class Practical_05 
{
	public static void main(String[] args) 
	{
		int i,total=0,avg=0;
		
		for(i=1;i<=5;i++)
		{
			total+=(i*10);
		}
		System.out.println("sum:"+total);
		avg=total/5;
		System.out.println("average:"+avg);
	}
}
