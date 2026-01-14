package d0113.TV;

public class Ltv implements TV {
	public void powerOn() {
		System.out.println("LG TV 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("LG TV 전원을 끕니다.");
	}
	public void volumeUp() {
		System.out.println("LG TV 볼륨을 높입니다.");
	}
	public void volumeDown() {
		System.out.println("LG TV 볼륨을 낮춥니다.");
	}
}
