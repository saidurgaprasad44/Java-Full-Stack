import java.io.*;
class table
{
public static void main(String args[])
{
int i,j,row=1,column=1;
int mult[][]=new int[10][10];
for(i=0;i<mult.length;i++)
{
	for(j=0;j<mult[i].length;j++)
	{
		mult[i][j]=row*column;
		column=column+1;
	}
	row=row+1;
	column=1;
} 
for(i=0;i<mult.length;i++)
{
	for(j=0;j<mult[i].length;j++)
	{
		System.out.print(+mult[i][j]"\t");
	}
	System.out.println("\n");
}
}
}
		