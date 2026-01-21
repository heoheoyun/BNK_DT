package d0121;

import java.util.Scanner;

public class Member_Test {
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		MemberService ms = new MemberService();
		
		Member m = null;
		
		boolean menu = true;
		
		while(menu) {
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
				ms.register();
				break;
			case 2 :
				m = ms.logIn();
				if(m != null) menu = false;
				break;
			default :
				continue;
			}
		}
		
		System.out.println();
		if(m != null) {
			System.out.println(m.getName() + "님 로그인 환영합니다.");
			menu = true;
		}
		
		while (m != null) {
			System.out.println("=[ 회원 화면 ]=");
			System.out.println("    내 정보    : 1 ");
			System.out.println("   이름 변경   : 2 ");
			System.out.println(" 비밀번호 변경 : 3 ");
			System.out.println("    로그 아웃  : 0 ");
			System.out.println("===============");
			System.out.print(">> ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
			case 1 :
				ms.showMyInfo(m);
				break;
			case 2 :
				m = ms.modifyName(m);
				break;
			case 3 :
				m = ms.modifyPW(m);
				break;
			case 0 : 
				m = null;
				System.out.println("로그아웃 되었습니다.");
				break;
			default :
				continue;
			}		
		}
		
		sc.close();
	}
}
