package d0112;

class Animal{
	void crying() {
		System.out.println("울음소리");
	}
}

class Tiger extends Animal{
	@Override
	void crying() {
		System.out.println("어흥");
	}
}

class Dog extends Animal{
	@Override
	void crying() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	@Override
	void crying() {
		System.out.println("야옹");
	}
}

public class Animals {
	public static void main(String[] args) {
		
		Animal[] animal = new Animal[3];
		animal[0] = new Tiger();
		animal[1] = new Dog();
		animal[2] = new Cat();
		
		for(int i=0; i<animal.length; i++) {
			animal[i].crying();
		}
	}
}
