package d0109;

import java.util.Scanner;

public class Test_Member {
	
	public static void main(String[] args) {
		
		Member member;
		
		Scanner sc = new Scanner(System.in);
		
		String id ="", pw = "", name = "", gender ="";
		
		System.out.println("회원가입을 시작합니다.");
		
		while(true) {
			if(id.length()<4) {
				System.out.print("4글자 이상의 아이디를 입력해주세요 >>");
				id = sc.nextLine().trim();
				continue;
			}
			if(pw.length()<8) {
				System.out.print("8글자 이상의 패스워드를 입력해주세요 >> ");
				pw = sc.nextLine().trim();
				continue;
			}
			if(name.isEmpty()) {
				System.out.print("이름을 입력해주세요 >> ");
				name = sc.nextLine().trim();
				continue;
			}
			System.out.println("성별을 입력해주세요.");
			System.out.print("[ 남자 / 여자 ] >>");
			gender = sc.nextLine().trim();
			if(gender.isEmpty()) member = new Member(id, pw, name);
			else member = new Member(id, pw, name, gender);
			System.out.println("회원가입이 완료되었습니다.");
			break;
		}
		
		String logId ="";
		String logPw = "";
		int count = 3;
		
		while(count > 0) {
			System.out.print("로그인을 하시려면 Y 아니라면 그 외 입력 >>");
			
			if(sc.nextLine().trim().equalsIgnoreCase("Y")){
				System.out.print("ID : ");
				System.out.print(">>");
				logId = sc.nextLine().trim();
				System.out.print("PassWord : ");
				System.out.print(">>");
				logPw = sc.nextLine().trim();
			 	if(member.check(logId,logPw)) {
			 		System.out.println("안녕하세요. "+member.getName()+"님");
			 		System.out.println(member.toString());
			 		break;
			 	}
			 	else {
			 		System.out.println("ID또는 비밀번호가 틀렸습니다. (남은 기회: " + count + "번)");
			 		count --;
			 	}
			 	
			} else {
				break;
			}
		}
		
		if(count == 0) System.out.println("로그인 기회가 다 소진되어 프로그램이 종료됩니다.");
		else System.out.println("프로그램이 정상 종료됩니다.");
		
		sc.close();
	}
}
