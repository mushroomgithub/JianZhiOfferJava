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
		System.out.println("�����г���3�ε������ǣ�"+num);
	}
	//�������е�ÿ��Ԫ�ض�Ԥ����Ϊ���������������е�ÿ��Ԫ�ش���0~256֮�䣬��¼Ԫ��֮ǰ����ѧ����
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
