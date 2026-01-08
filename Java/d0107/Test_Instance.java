package d0107;

class A{
	
	static int n = 100;
	char c;
	
	void f() {
		c = 'Z';
	}
}


public class Test_Instance {
	
	public static void main(String[] args) {

		A a = new A();
		A b = new A();
		A c = new A();
		A d = new A();
		
		a.c = 'A';
		b.c = 'B';
		c.c = 'C';
		d.f();
		
		System.out.println(a.c);
		System.out.println(b.c);
		System.out.println(c.c);
		System.out.println(d.c);
		
//		System.out.println(a.n);
//		b.n = 200;
//		System.out.println(b.n);
//		System.out.println(c.n);

	}
}
