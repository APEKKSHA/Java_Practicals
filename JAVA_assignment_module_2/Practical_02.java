package JAVA_assignment_module_2;
/*
 * W.A.J.P that takes the user to provide a single character from the alphabet.
 * print vowel,consonant depending on the user input.
 * if the user input is not a letter(between a to z and A to Z)
 * or is a string of length> 1, print an error
 * ----------------------------------------------------------------------------
 */
public class Practical_02
{
	public static void main(String[] args)
	{
		char a='1';
		
		if(a>=97 || a<=122)
		{
			System.out.println("given letter is in lower case");
			
			if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u')
			{
				System.out.println("given letter is vowel");
			}
			else
			{
				System.out.println("given letter is consonant");
			}
		}
		else if(a>=65 || a<=90)
		{
			System.out.println("given letter is in upper case");
		
			if(a=='A' || a=='E' || a=='I' || a=='O' || a=='U')
			{
				System.out.println("given letter is vowel");
			}
			else
			{
				System.out.println("given letter is consonant");
			}
		}
		else 
		{
			System.out.println("Given input is Invalid");
		}
	}
}
