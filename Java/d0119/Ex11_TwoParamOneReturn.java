package d0119;

@FunctionalInterface
interface Calculate{
	int add(int n, int m);
	
	default int sub(int n, int m) {
		return n-m;
	}
	
	static int mul(int n, int m) {
		return n*m;
	}
}

public class Ex11_TwoParamOneReturn {

	public static void main(String[] args) {
		
		Calculate calc;
		
		calc = new Calculate() {
			@Override
			public int add(int n, int m) {
				return n+m;
			}
		};
		
		System.out.println(calc.add(1, 2));
		
		calc = (n,m) -> {
			return n + m;
		};
		
		System.out.println(calc.add(1, 3)+""+calc.sub(2, 3));
		
		calc = (n,m) -> n+m;
		
		System.out.println(calc.add(2, 3));
	}
}
