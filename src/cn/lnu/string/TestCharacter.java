package cn.lnu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class TestCharacter {

	/**
	 * 有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数,并按个数降序排序。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="中国addfg的111萨菲bbb菲的zzz萨菲";
		Map map=new HashMap();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			Integer count=(Integer) map.get(c);
			if(count==null){
				count=1;
			}else{
				count++;
			}
			map.put(c, count);
		}
		TreeSet<Map.Entry<Character, Integer>> treeSet=new TreeSet<Map.Entry<Character, Integer>>(
				new Comparator<Map.Entry<Character, Integer>>(){

					public int compare(Entry<Character, Integer> o1,
							Entry<Character, Integer> o2) {
						// TODO Auto-generated method stub
						int temp=o1.getValue()-o2.getValue();
						return temp==0?o1.getKey().compareTo(o2.getKey()):-temp;
					}
					
				}
		);
		Set<Map.Entry<Character, Integer>> set=map.entrySet();
		for(Map.Entry<Character, Integer> entry:set){
			treeSet.add(entry);
		}
		System.out.println("<-------------------->");
		for(Map.Entry<Character, Integer> entry: treeSet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
