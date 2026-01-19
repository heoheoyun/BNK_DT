package d0119;

interface Anlmal{
	int DOG = 1;
	int CAT = 2;
}

class Person {
	public static final int MAN = 1;
	public static final int WOMAN = 2;
}

public class Ex02_NoSafeConst {
	
	public static void who(int man) {
		switch (man) {
		case Person.MAN: 
			System.out.println("남성 입니다.");break;
		case Person.WOMAN:
			System.out.println("여성 입니다.");break;
		}
	}
	
	public static void main(String[] args) {
		who(Person.MAN);
		who(Person.WOMAN);
		who(Anlmal.DOG);
		// 상수에 저장된 값이 같아 문제가 발생할 여지가 있음.
	}
}
