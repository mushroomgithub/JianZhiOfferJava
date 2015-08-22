package cn.lnu.domain;

interface A{
	int x=0;
}
class B1{
	int x=1;
}
public class C extends B1 implements A{

	public void pX(){
		System.out.println(super.x);
		System.out.println(A.x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C().pX();
	}

}
