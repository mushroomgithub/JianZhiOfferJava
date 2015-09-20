package cn.lnu.string.Test;

import java.util.Arrays;

public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str={
				"��ҾƵ��Լ۱ȸ�,�ṩ�����������,�����ַ��xxxx",
				"��ҾƵ��Լ۱ȸ�,�ṩ�����������,����� ַ��xxxx",
				"��ҾƵ��Լ۱ȸ�,�Һ�ϲ��",
				"��ҾƵ��Լ۱ȸ�,�ṩ����� ������,�����ַ��xxxx",
				"��ҾƵ��Լ۱ȸ�,�ṩ�����������,�����ַ��xxxx,���� �绰��1341414534"
		};
		String[] filters={"�����ַ","���۵绰","����"};
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
