package cn.lnu.domain;

public class Test2 {

	/**
	 * 测试Long与Integer类型比较
	 * Long a=5L= Long.valueOf(5);
	 * 结论：
	 * 当long的值在-128-127之间时，直接取LongCache类的缓存对象引用，地址相等
	 * 如果long的值大于等于128或者小于等于-129，则重新new出一个Long对象返回其引用，地址一定不同
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
		
		//测试Long与Integer的比较
		Long x=6L;
		Integer y=6;
		//System.out.println("x==y?"+(x==y));//x与y不能直接进行比较
		System.out.println("x.intValue()==y?"+(x.intValue()==y));//x==y?true
		System.out.println("x==y.longValue()?"+(x==y.longValue()));//x==y?true
	}

}
