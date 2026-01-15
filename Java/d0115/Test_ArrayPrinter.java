package d0115;

public class Test_ArrayPrinter {
	
	public static void main(String[] args) {
		
		Integer[] iArray = {-1,23,36};
		Float[] fArray = {1.1f,2.2f,3.3f};
		Double[] dArray = {1.2, 2.5, 3.1};
		String[] sArray = {"A", "b", "ce"};
		
		ArrayPrinter.printArray(iArray);
		ArrayPrinter.printArray(fArray);
		ArrayPrinter.printArray(dArray);
		ArrayPrinter.printArray(sArray);
		
	}
}
