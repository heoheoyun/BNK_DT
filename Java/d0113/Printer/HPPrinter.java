package d0113.Printer;

public class HPPrinter implements Printable {
	
	@Override
	public void on() {
		System.out.println("HP 프린터의 동작을 시작합니다.");
	}
	@Override
	public void off() {
		System.out.println("HP 프린터의 동작을 멈춥니다.");
	}
	@Override
	public void print() {
		System.out.println("HP 프린터가 출력을 합니다.");
		showEndMessage();
	}
}
