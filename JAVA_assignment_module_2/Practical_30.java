package JAVA_assignment_module_2;

/*
 * We have to calculate the percentage of marks obtained in three subjects (each out of 100) by student A and in four subjects (each out of 100) by student B. 
 * Create an abstract class 'Marks' with an abstract method 'getPercentage'.
 * It is inherited by two other classes 'A' and 'B' each having a method with the same name which returns the percentage of the students.
 * The constructor of student A takes the marks in three subjects as its parameters and 
 * the marks in four subjects as its parameters for student B.
 * Create an object for each of the two classes and print the percentage of marks for both the students. 
 */
abstract class Marks
{
    public abstract double getPercentage();
}

class StudentA extends Marks
{
    int s1,s2,s3;
    double per,total;
    public StudentA(int s1,int s2, int s3)
    {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }
    
    public double getPercentage()
    {
        total=s1+s2+s3;
        per=total/3;
        return per;
        
    }
}


class StudentB extends Marks
{
    int s1,s2,s3,s4;
    double per,total;
    public StudentB(int s1,int s2, int s3,int s4)
    {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
    }
    
    public double getPercentage()
    {
        total=s1+s2+s3+s4;
        per=total/4;
        return per;
        
    }
}

public class Practical_30
{

	public static void main(String[] args)
	{
	    StudentA a1=new StudentA(50,60,70);
	    System.out.println("percentage of Student A:"+a1.getPercentage());
	    
	    StudentB a2=new StudentB(60,40,80,90);
	    System.out.println("percentage of Student B:"+a2.getPercentage());

	}
}
