import java.io.*;
class room
{
	float l,w;
	room(float x,float y)
	{
		l=x;
		w=y;
	}
	float roomarea()
	{
		return(l*w);
	}
}
class classroom extends room
{
	float h;
	classroom(float x,float y,float z)
	{
		super(x,y);
		h=z;
	}
	float volume()
	{
		return(l*w*h);
	}
}
class inheri
{
	public static void main(String args[])
	{
		classroom r1=new classroom(12.2f,15.2f,10.3f);
		float area=r1.roomarea();
		float vol=r1.volume();
		System.out.println("the area of the room is"+area);
		System.out.println("the volume of the class room is"+vol);
	}
}
