package JAVA_assignment_module_2;
/*
 *  W.A.J.P that accepts an integer (n) and computes the value of n+nn+nnn.
 *  ex:
 *  input number:5
 *  5+55+555
 *  ------------------------------------------------------------------------
 */
public class Practical_11 
{
	public static void main(String[] args)
	{
		int i,n=7,t;
		t=0;
		for(i=1;i<=3;i++)
		{
			t=t*10+n;
			System.out.print(t+" ");
		}
	}
}
