package d0107;

public class Test_Bus {

	public static void main(String[] args) {
		
		Bus b1 = new Bus(1);
		Bus b2 = new Bus(2);
		Bus b3 = new Bus(3);
		Bus b4 = new Bus(4);
		
		PStudent s1 = new PStudent("김학생", 1, 12000);
		PStudent s2 = new PStudent("이학생", 2, 1500);
		PStudent s3 = new PStudent("박학생", 4, 3000);
		PStudent s4 = new PStudent("전학생", 3, 4000);
		PStudent s5 = new PStudent("지학생", 1, 2000);
		PStudent s6 = new PStudent("양학생", 1, 15000);
		PStudent s7 = new PStudent("강학생", 2, 1000);
		PStudent s8 = new PStudent("황학생", 3, 500);
		
		s1.boarding(b3);
		s2.boarding(b4);
		s3.boarding(b2);
		s4.boarding(b3);
		s5.boarding(b1);
		s6.boarding(b3);
		s7.boarding(b1);
		s8.boarding(b2);
		
		System.out.println(s1.studentInfoToString());
		System.out.println(s2.studentInfoToString());
		System.out.println(s3.studentInfoToString());
		System.out.println(s4.studentInfoToString());
		System.out.println(s5.studentInfoToString());
		System.out.println(s6.studentInfoToString());
		System.out.println(s7.studentInfoToString());
		System.out.println(s8.studentInfoToString());
		
		System.out.println(b1.busInfoToString());
		System.out.println(b2.busInfoToString());
		System.out.println(b3.busInfoToString());
		System.out.println(b4.busInfoToString());
		
	}

}
