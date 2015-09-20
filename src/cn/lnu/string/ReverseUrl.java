package cn.lnu.string;

public class ReverseUrl {

	/**
	 * 翻转域名如ww.baidu.com翻转之后变为com.baidu.www
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="www.baidu.com";
		str=reverseUrl(str);
		System.out.println(str);
	}

	private static String reverseUrl(String str) {
		str=Rerverse(str);
		String s[]=str.split("\\.");
		String temp="";
		for(int i=0;i<s.length;i++){
			if(i<s.length-1){
				temp+=Rerverse(s[i])+".";
			}else{
				temp+=Rerverse(s[i]);
			}
		}
		return temp;
	}

	private static String Rerverse(String str) {
		char s[]=str.toCharArray();
		for(int i=0;i<s.length/2;i++){
			char temp=s[i];
			s[i]=s[s.length-i-1];
			s[s.length-i-1]=temp;
		}
		return new String(s);
	}
}
