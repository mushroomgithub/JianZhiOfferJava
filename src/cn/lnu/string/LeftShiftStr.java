package cn.lnu.string;

public class LeftShiftStr {

	/**
	 * 实现将一个字符串左移动n位
	 * 经典三翻转，首先翻转前n为，之后翻转后面的len-n个字符
	 * 最后做一次全部字符串的翻转
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdefgh";
		char s[]=str.toCharArray();
		int n=2;
		leftShiftStr(s,n);
	}

	private static void leftShiftStr(char[] s,int n) {
		Reverse(s,0,n-1);
		Reverse(s,n,s.length-1);
		Reverse(s,0,s.length-1);
		
		System.out.println(s);
	}

	private static void Reverse(char[] s, int start, int end) {
		if(s==null)
			return;
		while(start<end){
			char temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;
		}
	}

}
