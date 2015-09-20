package cn.lnu.string;

public class MaxSymmetrySubString {

	/**
	 * 获得最长对称子串
	 * 思路：
	 * 由于对称子串存在aba和abba这样的情况，所以为了统一处理，将原字符串使用插#字符的方法对其预处理；
	 * 预处理完字符串之后，使用动态规划的方法，设置maxLen,maxStart,maxEnd三个指标分别指示最长对称子串
	 * 的长度，以及该对称子串的开始下标和结束下标；然后从头遍历一遍字符串数组，采用对称轴的方法，分别求出curLen,
	 * start,end的值，这种方法是将每次遍历的字符看做是对称子串的对称轴，分别向两边扫描，指定条件不符合位置，求出
	 * curLen的值，与maxLen比较，如果小于等于maxLen不交换，否则更新maxLen，maxStart,maxEnd的值，
	 * 遍历一遍数组之后，根据maxLen，maxStart,maxEnd，求出最长对称子串。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="google";
		char[] s=str.toCharArray();
		s=insertCharToArray(s,'#');
		System.out.println("预处理之后的字符串为："+new String(s));
		String maxSymmetrySubString=getMaxSymmetrySubString(s);
		System.out.println("字符串"+str+"的最长对称子串是："+maxSymmetrySubString);
	}

	private static String getMaxSymmetrySubString(char[] s) {
		// TODO Auto-generated method stub
		if(s==null)
			return null;
		int maxLen=0;
		int maxStart=0,maxEnd=0;
		for(int i=0;i<s.length;i++){
			int start=i;
			int end=i;
			//将每次遍历的字符视为对称子串的对称轴，然后分别向两侧扫描，找到以该字符为对称轴的对称子串的开始与结束位置
			while(start>=0&&end<=s.length-1&&s[start]==s[end]){
				start--;
				end++;
			}
			int curLen=(end-1)-(start+1)+1;//因为每次扫描条件不符合时，end都多加了一次，start都多减了一次
			if(curLen>maxLen){
				maxLen=curLen;
				maxStart=start+1;
				maxEnd=end-1;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int i=maxStart;i<=maxEnd;i++){
			if(s[i]!='#'){
				sb.append(s[i]);
			}
		}
		return new String(sb);
	}

	//采用插值法预处理原始字符串数组
	private static char[] insertCharToArray(char[] s, char c) {
		// TODO Auto-generated method stub
		String temp=c+"";
		for(int i=0;i<s.length;i++){			
			temp+=s[i];
			temp+=c;
		}
		return temp.toCharArray();
	}

}
