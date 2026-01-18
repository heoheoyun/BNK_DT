package d0116.Dictionary;

import java.util.Scanner;

public class TestDictionary {
	
	public static void main(String[] args) {
		
		int select = -1;
		
		Scanner sc = new Scanner(System.in);
		Dictionary dict = new Dictionary();
		
		while(select !=5) {
			System.out.println("=====[한영 사전 프로그램]=====");
			System.out.println("=== 기능을 선택해 주세요.");
			System.out.println("=== [1] : 등록 ");
			System.out.println("=== [2] : 모두 조회 ");
			System.out.println("=== [3] : 선택 조회 ");
			System.out.println("=== [4] : 퀴즈 ");
			System.out.println("=== [5] : 종료 ");
			System.out.println("==============================");
			System.out.print("입력을 해주세요 >> ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1 :
					dict.add();
					break;
				case 2 :
					dict.getAll();
					break;
				case 3 :
					System.out.print("검색하실 단어를 입력해주세요 : ");
					String search = sc.nextLine().trim().toLowerCase();
					dict.getBy(search);
					break;
				case 4:
					dict.quiz();
					break;
				default:
					continue;
			}
		}
		System.out.println("사전이 종료됩니다.");
		
		sc.close();
	}
}
