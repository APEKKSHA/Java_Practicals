package JAVA_assignment_module_2;

/*
 * Create an abstract class 'Parent' with a method 'message'. 
 * It has two subclasses each having a method with the same name 'message' 
 * that prints "This is first subclass" and "This is second subclass" respectively. 
 * Call the methods 'message' by creating an object for each subclass.
 */
class Parent 
{
    public void message()
    {
       System.out.println("This is Parent class");
    }
}
class SubClassOne extends Parent
{
    public void message()
    {
        
     System.out.println("This is First class");
    }
}

class SubClassTwo extends Parent
{
    public void message()
    {
        
       System.out.println("This is Second class");
    }
}                                    
public class Practical_28 
{	
    public static void main(String[] agrs)
    {
        SubClassOne s1=new SubClassOne();
        s1.message();
        
        SubClassTwo s2=new SubClassTwo();
        s2.message();
    }

}
