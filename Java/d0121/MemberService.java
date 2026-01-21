package d0121;

import java.sql.ResultSet;
import java.util.Scanner;

public class MemberService {
	
	Scanner sc = new Scanner(System.in);
	
	public void register() throws Exception{
		DBAccess db = new DBAccess();
		System.out.println("=[ 회원  가입 ]=");
		String id  = null;
		while(id == null){
			System.out.print("신규");
			id = validTest("아이디", 3, 20);
			ResultSet rs = db.search(id);
			if(rs.next()) {
				id = null;
				System.out.println("이미 있는 ID 입니다.");
				continue;
			}
			rs.close();
		}	
		System.out.print("신규");
		String name = validTest("이름", 3, 20);
		System.out.print("신규");
		String pw = validTest("비밀번호", 3, 20);
		while(checkPw(pw));
		
		db.insert(new Member(id, pw, name));
		db.close();
		
		System.out.println("회원가입이 완료되었습니다!");
	}
	
	public Member logIn() throws Exception {
		DBAccess db = new DBAccess();
		System.out.println("=[  로그인  ]=");
		System.out.print("ID : ");
		String id = sc.nextLine().trim();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine().trim();
		
		if(db.check(new Member(id, pw))) {
			
			Member m = newMember(id);
			System.out.println("로그인에 성공하셨습니다.");
			db.close();
			return m;
		} else {
			System.out.println("아이디 혹은 비밀번호를 틀렸습니다.");
			db.close();
			return null;
		}
	}
	
	public Member modifyPW(Member member) throws Exception{
		DBAccess db = new DBAccess();
		
		System.out.print("새로운 비밀번호 입력 : ");
		String pw = validTest("비밀번호", 3, 20);
		
		System.out.println("변경을 위한 원래 비밀번호를 입력해주세요. ");
		if(!checkPw(member.getPw())) {
			return member;
		}
		
		db.update(new Member(member.getId(), pw, member.getName()));
		db.close();
		System.out.println("변경이 완료되었습니다.");
		return newMember(member.getId());
	}
	
	public Member modifyName(Member member) throws Exception{
		DBAccess db = new DBAccess();
		
		System.out.print("새로운 이름 ");
		String name = validTest("이름", 3, 20);

		System.out.print("변경을 위한 원래 비밀번호 입력해주세요. ");
		if(!checkPw(member.getPw())) {
			return member;
		}

		db.update(new Member(member.getId(), member.getPw(), name));
		db.close();
		System.out.println("변경이 완료되었습니다.");
		return newMember(member.getId());
	}
	
	public void showMyInfo(Member member) throws Exception {
		DBAccess db = new DBAccess();
		ResultSet rs = db.search(member.getId());
		rs.next();
		System.out.println("======[ 나의 정보 ]======");
		System.out.println(new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name")));
		System.out.println("=========================");
		rs.close();
		db.close();
	}
	
	public void showAllMember() throws Exception {
		DBAccess db = new DBAccess();
		ResultSet rs = db.searchAll();
		while(rs.next()) {
			System.out.println(new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name")));
			System.out.println("=========================");
		}
		rs.close();
		db.close();
	}
	
	public Member newMember(String id) throws Exception {
		DBAccess db = new DBAccess();
		ResultSet rs = db.search(id);
		rs.next();
		Member m =new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
		rs.close();
		db.close();
		return m;
	}
	
	public String validTest(String s, int min, int max) {
		String result = null;
		while(result == null) {
			System.out.print(" "+ s +" 입력 : ");
			result = sc.nextLine().trim();
			if (!(result.length() >= min && result.length() <= max)) {
				System.out.println(min + "자 이상 "+max+"자 이내로 써주세요.");
				result =  null;
			}
		}
		return result;
	}
	
	public boolean checkPw(String pw) {
		System.out.print("비밀번호 다시 입력 : ");
		if(!pw.equals(sc.nextLine().trim())) {
			System.out.println("비밀번호가 일치 하지않습니다.");
			return true;
		}
		return false;
	}
}
