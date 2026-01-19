package d0119;

interface Printable2{
	void print();
}

class Papers2 {
	private String con;
	
	public Papers2(String s) {
		con = s;
	}
	
	public Printable2 getPrinter() {
		// 이 메소드 안에서만 Printer 인스턴스를 생성할 수 있다.
		/*
		class Printer implements Printable{
			@Override
			public void print() {
			 System.out.println(con);
			}
		}
		*/
		/*
		return new Printable2() {
			@Override
			public void print() {
				 System.out.println(con);
			}
		};
		*/
		return () -> System.out.println(con);
	}
}

public class Ex07_AnonymousInner {
	
	public static void main(String[] args) {
		Papers2 p2 = new Papers2("서류내용 : 안녕하세요.");
		p2.getPrinter().print();
		
	}
}
