package d0114.InfinityObjectArray;

public class A extends Parents{

	String s;
	
	@Override
	public void f() {
		af();
	}
	
	public void af() {
		System.out.println("A의 af() 실행");
	}
	
	@Override
	public String toString() {
		return "A [s=" + s + "]";
	}
}
