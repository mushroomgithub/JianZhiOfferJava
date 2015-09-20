package cn.lnu.string;

public class StringEncoding {

	/**
	 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，
	 * 将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="xxxyyyyyyxxyzzzb";
		char[]s=str.toCharArray();
		String strZip=Encoding(s);
		System.out.println("压缩后："+strZip);
	}

	private static String Encoding(char[]s){
		StringBuffer sb=new StringBuffer();
		char ch=s[0];
		int count=1;
		for(int i=1;i<s.length;i++){//i==s.length时退出循环，最后判断一下循环结束后没有添加的字符
			if(ch==s[i]){
				count++;
			}else{
				if(count>1){
					sb.append(count);
				}
				sb.append(ch);
				ch=s[i];
				count=1;
			}
		}
		if(count>1)
			sb.append(count);
		sb.append(ch);
		
		return sb.toString();
	}
}
