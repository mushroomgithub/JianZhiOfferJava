package cn.lnu.string;

public class StringDecoding {

	/**
	 *给定一个字符串，如a2bc3d1，要求对字符串进行解码，解码的规则是
	 *将两个数字间（前面没有数字的情况下算开头和数字间）的字符串重复数字次数
	 *，比如a2bc3d1，解码之后的字符串为aabcbcbcd
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="a2bc3d1";
		char[]s=str.toCharArray();
		
		String strDecoding=Decoding(str.toCharArray());
		System.out.println("解码后："+strDecoding);
	}

	private static String Decoding(char[] s) {
		StringBuffer sTemp=new StringBuffer();
		StringBuffer nTemp=new StringBuffer();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length;i++){
			if(s[i]>='0'&&s[i]<='9'){
				nTemp.append(s[i]);
				//如果下一个字符不是数字或者字符串的结尾，那么就进行操作，否则数字字符继续追加到nTemp中
				if(i==s.length-1||s[i+1]<'0'||s[i+1]>'9'){
					int n=Integer.parseInt(nTemp.toString());
					for(int j=0;j<n;j++){
						sb.append(sTemp);
					}
					sTemp.delete(0, sTemp.capacity());//阶段性清空
					nTemp.delete(0, nTemp.capacity());
				}
			}else{
				sTemp.append(s[i]);
			}
		}
		
		return sb.toString();
	}
	
	private static String Decoding(String s){
		String[] sTemp=s.split("\\d+");
		String[] nTemp=s.split("\\D+");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sTemp.length;i++){
			int n=Integer.parseInt(nTemp[i+1]);
			for(int j=0;j<n;j++){
				sb.append(sTemp[i]);
			}
		}
		return sb.toString();
	}
}
