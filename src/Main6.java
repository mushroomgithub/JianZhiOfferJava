import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main6 {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int num=s.nextInt();
		int a,b,c,d;
		for(int i=0;i<num;i++){
			a=s.nextInt();
			b=s.nextInt();
			c=s.nextInt();
			d=s.nextInt();
			int sum=a+b+c+d;
			boolean g=function(a,b,c,d,sum);
			if(g){
				if(sum>=350){
					System.out.println("Gongfei");
				}else{
					System.out.println("Zifei");
				}
			}else{
				System.out.println("Fail");
			}
		}
		s.close();
	}

	private static boolean function(int a,int b,int c,int d,int sum) {
		boolean r=false;
		if(sum>=310&&a>=60&&b>=60&&c>=90&&d>=90){
			r=true;
		}
		return r;
	}
}
