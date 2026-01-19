package d0119;

class Outer1{
	
	private static int result = 0;
	
	class Inner{
		void add(int n) {
			result += n;
		}
	}
	class Inner2{
		void print() {
			System.out.println(result);
		}
	}
}


public class Ex05_NonStaticNested {
	
	public static void main(String[] args) {
		
		Outer1 o1 = new Outer1();
		// 외부클래스의 인스턴스에 종속되는 내부 클래스는
		// 외부클래스의 인스턴스 참조변수를 통해 new 연산을 수행하여
		// 내부클래스 인스턴스를 생성한다.
		// --> 외부클래스 인스턴스의 참조변수 없이는 내부클래스의 인스턴스를 생성할 수 없다.
		// --> 내부클래스는 외부클래스의 인스턴스에 종속된다.
		Outer1.Inner o1in = o1.new Inner();
		Outer1.Inner2 o1in2 = o1.new Inner2();
		o1in.add(10);
		o1in2.print();
		
		Outer1 o2 = new Outer1();
		Outer1.Inner o2in = o2.new Inner();
		Outer1.Inner2 o2in2 = o2.new Inner2();
		o2in.add(5);
		o2in2.print();
	}
}
