package d0114.GradeProcessingProgram;

public class Student {
	
	private int sno;
	private String name;
	private Subject[] subjects;
	
	Student(int sno, String name){
		this.sno = sno;
		this.name = name;
		subjects = new Subject[3];
	}
	
	public int getSno() {
		return sno;
	}
	
	public String getName() {
		return name;
	}
	
	public void addSubject(Subject sub) {
	    for(int i=0; i<subjects.length; i++) {
	        if(subjects[i] == null) {
	            subjects[i] = sub;
	            return;
	        }
	    }
	    System.out.println("더 이상 과목 추가가 안됩니다.");
	}
	
	public Subject[] getSubjects() {
		return subjects;
	}
}
