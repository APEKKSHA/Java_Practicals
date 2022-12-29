package JAVA_assignment_module_2;
/*
 * create a class named 'Member' having the following members:
 * 1. Data members
 * 2. Name
 * 3. Age
 * 4. Phone number
 * 5. Address 
 * 6. Salary
 * 
 * It also has a method named 'PrintSalary' which prints the salary of the member
 */

class Member
{
	int mage,msalary;
	long mph;
	String mname,madd,msal;
	
	public void dataMember(int mage,int msalary,long mph,String mname,String madd)
	{
		this.mname=mname;
		this.mage=mage;
		this.mph=mph;
		this.madd=madd;
		this.msalary=msalary;
		
	}
	public void printSalary()
	{
		System.out.println("name:"+mname);
		System.out.println("age:"+mage);
		System.out.println("address:"+madd);
		System.out.println("phone number:"+mph);
		System.out.println("salary:"+msalary);
		
	}
}
public class Practical_25
{
	public static void main(String[] args) 
	{
		Member m1=new Member();
		m1.dataMember(22, 12345, 9876543210l, "apeksha", "ahmedabad");
		m1.printSalary();   
		
	}
}
