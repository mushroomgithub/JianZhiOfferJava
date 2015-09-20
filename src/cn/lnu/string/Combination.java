package cn.lnu.string;

import java.util.Set;
import java.util.TreeSet;

public class Combination {

	/**
	 * �ַ������������,��ÿ��ȡ�õ���ϻ��浽һ��TreeSet�����У�ʹ��TreeSet����ȥ�ز�ʵ���ֵ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aba";
		char s[]=str.toCharArray();
		commbination(s);
	}

	private static void commbination(char[] s) {
		// TODO Auto-generated method stub
		Set<String> set=new TreeSet<String>();
		for(int i=0;i<s.length;i++){
			for(int j=i;j<s.length;j++){
				permutation(s, i, j,set);
			}
		}
		for(String s1:set){
			System.out.println(s1);
		}
	}

	private static void permutation(char[] s, int start,int end,Set<String> set) {
		// TODO Auto-generated method stub
		if(s==null)
			return;
		if(start==end){
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<=end;i++){
				sb.append(s[i]);
				set.add(sb.toString());
			}
		}else{
			for(int i=start;i<=end;i++){
					swap(s,i,start);
					permutation(s,start+1,end,set);
					swap(s,i,start);
			}
		}
	}

	private static void swap(char[] s, int i, int start) {
		// TODO Auto-generated method stub
		char temp=s[start];
		s[start]=s[i];
		s[i]=temp;
	}
}
