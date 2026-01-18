package d0116;

import java.util.HashSet;
import java.util.Set;

public class ExSetTest {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("사과");
		set.add("바나나");
		set.add("오렌지");
		set.add("포도");
		
		System.out.println("set의 크기 : " + set.size());
		boolean tf = set.contains("사과");
		System.out.println(tf);
		
		set.remove("오렌지");
		System.out.println(set.size());
		System.out.println(set);
		
		set.add("사과");
		System.out.println(set);
	}
}
