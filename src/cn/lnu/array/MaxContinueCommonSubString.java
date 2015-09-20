package cn.lnu.array;

public class MaxContinueCommonSubString {

	/**
	 * ����������ַ�������󹫹��Ӵ���
	 * ��str1="ABCBDAB",str2="BCCBDAE"
	 * �������󹫹��Ӵ���CBDA,����Ϊ4
	 * ˼·��
	 * ����һ��m*n��help�������飬m=str.length+1,n=str2.length2+1,����������
	 * ������������Ӵ��ĳ��ȣ��ȳ�ʼ��help����ĵ�һ�����һ��ֵΪ0��
	 * ֮��������str2ÿ��Ԫ����str1������Ԫ�رȽϣ�����ȵ�help[i][j]=0,
	 * ��ȵ�����help[i][j]=help[i-1][j-1]+1,�ڴι�����ʹ��maxLen��¼help�����е�
	 * ���ֵ��ȡ�����ֵʱ��������ʹ��maxRow,maxCol��¼��������help���鹹����ϣ������
	 * �����Ӵ�����󳤶��Ѿ�ȡ�����ֵ�Ǻ�������Ҳ��֪���ˣ����ݺ������������Ͻǿ�ʼ���Ҳ�Ϊ0��Ԫ��
	 * ����������Ӵ��е�����һ��Ԫ�ء������Ͻ�Ԫ��Ϊ0ʱ������������Ӵ��ʹ��������ˡ�
	 * @param args
	 */
	public static void main(String[] args) {
		String str1="ABCBDAB";
		String str2="BCCBDAE";
		String maxCommonStr=getMaxContinueCommonSubString(str1,str2);
		System.out.println("����������Ӵ��ǣ�"+maxCommonStr);
	}

	private static String getMaxContinueCommonSubString(String str1, String str2) {
		char s1[]=str1.toCharArray();
		char s2[]=str2.toCharArray();
		int len1=s1.length;
		int len2=s2.length;
		int [][]help=new int[len1+1][len2+1];//���ڱ�����󹫹��Ӵ��ĳ���
		for(int i=0;i<help.length;i++)
			help[i][0]=0;
		for(int i=0;i<help[0].length;i++)
			help[0][i]=0;
		int maxLen=help[0][0];//��¼help�����е����ֵ
		int maxRow=0;//��¼ȡ��help�����ֵ��ʱ��help����ĺ�����
		int maxCol=0;//��¼ȡ��help�����ֵ��ʱ��help�����������
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				if (s1[i - 1] == s2[j - 1]){//�����ǰԪ��s1[i-1]��s2[j-1]��ȣ��ͽ�help[i][j]��ֵ����Ϊhelp���Ͻ�ֵ+1
					help[i][j] = help[i - 1][j - 1] + 1;
				}
				else
					help[i][j] = 0;
				
				if(maxLen<help[i][j]){//����
					maxLen=help[i][j];
					maxRow=i;
					maxCol=j;
				}
			}
			
		}
	  for(int i=0;i<help.length;i++){ 
		  for(int j=0;j<help[i].length;j++){
			  System.out.print(help[i][j]+" "); 
		  }
		  System.out.println();
	  }
	  //������󹫹��Ӵ�
	  int i=maxRow;
	  int j=maxCol;
	  int len=maxLen;
	  char result[]=new char[len];
	  while(i>0&&j>0){
		  result[--len]=s1[i-1];
		  if(help[i-1][j-1]==0){
			  break;
		  }else{
			  i--;
			  j--;
		  }
	  }
		return new String(result);
	}

}
