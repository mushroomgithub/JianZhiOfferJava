package cn.lnu.domain;

class Art {  
    Art() {  
        System.out.println("Art");  
        System.out.println(getClass().getName());  
    }  
}  
  
class Drawing extends Art {  
    Drawing() {  
        System.out.println("Drawing");  
        System.out.println(getClass().getName());  
    }  
}  
  
class Cartoon extends Drawing{  
    Cartoon(){  
        System.out.println("Cartoon");  
        System.out.println(getClass().getName());  
    }  
}
public class GetClass {

	/**
	 * 结论： 当调用getClass()时，返回这个对象真实的Class对象。  
     *  从3个继承对象相等的情况和输出可知，这三个对象有相同的this指针，即内存地址一致。
     *  而getClass()返回的就是this指针所代表的最真实的Class的对象，也即最上层的子类。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cartoon x = new Cartoon();  
        
        Drawing one =x;  
        Art two = x;  
        if(one == two){  
            System.out.println("==");  
        }else {  
            System.out.println("!=");  
        }  
        System.out.println(x.toString());  
        System.out.println(one.toString());  
        System.out.println(two.toString());  
	}

}
