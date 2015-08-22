package cn.lnu.string;

public class MaxNumberSquence {

	/**
	 * int maxContinuNum(const char *inputstr,char * outputstr)
	 * ��дһ�γ���ʵ�ָú�����ʵ�ַ���һ���ԡ�\0���������ַ�����������ִ��ĳ��ȣ����Ѹ������Ӵ����׵�ַ����outputstr��
	 * ����ʹ���κο⺯�����Ѿ����ڵĺ�������strlen��
	 *���ַ�����abc123abcdef12345abcdefgh123456789���У��Ѹ��ַ������׵�ַ����inputstr������9��
	 *outputstrָ���ַ�����123456789�����׵�ַ��
	 *
	 *˼·��
	 *ʹ�ö�̬�滮����������������maxLen��maxStart��maxEnd�ֱ����ڼ�¼����ִ��ĳ��ȺͿ�ʼ����λ�ã�
	 *����һ���ַ�����ÿ�α���һ���ַ���������������ʱ����curLen,start,end,�ֱ����ڼ�¼��ǰ�Ըñ������ִ�ͷ�����ִ�
	 *�ĳ��ȣ���ʼ�Լ������±꣬���ִ���βʱ���Ƚ�curLen��maxLen�Ĵ�С�����С�ڵ���maxLen�����������򽻻�������ֵ��
	 *���ҷֱ��¼��ǰ����ִ��Ŀ�ʼ������±꣬
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc123abcdef12345abcdefgh123456789";
		char s[]=str.toCharArray();
		char out[]=new char[256];
		int len=maxContinueNumSquence(s,out);
		System.out.println(len+" "+new String(out,0,len));
	}
	
	private static int maxContinueNumSquence(char[] s, char[] out) {
		if(s==null)
			return 0;
		int maxLen=0;
		int maxStart=0;
		int maxEnd=0;
		
		int i;
		for(i=0;i<s.length;i++){
			int curLen=0;
			int start=i;
			int end=i;
			if(s[i]>='0'&&s[i]<='9'){
				while(s[end]>='0'&&s[end]<='9'){
						end++;
						if(end==s.length)
							break;
				}
				curLen=(end-1)-start+1;//(end-1)����Ϊÿ�����ִ�������end�������ƶ�һλ
			}
			if(curLen>maxLen){
				maxLen=curLen;
				maxStart=start;
				maxEnd=end-1;
			}
			if(maxEnd>=s.length-1)
				break;
		}
		int j;
		for(i=maxStart,j=0;i<=maxEnd;i++,j++){
			out[j]=s[i];
		}
		out[j]='\0';
		return maxLen;
	}

}
