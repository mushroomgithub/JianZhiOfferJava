package cn.lnu.domain;
public class StaticVariableTest {
    private static StaticVariableTest svt = new StaticVariableTest();//Óï¾ä(1)  
    private static int count1;//Óï¾ä(2)  
    private static int count2 = 0;//Óï¾ä(3)
      
    private StaticVariableTest(){//Óï¾ä(4)  
        count1++;  
        count2++;  
    }  
    public static StaticVariableTest getInstance(){//Óï¾ä(5)  
        return svt;  
    }  
    public static int getCount1() {  
        return count1;  
    }  
    public static void setCount1(int count1) {  
        StaticVariableTest.count1 = count1;  
    }  
    public static int getCount2() {  
        return count2;  
    }  
    public static void setCount2(int count2) {  
        StaticVariableTest.count2 = count2;  
    }  
    public static void main(String[] args) throws ClassNotFoundException {  
        StaticVariableTest svt = StaticVariableTest.getInstance();//Óï¾ä(6)  
        System.out.println("count1:" + svt.getCount1());//Óï¾ä(7)  
        System.out.println("count2:" + svt.getCount2());//Óï¾ä(8)  
    }  
}  

