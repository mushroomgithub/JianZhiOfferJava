package cn.lnu.domain;

public class Test4 {
	public static void main(String[] args) {
		float f = 42.0f;
		float[] f1 = new float[2];
		float[] f2 = new float[2];
		float[] f3 = f1;
		long x = 42;
		f1[0] = 42.0f;
		
		System.out.println("x == f1[0] " + (x == f1[0]));
		System.out.println("f1 == f3 " + (f1 == f3));
//		System.out.println("f2 == f1[1]" + (f2 == f1[1]));
		System.out.println("f1 == f2 " + (f1 == f2));
	}

}
