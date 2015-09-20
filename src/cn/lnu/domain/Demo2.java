package cn.lnu.domain;

public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={88,677,88,677,499,499,-17,5262,-17,5262,88};
		int hash[]=new int[256];
		int flag[]=new int[a.length];
		hashArray(a, hash, flag);
		int num= getAppearThreeNumber(a, hash,flag);
		System.out.println("数组中出现3次的数字是："+num);
	}
	//将数组中的每个元素都预处理为正整数，并数组中的每个元素处理到0~256之间，记录元素之前的数学符号
	private static void hashArray(int[] a, int[] hash, int[] flag) {
		for(int i=0;i<flag.length;i++){
			flag[i]=1;
		}
		for(int i=0;i<a.length;i++){
				if(a[i]<0){
					a[i]=-a[i];
					flag[i]=-1;
				}
			int index=a[i]%256;
			hash[index]++;
		}
	}

	private static int getAppearThreeNumber(int[] a, int[] hash,int[] flag) {
		for(int i=0;i<a.length;i++){
			int index=a[i]%256;
			if(hash[index]==3){
				return flag[i]*a[i];
			}
		}
		return 0;
	}
}
