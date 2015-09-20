import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main1 {

	public static final double PI=3.1415927;
	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(s.hasNext()){
			double r=s.nextDouble();
			double d=function(r);
			DecimalFormat df=new DecimalFormat(".000");
			String res=df.format(d);
			System.out.println(res);
		}
	}

	private static double function(double r) {
		return (4.0/3)*PI*(r*r*r);
	}

}
