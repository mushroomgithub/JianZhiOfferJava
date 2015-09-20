import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		int d=function(a);
		System.out.println(d);
	}

	private static int function(int[] a) {
		if(a==null||a.length<=0)
			return 0;
		int max=a[1]=a[0];
		for(int i=1;i<a.length-1;i++){
			max=Math.max(a[i+1]-a[i], max);
		}
		return max;
	}
}
