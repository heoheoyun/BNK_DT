package d0113.Academy;

public class Employee {
	private int eNum;
	private String name;
	private String callNo;
	private int age;
	
	Employee(String name, String callNo, int age){
		setName(name);
		setCallNo(callNo);
		setAge(age);
	}
	
	Employee(int eNum, String name, String callNo, int age){
		seteNum(eNum);
		setName(name);
		setCallNo(callNo);
		setAge(age);
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
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
		return "[직원번호 : " + geteNum() + "]\n[이름 : " + getName() + "]\n[전화번호 : " + getCallNo() + "]\n[나이 : " + getAge() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;			// 1. 자기 자신의 주소인지 확인
		if(!(obj instanceof Employee)) return false;	// 2. 같은 타입인지 확인
			
		Employee other = (Employee)obj;
		if (name == null) {						// 3. null인 경우 비교
			return other.name == null;
		}
		return (name.equals(other.name))&&(callNo.equals(other.callNo))&&(age == other.age);
	}
}
