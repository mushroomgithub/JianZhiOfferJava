package cn.lnu.string.Test;

import java.util.Arrays;

public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str={
				"这家酒店性价比高,提供海外代购服务,网店地址：xxxx",
				"这家酒店性价比高,提供海外代购服务,网店地 址：xxxx",
				"这家酒店性价比高,我很喜欢",
				"这家酒店性价比高,提供海外代 购服务,网店地址：xxxx",
				"这家酒店性价比高,提供海外代购服务,网店地址：xxxx,销售 电话：1341414534"
		};
		String[] filters={"网店地址","销售电话","代购"};
		function(str,filters);
	}

	private static void function(String[] strs, String[] filters) {
		for(int i=0;i<strs.length;i++){
			char[] c=strs[i].toCharArray();
			int left=0;
			int right=0;
			String temp="";
			StringBuffer sb=new StringBuffer();
			while(right<c.length){
				if((temp=isContains(c,left,right,filters))!=null){
					char[] s=temp.toCharArray();
					while(c[left]!=s[0]) left++;
					while(c[right]!=s[s.length-1]) right--;
					if(left!=right){
						sb.append("[");
						for(int k=left;k<=right;k++){
							sb.append(c[k]);
						}
						sb.append("]    ");
					}
					left=right+1;
				}
				right++;	
			}
			if(sb.length()!=0){
				System.out.println(strs[i]);
				System.out.println(sb.toString());
				sb.delete(0, sb.length()-1);
			}
		}
	}	
		
	private static String isContains(char[] c, int left, int right,String[] filters) {
		StringBuffer sb=new StringBuffer();
		for(int i=left;i<=right;i++){
			if(c[i]!=' ')
				sb.append(c[i]);
		}
		String temp=sb.toString();
		for(int i=0;i<filters.length;i++){
			if(temp.contains(filters[i])){
				return filters[i];
			}
		}
		return null;
	}
}
