package cn.lnu.string;

public class CompareStringSet {

	/**
	 * �Ƚϸ������ַ�������{��cafe��, ��baidu��, ��duiba��,��face��, ��thisone��,��iseasy��}��
	 * �Ƿ�������������ַ��������ǰ������ַ��Լ��ַ�������ͬ������˳�򲻱���ͬ���ҵ�����ӡ������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[]={"cafe","baidu","duiba","face","thisone","iseasy","onethis"};
		compareStringSet(str);
	}

	private static void compareStringSet(String[] s) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length-1;i++){
			String temp=s[i];
			for(int j=i+1;j<s.length;j++){
				if(temp.length()==s[j].length()){
					/*char a[]=s[j].toCharArray();
					int k;
					for(k=0;k<a.length;k++){
						if(!temp.contains(a[k]+"")){
							break;
						}
					}
					if(k==a.length){
						System.out.println(temp+" "+s[j]);
					}*/
					if(isContains(temp,s[j])){
						System.out.println(temp+" "+s[j]);
					}
				}
			}
		}
	}
	private static boolean isContains(String str1, String str2) {
		int hash[]=new int[256];
		for(int i=0;i<str2.length();i++){
			hash[str2.charAt(i)]=1;
		}
		int count=str2.length();
		for(int i=0;i<str1.length();i++){
			if(hash[str1.charAt(i)]==1){
				hash[str1.charAt(i)]=0;
				count--;
				if(count==0)
					break;
			}
		}
		if(count==0)
			return true;
		else
			return false;
	}
}
