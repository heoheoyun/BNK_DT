package d0114.InfinityObjectArray;

public class TestIOA {
	
	public static void main(String[] args) {
		
		InfinityObjectArray ioa = new InfinityObjectArray();
		
		ioa.add(new C());
		ioa.add("안녕");
		ioa.add(new A());
		ioa.add(new B());
		ioa.add(new B());
		ioa.add(3.14);
		ioa.add(new A());
		ioa.add(new B());
		ioa.add(new A());
		ioa.add(new C());
		ioa.add(new A());
		ioa.add(5);
		
		ioa.showArray();
		ioa.modify(2, new C());
		
		ioa.fPractice();
	}
}
