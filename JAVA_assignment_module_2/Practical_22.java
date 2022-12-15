package JAVA_assignment_module_2;
/*
 * Create a class to print an integer and a character with two methods 
 * having the same name but different sequence of the integer and the character parameters.
 */

class Differentsequence
{
	public void sequence(int a, char b)
	{
		System.out.println("In the first sequence integer value:"+a+" and character:"+b);
	}
	public void sequence(char a, int b)
	{
		System.out.println("In the second sequence integer value:"+a+" and character:"+b);
	}
}

public class Practical_22
{
	public static void main(String[] args) 
	{
		Differentsequence ds1=new Differentsequence();
		ds1.sequence(10, 'a');
		ds1.sequence('A', 20);
	}
}
