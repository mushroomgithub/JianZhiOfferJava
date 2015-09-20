package cn.lnu.string;

public class TestStringSpilt {

	/**
	 * ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ�����
	 * ��Ҫ��֤���ֲ�����ȡ������硰��ABC����4��Ӧ�ý�ȡ����AB��;����"��ABC �� DEF",6;
	 * Ӧ���������ABC���������ǡ���ABC+���İ������
	 * 
	 * ˼·����spiltString(String str, int n)�����У�����һ������curLen����ʼ��Ϊ0��
	 * Ȼ�����ԭʼ�ַ�����ÿ���ַ����ж��ַ��ķ�Χ�����c<256����ʾ���������ַ���curLen+=1��������
	 * ����curLen����curLen+=2��������ʱ�ж�curLen-n==1������ǣ���˵�����һ���ַ��Ǻ��֣�����ֻ�а�����������
	 * ���curLen==n���0�±��ȡi���ַ�������һ����������������ֽ��������ַ������ֽ�������ֱ�ӷ���str�ַ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="��ABC �� DEF";
		//System.out.println(str.getBytes().length);//�ַ������ֽ���
		String str1="��ABC";
		String spiltStr=spiltString(str,6);
		String spiltStr1=spiltString(str1,4);
		System.out.println(spiltStr);
		System.out.println(spiltStr1);
	}

	private static String spiltString(String str, int n) {
		int curlen=0;
		for(int i=0;i<str.length();i++){
			if(curlen==n){
				return str.substring(0, i);
			}
			char c=str.charAt(i);
			if(c<256){
				curlen+=1;
			}else{
				curlen+=2;
				if(curlen-n==1){
					return str.substring(0,i);
				}
			}
		}
		return str;
	}

}
