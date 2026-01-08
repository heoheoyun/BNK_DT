package d0105;

/*
 for 문법
 for(초기화;조건식;증감식){
 	실행문;
 }
중첩 반복문
 */

public class Ex_for {

	public static void main(String[] args) {
		
		for(int k = 1; k < 10 ; k++ ) {
				System.out.print("=[ " + k+" 단 ]= \t");
			}
		for(int n = 1; n<10; n++) {
			System.out.println();
			for(int m = 1; m<10; m++) {
				System.out.print(m+ " x " + n + " = " + m*n + "\t");
			}
		}
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i<5; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 4; i>0; i--) {
			for(int j=0; j<5-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
