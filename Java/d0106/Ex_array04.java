package d0106;

import java.util.Random;
import java.util.Scanner;

/*
 * 로또 번호 출력기 
 * 1~45 , 중복되지 않은 6개 만들기
 */

public class Ex_array04 {
	public static void main(String[] args) {
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int[] lotto = new int[7];
		int[] mLotto = new int[6];
		int correct = 0;
		boolean bonusC = false;
		
		for(int i=0; i<lotto.length;) {
			int lNum = rd.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if (lotto[j] == lNum) {
					break;
				}
			}		
			lotto[i] = lNum;
			i++;
		}
		for(int i = 0; i<lotto.length-2; i++) {
			for(int j=0;j<lotto.length-2-i; j++) {
				int temp;
				if (lotto[j] > lotto[j+1]) {
					temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<mLotto.length; i++) {
			boolean check = false;
			System.out.print(i+1 + "번째 로또 번호를 입력해주세요 : ");
			int mNum = sc.nextInt();
			
			if((mNum>45)||(mNum<1)) {
				System.err.println("1~45 의 수를 입력하세요.");
				i--;
				continue;
			}
			for(int j=0; j<i; j++) {
				if (mLotto[j] == mNum) {
					i--;
					check = true;
					break;
				}
			}
			if(check) {
				check = false;
				System.err.println("중복되지 않은 번호를 입력하세요.");
				continue;
			}			
			mLotto[i] = mNum;
		}
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=0; j<mLotto.length; j++) {
				if(mLotto[j] == lotto[i]) {
					correct++;
					if(i==6) bonusC = true;
					break;
				}
			}
		}
			
		System.out.print("이번주 로또 번호는 [ ");
		for (int i=0; i<lotto.length-1; i++) {
			System.out.print(lotto[i]);
			if(i == lotto.length -2) continue;
			System.out.print(" | ");
		}
		System.out.println(" ] + " + lotto[6]);

		System.out.print("당신의 로또 번호는 [ ");
		for (int i=0; i<mLotto.length; i++) {
			System.out.print(mLotto[i]);
			if(i == mLotto.length -1) continue;
			System.out.print(" | ");
		}
		System.out.println(" ] 입니다.");
		
		if(bonusC) System.out.println("+ 당신은 보너스와 함께");
		else System.out.println("당신은 보너스 없이 ");
		System.out.println("로또를 "+correct+"개 맞췄습니다.");
		
		sc.close();
			
	}
}
