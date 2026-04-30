






import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int startElement, endElement;
        Scanner sc=new Scanner(System.in);
        startElement=sc.nextInt();
        endElement=sc.nextInt();
        ChildOne c1=new ChildOne();
        ChildTwo c2=new ChildTwo();
        System.out.println(c1.filter(startElement, endElement));
        System.out.println(c2.filter(startElement, endElement));
        
    }
}
class Parent{
    public String filter(int startElement, int endElement)
    {
        return null;
    }
}
class ChildOne extends Parent{
    public String filter(int startElement, int endElement)
    {
        int flag;
        String result="";
        for(int i=startElement;i<=endElement;i++)
        {
            flag=0;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0 && i!=1)
                result+=String.valueOf(i)+" ";
        }
        return result;
    }
}
class ChildTwo extends Parent{
    public String filter(int startElement, int endElement)
    {
        int flag,temp,r,n;
        String result="";
        for(int i=startElement;i<=endElement;i++)
        {
            flag=0;
            temp=i;
            n=0;
            while((n!=4 && n!=1) || temp!=0)
            {
                if(temp!=0){
                r=temp%10;
                n+=r*r;
                temp/=10;
                }
                else{
                    temp=n;
                    n=0;
                    r=temp%10;
                    n+=r*r;
                    temp/=10;
                }
            }
            if(n==1)
                result+=String.valueOf(i)+" ";
        }
        return result;
    }
}