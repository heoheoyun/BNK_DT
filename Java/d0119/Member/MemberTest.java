package d0119.Member;

public class MemberTest {
	
	public static void main(String[] args) {
		
		Member m1 = new Member("홍길동", Role.ADMIN);
		
		System.out.println(m1.toString());
		
		m1.getRole().go();
		
		m1.setRole(Role.MEMBER);
		
		System.out.println(m1.toString());
		
		m1.getRole().go();
		
		m1.setRole(Role.GUEST);
		
		System.out.println(m1.toString());
		
		m1.getRole().go();
	}
}
