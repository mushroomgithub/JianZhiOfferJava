package didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			
			int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };//ÿ��ÿ���µ�����
			int[] re = { 0, 0, 0, 0, 0, 0, 0 };//�����
			int sum = 0;
			for (int y = 1900; y <= 1900 + n - 1; y++) {
				if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {//����2��29��
					days[2] = 29;
				} else {//ƽ��28��
					days[2] = 28;
				}
				for (int m = 1; m <= 12; m++) {
					for (int d = 1; d <= days[m]; d++) {
						sum += 1;
						if (d == 13) {
							re[sum % 7]++;
						}
					}
 				}
			}
			// ��ӡ˳������ ������ ... ������
			System.out.print(re[6]);
			for (int g = 0; g < 6; g++)
				System.out.print(" " + re[g]);
			System.out.println();
		}
	}
}
