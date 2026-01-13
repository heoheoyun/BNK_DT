package d0112;

public class Train extends Transportation {
	
	@Override
	public void go() {
		price = 3000;
		System.out.println(price + "원에 부산행 기차에 몸을 싣고...");
	}
}
