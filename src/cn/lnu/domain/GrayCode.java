package cn.lnu.domain;

import java.util.Arrays;

public class GrayCode {

	/**
	 * ��һ�����ı����У��������������ڵĴ���ֻ��һλ����������ͬ��������ֱ���
	 * Ϊ������(Gray Code)�����дһ��������ʹ�õݹ鷽������Nλ�ĸ����룬���ұ�֤���
	 * �����Ľ�׳�ԡ�
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
