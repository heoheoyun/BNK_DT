package d0114.GradeProcessingProgram;

import java.util.Random;

public class TestGPP {
	
	public static void main(String[] args) {
		
		GradeProcessingProgram gpp = new GradeProcessingProgram();
		
		String[] names = { "김학생", "이학생", "박학생", "최학생", "장학생"};
		Random rd = new Random(); 
		for(int i=0; i<names.length;i++) {
			gpp.addStudent(new Student(i+1, names[i]));
			gpp.addSubject(names[i], new Subject("국어", rd.nextInt(101)));
			gpp.addSubject(names[i], new Subject("영어", rd.nextInt(101)));
			gpp.addSubject(names[i], new Subject("수학", rd.nextInt(101)));
		}
		gpp.showAllStudent();
	}
}
