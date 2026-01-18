package d0116;

public class Person implements Comparable<Person> {
	
	private String name;
	private int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 인터페이스 Comparable의 int compareTo(Object o) 메소드를 구현하여
			// 객체자료의 순서를 판단할 수 있도록 한다.
			// - 인자로 전달된 o가 작으면 양수 반환
			// - 인자로 전달된 o가 크다면 음수 반환
			// - 인자로 전돨된 o가 같으면 0반환
	@Override
	public int compareTo(Person p) {
		System.out.println(p.age+"실행...");
		
		return name.compareTo(p.name);
		
//		return age - other.age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + age;
	}
}
