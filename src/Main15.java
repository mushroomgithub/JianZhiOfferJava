import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main15 {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int d=s.nextInt();
		int m=0,n=0;
		while(s.hasNextInt()){
			m=s.nextInt();
			n=s.nextInt();
			int res=function(a,b,c,d,m,n);
			System.out.println(res);
		}
	}

	private static int function(int a, int b, int c, int d, int m, int n) {
		
		return 0;
	}
}
