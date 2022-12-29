/*
 * Create a class with a method that prints"This is a parent class" and 
 * its subclass with another method that prints "This is child".
 * Now, create an object for each of the class and call 1- method of parent class
 * 2- method of child class by object of child class 
 * 3- method of parent class by object of child class  
 */

package JAVA_assignment_module_2;

class ParentDemo
{
    public void showParentData()
    {
        System.out.println("This is Parent class");
    }
}
class ChildDemo extends ParentDemo
{
    public void showChildData()
    {
        System.out.println("This is Child class");
    }
}    
public class Practical_24 
{
	public static void main(String[] args)
	{
	    ParentDemo pd=new ParentDemo();
	    pd.showParentData();
	    
	    ChildDemo cd=new ChildDemo();
	    cd.showChildData();
	}
}
