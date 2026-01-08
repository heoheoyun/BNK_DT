package d0106;

import java.util.Scanner;

/*
 * C에서 했던 계산기 여러 함수를 사용해 구현
 * 배열 활용
 * 계산기 중지기능 구현
 * 한 번에 사칙연산 다 나오게 하기
 */


public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] used = new int[9];
		
		System.out.println("계산기를 실행합니다.");
		
		while(true) {
			Option();
			
			int select = sc.nextInt();
			
			if(select/9!=0) continue;
			
			used[select] ++;
			
			if(select == 0) {
				System.out.println("계산기가 종료됩니다.");
				System.out.println("==========================================");
				break;
			}
			
			System.out.println("연산이 선택 완료되었습니다.");
			System.out.println("==========================================");
			System.out.println("좌항을 입력해 주세요.");
			System.out.print(">> ");
			int a = sc.nextInt();
			System.out.println("==========================================");
			int b = 0;
				while (true) {
					System.out.println("우항을 입력해주세요.");
					System.out.print(">> ");
					b = sc.nextInt();
					if ((select==4 || select==5 || select==6 || select==8) && b == 0) {
						System.out.println("나누기는 0으로 나눌 수 없습니다.");
						continue;
					}
					break;
				}
			
			System.out.println();
			System.out.printf("계산 결과는 ");
			Result(Calc(a,b), select);
		}
		sc.close();
		
		System.out.println("지금까지 사용된 연산의 횟수는");
		System.out.println("덧셈 : "+used[1]+"회");
		System.out.println("뺄셈 : "+used[2]+"회");
		System.out.println("곱셈 : "+used[3]+"회");
		System.out.println("나눗셈 : "+used[4]+"회");
		System.out.println("몫 : "+used[5]+"회");
		System.out.println("나머지 : "+used[6]+"회");
		System.out.println("제곱 : "+used[7]+"회");
		System.out.println("사친연산 : "+used[8]+"회");
		
	}
	
	public static void Option() {
		System.out.println("\n==========================================");
		System.out.println("원하는 연산에 해당하는 옵션을 입력하세요.");
		System.out.println(" |  + :  1 | -  :  2 |   ×  : 3 | " );
		System.out.println(" |  ÷ :  4 | 몫 :  5 |나머지: 6 | ");
		System.out.println(" |제곱:  7 |  모든 사칙연산 : 8 | ");
		System.out.println(" |  계산기 종료 : 0  | " );
		System.out.println("==========================================");
		System.out.print(">> ");
	}
	
	
	public static double[] Calc(int a, int b) {
		
		double[] result = new double[7];
		
		result[0] = a + b;
		result[1] = a - b;
		result[2] = a * b;
		result[3] = a / (double)b;
		result[4] = a / b;
		result[5] = a % b;
		result[6] = 1;
		if(b>=0) {
			for(int i = 0; i<b ; i++) {
					result[6] = result[6] * a;
			}
		} else {
			b = b * (-1);
			for(int i = 0; i<b ; i++) {
				result[6] = result[6] / (double)a;
			}
		}
		return result;
	}
	
	public static void Result(double[] calc, int select) {
		
		if(select==8) {
			System.out.println("덧  셈 : " + (int)calc[0]);
			System.out.println("뺄  셈 : " + (int)calc[1]);
			System.out.println("곱  셈 : " + (int)calc[2]);
			System.out.println("나눗셈 : " + calc[3]);
			return;
		}
		if(select != 4 && select != 7)System.out.print((int)calc[select-1]);
		else System.out.print(calc[select-1]);
	}
	
}
