package JAVA_assignment_module_2;
/*
 * W.A.J. P to create one thread by extending Thread class in another Class.
 */

class ThreaDemoTwo extends Thread
{
    public void run()
    {
        System.out.println("this is thread demo two using thread class");
    }
}
public class Practical_38 
{
	public static void main(String[] args) 
	{
	    ThreaDemoTwo td1=new ThreaDemoTwo();
	    Thread t1=new Thread(td1);
	    t1.start();
	    
	}
}
