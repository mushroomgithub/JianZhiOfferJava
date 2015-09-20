package cn.lnu.string;

import java.util.ArrayList;
import java.util.List;

public class RelativeToAbsolutePath {

	/**
	 * 相对路径转绝对路径
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="/home/abs/../temp/new/../";
		String absPath=getAbsPath(str);
		System.out.println(absPath);
	}
	//返回给定相对路径的绝对路径表示形式
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
				if(!"/..".equals(temp)){//如果截取到的字符串不等于/..就直接添加到list中，否则弹出链表最后一个元素
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
