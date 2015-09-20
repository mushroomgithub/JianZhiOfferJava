package cn.lnu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class CharSquenceSort {
	/**
	 * 已知字母序列【d, g, e, c, f, b, o, a】，请实现一个函数针对输入的一组字符串 input[] = {"bed", "dog",
	 * "dear", "eye"}， 按照字母顺序排序并打印。本例的输出顺序为：dear, dog, eye, bed。
	 * 
	 * 思路：
	 * 使用hashmap实现对给定字母序列排列先后顺序，使用TreeSet与Comparator，并重写Comparator接口的compare函数，
	 * 实现再向TreeSet存放字符串的时候，按照hashMap的键值对中值的大小先后顺序排列字符串，值越小越排列在前面
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dgecfboa";// 给定的字符序列
		String input[] = { "bed", "dog", "dear", "eye" };
		char s[] = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length; i++) {
			// 根据给定字母序列，将其存入map集合，key保存字母序列中的一个字符，value的大小表示该字符在字母序列出现的先后，
			// 值越小，说明越靠前排列
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
					if (map.get(c1[i]) < map.get(c2[j])) { // 返回-1，说明以c1[i]开头的字符串应该排在以c2[j]开头的字符串之前
						return -1;
					} else if (map.get(c1[i]) > map.get(c2[j])) { // 返回1，说明以c1[i]开头的字符串应该排在以c2[j]开头的字符串之后
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