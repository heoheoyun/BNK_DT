package d0106;
/*
 * 학생 5명의 정보를 Student 배열에 저장하기 
 * -> 다섯명의 객체를 따로 생성한 후 각 객체를 배열의 인덱스마다 저장
 * 이후에 for 를 활용해 배열을 출력하는 것 처럼 Student 배열 출력
 * -> 남,녀 가 몇명있는지 세어서 출력
 * -> 'M', 'F'로 성별을 출력하지 않고 "남자", "여자"라고 출력하기
 */

public class Test_Student {
	
	public static void main(String[] args) {
		
		System.out.println(Student.sno);
		
		Student stu = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		Student stu5 = new Student();	
		
		stu.no = 1;
		stu.name = "홍길동";
		stu.gender = 'M';
		
		stu2.no = 2;
		stu2.name = "고길동";
		stu2.gender = 'M';
		
		stu3.no = 3;
		stu3.name = "김선녀";
		stu3.gender = 'F';
		
		stu4.no = 4;
		stu4.name = "이여자";
		stu4.gender = 'F';
		
		stu5.no = 5;
		stu5.name = "전남자";
		stu5.gender = 'M';
		
		Student[] students = new Student[5];
		
		int[] cnt_g = new int[2];

		students[0] = stu;
		students[1] = stu2;
		students[2] = stu3;
		students[3] = stu4;
		students[4] = stu5;
		
		
		for(int i = 0; i < students.length; i++) {
			if(students[i].gender =='M') {
				cnt_g[0] ++;
			} else {
				cnt_g[1] ++;
			}
			students[i].showStudentInfo();
		}
		System.out.println("성별 통계");
		System.out.println("남자 : " +cnt_g[0]+"명" );
		System.out.println("여자 : " +cnt_g[1]+"명" );
	}
}
