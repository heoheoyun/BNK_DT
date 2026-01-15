package d0114;

public class My_Exception extends Exception {
	
	public My_Exception(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
