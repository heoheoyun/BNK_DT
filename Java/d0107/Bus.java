package d0107;

public class Bus {
	static int charge = 1000;
	private int no;
	private int passenger = 0;
	private int total_fee = 0;
	
	//private 는 정보 은닉
	
	int getNo() {
		return no;
	}
	
	int getPassenger() {
		return passenger;
	}

	void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	int getTotal_fee() {
		return total_fee;
	}

	void setNo(int no) {
		this.no = no;
	}

	Bus(int no){
		this.no = no;
	}
	
	void boarding() {
		passenger++;
		total_fee = total_fee + charge;
	}
	
	void disembarking() {
		passenger --;
	}
	
	String busInfoToString() {
		return "번호 : " + no + ", 탑승 중인 승객 :"+ passenger +", 요금 합계 : " + total_fee; 
	}
	
}
