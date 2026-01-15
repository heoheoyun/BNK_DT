package d0114;

public class Test {
	
	public void f1() throws My_Exception {
		try {
			f2();
		} catch (NullPointerException e) {
			System.out.println("f1() catch....");
			throw new My_Exception(e.getMessage());
		}
	}
	
	public void f2() throws NullPointerException {
		String s = null;
		int n = s.length();
	}
	
	public static void main(String[] args) throws NullPointerException  {	
		
		Test t = new Test();
		try {
			t.f1();
		} catch (My_Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end.....");
	}
	
}

//// 