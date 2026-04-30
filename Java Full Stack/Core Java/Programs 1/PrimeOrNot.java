import java.util.Scanner;
public class PrimeOrNot{
public static void main(String args[]){
int n,flag=0;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the value of n");
n=sc.nextInt();
for(int i=2;i<n;i++)
if(n%i==0){
flag=1;
break;
}
if(flag==0)
System.out.println(n+" is a prime number");
else
System.out.println(n+" is not a prime number");
}}