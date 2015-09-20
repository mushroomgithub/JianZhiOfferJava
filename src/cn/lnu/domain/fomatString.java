package cn.lnu.domain;

public class fomatString {

	/**
	 * 去除一个字符串首尾空格，并且多个空格只保留一个
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=" I love   meituan  ";
		String res=str.trim().replaceAll("\\s+", " ");
		System.out.println(res+" "+res.length());
		String result=doSometing(str);
		System.out.println(result+" "+result.length());
	}
	
	private static String doSometing(String s){
		if(s==null)
			return null;
		int i=0;
		char c[]=s.trim().toCharArray();
		StringBuffer sb=new StringBuffer();
		int count=0;
		while(i<c.length&&c[i]!='\0'){
			if(c[i]!=' '){
				count=0;
				sb.append(c[i]);
			}else{
				count++;
				if(count==1){					
					sb.append(' ');
				}
			}
			i++;
		}
		return sb.toString();
	}
}
