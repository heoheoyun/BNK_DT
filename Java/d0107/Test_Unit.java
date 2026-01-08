package d0107;

public class Test_Unit {

	public static void main(String[] args) {
		
		Unit u1 = new Unit("Red");
		Unit u2 = new Unit("Green");
		Unit u3 = new Unit("Blue");
		
		System.out.println(u1.unitInfo());
		System.out.println(u2.unitInfo());
		System.out.println(u3.unitInfo());
		
		u1.attack(u3);
		u2.attack(u1);
		u2.attack(u3);
		u3.attack(u2);
		u1.attack(u2);
		u1.attack(u2);
		u2.attack(u3);
		u3.attack(u1);
		u1.attack(u2);
		
		System.out.println(u1.unitInfo());
		System.out.println(u2.unitInfo());
		System.out.println(u3.unitInfo());
		
	}
}
