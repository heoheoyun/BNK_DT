package d0109;

public class Test_InfinityArray {
	
	public static void main(String[] args) {
//		Random rd = new Random();
	
		InfinityArray arr = new InfinityArray(3);
		
		for(int i=0; i<5; i++) {
			arr.insert(i+1);
		}
		
		arr.modify(2, 10);
		System.out.println(arr.not_fill_idx);
		arr.printArray();
		arr.delete(1);
		arr.printArray();
		arr.delete(1);
		arr.printArray();
	}
}