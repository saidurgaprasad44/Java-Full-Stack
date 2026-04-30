import java.util.*;
public class Fibonacci
{
	public static void main(String[] args) {
		int t1=0,t2=1,n,i=2,temp;
		Scanner s=new Scanner(System.in);
	    n=s.nextInt();
	    System.out.print(t1+","+t2);
		while(i<n){
		    temp=t1+t2;
		    t1=t2;
		    t2=temp;
		    i++;
		    System.out.print(","+t2);
		}
	}
}
