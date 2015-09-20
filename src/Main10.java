import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main10 {

	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
	}
	public static int Max2(int a[]) {  
	    int i;  
	    int MaxSum = 0;  
	    int CurSum = 0;  
	    for (i = 0; i < a.length; i++) {  
	        CurSum += a[i];  
	        if (CurSum > MaxSum)  
	            MaxSum = CurSum;  
	        if (CurSum < 0)  
	            CurSum = 0;  
	    }  
	    return MaxSum;  
	} 
}
