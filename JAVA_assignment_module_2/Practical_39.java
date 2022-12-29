package JAVA_assignment_module_2;
/*
 *  W.A.J.P to start the same Thread twice by calling start () method twice. 
 *  Test ThreadTwice1 t1=new TestThreadTwice1(); t1.start (); t1.start (); 
 */
class ThreadThree implements Runnable
{
    public void run()
    {
        String[] city={"Ahmedabad","vadodara","Surat","Rajkot","Bhavnagar","Anand","Jamnagar","Junagadh","Navsari","Valsad"};
        
		System.out.println("Ten Cities Of Gujarat::");
		
		for(int i=0;i<10;i++)
		{
		    
		System.out.println(city[i]);
		}
    }
}
public class Practical_39 
{	public static void main(String[] args) 
	{
	    
	    ThreadThree th1=new ThreadThree();
	   
	    Thread t1=new Thread(th1);
	    t1.start();
		t1.start();
	}

}
