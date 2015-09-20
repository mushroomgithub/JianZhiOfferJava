package cn.lnu.string;

import java.util.ArrayList;
import java.util.List;

public class RelativeToAbsolutePath {

	/**
	 * ���·��ת����·��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="/home/abs/../temp/new/../";
		String absPath=getAbsPath(str);
		System.out.println(absPath);
	}
	//���ظ������·���ľ���·����ʾ��ʽ
	private static String getAbsPath(String str) {
		List<String> list=new ArrayList<String>();
		int pos1,pos2;
		pos1=str.indexOf('/');
		if(pos1<0){
			return str;
		}
		while(true){
			pos2=str.indexOf('/', pos1+1);
			if(pos2>pos1){
				String temp=str.substring(pos1, pos2);
				if(!"/..".equals(temp)){//�����ȡ�����ַ���������/..��ֱ����ӵ�list�У����򵯳��������һ��Ԫ��
					list.add(temp);
				}else{
					list.remove(list.size()-1);
				}
				pos1=pos2;
			}else{
				break;
			}
		}	
		String result="";
		for(String s:list){
			result+=s;
		}
		return result;
	}
}
