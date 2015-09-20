package cn.lnu.string;

import java.util.ArrayList;
import java.util.List;

public class AbsoluteToRelativePath {

	/**
	 * 求绝对路径b相对于绝对路径a的相对路径表示形式
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
		//既然是相对路径，那么路径a与b前面的字符串就应该是相同的
		while(i<a.length&&i<b.length){
			if(a[i]==b[i]){
				i++;
			}else{
				break;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int k=i;k<a.length;k++){//查看B相对于A有几个层级就添加几个../
			if('/'==a[k]){
				sb.append("../");
			}
		}
		//追加b路径之后的字符
		for(int j=i;j<b.length;j++){
			sb.append(b[j]);
		}
		return sb.toString();
	}
}
