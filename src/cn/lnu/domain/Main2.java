package cn.lnu.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		st.nextToken();
		int n = (int) st.nval;
		for (int i = 0; i < n; i++) {
			st.nextToken();
			int m = (int) st.nval;
			int[] a = new int[m];
			for (int j = 0; j < m; j++) {
				st.nextToken();
				a[j] = (int) st.nval;
			}
			System.out.println("Case " + (i + 1) + ":");
			function(a);
			if (i < n - 1)
				System.out.println();
		}
	}

	private static void function(int[] a) {
		int thisSum = 0;
		int sum = a[0];
		int best_i = 0;
		int best_j = 0;
		int i = 0;
		for (int j = 0; j < a.length; j++) {
			thisSum += a[j];
			if (thisSum > sum) {
				sum = thisSum;
				best_i = i;
				best_j = j;
			}
			if (thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}
		System.out.println(sum + " " + (best_i + 1) + " " + (best_j + 1));
	}

}
