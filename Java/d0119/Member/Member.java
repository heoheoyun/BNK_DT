package d0119.Member;

public class Member {
	
	private static int cnt = 0;
	private int mno;
	private String name;
	private Role role;
	
	public Member(String name, Role role) {
		cnt++;
		mno = cnt;
		this.name = name;
		this.role = role;
	}
	public static int getCnt() {
		return cnt;
	}
	public int getMno() {
		return mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "회원정보 [회원번호 : " + mno + ", 이름 : " + name + ", 직책 : " + role + "]";
	}

}
