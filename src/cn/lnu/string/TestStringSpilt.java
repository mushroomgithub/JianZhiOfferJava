package cn.lnu.string;

public class TestStringSpilt {

	/**
	 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串，
	 * 但要保证汉字不被截取半个，如“我ABC”，4，应该截取“我AB”;输入"我ABC 汉 DEF",6;
	 * 应该输出“我ABC”，而不是“我ABC+汉的半个”。
	 * 
	 * 思路：在spiltString(String str, int n)函数中，定义一个变量curLen，初始化为0；
	 * 然后遍历原始字符串的每个字符，判断字符的范围，如果c<256，表示不是中文字符，curLen+=1；操作；
	 * 否则curLen进行curLen+=2操作；此时判断curLen-n==1，如果是，则说明最后一个字符是汉字，但是只有半个，不输出；
	 * 如果curLen==n则从0下标截取i个字符，还有一种情况，如果输入的字节数大于字符串总字节数数，直接返回str字符串。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="我ABC 汉 DEF";
		//System.out.println(str.getBytes().length);//字符串总字节数
		String str1="我ABC";
		String spiltStr=spiltString(str,6);
		String spiltStr1=spiltString(str1,4);
		System.out.println(spiltStr);
		System.out.println(spiltStr1);
	}

	private static String spiltString(String str, int n) {
		int curlen=0;
		for(int i=0;i<str.length();i++){
			if(curlen==n){
				return str.substring(0, i);
			}
			char c=str.charAt(i);
			if(c<256){
				curlen+=1;
			}else{
				curlen+=2;
				if(curlen-n==1){
					return str.substring(0,i);
				}
			}
		}
		return str;
	}

}
