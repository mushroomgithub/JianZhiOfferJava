package cn.lnu.string.Test;

public class Test1 {

	/**
	 * 将一个字符串通过插入字符串或者删除字符串的方式转换为另一个给定的字符串。
	 *   删除连续n个字符的操作的代价为2，
	 *   插入n个字符的代价为n+2。
	 *   求转换的最小代价。
	 *	int getmincost(char *s1, char *s2)
	 *	例子:
	 *	aaabc=>bcd所需要代价为删除aaa 2，添加d 3
	 *	abc=>acd 删除b 2，添加d 3
	 * @param args
	 */
	public static void main(String[] args) {
		/*String s1="aaabc";
		String s2="bcd";*/
		/*String s1="abc";
		String s2="acd";*/
		/*String s1="fafbsf";
		String s2="safbcf";*/
		String s1="fafbsf";
		String s2="safbcf";
		int minCost=getMinCost(s1.toCharArray(),s2.toCharArray());
		System.out.println(minCost);
	}

	private static int getMinCost(char[] s1, char[] s2) {
		int i=0,j=0;
		int cost=0;
		int insert=0;
		int delete=0;
		while(i<s1.length&&j<s2.length){
			if(s1[i]!=s2[j]){
				delete++;
				i++;
			}else{
				i++;
				j++;
				if(delete>0)
					cost+=2;
				delete=0;
			}
		}
		if(i<s1.length){
			return cost;
		}
		if(j<s2.length){
			insert=s2.length-j;
			cost+=(insert+2);
		}
		return cost;
	}

}
