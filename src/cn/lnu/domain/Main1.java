package cn.lnu.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		while (s.hasNext()) {
			Point pt1 = new Point(s.nextDouble(), s.nextDouble());
			Point pt2 = new Point(s.nextDouble(), s.nextDouble());
			double len = pt1.getLen(pt2);
			System.out.printf("%.2f",len);
			System.out.println();
		}
	}

}
class Point{
	double x;
	double y;
	public Point(){
		
	}
	public Point(double x,double y){
		this.x=x;
		this.y=y;
	}
	public double getLen(Point pt){
		double b=(pt.x-x)*(pt.x-x)+(pt.y-y)*(pt.y-y);
		return Math.sqrt(b);
	}
}