package JAVA_assignment_module_2;

abstract class Shape
{
    public abstract int rectangleArea(int l, int b);
    public abstract int squareArea(int s);
    public abstract double circleArea(double r);
    
}

class Area extends Shape
{
    int l,b,s,ar,as;
    double r,ac;
    
    public int rectangleArea(int l, int b)
    {
        this.l=l;
        this.b=b;
        ar=l*b;
        return ar;
    }
    
    public int squareArea(int s)
    {
        this.s=s;
        as=s*s;
        return as;
    }
    
    public double circleArea(double r)
    {
        this.r=r;
        ac=3.14*r*r;
        return ac;
        
    }
}
public class Practical_32 
{
	public static void main(String[] args) {
        Area a1=new Area();
        System.out.println("Area of Rectangle:"+a1.rectangleArea(10,20));
        System.out.println("Area of Square:"+a1.squareArea(10));
        System.out.println("Area of Circle:"+a1.circleArea(22.5));
		}
}
