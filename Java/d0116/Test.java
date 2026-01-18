package d0116;

public class Test {
	public static void main(String[] args) {
		
		int[] arr = {2,3};
		
		Object obj = arr;
		
		obj = new int[2];
		
		System.out.println(arr.getClass());
		System.out.println(obj.getClass());
	}
}
