package d0106;

import java.util.Random;

/*
 * 배열 정리하기
 * 
 */

public class Ex_array05 {
	public static void main(String[] args) {
		
		Random rd = new Random();
		int[] A = new int[15];
		
		for(int i = 0; i<A.length; i++) {
			A[i] = rd.nextInt(201) -100;
		}
		
		System.out.print("기존 배열 A : [");
		for (int i=0; i<A.length; i++) {
			System.out.print(" "+A[i]+" ");
		}
		System.out.println("]");
		
		for(int i = 0; i<A.length-1; i++) {
			for(int j=0;j<A.length-1-i; j++) {
				int temp;
				if (A[j] > A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		System.out.print("정렬 배열 A : [");
		for (int i=0; i<A.length; i++) {
			System.out.print(" "+A[i]+" ");
		}
		System.out.println("]");
	}
}
