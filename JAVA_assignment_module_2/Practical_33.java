package JAVA_assignment_module_2;
/*
 * Write a program which will ask the user to enter his/her marks (out of 100). 
 * Define a method that will display grades according to the marks 
 * entered as below: 
 * 		Marks Grade 	
 * 					91-100 AA 
 *					81-90 AB 
 * 					71-80 BB 
 *					61-70 BC 
 *					51-60 CD 
 *					41-50 DD 
 *					40 Fail
 */
import java.util.Scanner;

class StudentGrades
{
	int sci,math,eng,per;
	public void getMarks()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter english marks:");
		eng=sc.nextInt();
		System.out.println("enter math marks:");
		math=sc.nextInt();
		System.out.println("enter science marks:");
		sci=sc.nextInt();
		
	}
	public void calcGrade()
	{
		per=(eng+sci+math)/3;
		System.out.println("percentage are:"+per);
		
		if(per<=100 && per>=91)
		{
			System.out.println("A grade");
		}
		else if(per<=90 && per>=80)
		{
			System.out.println("B grade");
		}
		else if(per<=79 && per>=70)
		{
			System.out.println("C grade");
		}
		else if(per<=79 && per>=70)
		{
			System.out.println("C grade");
		}
		else if(per<=69 && per>=60)
		{
			System.out.println("D grade");
		}
		else if(per<=59 && per>=41)
		{
			System.out.println("DD grade");
		}
		else if(per<=40 )
		{
			System.out.println("Fail !!!");
		}
	}
}

public class Practical_33 
{
	public static void main(String[] args) 
	{
		StudentGrades sg1=new StudentGrades();
		sg1.getMarks();
		sg1.calcGrade();
	}
}
