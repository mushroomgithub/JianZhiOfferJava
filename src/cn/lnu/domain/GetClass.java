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
	 * ���ۣ� ������getClass()ʱ���������������ʵ��Class����  
     *  ��3���̳ж�����ȵ�����������֪����������������ͬ��thisָ�룬���ڴ��ַһ�¡�
     *  ��getClass()���صľ���thisָ�������������ʵ��Class�Ķ���Ҳ�����ϲ�����ࡣ
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
