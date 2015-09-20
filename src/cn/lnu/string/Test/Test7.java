package cn.lnu.string.Test;

public class Test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="ABCDABEFAB";
		function(str.toCharArray());
	}

	private static void function(char[] a) {
		int hash[]=new int [26];
		int count=0;
		for(int i=0;i<a.length;i++){
			++hash['Z'-a[i]];
		}
		for(int i=0;i<26;i++){
			if(++count>1) System.out.print(';');
			System.out.print(('Z'-i)+"="+hash[i]);
		}
	}
	
}
