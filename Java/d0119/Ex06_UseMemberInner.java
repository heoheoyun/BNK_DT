package d0119;

interface Printable{
	void print();
}

class Papers {
	private String con;
	
	public Papers(String s) {
		con = s;
	}
	
	public Printable getPrinter() {
		// 이 메소드 안에서만 Printer 인스턴스를 생성할 수 있다.
		class Printer implements Printable{
			@Override
			public void print() {
			 System.out.println(con);
			}
		}
		return new Printer();
	}
}

public class Ex06_UseMemberInner {
	public static void main(String[] args) {
		Papers p = new Papers("서류내용 : 안녕하세요.");
		
		Printable prn = p.getPrinter();
		prn.print();
		
	}
}
