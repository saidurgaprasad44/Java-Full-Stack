import java.util.Scanner;
public class PrimeSeries
{
	public static void main(String[] args) {
		int n,flag;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n ");
		n=sc.nextInt();
		for(int i=1;i<=n;i++){
		    flag=0;
		    for(int j=2;j<i;j++){
		        if(i%j==0){
		            flag=1;
		            break;
		        }
		    }
		    if(flag==0){
		        System.out.print(i+" ");
		    }
		}
		
	}
}