package d0113.Academy;

public class Student{
	
	private int sNum;
	private String name;
	private String callNo;
	private int age;
	
	Student(String name, String callNo, int age){
		setName(name);
		setCallNo(callNo);
		setAge(age);
	}
	
	Student(int sNum, String name, String callNo, int age){
		setsNum(sNum);
		setName(name);
		setCallNo(callNo);
		setAge(age);
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "[학생번호 : " + getsNum() + "]\n[이름 : " + getName() + "]\n[전화번호 : " + getCallNo() + "]\n[나이 : " + getAge() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;			// 1. 자기 자신의 주소인지 확인
		if(!(obj instanceof Student)) return false;	// 2. 같은 타입인지 확인
			
		Student other = (Student)obj;
		if (name == null) {						// 3. null인 경우 비교
			return other.name == null;
		}
		return (name.equals(other.name))&&(callNo.equals(other.callNo))&&(age == other.age);
	}
}
