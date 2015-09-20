package cn.lnu.string.Test;
/*
 * �ҳ����ڿ��ɹ������ۣ�����ӡ���ܵĹ��ؼ���
 * */

public class Test6 {

	public static void main(String[] args) {
		String[] keyWords = { "�����ַ", "���۵绰", "����" };
		String[] text = { "��ҾƵ��Լ۱ȸߣ��ṩ������������� ��de��  ַ��XXXXX",
				"��ҾƵ��Լ۱ȸߣ��ṩ������������� ���  ַ��XXXXX������    �绰��XXXXXX",
				"��ҾƵ��Լ۱ȸߣ��ṩ�����������", "��ҾƵ��Լ۱ȸ�",
				"��ҾƵ��Լ۱ȸ�,�ṩ�����������,�����ַ��xxxx,���� �绰��1241414534"};
		function(text, keyWords);
	}

	private static void function(String[] text, String[] keyWords) {
		for (int i = 0; i < text.length; i++) {
			char[] c = text[i].toCharArray();
			int left = 0;
			int right = 0;
			String re = "";
			StringBuffer sb = new StringBuffer();
			while (right < c.length) {
				if ((re = isContains(c, left, right, keyWords)) != null) {//�ҵ��������ɹؼ��ֵ��Ӵ�
					char[] s=re.toCharArray();
					while (c[left] != s[0])	left++;//�ҵ������ؼ����Ӵ��Ŀ�ʼλ��	
					while (c[right] != s[s.length-1])	right--;//�ҵ������ؼ����Ӵ��Ľ���λ��
						
					if (left != right) {//�ݴ���ɹؼ��֣������ո�
						sb.append("\"");
						for (int k = left; k <= right; k++) 
							sb.append(c[k]);
						sb.append("\"    ");
					}
					left = right + 1;//��λ��һ�����ɹؼ��ֵĳ�ʼ��ʼλ��
				}
				right++;
			}
			if (sb.length() != 0) {
				System.out.println(text[i]);
				System.out.println(sb.toString());
				sb.delete(0, sb.length() - 1);
			}
		}
	}
	//���ݲ�ѯ�Ӵ����ж��Ӵ��Ƿ�������ɹ���
	private static String isContains(char[] c, int left, int right, String[] keyWords) {
		StringBuffer sb = new StringBuffer();
		for (int k = left; k <= right; k++) {
			if (c[k] != ' ')
				sb.append(c[k]);
		}
		String temp = sb.toString();
		for (int k = 0; k < keyWords.length; k++) {
			if (temp.contains(keyWords[k])) 
				return keyWords[k];
		}
		return null;
	}
}