package cn.lnu.string;

public class StringDecoding {

	/**
	 *����һ���ַ�������a2bc3d1��Ҫ����ַ������н��룬����Ĺ�����
	 *���������ּ䣨ǰ��û�����ֵ�������㿪ͷ�����ּ䣩���ַ����ظ����ִ���
	 *������a2bc3d1������֮����ַ���Ϊaabcbcbcd
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="a2bc3d1";
		char[]s=str.toCharArray();
		
		String strDecoding=Decoding(str.toCharArray());
		System.out.println("�����"+strDecoding);
	}

	private static String Decoding(char[] s) {
		StringBuffer sTemp=new StringBuffer();
		StringBuffer nTemp=new StringBuffer();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length;i++){
			if(s[i]>='0'&&s[i]<='9'){
				nTemp.append(s[i]);
				//�����һ���ַ��������ֻ����ַ����Ľ�β����ô�ͽ��в��������������ַ�����׷�ӵ�nTemp��
				if(i==s.length-1||s[i+1]<'0'||s[i+1]>'9'){
					int n=Integer.parseInt(nTemp.toString());
					for(int j=0;j<n;j++){
						sb.append(sTemp);
					}
					sTemp.delete(0, sTemp.capacity());//�׶������
					nTemp.delete(0, nTemp.capacity());
				}
			}else{
				sTemp.append(s[i]);
			}
		}
		
		return sb.toString();
	}
	
	private static String Decoding(String s){
		String[] sTemp=s.split("\\d+");
		String[] nTemp=s.split("\\D+");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sTemp.length;i++){
			int n=Integer.parseInt(nTemp[i+1]);
			for(int j=0;j<n;j++){
				sb.append(sTemp[i]);
			}
		}
		return sb.toString();
	}
}
