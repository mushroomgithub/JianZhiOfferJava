package cn.lnu.string.Test;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="a:%s,b:%s,c:%s";
		String[] temp={"a","b","c"};
		String[] temp1={"a","b","null"};
		String[] temp2={"a","b","c","d","e"};
		String res=function(str,temp2);
		System.out.println(res);
	}

	private static String function(String str,String[] temp) {
		char c[]=str.toCharArray();
		StringBuffer sb=new StringBuffer();
		int j=0;
		for(int i=0;i<c.length;i++){
			if(c[i]==':'){//是：的字符添加temp中对应的元素替换%s,移动i值跳过%s
				sb.append(":"+temp[j++]);
				i=i+3;//移动到,位置添加逗号
				if(i==c.length){//如果是遇到最后一个%s则将temp中的剩下的元素按指定格式追加
					sb.append('[');
					while(j<temp.length){
						if(j<temp.length-1)
							sb.append(temp[j++]+",");
						else
							sb.append(temp[j++]);
					}
					sb.append(']');
				}	
			}
			if(i!=c.length){//不是：的字符直接添加			
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}
