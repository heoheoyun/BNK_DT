package d0105;
/*
 C에서 했던 가위바위보 간단하게 구현하기
 */

import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int rdNum = rd.nextInt(3) + 1;
		
		Scanner sc = new Scanner(System.in);
		
		//String[] hands = {"", "가위", "바위", "보"};
		
		int input = 0;
		while (true) {
			System.out.print("가위 : 1 | 바위 : 2 | 보 : 3 | 중에 선택하여주세요. \n >> ");
			input = sc.nextInt();
			if (input == 1 || input == 2 || input == 3) break;
		}
		
		//System.out.println("나 | "+hands[input]+" vs "+hands[rdNum]+ " | 컴퓨터");
		
		switch((input-rdNum+3)%3) {
			case 0:
				System.out.println("비겼습니다.");
				break;
			case 1:
				System.out.println("이겼습니다.");
				break;
			case 2 :
				System.out.println("졌습니다.");
				break;
		}
		
		sc.close();	
	}

}
