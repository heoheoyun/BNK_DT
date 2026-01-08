package d0107;

public class Human {
	
	private String name;
	private char gender;
	private int life = 100;
	
	Human(String name, char gender) {
		setName(name);
		setGender(gender);
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void setGender(char gender) {
		this.gender = gender;
	}
	
	String getGender() {
		if(gender =='M') return "남자";
		else if(gender =='F') return "여자";
		else return "기타";
	}
	
	int getLife() {
		return life;
	}
	
	String infoToString() {
		return "이름 : " + getName() + ", 성별 : " + getGender() + ", 남은 수명 : " + getLife();
	}
	

	
	void smoking(int cigarette) {
		if(life < cigarette) {
			life = 0;
			System.out.println(getName() +"님은 수명 이상의 흡연을 하였습니다.");
		} else life = life - cigarette;
	}
	
	void drinking(int bottle) {
		if(life < 2*bottle) {
			life = 0;
			System.out.println(getName() + "님은 수명 이상의 음주를 하였습니다.");
		}
		else life = life - 2*bottle;
	}
}
