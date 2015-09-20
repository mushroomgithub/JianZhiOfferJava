package cn.lnu.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayBJ {

	/**
	 * 给定两个数组，如何求数组并集
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,2,3,5,7};
		int b[]={2,3,4,6,6,8,9};
		Set set=getArrayBJ(a,b);
		System.out.println(set);
	}

	private static Set getArrayBJ(int[] a, int[] b) {
		Set<Integer> set=new LinkedHashSet<Integer>();
		
		for(int i=0;i<a.length;i++){
			set.add(a[i]);
		}
		for(int i=0;i<b.length;i++){
			set.add(b[i]);
		}
		
		return set;
	}
}
