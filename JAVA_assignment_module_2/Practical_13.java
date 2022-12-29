package JAVA_assignment_module_2;
/*
 * Write a Java program to display the system time. 
 */
import java.time.LocalTime;

public class Practical_13 
{
	public static void main(String[] args)
	{
	    LocalTime obj=LocalTime.now();
		System.out.println("System time:"+obj);
	}
}
