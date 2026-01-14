package d0113.Printer;

public class PrinterFactory {
	private String brandName;
	
	public PrinterFactory(String brandName) {
		this.brandName = brandName.toLowerCase();
		
	}
	
	public Printable getBrand() {
		if(brandName.equals("hp")) return new HPPrinter(); 
		else if (brandName.equals("cannon")) return new CannonPrinter();
		else return null;
	}
}
