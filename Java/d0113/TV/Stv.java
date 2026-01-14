package d0113.TV;

public class Stv implements TV {
	
	public void powerOn() {
		System.out.println("삼성 TV 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("삼성 TV 전원을 끕니다.");
	}
	public void volumeUp() {
		System.out.println("삼성 TV 볼륨을 높입니다.");
	}
	public void volumeDown() {
		System.out.println("삼성 TV 볼륨을 낮춥니다.");
	}
}
