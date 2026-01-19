package d0119;

interface HowLong{
	int length(String s);
}

public class Ex10_OneParamOneReturn {
	
	public static void main(String[] args) {
		
		HowLong hl;
		
		hl = new HowLong() {
			@Override
			public int length(String s) {
				return s.length();
			}
		};
		
		System.out.println(hl.length("Hello"));
		
		hl = (s) -> {
			return s.length();
		};
		
		System.out.println(hl.length("Good"));
		
		hl = s -> s.length();
		
		System.out.println(hl.length("Bye"));
	}
}
