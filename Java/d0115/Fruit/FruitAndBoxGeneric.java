package d0115.Fruit;

public class FruitAndBoxGeneric {

	public static void main(String[] args) {
		
		Box2<Apple> aBox = new Box2<Apple>();
		Box2<Orange> oBox = new Box2<Orange>();
		
		aBox.set(new Apple());
		oBox.set(new Orange());
		
		Apple ap = aBox.get();
		Orange og = oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
		
	}
}
