package d0112;

public class Testfly {
	
	public static void main(String[] args) {
		
		Bird bird = new Bird();
		Car car = new Car();
		Person person = new Person();
		
		Flyalbe[] fly = {bird, car, person};
		
		for(int i=0; i<fly.length; i++) {
			fly[i].fly();
		}
	}
}
