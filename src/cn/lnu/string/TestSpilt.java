package cn.lnu.string;

public class TestSpilt {

	/**
	 * 写一个函数，要求输入输入一个字符串和一个字符串长度，对该字符串进行分割
	 * 思路：在spiltString函数中根据传入的字符串长度，创建一个将要保存分割原始字符串字符串数组
	 * 求出字符串数组的长度n，遍历原始字符串，由于最后一个字符串长度未必等于CharLen，所以要分两种情况考虑；
	 * 当i<n-1时，通过subString（i*charLen,(i+1)*charLen）截取字符串保存到字符串数组的i下标中；
	 * 当i=n,时，使用subString(i*charLen）截取最后一个字符串，之后break,禁止i继续自加，否则会出现数组下标越界异常
	 */
	public static void main(String[] args) {
		String str="ashafshafjfaf";
		int charLen=4;
		String[] s1=spiltString(str,charLen);
		for(String s:s1){
			System.out.println(s);
		}
	}

	private static String[] spiltString(String str, int charLen) {
		int n=(str.length()+charLen-1)/charLen;
		String[] spiltStr=new String[n];
		
		for(int i=0;i<str.length();i++){
			if(i<n-1){
				spiltStr[i]=str.substring(i*charLen,(i+1)*charLen);
			}
			else{
				spiltStr[i]=str.substring(i*charLen);
				break;
			}	
		}
		
		return spiltStr;
	}

}
