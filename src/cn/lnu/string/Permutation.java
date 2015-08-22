package cn.lnu.string;

public class Permutation {

	/**
	 * 字符串全排列（具有去重功能）
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		char s[]=str.toCharArray();
		permutation(s,0,s.length-1);
	}

	private static void permutation(char[] s, int start,int end) {
		// TODO Auto-generated method stub
		if(s==null)
			return;
		if(start==end){
			for(int i=0;i<=end;i++)
				System.out.print(s[i]);
			System.out.println();
		}else{
			for(int i=start;i<=end;i++){
				if(isSwap(s,start,i)){//从第一个字符起分别与它后面非重复出现的字符交换
					swap(s,i,start);
					permutation(s,start+1,end);
					swap(s,i,start);
				}
				
			}
		}
	}

	//判断start，end区间的字符是否存在重复字符，有返回false，没有返回true
	private static boolean isSwap(char[] s, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=start;i<end;i++){
			if(s[i]==s[end]){
				return false;
			}
		}
		return true;
	}

	private static void swap(char[] s, int i, int start) {
		// TODO Auto-generated method stub
		char temp=s[start];
		s[start]=s[i];
		s[i]=temp;
	}

}
