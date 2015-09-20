package cn.lnu.array;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayJJ {

	/**
	 * 给定两个数组，求两个数组的交集
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,2,3,4,5,7};
		int b[]={2,3,4,4,6,8,9};
		Set<Integer> set=getArrayJJ(a,b);
		System.out.println(set);
	}
	private static Set getArrayJJ(int[] a, int[] b) {
		Set<Integer> set=new HashSet<Integer>();
		Set<Integer> result=new HashSet<Integer>();
		for(int i=0;i<a.length;i++){
			set.add(a[i]);
		}
		for(int i=0;i<b.length;i++){
			if(set.contains(b[i])){
				result.add(b[i]);
			}
		}
		return result;
	}
}
