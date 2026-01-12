package d0109;

public class Member {
	private String id;			// 필수
	private String password;	// 필수
	private String name;		// 필수
	private String gender;		// 필수는 아님
	
	Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	Member(String id, String password, String name, String gender) {
		this(id,password,name);
		setGender(gender);
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(String gender) {
		if(gender.equals("남자") || gender.equals("여자"))this.gender = gender;
		else {
			System.out.println("남자, 여자 이외의 성별이 적혀 미입력처리됩니다.");
			this.gender = "";
		}
	}
	
	boolean check(String id, String pw) {
		return (this.id.equals(id)&&password.equals(pw));
	}

	@Override
	public String toString() {
		return "회원정보\n[ ID : " + id + " ]\n[ 이름 : " + name + " ]\n[ 성별 : " + gender + " ]";
	}
	


}
