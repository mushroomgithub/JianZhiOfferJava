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
		if (a.length == 1) {//���ֻ��һ��Ԫ�أ�����С�����������䱾��
			System.out.println(a[0]);
		} else {
			int min = minGongBei(a[0], a[1]);//����ǰ����Ԫ������С������
			for (int i = 2; i < a.length; i++) {
				min = minGongBei(min, a[i]);//��ÿ���������С����������һ��Ԫ������С�������������������֮�󣬵õ��������յ���С������
			}
			System.out.println(min);
		}
	}

	// �������������Լ��
	public static int maxGongyue(int m, int n) {
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {//շת���������С��Լ��
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;
	}

	// ����С������
	public static int minGongBei(int m, int n) {
		return m * n / maxGongyue(m, n);
	}

}
