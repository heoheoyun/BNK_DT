package d0119;

@FunctionalInterface
interface Calculatable<T>{
	T calc(T n, T b);
}

public class LamdaGeneric {
	
	public static void main(String[] args) {
		
		Calculatable<Integer> ci = (n, m) -> n + m;
		Calculatable<Double> cd = (n, m) -> n + m;
		Calculatable<Float> cf = (n, m) -> n + m;
		
		System.out.println(ci.calc(1, 2));
		System.out.println(cd.calc(1.0, 2.3));
		System.out.println(cf.calc(1.0f, 2.8f));
	}
	
}
