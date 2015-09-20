package cn.lnu.string;

/**
 * @author 03114
 * 
 *	����������У��ɲ�����������̬�滮
 *˼·��
 *����һ����������help[s1.length+1][s2.length+1],��һ�е�һ�г�ʼ��Ϊ0��
 *֮��s1��ÿ��Ԫ����s2������Ԫ�رȽϣ������ȣ���help[i][j]=help[i-1][j-1]+1;
 *���򣬾�ȥhelp[i][j]���Ͻ������½ǽϴ��һ����ֵ��help[i][j];��help��ʼ����ϣ�
 *help���½ǵ�Ԫ��һ�������ģ����ҵ�������������еĳ��ȣ�Ȼ������Ԫ�ؿ�ʼ���ϻ���
 *�������ֱ���ҵ�maxLen���ȵ������н�����
 */
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String s1 = "BDCABA";
		String s2 = "ABCBDAB";
		String re = getLCSequence(s1.toCharArray(), s2.toCharArray());
		System.out.println("LCSequence: " + re);
	}

	private static String getLCSequence(char[] c1, char[] c2) {
		// �����м�������
		int[][] help = new int[c1.length + 1][c2.length + 1];
		//��ʼ����һ��Ϊ0
		for (int i = 0; i < help.length; i++)
			help[i][0] = 0;
		//��ʼ����һ��Ϊ0
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
		// �������: ���ǿ�������ʲô����û��ʵ���ô�
		for (int i = 0; i < help.length; i++) {
			for (int j = 0; j < help[0].length; j++)
				System.out.print(help[i][j] + " ");
			System.out.println();
		}
		// ���ݾ����ҳ������������
		int i = help.length - 1;
		int j = help[0].length - 1;
		int len = help[i][j];
		char[] result = new char[len];
		while (i > 0 && j > 0) {
			if (help[i][j] == help[i - 1][j]) {//�������
				i--;
			} else if(help[i][j]==help[i][j-1]){//�������
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