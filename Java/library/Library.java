package Library;

import java.util.Scanner;

public class Library {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		LibraryService ls = new LibraryService(); //내부 기능 클래스
		User u = null;
		
		while(true) {
			//시작 화면
			while(u == null) {
				System.out.println("=[ 시작  화면 ]=");
				System.out.println(" 회원 가입 : 1 ");
				System.out.println("   로그인  : 2 ");
				System.out.println(" 메뉴 종료 : 3 ");
				System.out.println("================");
				System.out.print(">> ");
				int select = sc.nextInt();
				sc.nextLine();
				switch (select) {
				case 1 :
					ls.register();
					break;
				case 2 :
					u = ls.logIn();
					break;
				case 3:
					sc.close();
					System.exit(0);
					break;
				default :
					continue;
				}
			}
			
			//로그인 확인 메세지 출력 구문
			System.out.println();
			if(u != null) {
				System.out.println(u.getName() + "님 로그인 환영합니다.");
			}
			
			//일반 사용자
			while (u != null && !u.equals(ls.admin())) {
				System.out.println("=[ 회원 화면 ]=");
				System.out.println("    내 정보    : 1 ");
				System.out.println("    책 조회    : 2 ");
				System.out.println("    책 대출    : 3 ");
				System.out.println("    책 반납    : 4 ");
				System.out.println(" 비밀번호 변경 : 5 ");
				System.out.println(" 회원탈퇴 신청 : 6 ");
				System.out.println("   로그 아웃   : 0 ");
				System.out.println("===============");
				System.out.print(">> ");
				String select = sc.nextLine();
				switch (select) {
				case "1" :
					ls.showMyInfo(u);
					break;
				case "2" :
					ls.searchBooks(u);
					break;
				case "3" :
					ls.bookLoan(u);
					break;
				case "4":
					ls.bookReturn(u);
					break;
				case "5" :
					ls.modifyPw(u);
					break;
				case "6" :
					ls.withdrawal_requests(u);
					break;
				case "0" : 
					u = null;
					System.out.println("로그아웃 되었습니다.");
					break;
				default :
					continue;
				}		
			}
			//관리자
			while (u != null && u.equals(ls.admin())) {
				System.out.println("= [ 관리자 화면 ] =");
				System.out.println("  책 등록 하기  : 1 ");
				System.out.println("  책 삭제 하기  : 2 ");
				System.out.println("  책 조회 하기  : 3 ");
				System.out.println(" 회원 정보 조회 : 4 ");
				System.out.println(" 대출 내역 조회 : 5 ");
				System.out.println(" 탈퇴 요청 확인 : 6 ");
				System.out.println(" 탈퇴 처리하기  : 7 ");
				System.out.println("  로그  아웃  : 0 ");
				System.out.println("===================");
				System.out.print(">> ");
				String select = sc.nextLine();
				switch (select) {
				case "1" :
					ls.registBook();
					break;
				case "2" :
					ls.deleteBook();
					break;
				case "3" :
					ls.searchBooks(u);
					break;				
				case "4" : 
					ls.showAllMember();
					break;
				case "5" :
					ls.showLog();
					break;
				case "6" :
					ls.check_withdrawal_requests();
					break;
				case "7" :
					ls.delete_member();
					break;
				case "0" : 
					u = null;
					System.out.println("로그아웃 되었습니다.");
					break;
				default :
					continue;
				}		
			}
		}
	}
}
