package cn.lnu.domain;

public class Test2 {

	/**
	 * ����Long��Integer���ͱȽ�
	 * Long a=5L= Long.valueOf(5);
	 * ���ۣ�
	 * ��long��ֵ��-128-127֮��ʱ��ֱ��ȡLongCache��Ļ���������ã���ַ���
	 * ���long��ֵ���ڵ���128����С�ڵ���-129��������new��һ��Long���󷵻������ã���ַһ����ͬ
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long a=5L;
		Long b=5l;
		System.out.println("a==b?"+(a==b));//a==b?true
		
		Long c=127l;
		Long d=127l;
		System.out.println("c==d?"+(c==d));//c==d?true
		
		Long e=128l;
		Long f=128l;
		System.out.println("e==f?"+(e==f));//e==f?false
		System.out.println("e.equals(f)?"+(e.equals(f)));//e.equals(f)?true
		
		Long g=-128l;
		Long h=-128l;
		System.out.println("g==h?"+(g==h));//g==h?true
		
		Long i=-129l;
		Long j=-129l;
		System.out.println("i==j?"+(i==j));//i==j?false
		
		//����Long��Integer�ıȽ�
		Long x=6L;
		Integer y=6;
		//System.out.println("x==y?"+(x==y));//x��y����ֱ�ӽ��бȽ�
		System.out.println("x.intValue()==y?"+(x.intValue()==y));//x==y?true
		System.out.println("x==y.longValue()?"+(x==y.longValue()));//x==y?true
	}

}
