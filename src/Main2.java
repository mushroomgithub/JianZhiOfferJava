import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=s.nextInt();
		for(int i=0;i<n;i++){
			String str=s.next();
			int count=funtion(str.toCharArray());
			System.out.println(count);
		}
	}

	private static int funtion(char[] c) {
		if(c==null||c.length<=0)
			return 0;
		int count=0;
		for(int i=0;i<c.length;i++){
			if(c[i]>='0'&&c[i]<='9'){
				count++;
			}
		}
		return count;
	}
}
