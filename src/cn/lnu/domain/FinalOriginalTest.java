package cn.lnu.domain;

import java.io.UnsupportedEncodingException;

public class FinalOriginalTest {  
   // private static final int a=0;  
	private final int a;
    private String name;  
    public FinalOriginalTest(){  
       a = 3;  
    }  
    public FinalOriginalTest(String name){  
    	a=7;
        this.name = name;  
    }  
    public static void main(String[] args) throws UnsupportedEncodingException{  
        FinalOriginalTest ft = new FinalOriginalTest();  
        FinalOriginalTest ft1 = new FinalOriginalTest("hello");  

        System.out.println("系统默认字符集是:"+System.getProperty("file.encoding")); 
        String str="ahvcs我";
    
        byte []a=str.getBytes();
        byte [] b=str.getBytes("ascii");
        byte []c=str.getBytes("utf8");
        byte []d=str.getBytes("utf16");
        byte []e=str.getBytes("gbk");
        byte []f=str.getBytes("gb2312");
        System.out.println("a_default:"+a.length);
        System.out.println("b_ascii:"+b.length);
        System.out.println("c_utf8:"+c.length);
        System.out.println("d_utf16:"+d.length);
        System.out.println("e_gbk:"+e.length);
        System.out.println("f_gb2312:"+f.length);
    }  
} 