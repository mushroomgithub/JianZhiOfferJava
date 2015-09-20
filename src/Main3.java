import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int num=s.nextInt();
		int a[]=new int[num];
		for(int i=0;i<num;i++){
			a[i]=s.nextInt();
		}
		function(a);
	}
	private static void function(int[] a) {
		if (a.length == 1) {//如果只有一个元素，怎最小公倍数就是其本身
			System.out.println(a[0]);
		} else {
			int min = minGongBei(a[0], a[1]);//首先前两个元素求最小公倍数
			for (int i = 2; i < a.length; i++) {
				min = minGongBei(min, a[i]);//将每次求出的最小公倍数与下一个元素求最小公倍数，当数组遍历完之后，得到就是最终的最小公倍数
			}
			System.out.println(min);
		}
	}

	// 求两个数的最大公约数
	public static int maxGongyue(int m, int n) {
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {//辗转相除法求最小公约数
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;
	}

	// 求最小公倍数
	public static int minGongBei(int m, int n) {
		return m * n / maxGongyue(m, n);
	}

}
