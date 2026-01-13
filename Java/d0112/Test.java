package d0112;

class A1{
	int n;
	
	A1(int n){
		this.n = n;
	}
}

class B1 extends A1{
	String s;

	B1(int n, String s){
		super(n);
		this.s = s;
	}
}


public class Test {
	
	public static void main(String[] args) {
		
		A1 a = new B1(10,"S");
		
		System.out.println(a.n);
	}
}
