import java.io.*;
public class operators
{
public static void main(String args[])
{
int a=10,b=20,c=0,d=35;
int f=60,g=13,h=0;
boolean k=true,l=false;
int n=10,m;
int x=10,y=20, z=0;
System.out.println("a+b="+(a+b));
System.out.println("a-b="+(a-b));
System.out.println("a*b="+(a*b));
System.out.println("b/a="+(b/a));
System.out.println("c%a="+(c%a));
System.out.println("these are arithmetic operators");
System.out.println("a==b="+(a==b));
System.out.println("a!=b="+(a!=b));
System.out.println("a>b="+(a>b));
System.out.println("c<a="+(c<a));
System.out.println("d>=a="+(d>=a));
System.out.println("d<=a="+(d<=a));
System.out.println("these are relational operators");
System.out.println("k&&l="+(k&&l));
System.out.println("k||l="+(k||l));
System.out.println("!(k&&l)="+!(k&&l));
System.out.println("these are logical operators");
h=f&g;
System.out.println("f&g="+h);
h=f|g;
System.out.println("f|g="+h);
h=f^g;
System.out.println("f^g="+h);
h=~g;
System.out.println("~g="+h);
h=f<<2;
System.out.println("f<<2="+h);
h=f>>2;
System.out.println("f>>2="+h);
h=f>>>2;
System.out.println("f>>>2="+h);
System.out.println("these are bitwise operators");
z=x+y;
System.out.println("z="+z);
z+=x;
System.out.println("z+="+z);
z&=x;
System.out.println("z&="+z);
z^=y;
System.out.println("z^="+z);
z|=y;
System.out.println("z|="+z);
z<<=2;
System.out.println("z<<=2="+z);
System.out.println("these are assignment operators");
m=(n==1)? 20:30;
System.out.println("value of m is :"+m);
m=(n==10)? 20:30;
System.out.println("value of m is :"+m);
System.out.println("these are ternary/conditional operators(?:)");
}
}
