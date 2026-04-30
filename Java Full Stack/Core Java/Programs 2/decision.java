import java.io.*;
import java.util.*;
class decision
{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int m,p,c,total;
System.out.println("enter maths marks");
m=s.nextInt();
System.out.println("enter physics marks");
p=s.nextInt();
System.out.println("enter computer marks");
c=s.nextInt();
total=m+p+c;
System.out.println("total marks="+total);
if(total<=300&&total>=250)
{
System.out.println("A grade");
}
else if(total<250&&total>=200)
{
System.out.println("B grade");
}
else if(total<200&&total>=150)
{
System.out.println("C grade");
}
else if(total<150&&total>=100)
{
System.out.println("D grade");
}
else 
{
System.out.println("he/she is failed");
}
}
}