package d0114.GradeProcessingProgram;

public class Subject {
	private String subjectname;
	private int score = 0;
	
	Subject(String name, int score) {
		if(setSubjectname(name)) {
			setScore(score);
		}
	}
	
	public boolean setSubjectname(String subjectname) {
		if(subjectname.equals("국어")||subjectname.equals("영어")||subjectname.equals("수학")) {
			this.subjectname = subjectname;
			return true;
		} else {
			System.out.println("등록을 할 수 없는 과목 명입니다.");
			return false;
		}
	}
	
	public String getSubjectname() {
		return subjectname;
	}
	
	public void setScore(int score) {
		if(score<0 || 100<score) {
			System.out.println(score+ "는 기입이 불가능한 점수입니다.");
		} else {
			this.score = score;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "["+subjectname+"] : "+ score + " 점";
	}
}
