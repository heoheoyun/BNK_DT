package d0114;

public class Ex_Exception {

	public static void main(String[] args) {
		
		try {
			int n = 4/0;
			System.out.println(n);
			int[] arr = new int[3];
			arr[3] = 5;
		}catch (Exception e) {
			System.out.println(e);
		System.out.println("end");
		}
	}
}
