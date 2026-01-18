package d0116;

public class MySystem {
	
	public static <T>void arrayCopy(T[] org, int oStart, T[] copy, int cStart, int length) {
				
		for(int i=0; i<length; i++) {
			copy[cStart+i] = org[oStart+i];
		}
	}
	
}
