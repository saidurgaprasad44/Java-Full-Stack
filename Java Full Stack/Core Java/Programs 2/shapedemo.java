import java.io.*;
abstract class shape
{
	abstract void numberofsides();
}
class trapezoid extends shape
{
	void numberofsides()
	{
		System.out.println("trapezoid has four sides");
	}
}
class triangle extends shape
{
	void numberofsides()
	{
		System.out.println("triangle has three sides");
	}
}
class hexagon extends shape
{
	void numberofsides()
	{
		System.out.println("hexagon has six sides");
	}
}
class shapedemo
{
	public static void main(String args[])
	{
		trapezoid t =new trapezoid();
		triangle r =new triangle();
		hexagon h=new hexagon();
		shape s;
		s=t;
		s.numberofsides();
		s=r;
		s.numberofsides();
		s=h;
		s.numberofsides();
	}
} 
