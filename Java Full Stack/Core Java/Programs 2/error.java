import java.io.*;
class error
{
	public static void main(String args[])
	{
		int a=10,b=5,c=5,x,y;
		try
		{
			x=a/(b-c);
			System.out.println("x="+x);
		}
		catch(ArithmeticException e)
		{
			System.out.println("division by zero error occured");
		}
		y=a/(b+c);
		System.out.println("y="+y);
	}
}