package cn.lnu.string.Test;

public class Test1 {

	/**
	 * ��һ���ַ���ͨ�������ַ�������ɾ���ַ����ķ�ʽת��Ϊ��һ���������ַ�����
	 *   ɾ������n���ַ��Ĳ����Ĵ���Ϊ2��
	 *   ����n���ַ��Ĵ���Ϊn+2��
	 *   ��ת������С���ۡ�
	 *	int getmincost(char *s1, char *s2)
	 *	����:
	 *	aaabc=>bcd����Ҫ����Ϊɾ��aaa 2�����d 3
	 *	abc=>acd ɾ��b 2�����d 3
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
