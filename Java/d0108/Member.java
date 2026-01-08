package d0108;

public class Member {
	
	static int count = 0;
	private String name;
	private String callNo;
	private char gender;
	private String address;
	
	Member(String name, String callNo, char gender, String address) {
		this.name = name;
		this.callNo = callNo;
		this.gender = gender;
		this.address = address;
		count++;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getCallNo() {
		return callNo;
	}

	void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	String getGender() {
		String temp_gender;
		if(gender =='M') temp_gender = "남자";
		else if(gender =='F') temp_gender = "여자";
		else temp_gender = "그 외";
		return temp_gender;
	}

	void setGender(char gender) {
		this.gender = gender;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "[이름 : " + name + ", 전화번호 : " + callNo + ", 성별 : " + getGender() + ", 주소 : " + address + "]";
	}
}
