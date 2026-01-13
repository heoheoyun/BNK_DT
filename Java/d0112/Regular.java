package d0112;

public class Regular extends Empolyee {
	
	static int regular_cnt = 0;
	int basic;
	
	public Regular(String name, int basic) {
		super(name);
		regular_cnt ++;
		setNo();
		this.basic = basic;
		setSalary();
	}
	
	@Override
	public void setNo() {
		no = "j"+regular_cnt;
	}
	
	@Override
	public void setSalary() {
		salary = (int) (basic * 1.1);
	}
	
	@Override
	public String toString() {
		return "[정직원]\n[사번] : "+ no + "\n[이름] : "+ name +"\n[급여] : " + salary;
	}
}
