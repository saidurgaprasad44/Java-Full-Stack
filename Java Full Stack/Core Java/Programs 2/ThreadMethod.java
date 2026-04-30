import java.io.*;
import java.lang.Thread;
class A extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			if(i==1)
			yield();
			System.out.println("from thread A:i="+i);
		}
		System.out.println("exiting from thread A");
	}
}
class B extends Thread
{
	public void run()
	{
		for(int j=1;j<=5;j++)
		{
			System.out.println("from thread B :j="+j);
			if(j==3)
			stop();
		}
		System.out.println("exiting from thread B");
	}
}
class ThreadMethod
{
	public static void main(String args[])
	{
		A a=new A();
		B b=new B();
		System.out.println("thread A started");
		a.start();
		System.out.println("thread B started");
		b.start();
		System.out.println("exiting from main");
	}
}
