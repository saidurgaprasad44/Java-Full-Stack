import java.io.*;
class overload
{
	double area(float l,float w,float h)
	{
		return l*w*h;
	}
	double area(float l)
	{
		return l*l*l;
	}
	double area(float r,float h)
	{
		return 3.1416*r*r*h;
	}
}
class overloading
{
public static void main(String args[])
{
overload ovl=new overload();
double rectangleBox=ovl.area(4,7,3);
System.out.println("area of rectangle box is"+rectangleBox);
double cube=ovl.area(5);
System.out.println("area of cube is"+cube);
double cylinder=ovl.area(3,6);
System.out.println("area of cylinder"+cylinder);
}
}
