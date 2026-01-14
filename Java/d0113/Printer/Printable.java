package d0113.Printer;

public interface Printable {
	
	public void on();
	public void off();
	public void print();
	
	default public void showEndMessage() {
		System.out.println("행동이 완료되었습니다.");
	}
}
