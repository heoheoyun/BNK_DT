package d0119;

interface Flyable{
	void fly();
}

public class Ex08_NoParamNoReturn {
	public static void main(String[] args) {
		Flyable f;
		f = new Flyable() {
			
			@Override
			public void fly() {
				System.out.println("날자~~");
				
			}
		};
		
		f.fly();
		
		f = () -> {
			System.out.println("날자고~~");
		};
		
		f.fly();
		
		f = () -> { 
		System.out.println("날자고라~~");
		System.out.println("Hello");
		};
		f.fly();
	}
}
