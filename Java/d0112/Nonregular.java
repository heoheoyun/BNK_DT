package d0112;

public class Nonregular extends Empolyee{
	
	static int nr_cnt = 0;
	static int hourly_wage = 10320;
	int time;
	
	public Nonregular(String name, int time) {
		super(name);
		nr_cnt++;
		setNo();
		this.time = time;
		setSalary();
	}
	
	@Override
	public void setNo() {
		no = "b" + nr_cnt;
	}
	
	@Override
	public void setSalary() {
		salary = hourly_wage * time;
	}
	@Override
	public String toString() {
		return "[비정규직]\n[사번] : "+ no + "\n[이름] : "+ name +"\n[급여] : " + salary;
	}
	
}
