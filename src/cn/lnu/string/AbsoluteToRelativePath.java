package cn.lnu.string;

import java.util.ArrayList;
import java.util.List;

public class AbsoluteToRelativePath {

	/**
	 * �����·��b����ھ���·��a�����·����ʾ��ʽ
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="/qihoo/app/a/b/c/d/new.c";
		String b="/qihoo/app/1/2/test.c";
		
		String relativePath=getRelativePathB_A(a.toCharArray(),b.toCharArray());
		System.out.println(relativePath);
	}
	private static String getRelativePathB_A(char[]a, char[]b) {
		int i=0;
		//��Ȼ�����·������ô·��a��bǰ����ַ�����Ӧ������ͬ��
		while(i<a.length&&i<b.length){
			if(a[i]==b[i]){
				i++;
			}else{
				break;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int k=i;k<a.length;k++){//�鿴B�����A�м����㼶����Ӽ���../
			if('/'==a[k]){
				sb.append("../");
			}
		}
		//׷��b·��֮����ַ�
		for(int j=i;j<b.length;j++){
			sb.append(b[j]);
		}
		return sb.toString();
	}
}
