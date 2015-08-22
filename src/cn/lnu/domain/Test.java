package cn.lnu.domain;

public class Test {

	/**
	 * ×Ö·û´®±È½Ï
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str = new String("abc"); //Óï¾ä(1)  
	        String str1 = "abc";//Óï¾ä(2)  
	        String str2 = new String("abc");//Óï¾ä(3)  
	        System.out.println("<----------abc----------->"); 
	        System.out.println(str == str1);//Óï¾ä(4)  false
	        System.out.println(str == str2);//Óï¾ä(5)  fales
	        System.out.println(str1 == str2);//Óï¾ä(6)  false
	        System.out.println("<---------intern  abc------------>");
	        System.out.println(str == str.intern());//Óï¾ä(7) false  
	        System.out.println(str1.intern() == str1.intern());//Óï¾ä(8)  true
	        System.out.println(str.intern() == str2.intern());//Óï¾ä(9) true  
	        System.out.println("<----------hello----------->");
	        String hello = "hello";//Óï¾ä(10)  
	        String hel = "hel";//Óï¾ä(11)  
	        String lo = "lo";//Óï¾ä(12)  
	       
	        System.out.println(hello == "hel" + "lo");//Óï¾ä(13) true 
	        System.out.println(hello == "hel" + lo);//Óï¾ä(14)  false
	        
	        String s3="abc\\12\n";//7
	        s3="abc\12\n";//5
	        s3="\tMyNane\103";//8
	        System.out.println(s3.length());
	}

}
