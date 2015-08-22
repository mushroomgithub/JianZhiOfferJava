package cn.lnu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class CharSquenceSort1 {

	/**
	 * ��֪��ĸ���С�d, g, e, c, f, b, o, a������ʵ��һ��������������һ���ַ��� input[] = {"bed", "dog", "dear", "eye"}��
	 * ������ĸ˳�����򲢴�ӡ�����������˳��Ϊ��dear, dog, eye, bed��
	 * 
	 * ˼·��
     * ʹ��hash��Ը�����ĸ���������Ⱥ�˳�򣬲�������ĸ����ǰ����ַ���hashֵС������ĸ���к����ַ���hashֵ��ֵԽС����ʾԽ����ǰ�棻
     * ֮��ʹ��ѡ������ÿ��ѡ��һ���ǰ(С)���ַ������Ƚ�ʱ�Ǹ��ݶ����compare����ʵ���ַ����ıȽϣ�����-1����ʾǰ����ַ���Ӧ����
     * ��ǰ�棬�����ո�����ĸ���У�ǰ���ַ���С�ں����ַ�����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="dgecfboa";//�������ַ�����
		String input[]={"bed","dog","dear","eye"};
		char s[]=str.toCharArray();
		int hash[]=new int[256];
		int cnt=1;
		for(int i=0;i<s.length;i++){//���ݸ�����ĸ���У����ַ������Ⱥ�˳��֮����ַ�����������Ⱥ�˳��Ƚ�
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
			if(hash[c1[i]]<hash[c2[j]]){//����-1��˵����c1[i]��ͷ���ַ���Ӧ��������c2[j]��ͷ���ַ���֮ǰ
				return -1;
			}else if(hash[c1[i]]>hash[c2[j]]){//����1��˵����c1[i]��ͷ���ַ���Ӧ��������c2[j]��ͷ���ַ���֮��
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
