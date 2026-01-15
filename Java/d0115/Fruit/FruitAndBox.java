package d0115.Fruit;

public class FruitAndBox {
	public static void main(String[] args) {
		
		Box aBox = new Box();
		Box oBox = new Box();
//		Box aBox2 = new Box();
		
		aBox.set(new Apple());
		oBox.set(new Orange());
//		aBox2.set("사과");
		
		Apple ap = (Apple) aBox.get();
		Orange og = (Orange) oBox.get();
//		Apple ap2 = (Apple) aBox2.get();
		
		System.out.println(ap);
		System.out.println(og);
	}
}
