package d0119;
/*
 * 클래스 내에 정의된 클래스 - Nested Class 
 * 1. Static Nested Class
 * 	- 외부클래스 (Outer)의 인스턴스와 상관없이 static Nested1 Class 인스턴스 생성.
 * 2. Non-Static Nested Class
 * 	1) Member Inner Class (클래스 내)
 * 	2) Local Inner Class (메소드 내)
 * 	3) Anonymous Inner Class(익명 클래스)
 */


class Outer{
//	Nested1 n;
	private static int num = 0;
	
	static class Nested1{
		void add(int n) {
			num += n;
		}
		
	}
	static class Nested2{
		void print() {
			System.out.println(num);
		}
	}
}



public class Ex04_NestedClass {
	
	public static void main(String[] args) {
		Outer.Nested1 nst1 = new Outer.Nested1();
		Outer.Nested2 nst2 = new Outer.Nested2();
		
		nst1.add(5);
		nst2.print();
	}
}
