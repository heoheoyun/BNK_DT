package d0114.GradeProcessingProgram;

public class GradeProcessingProgram {
	
	private int size;
	private Student[] students;
	private int not_fill_idx = 0;
	
	public GradeProcessingProgram() {
		size = 5;
		students = new Student[size];
	}
	
	public void addStudent(Student s) {
		if(size<=not_fill_idx) {
			Student[] temp = students;
			size += 5;
			students = new Student[size];
			for(int i=0;i<temp.length;i++) {
				students[i] = temp[i];
			}
		}
		students[not_fill_idx] = s;
		not_fill_idx++;
	}
	
	private int sum(Student s) {
		int sum = 0;
		for(int i=0; i<s.getSubjects().length; i++) {
			if(s.getSubjects()[i] == null) continue;
			sum += s.getSubjects()[i].getScore();
		}
		return sum;
	}
	
	private double avg(Student s) {
		return sum(s) /(s.getSubjects().length*(1.0));
	}
	
	public void addSubject(String name, Subject sub) {
		for(int i=0; i<not_fill_idx; i++) {
			if(students[i].getName().equals(name)) {
				students[i].addSubject(sub);
				return;
			}
		}
		System.out.println("학생을 찾을 수 없습니다.");
	}
	
	public void setGrades(String name, String subject, int score) {
		int idx = -1;
		for(int i=0; i<not_fill_idx; i++) {
			if(students[i].getName().equals(name)) {
				idx = i;
				break;
			}
		}
		if(idx == -1) {
			System.out.println(name + "이름의 학생이 없습니다.");
			return;
		}
		for(int i=0; i<students[idx].getSubjects().length; i++) {
			if(students[idx].getSubjects()[i].getSubjectname().equals(subject)) {
				students[idx].getSubjects()[i].setScore(score);
				return;
			}
		}
		System.out.println(subject + "과목이 없습니다.");
	}
	
	public void showGrades(Student s) {
		System.out.println("===========[성적표]===========");
	    System.out.println("==[번호 : "+s.getSno()+"] [이름 : "+s.getName()+"]==");
	    for(Subject sub : s.getSubjects()) {
	        if(sub != null) {
	            System.out.println(sub);
	        }
	    }
		System.out.println("[총점] : " + sum(s)+" 점");
		System.out.printf("[평균] : %2.2f 점\n", avg(s));
		System.out.println("==============================");
	}
	
	public void showAllStudent() {
		System.out.println("성적 정보 일괄 확인");
		for(int i=0; i<not_fill_idx; i++) {
			showGrades(students[i]);
		}
	}
}
