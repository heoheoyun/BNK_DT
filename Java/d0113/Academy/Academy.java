package d0113.Academy;

public class Academy {

	public static void main(String[] args) {
		
		StudentManagement sm = new StudentManagement();
		EmployeeManagement em = new EmployeeManagement();
		
		sm.register("김학생", 20, "010-0000-1111");
		sm.register("이학생", 21, "010-1111-2222");
		sm.register("정학생", 22, "010-3333-4444");
		sm.register("박학생", 23, "010-5555-6666");
		sm.register("전학생", 24, "010-7777-8888");
		
		em.register("김직원", 30, "010-0011-1122");
		em.register("이직원", 31, "010-1122-2233");
		em.register("정직원", 32, "010-3344-4455");
		em.register("박직원", 33, "010-5566-6677");
		em.register("전직원", 34, "010-7788-8899");
		
		sm.showAllInfo();
//		em.showAllInfo();
		
		sm.inquire("이름", "정학생");
		sm.modify("이름",3, "오학생");
		sm.showAllInfo();
		sm.delete("박학생", 23, "010-5555-6666");
		sm.showAllInfo();
		sm.register("배학생", 25, "010-8888-9999");
		sm.showAllInfo();
	}
}
