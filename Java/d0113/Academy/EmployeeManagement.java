package d0113.Academy;

public class EmployeeManagement implements Manageable{
	
	private Employee[] employees;
	private int size = 0;
	private int not_fill = 0;
	
	public EmployeeManagement() {
		size = 5;
		employees = new Employee[size];
	}

	@Override
	public void register(String name, int age, String callno) {
		if(!(size > not_fill )) expand();
		employees[not_fill] = new Employee(not_fill+1, name, callno, age);
		not_fill++;
	}
	
	@Override
	public void inquire(String select, Object obj) {
		switch(select) {
			case "직원번호":
				for(int i=0; i<not_fill; i++) {
					if(employees[i] != null  && employees[i].geteNum() == (int) obj )
						System.out.println(employees[i].toString());
				}
				break;
			case "이름":
				for(int i=0; i<not_fill; i++) {
					if(employees[i] != null && employees[i].getName().equals((String)obj) ) 
						System.out.println(employees[i].toString());
				}
				break;
			case "전화번호":
				for(int i=0; i<not_fill; i++) {
					if(employees[i] != null && employees[i].getCallNo().equals((String)obj))
						System.out.println(employees[i].toString());
				}
				break;
			case "나이":
				for(int i=0; i<not_fill; i++) {
					if(employees[i] != null && employees[i].getAge() == (int) obj)
						System.out.println(employees[i].toString());
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
			if(employees[i] == null || employees[i].geteNum() != num) continue;
			if(select.equals("이름")){
				before = employees[i].getName();
				employees[i].setName((String)after);	
			}
			if(select.equals("전화번호")){
				before = employees[i].getCallNo();
				employees[i].setCallNo((String)after);	
			}
			if(select.equals("나이")){
				before = employees[i].getAge();
				employees[i].setAge((int)after);	
			}
			break;
		}
		if (before != null) System.out.println(select+" 수정 완료 :" + before +" -> "+ after);
		else System.out.println("일치하는 직원이 없어 수정이 불가능합니다.");
	}

	@Override
	public void delete(String name, int age, String callNo) {
		Employee temp = new Employee(name, callNo, age);
		for(int i=0; i<not_fill;i++) {
			if(employees[i] != null && employees[i].equals(temp)) {
				employees[i] = null;
				break;
			}
		}
	}
	
	private void expand() {
		Employee[] tempArray = employees;
		size +=5;
		this.employees = new Employee[size];
		for(int i = 0; i<tempArray.length;i++) {
			employees[i] = tempArray[i];
		}
	}
	
	public void showAllInfo() {
		for(int i=0; i<not_fill;i++) {
			if(employees[i]!=null) {
				System.out.println(employees[i].toString());
				System.out.println("==============================");
			}
		}
	}
	
}
