package d0108;

import java.util.Scanner;

public class Test_Member {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Storage db = new Storage(10);
		
		boolean flag = false;
		
		while(!flag) {
			menu(0);
			System.out.print(">> ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1:
					System.out.println("저장을 시작합니다.");
					System.out.print("이름 : ");
					String name = sc.nextLine();
					System.out.print("번호 ( xxx-xxxx-xxxx ) : ");
					String no = sc.nextLine();
					System.out.print("성별 ( M / F ) : ");
					char gender = sc.next().charAt(0);
					sc.nextLine();
					System.out.print("주소 : ");
					String address = sc.nextLine();
					db.save(new Member(name, no, gender, address));
					break;
				case 2:
					menu(1);
					System.out.print(">> ");
					int serch = sc.nextInt();
					sc.nextLine();
					System.out.print("검색 : ");
					String serchW = sc.next();
					switch(serch) {
						case 1:
							db.searchName(serchW);
							break;
						case 2:
							db.searchNo(serchW);
							break;
						case 3:
							db.searchGender(serchW);
							break;
						case 4:
							db.searchAddress(serchW);
							break;
						default:
							System.out.println("처음 화면으로 돌아갑니다.");
					}
					break;
				case 3:
					db.showMemberList();
					break;
				case 4:
					flag = true;
					break;
				default : flag = false;
			}
			
			if(flag) break;
			else continue;
		}
		
		sc.close();
	}
	
	static void menu(int sel) {
		switch(sel) {
			case 0 :
				System.out.println("================");
				System.out.println("===== 기 능 ====");
				System.out.println("================");
				System.out.println("=== 저장 : 1 ===");
				System.out.println("=== 검색 : 2 ===");
				System.out.println("=== 조회 : 3 ===");
				System.out.println("=== 종료 : 4 ===");
				System.out.println("================");	
				break;
			case 1 :
				System.out.println("================");
				System.out.println("===== 검 색 ====");
				System.out.println("================");
				System.out.println("=== 이름 : 1 ===");
				System.out.println("=== 번호 : 2 ===");
				System.out.println("=== 성별 : 3 ===");
				System.out.println("=== 주소 : 4 ===");
				System.out.println("== 처음:그 외 ==");
				System.out.println("===============");	
				break;
		}
	}
}
