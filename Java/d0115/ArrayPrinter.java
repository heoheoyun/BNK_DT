package d0115;

public class ArrayPrinter {
	
	static public <T>void printArray(T[] t){
		
		for(int i=0; i<t.length; i++) {
			System.out.println(t[i]);
		}
	}
}
