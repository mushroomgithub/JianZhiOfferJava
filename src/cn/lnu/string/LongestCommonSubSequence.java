package cn.lnu.string;

/**
 * @author 03114
 * 
 *	最长公共子序列（可不连续）：动态规划
 *思路：
 *构建一个辅助矩阵help[s1.length+1][s2.length+1],第一行第一列初始化为0，
 *之后将s1的每个元素与s2的所有元素比较，如果相等，则help[i][j]=help[i-1][j-1]+1;
 *否则，就去help[i][j]左上角与右下角较大的一个赋值给help[i][j];当help初始化完毕，
 *help右下角的元素一定是最大的，并且等于最长公共子序列的长度，然后从这个元素开始向上或者
 *向左查找直到找到maxLen长度的子序列结束。
 */
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String s1 = "BDCABA";
		String s2 = "ABCBDAB";
		String re = getLCSequence(s1.toCharArray(), s2.toCharArray());
		System.out.println("LCSequence: " + re);
	}

	private static String getLCSequence(char[] c1, char[] c2) {
		// 构造中间结果矩阵
		int[][] help = new int[c1.length + 1][c2.length + 1];
		//初始化第一列为0
		for (int i = 0; i < help.length; i++)
			help[i][0] = 0;
		//初始化第一行为0
		for (int j = 0; j < help[0].length; j++)
			help[0][j] = 0;
		
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				if (c1[i - 1] == c2[j - 1])
					help[i][j] = help[i - 1][j - 1] + 1;
				else
					help[i][j] = (help[i - 1][j] > help[i][j - 1]) ? help[i - 1][j] : help[i][j - 1];
			}
		}
		// 输出矩阵: 就是看看矩阵什么样，没有实际用处
		for (int i = 0; i < help.length; i++) {
			for (int j = 0; j < help[0].length; j++)
				System.out.print(help[i][j] + " ");
			System.out.println();
		}
		// 根据矩阵找出最长公共子序列
		int i = help.length - 1;
		int j = help[0].length - 1;
		int len = help[i][j];
		char[] result = new char[len];
		while (i > 0 && j > 0) {
			if (help[i][j] == help[i - 1][j]) {//纵向查找
				i--;
			} else if(help[i][j]==help[i][j-1]){//横向查找
				j--;
			}else {
				result[--len] = c1[i - 1];
				i--;
				j--;
			}
		}
		return new String(result);
	}
}