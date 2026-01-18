package d0116;

import java.util.Arrays;

public class SortTest {
	
	public static void main(String[] args) {
		int[] ar1 = {1, 5, 2, 3, 4};
		Arrays.sort(ar1);
		
		for(int n: ar1) {
			System.out.print(n +"\t");
		}
		System.out.println();
		int[] array = { 9, 7, 5, 3, 6};
		SelectionSort.sort(array);
		
		System.out.println();
		for(int n : array) {
			System.out.print(n + "\t");
		}
		System.out.println();
	}
}
