package cn.lnu.string;

/**
 * @author 03114
 * 
 *	����������У��ɲ�����������̬�滮
 */
public class LCSequence {

	public static void main(String[] args) {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		
		String re = getLCSequence(s1.toCharArray(), s2.toCharArray());
		System.out.println("LCSequence: " + re);
	}

	private static String getLCSequence(char[] c1, char[] c2) {
		// �����м�������
		int[][] matrix = new int[c1.length + 1][c2.length + 1];
		
		for (int i = 0; i < matrix.length; i++)
			matrix[i][0] = 0;
		for (int j = 0; j < matrix[0].length; j++)
			matrix[0][j] = 0;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (c1[i - 1] == c2[j - 1])
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				else
					matrix[i][j] = (matrix[i - 1][j] > matrix[i][j - 1]) ? matrix[i - 1][j] : matrix[i][j - 1];
			}
		}
		// �������: ���ǿ�������ʲô����û��ʵ���ô�
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
		// ���ݾ����ҳ������������
		int i = matrix.length - 1;
		int j = matrix[0].length - 1;
		int len = matrix[i][j];
		char[] re = new char[len];
		while (i > 0 && j > 0) {
			if (matrix[i][j] == matrix[i - 1][j]) {
				i--;
			} else if (matrix[i][j] == matrix[i][j - 1]) {
				j--;
			} else {
				re[--len] = c1[i - 1];
				i--;
				j--;
			}
		}
		return new String(re);
	}

}