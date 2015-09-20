package cn.lnu.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Demo3 {

	/**
	 * 从1.txt文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in=Demo3.class.getResourceAsStream("2.txt");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line=null;
		Map map=new HashMap();
		Map<String,String> map2=new HashMap<String,String>();
		while((line=br.readLine())!=null){
			dealLine(line,map,map2);
		}
		
		TreeSet<Map.Entry<String, Integer>> treeSet=new TreeSet<Map.Entry<String, Integer>>(new Comparator(){

			public int compare(Object o1, Object o2) {
				Map.Entry<String, Integer> e1=(Entry<String, Integer>) o1;
				Map.Entry<String, Integer> e2=(Entry<String, Integer>) o2;
				int temp=e1.getValue()-e2.getValue();
				return temp==0?e1.getKey().compareTo(e2.getKey()):temp;
			}
		});
		
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		for(Map.Entry<String, Integer> entry:set){
			treeSet.add(entry);
		}
		int max=0;//记录电话号码出现的最多次数
		String telphone="";
		for(Map.Entry<String, Integer> entry: treeSet){
			int temp=entry.getValue();
			if(temp>max){
				max=temp;
				telphone=entry.getKey();
			}
		}
		for(Map.Entry<String, String> entry:map2.entrySet()){
			if(telphone.equals(entry.getValue())){
				System.out.print(telphone+":"+entry.getKey());
			}
		}
	}

	private static void dealLine(String line, Map map,Map map2) {
		if(!"".equals(line.trim())){
			String[] results=line.split(" ");
			if(results.length==2){
				String tel=results[1];
				Integer count=(Integer) map.get(tel);
				if(count==null)
					count=1;
				else
					count++;
				map.put(tel, count);
				map2.put(results[0], tel);
			}
		}
	}

}


