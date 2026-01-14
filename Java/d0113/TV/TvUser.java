package d0113.TV;

public class TvUser {
	
	public static void main(String[] args) {
		
		
		TVFactory tvf = new TVFactory("Samsung");
		TV tv = tvf.getBrand();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
