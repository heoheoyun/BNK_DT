package d0105;

public class Test {

	public static void main(String[] args) {
		
		int sum = 0;
		int cnt = 0;
		
		while (cnt < 5) {
			sum += cnt;
			System.out.println(sum);
			cnt ++;
			if(sum>5) break;
		}
				
		System.out.println("sum : " + sum);
	}

}
