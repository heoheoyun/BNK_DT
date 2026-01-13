package d0112;

public class Test_Salaries {
	
	
	public static void main(String[] args) {
		
		Empolyee h1 = new Regular("정직원",50000000);
		Empolyee h2 = new Regular("진직원",45000000);
		Empolyee h3 = new Nonregular("안직원",230);
		Empolyee h4 = new Nonregular("이직원",235);
		Empolyee h5 = new Regular("강직원",30000000);
		
		Company c = new Company();
		
		c.showEmpolyeeInfo(h1);
		c.showEmpolyeeInfo(h2);
		c.showEmpolyeeInfo(h3);
		c.showEmpolyeeInfo(h4);
		c.showEmpolyeeInfo(h5);
	}
}
