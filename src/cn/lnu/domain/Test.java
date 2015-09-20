package cn.lnu.domain;

public class Test {

	/**
	 * 字符串比较
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str = new String("abc"); //语句(1)  
	        String str1 = "abc";//语句(2)  
	        String str2 = new String("abc");//语句(3)  
	        System.out.println("<----------abc----------->"); 
	        System.out.println(str == str1);//语句(4)  false
	        System.out.println(str == str2);//语句(5)  fales
	        System.out.println(str1 == str2);//语句(6)  false
	        System.out.println("<---------intern  abc------------>");
	        System.out.println(str == str.intern());//语句(7) false  
	        System.out.println(str1.intern() == str1.intern());//语句(8)  true
	        System.out.println(str.intern() == str2.intern());//语句(9) true  
	        System.out.println("<----------hello----------->");
	        String hello = "hello";//语句(10)  
	        String hel = "hel";//语句(11)  
	        String lo = "lo";//语句(12)  
	       
	        System.out.println(hello == "hel" + "lo");//语句(13) true 
	        System.out.println(hello == "hel" + lo);//语句(14)  false
	        
	        String s3="abc\\12\n";//7
	        s3="abc\12\n";//5
	        s3="\tMyNane\103";//8
	        System.out.println(s3.length());
	        
	        //String[] aa = "aaa|bbb|ccc".split("|"); //虽然能够执行，但得到不是想要的结果  
	        String[] aa = "aaa|bbb|ccc".split("\\|"); //这样才能得到正确的结果
	        for(String s:aa){
	        	System.out.println(s);
	        }
	         
	}

}
