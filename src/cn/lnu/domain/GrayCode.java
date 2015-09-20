package cn.lnu.domain;

import java.util.Arrays;

public class GrayCode {

	/**
	 * 有一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码
	 * 为格雷码(Gray Code)，请编写一个函数，使用递归方法生产N位的格雷码，并且保证这个
	 * 函数的健壮性。
	 * @param args
	 */
	public static void main(String[] args) {
		String[] res=GrayCode(5);
		System.out.println(Arrays.toString(res));
	}
	public static String[] GrayCode(int n) {  
	    // produce 2^n grade codes  
	    String[] graycode = new String[(int) Math.pow(2, n)];  
	    if (n == 1) {  
	        graycode[0] = "0";  
	        graycode[1] = "1";  
	        return graycode;  
	    }  
	    String[] last = GrayCode(n - 1);  
	    for (int i = 0; i < last.length; i++) {  
	        graycode[i] = "0" + last[i];  
	        graycode[graycode.length - 1 - i] = "1" + last[i];  
	    }  
	    return graycode;  
	}
}
