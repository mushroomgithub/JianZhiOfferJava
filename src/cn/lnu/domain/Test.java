package cn.lnu.domain;

public class Test {

	/**
	 * �ַ����Ƚ�
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str = new String("abc"); //���(1)  
	        String str1 = "abc";//���(2)  
	        String str2 = new String("abc");//���(3)  
	        System.out.println("<----------abc----------->"); 
	        System.out.println(str == str1);//���(4)  false
	        System.out.println(str == str2);//���(5)  fales
	        System.out.println(str1 == str2);//���(6)  false
	        System.out.println("<---------intern  abc------------>");
	        System.out.println(str == str.intern());//���(7) false  
	        System.out.println(str1.intern() == str1.intern());//���(8)  true
	        System.out.println(str.intern() == str2.intern());//���(9) true  
	        System.out.println("<----------hello----------->");
	        String hello = "hello";//���(10)  
	        String hel = "hel";//���(11)  
	        String lo = "lo";//���(12)  
	       
	        System.out.println(hello == "hel" + "lo");//���(13) true 
	        System.out.println(hello == "hel" + lo);//���(14)  false
	        
	        String s3="abc\\12\n";//7
	        s3="abc\12\n";//5
	        s3="\tMyNane\103";//8
	        System.out.println(s3.length());
	}

}
