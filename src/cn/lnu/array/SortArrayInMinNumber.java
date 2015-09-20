package cn.lnu.array;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayInMinNumber {

	/**
	 * �������ų���С����
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={3,32,321};
		String s[]=new String[a.length];
		s=IntToString(a);
		String minString=sortArrayInMinNumber(s);
		System.out.println("�����ųɵ���С���ǣ�"+minString);
		
	}
	//ʹ��Arrays���������ʵ������������дComparator�ӿڣ�ʵ��compare�����Ƚ�mn��nm��С
	 public static String sortArrayInMinNumber(String[] strs){  
	        Arrays.sort(strs,new Comparator<String>(){  
	            public int compare(String s1, String s2) {  
	                return (s1+s2).compareTo(s2+s1);  
	            }  
	        });  
	        StringBuffer sb=new StringBuffer();  
	        for(String str:strs){  
	            sb.append(str);  
	        }  
	        return sb.toString();  
	    }  
	    //����������ת��Ϊ�ַ�������   
	    public static String[] IntToString(int[] a){  
	        int len=a.length;  
	        String[] strs=new String[len];  
	        for(int i=0;i<len;i++){  
	            strs[i]=""+a[i];  
	        }  
	        return strs;  
	    } 
}
