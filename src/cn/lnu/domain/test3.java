package cn.lnu.domain;


/*public class test3 {
	public static void main(String[] args) {
	    StringBuffer a = new StringBuffer("A"); 
	    StringBuffer b = new StringBuffer("B"); 
	    operator(a, b); 
	    System.out.println(a + "," + b); 
	    java.util.HashMap map=new java.util.HashMap(); 
	    map.put("name",null);      
	    map.put("name","Jack");
	    System.out.println(map.size());
	} 
	public static void operator(StringBuffer x, StringBuffer y) { 
	    x.append(y); 
	    y = x; 
	}
}*/
/*public class test3 {
    public static void main(String[] args) {   
        Object o = new Object() {  
             public boolean equals(Object obj) {  
                 return true; 
         }
     };   
     System.out.println(o.equals("Fred"));
     
     byte b1=1,b2=2,b3,b6; 
     final byte b4=4,b5=6; 
     b6=b4+b5; 
     b3=(byte)(b1+b2); 
     System.out.println(b3+b6);
     }
}*/

public class test3{ 
    public int add(int a,int b){   
         try {
             return a+b;      
         } catch (Exception e) {  
            System.out.println("catch”Ôæ‰øÈ");
         }finally{ 
             System.out.println("finally”Ôæ‰øÈ");
         }
         return 0;
    } 
     public static void main(String argv[]){ 
         test3 test =new test3(); 
         System.out.println("∫Õ «£∫"+test.add(9, 34)); 
     }
}