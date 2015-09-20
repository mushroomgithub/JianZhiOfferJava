package cn.lnu.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(s.hasNext()){
			double x=s.nextDouble();
			double d=funtion(x);
			DecimalFormat df=new DecimalFormat(".00");
			String st=df.format(d);
			System.out.println(st);
		}
		
	}

	private static double funtion(double x) {
		double r=Math.abs(x);
		return r;
	}
}
