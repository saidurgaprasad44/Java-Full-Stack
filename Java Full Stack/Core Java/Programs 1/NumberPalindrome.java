import java.util.Scanner;
public class NumberPalindrome{
public static void main(String args[]){
int n,temp,r,res=0;
Scanner sc=new Scanner(System.in);
System.out.println("enter the value of n");
n=sc.nextInt();
temp=n;
while(temp!=0)
{
r=temp%10;
res=(res*10)+r;
temp=temp/10;
}
if(n==res)
System.out.println("the given number is a palindrome");
else
System.out.println("the given number is not a palindrome");
}}