package cn.lnu.string;

public class StringInclude {

	/**
	 * 字符串包含问题
	 * 假设这有一个各种字母组成的字符串A，和另外一个字符串B，字符串里B的字母数相对少一些。
	 * 什么方法能最快的查出所有小字符串B里的字母在大字符串A里都有？比如，如果是下面两个字符串：
	 * String 1: ABCDEFGHLMNOPQRS
	 * String 2: DCGSRQPO
	 * 
	 * 思路：采用hash表的方法，首先对短字符串进行hash,将短字符串中的每个字符的hash值设置为1;
	 * 记录短字符串的字符个数为count=shortStr.length();然后对长字符串中的每个字符,如果遍历
	 * 长字符串中对应字符的时候hash值为1，则进行处理，否则不处理；处理时采用将该字符对应的hash值设置为0，同时count--，
	 * 当count=0的时候中途退出对长字符串的遍历，然后判断count的值是否为0，为0说明长字符串包含短字符串，都在不包含
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longStr="ABCDEFGHLMNOPQRS";
		String shortStr="DCGSRQPO";
		boolean isContain=isContains(longStr, shortStr);
		if(isContain==true){
			System.out.println("长字符串longStr:"+longStr+"包含短字符串shortStr:"+shortStr);
		}else{
			System.out.println("长字符串longStr:"+longStr+"不包含短字符串shortStr:"+shortStr);
		}
	}

	private static boolean isContains(String str1, String str2) {
		int hash[]=new int[256];
		for(int i=0;i<str2.length();i++){
			hash[str2.charAt(i)]=1;
		}
		int count=str2.length();
		for(int i=0;i<str1.length();i++){
			if(hash[str1.charAt(i)]==1){
				hash[str1.charAt(i)]=0;
				count--;
				if(count==0)
					break;
			}
		}
		if(count==0)
			return true;
		else
			return false;
	}

}
