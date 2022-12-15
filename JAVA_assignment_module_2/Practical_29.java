package JAVA_assignment_module_2;

abstract class Bank
{
    public abstract void getBalance();
}

class BankA extends Bank
{
    String amount="$100";
    public void getBalance()
    {
        System.out.println("Amount deposited in BankA :"+amount);
    }
}
class BankB extends Bank
{
    String amount="$150";
    public void getBalance()
    {
        System.out.println("Amount deposited in BankB :"+amount);
    }
    
}
class BankC extends Bank
{
    
    String amount="$200";
    public void getBalance()
    {
        System.out.println("Amount deposited in BankC :"+amount);
    }
}

public class Practical_29 
{

	public static void main(String[] args) 
	{
	    BankA b1=new BankA();
	        b1.getBalance();
	        
	    BankB b2=new BankB();
	        b2.getBalance();
	        
	    BankC b3=new BankC();
	        b3.getBalance();
	}
}
