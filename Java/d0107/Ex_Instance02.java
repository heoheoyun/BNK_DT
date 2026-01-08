package d0107;

public class Ex_Instance02 {
	
	public static void main(String[] args) {
		
		Student stu = new Student("홍길동", 19, 'M');
		Student stu2 = new Student("임꺽정", 20, 'M');
		Student stu3 = new Student("James", -20, 'M');
		
		System.out.println(stu.infoToString());
		System.out.println(stu2.infoToString());
		System.out.println(stu3.infoToString());
		
		stu2.setName("둘리");
		
		System.out.println(stu2.infoToString());
		
		stu2.setGender('F');
		
		System.out.println(stu2.infoToString());
		
		System.out.println("총 학생 수 : " + Student.cnt);
		
		
	}
	
}
