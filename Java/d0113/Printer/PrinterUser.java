package d0113.Printer;

public class PrinterUser {

	
	public static void main(String[] args) {
		
		PrinterFactory pf = new PrinterFactory("hp");
		
		Printable printer = pf.getBrand();
		
		printer.on();
		printer.print();
		printer.off();
		
		NewPrinter nPrinter = new NewPrinter();
		
		nPrinter.on();
		nPrinter.print();
		nPrinter.copy();
		nPrinter.scan();
		nPrinter.off();
		
	}
}
