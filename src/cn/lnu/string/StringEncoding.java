package cn.lnu.string;

public class StringEncoding {

	/**
	 * ͨ����������һ��Сд��ĸ(a~z)��ɵ��ַ��������дһ���ַ���ѹ������
	 * ���ַ�����������ϯ���ظ���ĸ����ѹ���������ѹ������ַ�����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="xxxyyyyyyxxyzzzb";
		char[]s=str.toCharArray();
		String strZip=Encoding(s);
		System.out.println("ѹ����"+strZip);
	}

	private static String Encoding(char[]s){
		StringBuffer sb=new StringBuffer();
		char ch=s[0];
		int count=1;
		for(int i=1;i<s.length;i++){//i==s.lengthʱ�˳�ѭ��������ж�һ��ѭ��������û����ӵ��ַ�
			if(ch==s[i]){
				count++;
			}else{
				if(count>1){
					sb.append(count);
				}
				sb.append(ch);
				ch=s[i];
				count=1;
			}
		}
		if(count>1)
			sb.append(count);
		sb.append(ch);
		
		return sb.toString();
	}
}
