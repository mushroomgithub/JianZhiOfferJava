package cn.lnu.string.Test;
/*
 * 找出存在可疑广告的评论，并打印可能的广告关键词
 * */

public class Test6 {

	public static void main(String[] args) {
		String[] keyWords = { "网店地址", "销售电话", "代购" };
		String[] text = { "这家酒店性价比高，提供海外代购服务，网 店de地  址：XXXXX",
				"这家酒店性价比高，提供海外代购服务，网 店地  址：XXXXX，销售    电话：XXXXXX",
				"这家酒店性价比高，提供海外代购服务", "这家酒店性价比高",
				"这家酒店性价比高,提供海外代购服务,网店地址：xxxx,销售 电话：1241414534"};
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
				if ((re = isContains(c, left, right, keyWords)) != null) {//找到包含可疑关键字的子串
					char[] s=re.toCharArray();
					while (c[left] != s[0])	left++;//找到包含关键字子串的开始位置	
					while (c[right] != s[s.length-1])	right--;//找到包含关键字子串的结束位置
						
					if (left != right) {//暂存可疑关键字，包含空格
						sb.append("\"");
						for (int k = left; k <= right; k++) 
							sb.append(c[k]);
						sb.append("\"    ");
					}
					left = right + 1;//定位下一个可疑关键字的初始开始位置
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
	//根据查询子串，判断子串是否包含可疑广告词
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