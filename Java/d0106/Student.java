package d0106;

public class Student {
	static int sno =1;
	int no;
	String name;
	char gender;
	
	void showStudentInfo(){
		System.out.println("번호 : " + no);
		System.out.println("이름 : " + name);
		String temp_gender;
		if(gender =='M') {
			temp_gender = "남자";
		} else {
			temp_gender = "여자";
		}
		System.out.println("성별 : " +  temp_gender);
		System.out.println("==================");
	}
	
	
	Student() {
		
	}

}
