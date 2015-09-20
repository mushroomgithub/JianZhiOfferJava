package cn.lnu.array;

public class MaxContinueCommonSubString {

	/**
	 * 求给定两个字符串的最大公共子串，
	 * 如str1="ABCBDAB",str2="BCCBDAE"
	 * 则求得最大公共子串是CBDA,长度为4
	 * 思路：
	 * 创建一个m*n的help辅助数组，m=str.length+1,n=str2.length2+1,该数组用于
	 * 存放连续公共子串的长度；先初始化help数组的第一行与第一列值为0，
	 * 之后依次让str2每个元素与str1的所有元素比较，不相等的help[i][j]=0,
	 * 相等的设置help[i][j]=help[i-1][j-1]+1,在次过程中使用maxLen记录help数组中的
	 * 最大值，取得最大值时横纵坐标使用maxRow,maxCol记录；这样当help数组构建完毕，最长连续
	 * 公共子串的最大长度已经取得最大值是横纵坐标也就知道了，根据横纵坐标向左上角开始查找不为0的元素
	 * 就是最长连续子串中的其中一个元素。当左上角元素为0时，最长连续公共子串就创建出来了。
	 * @param args
	 */
	public static void main(String[] args) {
		String str1="ABCBDAB";
		String str2="BCCBDAE";
		String maxCommonStr=getMaxContinueCommonSubString(str1,str2);
		System.out.println("最长连续公共子串是："+maxCommonStr);
	}

	private static String getMaxContinueCommonSubString(String str1, String str2) {
		char s1[]=str1.toCharArray();
		char s2[]=str2.toCharArray();
		int len1=s1.length;
		int len2=s2.length;
		int [][]help=new int[len1+1][len2+1];//用于保存最大公共子串的长度
		for(int i=0;i<help.length;i++)
			help[i][0]=0;
		for(int i=0;i<help[0].length;i++)
			help[0][i]=0;
		int maxLen=help[0][0];//记录help数组中的最大值
		int maxRow=0;//记录取得help中最大值的时候，help数组的横坐标
		int maxCol=0;//记录取得help中最大值的时候，help数组的纵坐标
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				if (s1[i - 1] == s2[j - 1]){//如果当前元素s1[i-1]与s2[j-1]相等，就将help[i][j]的值设置为help左上角值+1
					help[i][j] = help[i - 1][j - 1] + 1;
				}
				else
					help[i][j] = 0;
				
				if(maxLen<help[i][j]){//更新
					maxLen=help[i][j];
					maxRow=i;
					maxCol=j;
				}
			}
			
		}
	  for(int i=0;i<help.length;i++){ 
		  for(int j=0;j<help[i].length;j++){
			  System.out.print(help[i][j]+" "); 
		  }
		  System.out.println();
	  }
	  //查找最大公共子串
	  int i=maxRow;
	  int j=maxCol;
	  int len=maxLen;
	  char result[]=new char[len];
	  while(i>0&&j>0){
		  result[--len]=s1[i-1];
		  if(help[i-1][j-1]==0){
			  break;
		  }else{
			  i--;
			  j--;
		  }
	  }
		return new String(result);
	}

}
