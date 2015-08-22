package cn.lnu.string;

public class TestSpilt {

	/**
	 * дһ��������Ҫ����������һ���ַ�����һ���ַ������ȣ��Ը��ַ������зָ�
	 * ˼·����spiltString�����и��ݴ�����ַ������ȣ�����һ����Ҫ����ָ�ԭʼ�ַ����ַ�������
	 * ����ַ�������ĳ���n������ԭʼ�ַ������������һ���ַ�������δ�ص���CharLen������Ҫ������������ǣ�
	 * ��i<n-1ʱ��ͨ��subString��i*charLen,(i+1)*charLen����ȡ�ַ������浽�ַ��������i�±��У�
	 * ��i=n,ʱ��ʹ��subString(i*charLen����ȡ���һ���ַ�����֮��break,��ֹi�����Լӣ��������������±�Խ���쳣
	 */
	public static void main(String[] args) {
		String str="ashafshafjfaf";
		int charLen=4;
		String[] s1=spiltString(str,charLen);
		for(String s:s1){
			System.out.println(s);
		}
	}

	private static String[] spiltString(String str, int charLen) {
		int n=(str.length()+charLen-1)/charLen;
		String[] spiltStr=new String[n];
		
		for(int i=0;i<str.length();i++){
			if(i<n-1){
				spiltStr[i]=str.substring(i*charLen,(i+1)*charLen);
			}
			else{
				spiltStr[i]=str.substring(i*charLen);
				break;
			}	
		}
		
		return spiltStr;
	}

}
