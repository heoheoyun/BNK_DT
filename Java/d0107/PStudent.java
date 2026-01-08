package d0107;

public class PStudent {
	
	private String name;
	private int grade;
	private int money;
	private int bus_no = 0;
	
	PStudent(String name, int grade, int money) {
		this.name = name;
		this.grade = grade;
		this.money = money;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void setGrade(int grade) {
		this.grade = grade;
	}
	
	int getGrade() {
		return grade;
	}
	
	void setMoney(int money) {
		this.money = money;
	}
	
	int getMoney() {
		return money;
	}
	
	int getBus_no() {
		return bus_no;
	}
	
	void peyment() {
	}
	
	void boarding(Bus bus) {
		if(getMoney() >= Bus.charge ) {
			money = money - Bus.charge;
			System.out.println(getName()+"이 요금을 지불했습니다.");
			bus_no = bus.getNo();
			bus.boarding();
		} else {
			System.out.println("승차가 거부 되었습니다.");
		}
	}
	
	void disembarking(Bus bus) {
		if(bus_no == bus.getNo()) {
			System.out.println(name + " 님이 버스에서 하차했습니다.");
			bus.disembarking();
			bus_no = 0;
		} else {
			System.out.println(name + " 님은 해당 버스에 탑승 중이지 않습니다.");
		}
	}
	
	String studentInfoToString() {
		if(bus_no > 0) return "이름 : " + name + ", 학년 : " + grade + "\t 탑승 중인 버스 :"+ bus_no +", 가진 돈 : " + money; 
		else return "이름 : " + name + ", 학년 : " + grade +", 가진 돈 : " + money;
	}
	
}
