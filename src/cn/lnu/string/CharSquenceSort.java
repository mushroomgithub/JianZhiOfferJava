package cn.lnu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class CharSquenceSort {
	/**
	 * ��֪��ĸ���С�d, g, e, c, f, b, o, a������ʵ��һ��������������һ���ַ��� input[] = {"bed", "dog",
	 * "dear", "eye"}�� ������ĸ˳�����򲢴�ӡ�����������˳��Ϊ��dear, dog, eye, bed��
	 * 
	 * ˼·��
	 * ʹ��hashmapʵ�ֶԸ�����ĸ���������Ⱥ�˳��ʹ��TreeSet��Comparator������дComparator�ӿڵ�compare������
	 * ʵ������TreeSet����ַ�����ʱ�򣬰���hashMap�ļ�ֵ����ֵ�Ĵ�С�Ⱥ�˳�������ַ�����ֵԽСԽ������ǰ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dgecfboa";// �������ַ�����
		String input[] = { "bed", "dog", "dear", "eye" };
		char s[] = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length; i++) {
			// ���ݸ�����ĸ���У��������map���ϣ�key������ĸ�����е�һ���ַ���value�Ĵ�С��ʾ���ַ�����ĸ���г��ֵ��Ⱥ�
			// ֵԽС��˵��Խ��ǰ����
			map.put(s[i], i + 1);
		}
		input = charSquenceSort(input, map);
		for (String s1 : input) {
			System.out.print(s1 + " ");
		}
	}

	private static String[] charSquenceSort(String[] input,final Map<Character, Integer> map) {
		TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				char c1[] = s1.toCharArray();
				char c2[] = s2.toCharArray();
				int len1 = c1.length;
				int len2 = c2.length;
				int i, j;
				i = j = 0;
				while (i < len1 && j < len2) {
					if (map.get(c1[i]) < map.get(c2[j])) { // ����-1��˵����c1[i]��ͷ���ַ���Ӧ��������c2[j]��ͷ���ַ���֮ǰ
						return -1;
					} else if (map.get(c1[i]) > map.get(c2[j])) { // ����1��˵����c1[i]��ͷ���ַ���Ӧ��������c2[j]��ͷ���ַ���֮��
						return 1;
					} else {
						i++;
						j++;
					}
				}
				if (i == len1 && j == len2) {
					return 0;
				} else if (i == len1) {
					return -1;
				} else {
					return 1;
				}
			}

		});
		for (int i = 0; i < input.length; i++) {
			treeSet.add(input[i]);
		}
		input = treeSet.toArray(input);
		return input;
	}
}