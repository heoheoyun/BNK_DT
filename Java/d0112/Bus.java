package d0112;

public class Bus extends Transportation {
	
	@Override
	public void go() {
		price = 1000;
		System.out.println(price + "원에 부산행 버스에 몸을 싣고...");
	}
}
