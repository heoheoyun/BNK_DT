package d0112;

public class Person extends God implements Flyalbe, Swimable {

	@Override
	public void fly() {
		System.out.println("사람이 하늘을 납니다.");
	}
	
	@Override
	public void swim() {
		System.out.println("사람이 수영을 합니다.");
	}

}
