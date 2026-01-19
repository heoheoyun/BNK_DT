package d0119;

// interface 의 구성 요소 : public static final 상수, static 메소드, default 메소드, abstract 메소드

interface Role{
	int ADMIN = 1;
	int MEMBER = 2;
	int GUEST = 3;
}

public class Ex01_ClassBasedConst {

	public static void main(String[] args) {
//		Role role = new Role();

//		System.out.println(role.getADMIN());
		System.out.println(Role.ADMIN);
		
//		int user = role.getADMIN();
		int user = Role.ADMIN;
		
		switch(user) {
		case Role.ADMIN:
			System.out.println("관리자...");break;
		case Role.MEMBER:
			System.out.println("회원...");break;
		case Role.GUEST:
			System.out.println("손님...");break;
		default:
			System.out.println("?..");
		}
	}
}
