package JAVA_assignment_module_2;
/*
 * W.A.J. P to create one thread by implementing Runnable interface in Class.
 */
class ThreadDemoOne implements Runnable
{
    public void run()
    {
        System.out.println("this is thread demo one using Runnable interface:");
    }
}
public class Practical_37 
{
	public static void main(String[] args) 
	{
	ThreadDemoOne td1=new ThreadDemoOne();
	    Thread t1=new Thread(td1);
	    t1.start();
	}
}
