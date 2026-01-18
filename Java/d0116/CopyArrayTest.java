package d0116;

import java.util.Arrays;

public class CopyArrayTest {
	
	public static void main(String[] args) {
		
		Double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		Double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
		
		Double[] arCpy2 = Arrays.copyOf(arOrg, 3);
		
		Double[] arCpy3 = Arrays.copyOfRange(arOrg, 2,4);
		
		Double[] cpy = new Double[3];
		
		MySystem.arrayCopy(arOrg, 0, cpy, 0, 3);
		
		printArray(arCpy1);
		System.out.println();
		printArray(arCpy2);
		System.out.println();
		printArray(arCpy3);
		System.out.println();
		printArray(cpy);
	}
	
	static <T>void printArray(T[] obj) {
		for(T o : obj) {
			System.out.print(o+"\t");
		}
	}
}
