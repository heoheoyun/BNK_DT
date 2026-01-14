package d0113.Printer;

public class NewPrinter implements multifunctionable {

	@Override
	public void on() {
		System.out.println("복합기의 동작을 시작합니다.");
	}
	@Override
	public void off() {
		System.out.println("복합기의 동작을 멈춥니다.");
	}
	@Override
	public void print() {
		System.out.println("복합기가 출력을 합니다.");
		showEndMessage();
	}
	@Override
	public void copy() {
		System.out.println("복합기가 복사를 합니다.");
		showEndMessage();
	}
	@Override
	public void scan() {
		System.out.println("복합기가 문서를 읽습니다.");
		showEndMessage();
	}
}
