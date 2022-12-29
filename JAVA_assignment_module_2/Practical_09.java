package JAVA_assignment_module_2;

import java.util.Scanner;

/*
 *  W.A.J.P to count the letters, space, numbers 
 *  and other characters of an input string
 *  -----------------------------------------------
 */
public class Practical_09 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int spc=0, num=0, alpha=0,splchar=0;;
		System.out.println("Enter any string:");
		String str=sc.nextLine();
		
		System.out.println("Entered String is:"+str);
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				spc++;
			}
			else if(Character.isDigit(str.charAt(i)))
			{
				num++;
			}
			else if(Character.isLetter(str.charAt(i)))
			{
				alpha++;
			}
			else 
			{
				splchar++;
			}
		}
		
		System.out.println("number of space in string is: "+spc);
		System.out.println("number of digits in string is: "+num);
		System.out.println("number of alphabets in string is: "+alpha);
		System.out.println("number of special character in string is: "+splchar);
		
	}
}
