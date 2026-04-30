import java.util.Scanner;
public class Palindrome{
public static void main(String args[]){
String s, temp="";
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string");
s=sc.next();
int n=s.length();
for(int i=n-1;i>=0;i--)
temp=temp+s.charAt(i);
if(temp.equals(s))
System.out.println("the given string is a palindrome");
else
System.out.println("the given string is not a palindrome");
}
}