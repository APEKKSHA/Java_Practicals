package JAVA_assignment_module_2;
/*
 * W.A.J.P and create a class named 'Print Number' to print various numbers of different datatypes
 * by creating different methods with same name 'printn' having a parameter for each data type
 */

class PrintNumber
{
	public void printn(int n)
	{
		System.out.println("Value of int n:"+n);
	}
	
	public void printn(long n)
	{
		System.out.println("Value of long n:"+n);
	}
	
	public void printn(double n)
	{
		System.out.println("Value of double n:"+n);
	}
	
	public void printn(byte n)
	{
		System.out.println("Value of byte n:"+n);
	}
	
	public void printn(float n)
	{
		System.out.println("Value of float n:"+n);
	}
	
	public void printn(boolean n)
	{
		System.out.println("Value of boolean n:"+n);
	}
	
	public void printn(char n)
	{
		System.out.println("Value of char n:"+n);
	}
	
}
public class Practical_21 
{
	public static void main(String[] args) 
	{
		PrintNumber p1=new PrintNumber();
		p1.printn(10);//int
		p1.printn(2147483648l);//long
		p1.printn(12.2365);//double
		p1.printn((byte)128);//byte
		p1.printn(11.23f);//float
		p1.printn(false);//boolean
		p1.printn('a');//char
	}
}
