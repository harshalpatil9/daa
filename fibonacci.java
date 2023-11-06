import java.util.*;


public class fibonacci{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<=n;i++)
		System.out.print(fibRecursive(i)+" ");
		long end = System.currentTimeMillis();
		System.out.print("The time of Recursive function is : "+(end-start)+"ms");
		
		System.out.println("\n*********************");
		
		start = System.currentTimeMillis();
		fibNonRec(n);
		end = System.currentTimeMillis();
		System.out.print("The time of NON Recursive function is : "+(end-start)+"ms");
	}
	public static int fibRecursive(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else{
			//System.out.println(fibRecursive(n-1));
			return fibRecursive(n-1) + fibRecursive(n-2);
		}
	}
	public static void fibNonRec(int n){
		int f=0,s=1;
		int next;
		System.out.print(0+" "+1+" ");
		
		for(int i=2;i<=n;i++){
			next = f+s;
			f = s;
			s = next;
			System.out.print(next+" ");
		}
	}
}
