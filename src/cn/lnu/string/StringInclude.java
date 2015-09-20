package cn.lnu.string;

public class StringInclude {

	/**
	 * �ַ�����������
	 * ��������һ��������ĸ��ɵ��ַ���A��������һ���ַ���B���ַ�����B����ĸ�������һЩ��
	 * ʲô���������Ĳ������С�ַ���B�����ĸ�ڴ��ַ���A�ﶼ�У����磬��������������ַ�����
	 * String 1: ABCDEFGHLMNOPQRS
	 * String 2: DCGSRQPO
	 * 
	 * ˼·������hash��ķ��������ȶԶ��ַ�������hash,�����ַ����е�ÿ���ַ���hashֵ����Ϊ1;
	 * ��¼���ַ������ַ�����Ϊcount=shortStr.length();Ȼ��Գ��ַ����е�ÿ���ַ�,�������
	 * ���ַ����ж�Ӧ�ַ���ʱ��hashֵΪ1������д������򲻴�������ʱ���ý����ַ���Ӧ��hashֵ����Ϊ0��ͬʱcount--��
	 * ��count=0��ʱ����;�˳��Գ��ַ����ı�����Ȼ���ж�count��ֵ�Ƿ�Ϊ0��Ϊ0˵�����ַ����������ַ��������ڲ�����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longStr="ABCDEFGHLMNOPQRS";
		String shortStr="DCGSRQPO";
		boolean isContain=isContains(longStr, shortStr);
		if(isContain==true){
			System.out.println("���ַ���longStr:"+longStr+"�������ַ���shortStr:"+shortStr);
		}else{
			System.out.println("���ַ���longStr:"+longStr+"���������ַ���shortStr:"+shortStr);
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
