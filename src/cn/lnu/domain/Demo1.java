package cn.lnu.domain;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		String s = "";
		Scanner scanner = new Scanner(System.in);
		s = scanner.nextLine();
		s = Reverse(s.toCharArray());
		String[] str = s.split(" ");
		String temp = "";
		temp = ReverseWords(str);
		System.out.println(temp);
	}

	private static String ReverseWords(String[] str) {
		String temp="";
		for (int i = 0; i < str.length; i++) {
			str[i] = Reverse(str[i].toCharArray());
			if (i < str.length - 1) {
				temp += str[i] + " ";
			} else {
				temp += str[i];
			}
		}
		return temp;
	}

		private static String Reverse(char[] a) {
			// TODO Auto-generated method stub
			int n=a.length;
			for(int i=0;i<n/2;i++){
				char ch=a[i];
				a[i]=a[n-i-1];
				a[n-i-1]=ch;
			}
			return new String(a);
		}
}
