package cn.lnu.array;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayInMinNumber {

	/**
	 * 把数组排成最小的数
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={3,32,321};
		String s[]=new String[a.length];
		s=IntToString(a);
		String minString=sortArrayInMinNumber(s);
		System.out.println("数组排成的最小数是："+minString);
		
	}
	//使用Arrays数组帮助类实现数组排序，重写Comparator接口，实现compare函数比较mn与nm大小
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
	    //将整形数组转化为字符串数组   
	    public static String[] IntToString(int[] a){  
	        int len=a.length;  
	        String[] strs=new String[len];  
	        for(int i=0;i<len;i++){  
	            strs[i]=""+a[i];  
	        }  
	        return strs;  
	    } 
}
