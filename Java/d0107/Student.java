package d0107;

public class Student {
	static int cnt;
	private int no;
	private String name;
	private char gender;
	private int age;
	
	
	Student() {
		cnt++;
	}
	
	// 학생 정보를 매개 변수로 전달받아 클래스를 생성하는 생성자
	Student(String name, int age, char gender) {
		no = ++cnt;
		setName(name);
		setAge(age);
		setGender(gender);
		
	}
	
	// 학생 정보들을 문자열로 반환하는 함수
	String infoToString() {
		return "번호: "+ no +", 이름 : "+getName() +", 나이 :"+ getAge()+", 성별 : " + getGender();
	}
	
	// 학생 이름을 반환하는 함수
	String getName() {
		return name;
	}
	// 학생 이름을 변경하는 함수
	void setName(String name) {
		this.name = name;
	}
	// 학생 성별을 반환하는 함수
	char getGender() {
		return gender;
	}
	// 학생 성별을 변경하는 함수
	void setGender(char gender) {
		this.gender = gender;
	}
	// 학생 나이를 반환하는 함수
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		if(age<0)
			System.out.println("음수 값을 넣을 수 없습니다.");
		else this.age = age;
	}
}
