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

public class TestFileRead {

	/**
	 * ��1.txt�ı��ļ��ж�ȡ�����е�����������ӡ���ظ����������ظ��Ĵ����������ظ���������
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in=TestFileRead.class.getResourceAsStream("1.txt");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line=null;
		Map map=new HashMap();
		while((line=br.readLine())!=null){
			dealLine(line,map);
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
		System.out.println("<-------------------->");
		for(Map.Entry<String, Integer> entry: treeSet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

	private static void dealLine(String line, Map map) {
		if(!"".equals(line.trim())){
			String[] results=line.split("��");
			if(results.length==3){
				System.out.println(results[1]+":"+results[2]);
				String name=results[1];
				Integer count=(Integer) map.get(name);
				
				if(count==null)
					count=1;
				else
					count++;
				map.put(name, count);
			}
		}
	}

}


