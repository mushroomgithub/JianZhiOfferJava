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
			if(c[i]==':'){//�ǣ����ַ����temp�ж�Ӧ��Ԫ���滻%s,�ƶ�iֵ����%s
				sb.append(":"+temp[j++]);
				i=i+3;//�ƶ���,λ����Ӷ���
				if(i==c.length){//������������һ��%s��temp�е�ʣ�µ�Ԫ�ذ�ָ����ʽ׷��
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
			if(i!=c.length){//���ǣ����ַ�ֱ�����			
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}
