package cn.lnu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class CharSquenceSort1 {

	/**
	 * 已知字母序列【d, g, e, c, f, b, o, a】，请实现一个函数针对输入的一组字符串 input[] = {"bed", "dog", "dear", "eye"}，
	 * 按照字母顺序排序并打印。本例的输出顺序为：dear, dog, eye, bed。
	 * 
	 * 思路：
     * 使用hash表对给定字母序列排列先后顺序，并且在字母序列前面的字符的hash值小于在字母序列后面字符的hash值，值越小，表示越排在前面；
     * 之后使用选择排序，每次选出一个最靠前(小)的字符串，比较时是根据定义的compare函数实现字符串的比较，返回-1，表示前面的字符串应该排
     * 在前面，即按照给定字母序列，前面字符串小于后面字符串。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="dgecfboa";//给定的字符序列
		String input[]={"bed","dog","dear","eye"};
		char s[]=str.toCharArray();
		int hash[]=new int[256];
		int cnt=1;
		for(int i=0;i<s.length;i++){//根据给定字母序列，给字符排列先后顺序，之后的字符串按照这个先后顺序比较
			hash[s[i]]=cnt++;
		}
		input=charSquenceSort(input,hash);
		for(String s1:input){
			System.out.print(s1+" ");
		}
	}

	private static String[] charSquenceSort(String[] input, int[] hash) {
		
		for(int i=0;i<input.length-1;i++){
			int minIndex=i;
			for(int j=i+1;j<input.length;j++){
				if(compare(input[j],input[minIndex],hash)==-1){
					minIndex=j;
				}
			}
			swap(input,minIndex,i);
		}
		
		return input;
	}

	private static void swap(String[] input, int i, int minIndex) {
		// TODO Auto-generated method stub
		String temp=input[i];
		input[i]=input[minIndex];
		input[minIndex]=temp;
	}

	private static int compare(String s1, String s2, int[] hash) {
		// TODO Auto-generated method stub
		char c1[]=s1.toCharArray();
		char c2[]=s2.toCharArray();
		int len1=c1.length;
		int len2=c2.length;
		int i,j;
		i=j=0;
		while(i<len1&&j<len2){
			if(hash[c1[i]]<hash[c2[j]]){//返回-1，说明以c1[i]开头的字符串应该排在以c2[j]开头的字符串之前
				return -1;
			}else if(hash[c1[i]]>hash[c2[j]]){//返回1，说明以c1[i]开头的字符串应该排在以c2[j]开头的字符串之后
				return 1;
			}else{
				i++;
				j++;
			}
		}
		
		if(i==len1&&j==len2){
			return 0;
		}else if(i==len1){
			return -1;
		}else{
			return 1;
		}
	}

}
