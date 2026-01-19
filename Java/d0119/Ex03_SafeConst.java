package d0119;

enum Animal2{
	DOG , CAT
}
/*
enum Person2{
	MAN{
		@Override
		String message() {
			return "MAN";
		}
		
	}, WOMAN{												// 7. 각 상수 별로 별도로 메서드 지정 가능
		@Override
		String message() {
			return "WOMAN";
		}
	};
	
	private Person2() {
		System.out.println("Person2 생성자 호출...");
	}
	
	abstract String message();								// 9. 추상 메서드로 각 상수 별로 기능 구현을 하게 가능
	
	@Override
	public String toString() {
		return message();
	}
}
*/

enum Person2{
	MAN("MAN 입니다.") {
		@Override
		void go() {
			System.out.println("군대 갑니다.");	
		}
	},
	WOMAN("WOMAN 입니다.") {
		@Override
		void go() {
			System.out.println("일반대 갑니다.");
		}
	};
	
	String message;
	private Person2(String s) {
		message = s;
	}
	
	abstract void go();
	
	@Override
	public String toString() {
		return message;
	}
}

public class Ex03_SafeConst {
	
	public static void who(Person2 p) {
		/*
		switch (p) {
		case MAN: 
			System.out.println("남성 입니다.");break;
		case WOMAN:
			System.out.println("여성 입니다.");break;
		}
		*/
//		System.out.println(p); 								// 11. 위의 switch-case 문을 대체하는 코드로 완성
		p.go();												// 12. 새롭게 메소드를 정의하여 활용하기
	}
	
	public static void main(String[] args) {
//		who(Person2.MAN);
//		who(Animal2.CAT); 									// 1. Person만 유효하게 동작하는것을 확인
		
//		System.out.println(Person2.WOMAN);					// 2. WOMAN이라고 출력됨을 확인.
//		System.out.println(Person2.WOMAN.equals("WOMAN"));	// 3. 문자열이 아님을 확인.
//		System.out.println(Person2.WOMAN.toString());		// 4. toString을 오버라이딩 가능한 것을 확인
															// 5. 상수 마다 생성자가 호출됨, 개발자가 직접 생성 불가, 자동 생성
															// 6. Object의 요소를 재정의 가능하며 생성자를 만드는게 가능함으로 미루어 보아 enum은 class의 한 종류
		System.out.println(Person2.MAN);
		System.out.println(Person2.WOMAN);
		System.out.println(Person2.MAN != Person2.WOMAN);	// 8. equals를 쓰지 않고도 비교 가능.
//		Person2.MAN.f()										// 9. f를 일반적인 메소드 처럼 선언이 안됨.
//		System.out.println(Person2.MAN.message());			// message 는 참조가 되는 상황
															// 여기까지 주석처리 된 Person2 에 대한 설명
		System.out.println(Person2.MAN.message); 			// 10. 다른 형태로 enum을 만들고 사용
															// 주석 처리 안된 enum Person2 참고
		
		who(Person2.MAN);
	}
		
}
