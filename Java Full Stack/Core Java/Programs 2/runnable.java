import java.io.*;
class A implements runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("thread from A:="+i);
		}
		System.out.pritnln("exiting from thread A");
	}
}
class runnable
{
	public static void main(String args[])
	{
		A obj=new A();
		Thread t=new Thread(obj);
		t.start();
		System.out.println("exiting from main");
	}
}