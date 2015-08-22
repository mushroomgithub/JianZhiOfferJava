package cn.lnu.string;

public class MaxNumberSquence {

	/**
	 * int maxContinuNum(const char *inputstr,char * outputstr)
	 * 编写一段程序实现该函数，实现返回一个以“\0”结束的字符串中最长的数字串的长度，并把该数字子串的首地址赋给outputstr。
	 * 不能使用任何库函数或已经存在的函数，如strlen。
	 *在字符串“abc123abcdef12345abcdefgh123456789”中，把该字符串的首地址赋给inputstr，返回9，
	 *outputstr指向字符串“123456789”的首地址。
	 *
	 *思路：
	 *使用动态规划法，设置三个变量maxLen，maxStart，maxEnd分别用于记录最长数字串的长度和开始结束位置；
	 *遍历一遍字符串，每次遍历一个字符，再设置三个临时变量curLen,start,end,分别用于记录当前以该遍历数字打头的数字串
	 *的长度，开始以及结束下标，数字串结尾时，比较curLen与maxLen的大小，如果小于等于maxLen不交换，否则交换两个的值，
	 *并且分别记录当前最长数字串的开始与结束下标，
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc123abcdef12345abcdefgh123456789";
		char s[]=str.toCharArray();
		char out[]=new char[256];
		int len=maxContinueNumSquence(s,out);
		System.out.println(len+" "+new String(out,0,len));
	}
	
	private static int maxContinueNumSquence(char[] s, char[] out) {
		if(s==null)
			return 0;
		int maxLen=0;
		int maxStart=0;
		int maxEnd=0;
		
		int i;
		for(i=0;i<s.length;i++){
			int curLen=0;
			int start=i;
			int end=i;
			if(s[i]>='0'&&s[i]<='9'){
				while(s[end]>='0'&&s[end]<='9'){
						end++;
						if(end==s.length)
							break;
				}
				curLen=(end-1)-start+1;//(end-1)是因为每次数字串结束，end都向后多移动一位
			}
			if(curLen>maxLen){
				maxLen=curLen;
				maxStart=start;
				maxEnd=end-1;
			}
			if(maxEnd>=s.length-1)
				break;
		}
		int j;
		for(i=maxStart,j=0;i<=maxEnd;i++,j++){
			out[j]=s[i];
		}
		out[j]='\0';
		return maxLen;
	}

}
