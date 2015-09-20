package cn.lnu.string;

public class MaxSymmetrySubString {

	/**
	 * �����Գ��Ӵ�
	 * ˼·��
	 * ���ڶԳ��Ӵ�����aba��abba���������������Ϊ��ͳһ������ԭ�ַ���ʹ�ò�#�ַ��ķ�������Ԥ����
	 * Ԥ�������ַ���֮��ʹ�ö�̬�滮�ķ���������maxLen,maxStart,maxEnd����ָ��ֱ�ָʾ��Գ��Ӵ�
	 * �ĳ��ȣ��Լ��öԳ��Ӵ��Ŀ�ʼ�±�ͽ����±ꣻȻ���ͷ����һ���ַ������飬���öԳ���ķ������ֱ����curLen,
	 * start,end��ֵ�����ַ����ǽ�ÿ�α������ַ������ǶԳ��Ӵ��ĶԳ��ᣬ�ֱ�������ɨ�裬ָ������������λ�ã����
	 * curLen��ֵ����maxLen�Ƚϣ����С�ڵ���maxLen���������������maxLen��maxStart,maxEnd��ֵ��
	 * ����һ������֮�󣬸���maxLen��maxStart,maxEnd�������Գ��Ӵ���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="google";
		char[] s=str.toCharArray();
		s=insertCharToArray(s,'#');
		System.out.println("Ԥ����֮����ַ���Ϊ��"+new String(s));
		String maxSymmetrySubString=getMaxSymmetrySubString(s);
		System.out.println("�ַ���"+str+"����Գ��Ӵ��ǣ�"+maxSymmetrySubString);
	}

	private static String getMaxSymmetrySubString(char[] s) {
		// TODO Auto-generated method stub
		if(s==null)
			return null;
		int maxLen=0;
		int maxStart=0,maxEnd=0;
		for(int i=0;i<s.length;i++){
			int start=i;
			int end=i;
			//��ÿ�α������ַ���Ϊ�Գ��Ӵ��ĶԳ��ᣬȻ��ֱ�������ɨ�裬�ҵ��Ը��ַ�Ϊ�Գ���ĶԳ��Ӵ��Ŀ�ʼ�����λ��
			while(start>=0&&end<=s.length-1&&s[start]==s[end]){
				start--;
				end++;
			}
			int curLen=(end-1)-(start+1)+1;//��Ϊÿ��ɨ������������ʱ��end�������һ�Σ�start�������һ��
			if(curLen>maxLen){
				maxLen=curLen;
				maxStart=start+1;
				maxEnd=end-1;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int i=maxStart;i<=maxEnd;i++){
			if(s[i]!='#'){
				sb.append(s[i]);
			}
		}
		return new String(sb);
	}

	//���ò�ֵ��Ԥ����ԭʼ�ַ�������
	private static char[] insertCharToArray(char[] s, char c) {
		// TODO Auto-generated method stub
		String temp=c+"";
		for(int i=0;i<s.length;i++){			
			temp+=s[i];
			temp+=c;
		}
		return temp.toCharArray();
	}

}
