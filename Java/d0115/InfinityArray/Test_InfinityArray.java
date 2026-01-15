package d0115.InfinityArray;

public class Test_InfinityArray {
	
	public static void main(String[] args) {
		
		InfinityArray<String> sArray = new InfinityArray<>();
		InfinityArray<Integer> iArray = new InfinityArray<>();
		
		System.out.println(sArray.size());
		System.out.println(sArray.isEmpty());
		System.out.println(sArray);
		sArray.add("A");
		sArray.add("B");
		sArray.add("C");
		sArray.add("D");
		sArray.add(0,"E");
		System.out.println(sArray.get(1));
		System.out.println(sArray);
		
		iArray.add(1);
		iArray.add(2);
		iArray.add(3);
		iArray.add(4);
		iArray.add(5);
		System.out.println(iArray);
		iArray.add(1,6);
		System.out.println(iArray);
		
		iArray.set(2, 100);
		iArray.remove(0);
		System.out.println(iArray.contains(5));
		System.out.println(iArray.contains(10));
		System.out.println(iArray);
	}
}
