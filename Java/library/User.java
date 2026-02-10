package Library;

public class User {
	
	private String id;
	private String pw;
	private String name;
	private String reason = null;
	
	//로그인 확인용
	User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//회원가입용
	User(String id, String pw, String name) {
		this(id, pw);
		this.name = name;
	}
	
	// DB 조회용 (탈퇴 사유 포함)
	User(String id, String pw, String name, String reason){
		this(id, pw, name);
		this.reason = reason;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public String getReason() {
		return reason;
	}

	// 비밀번호 변경 기능(modifyPw)
    public void setPw(String pw) {
        this.pw = pw;
    }
	public void setReason(String reason) {
        this.reason = reason;
    }

	@Override
    public String toString() {
        String str = "[ID : " + id + "] [이름 : " + name + "]";
        // 탈퇴 사유가 있다면 출력, 관리자 화면에서 사용
        if(reason != null && !reason.isEmpty()) {
            str += " [탈퇴요청: " + reason + "]";
        }
        return str;
    }
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof User)) return false;
		
		User other = (User) obj;
		
		if(id == null) {
			return other.id == null;
		}
		
		return id.equals(other.id);
	}
}
