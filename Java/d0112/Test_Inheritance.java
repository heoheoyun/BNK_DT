package d0112;

class A{
	protected int n;
	
	A(){
		System.out.println("A 클래스 인스턴스 생성...");
	}
	
	void f() {
		System.out.println("f() 함수 실행...");
	}
}

class B extends A{
	String s;
	
	B() {
		System.out.println("B 클래스 인스턴스 생성...");
	}
	
	void f1() {
		System.out.println("f1() 함수 실행..." + s + ", n = " + n);
	}
}

class C extends A {
	protected float f;
	
	C() {
		System.out.println("C 클래스 인스턴스 생성...");
	}
	
	void f2() {
		System.out.println("f2() 함수 실행...");
	}
}

public class Test_Inheritance {
	
	public static void main(String[] args) {
		
		A[] aa = new A[2];
		aa[0] = new B();
		aa[1] = new C();
	}
}
