package d0108;

import java.util.Scanner;

public class Test_Calc {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		intro();
		
		int[] abo = select();
		
		int oper = abo[0], a = abo[1], b = abo[2] ;
		
		double result;
		
		switch(oper) {
			case 0 :
				System.out.println("0으로 나눌 수 없습니다.");
				result = 0;
				break;
			case 1 :
				result = calc.add(a,b);
				break;
			case 2 :
				result = calc.sub(a,b);
				break;
			case 3 :
				result = calc.multi(a, b);
				break;
			case 4 :
				result = calc.div(a, b);
				break;
			default: result = 0;
		}
		
		System.out.println("계산 결과 : " + result);
	}
	
	static void intro() {
		System.out.println("==========================");
		System.out.println("======= 계산기 V1.0 ======");
		System.out.println("==========================");
		System.out.println("==연산자를 입력해주세요.==");
		System.out.println("==== + : 1  ||  - : 2 ====");
		System.out.println("==== × : 3  ||  ÷ : 4 ====");
		System.out.println("==========================");
		
	}
	
	static int[] select() {
		Scanner sc = new Scanner(System.in);
		int[] abo = new int[3];
		System.out.print("=========>    ");
		abo[0] = sc.nextInt();
		
		while(abo[0] < 1 || abo[0] > 4) {
			System.out.println("== 1 ~ 4 에서 고르세요. ==");
			System.out.print("=========>    ");
			abo[0] =  sc.nextInt();
		}
		
		System.out.println("== 좌항을 입력해주세요. ==");
		System.out.println("==========================");
		System.out.print("=========>    ");
		abo[1] = sc.nextInt();
		System.out.println("== 우항을 입력해주세요. ==");
		System.out.println("==========================");
		System.out.print("=========>    ");
		abo[2] = sc.nextInt();
		
		if((abo[0] == 4)&&(abo[2] == 0)) abo[0] = 0;
		
		sc.close();
		return abo;
	}
}
