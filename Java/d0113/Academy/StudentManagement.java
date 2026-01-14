package d0113.Academy;

public class StudentManagement implements Manageable {
	
	private Student[] students;
	private int size = 0;
	private int not_fill = 0;
	
	public StudentManagement() {
		size = 5;
		students = new Student[size];
	}

	@Override
	public void register(String name, int age, String callno) {
		if(!(size > not_fill )) expand();
		students[not_fill] = new Student(not_fill+1, name, callno, age);
		not_fill++;
	}
	
	@Override
	public void inquire(String select, Object obj) {
		switch(select) {
			case "학생번호":
				for(int i=0; i<not_fill; i++) {
					if(students[i] != null && students[i].getsNum() == (int) obj)
						System.out.println(students[i].toString());
				}
				break;
			case "이름":
				for(int i=0; i<not_fill; i++) {
					if(students[i] != null && students[i].getName().equals((String)obj))
						System.out.println(students[i].toString());
				}
				break;
			case "전화번호":
				for(int i=0; i<not_fill; i++) {
					if(students[i] != null && students[i].getCallNo().equals((String)obj))
						System.out.println(students[i].toString());
				}
				break;
			case "나이":
				for(int i=0; i<not_fill; i++) {
					if(students[i] != null && students[i].getAge() == (int) obj )
						System.out.println(students[i].toString());
				}
				break;
			default :
				System.out.println("조회가 불가능한 분류입니다.");
		}
	}
	
	@Override
	public void modify(String select, int num, Object after) {
		Object before = null;
		for(int i=0; i<not_fill; i++) {
			if(students[i] == null || students[i].getsNum() != num) continue;
			if(select.equals("이름")){
				before = students[i].getName();
				students[i].setName((String)after);	
			}
			if(select.equals("전화번호")){
				before = students[i].getCallNo();
				students[i].setCallNo((String)after);	
			}
			if(select.equals("나이")){
				before = students[i].getAge();
				students[i].setAge((int)after);	
			}
			break;
		}
		if (before != null) System.out.println(select+" 수정 완료 :" +before+" -> "+after);
		else System.out.println("일치하는 학생이 없어 수정이 불가능합니다.");
	}

	@Override
	public void delete(String name, int age, String callNo) {
		Student temp = new Student(name, callNo, age);
		for(int i=0; i<not_fill;i++) {
			if(students[i] != null && students[i].equals(temp)) {
				students[i] = null;
				break;
			}
		}
	}
	
	private void expand() {
		Student[] tempArray = students;
		size +=5;
		this.students = new Student[size];
		for(int i = 0; i<tempArray.length;i++) {
			students[i] = tempArray[i];
		}
	}
	
	public void showAllInfo() {
		for(int i=0; i<not_fill;i++) {
			if(students[i]!=null) {
				System.out.println(students[i].toString());
				System.out.println("==============================");
			}
		}
	}
}
