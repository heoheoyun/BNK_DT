package Library;

import java.util.ArrayList;
import java.util.Scanner;


public class LibraryService {

	//"EUC-KR은 한글 깨짐 문제시 사용, 그 이외에는 사용하지 말것!
	Scanner sc= new Scanner(System.in, "EUC-KR");
	LibraryDBA db; // 데이터베이스 클래스
	
	public LibraryService() throws Exception {
		db = new LibraryDBA();
	}
	

	//회원 가입 기능
	public void register() throws Exception{
		System.out.println("=[ 회원  가입 ]=");
		String id  = null;
		while(id == null){
			id = validTest("신규 아이디", 3, 20); //최소 3자, 최대 20자
			if(db.uSearch(id) != null) {
				id = null;
				System.out.println("이미 있는 ID 입니다.");
			}
		}
		
		String name = validTest("신규 이름", 2, 20); // 두 글자인 한국인 이름을 고려하여 2이상
		String pw = validTest("신규 비밀번호", 3, 20);
		while(checkPw(pw));
		
		db.userInsert(new User(id, pw, name));
		System.out.println("회원가입이 완료되었습니다!");
	}

	//아이디 유효성 검사
	public String validTest(String s, int min, int max) {
		String result = null;
		while(result == null) {
			System.out.print(s +" 입력 : ");
			result = sc.nextLine().trim();
			if (!(result.length() >= min && result.length() <= max)) {
				System.out.println(min + "자 이상 "+ max +"자 이내로 써주세요.");
				result =  null;
			}
		}
		return result;
	}
	
	//비밀번호 유효성 검사
	public boolean checkPw(String pw) {
		System.out.print("비밀번호 다시 입력 : ");

		if(!pw.equals(sc.nextLine().trim())) {
			System.out.println("비밀번호가 일치 하지않습니다.");
				return true;
		}
		return false;
	}
	
	//로그인 기능
	public User logIn() throws Exception {
		System.out.println("=[  로그인  ]=");
		System.out.print("ID : ");
		String id = sc.nextLine().trim();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine().trim();
		
		if(db.check(new User(id, pw))) {
			User u = db.uSearch(id);
			System.out.println("로그인에 성공하셨습니다.");
			return u;
		} else {
			System.out.println("아이디 혹은 비밀번호를 틀렸습니다.");
			return null;
		}
	}
	
	//사용자 정보 출력 기능
	public void showMyInfo(User user) throws Exception {
	    System.out.println("======[ 나의 정보 ]======");
	    System.out.println(" ID : " + user.getId());
	    System.out.println("이름: " + user.getName());
	    System.out.println("======[ 대출 목록 ]======");
	    ArrayList<Book> books = db.lbSearch(user);

	    if(books.isEmpty()) System.out.println("대출한 책이 없습니다.");
	    else {
	        for (Book book : books ) {
	            System.out.println(book);
	        }
	    }
	    System.out.println("=========================");
	}
	
	//도서 검색 기능
	public void searchBooks(User user) throws Exception {
	    System.out.println("다음 검색 조건 중에 선택해주세요.");
	    System.out.println(" - 이름 / 출판사 / 저자 / 분류코드 / 그 외 : 취소");
	    System.out.println("================================");
	    String select = sc.nextLine().trim();
		// 입력 값이 한글로 인식되는지를 위한 디버깅 코드
		// System.out.println("[DEBUG] 현재 select 값: [" + select + "]"); 
		
	    String column = "";
	    switch(select) {
	        case "이름":     column = "b_name"; break;
	        case "출판사":   column = "b_publish"; break;
	        case "저자":     column = "b_author"; break;
	        case "분류코드": column = "b_cno"; break;
	        default:
	            System.out.println("검색이 취소되었습니다.");
	            return;
	    }

	    System.out.print(select + "을(를) 입력해주세요 >> ");
	    String value = sc.nextLine().trim();
	    
		//LIKE문을 사용함으로써 포함된 단어 검색 가능함
	    String finalSql = "SELECT * FROM Books WHERE " + column + " LIKE '%" + value + "%' ORDER BY b_no";
	    ArrayList<Book> books = db.bSqlSearch(finalSql);
	    
	    System.out.println("================================");
	    if(books.isEmpty()) {
	        System.out.println("검색된 책이 없습니다.");
	    } else {
	        for (Book book : books) {
	            System.out.println(book + book.getLoanable() );
	            System.out.println("--------------------------------");
	        }
	    }
	}
	
	//도서 대출 기능
	public void bookLoan(User user) throws Exception{
        System.out.print("대출할 책 번호(b_no) 입력: ");
        String bno = sc.nextLine().trim();
        
        Book book = db.bSearch(bno);
        if(book == null) {
            System.out.println("존재하지 않는 책 번호입니다.");
            return;
        }

        // 이미 대출중인지 확인
        if(db.isLoaned(bno)) {
            System.out.println("이미 대출 중인 도서입니다.");
            return;
        }
        
        int currentCount = db.getLoanCount(user.getId());
        if(currentCount >= 3) {
            System.out.println(" [경고] 대출 한도 초과!");
            System.out.println(" 현재 " + currentCount + "권을 대출 중입니다.");
            System.out.println(" 반납 후 다시 이용해주세요.");
            return;
        }

        System.out.print("'" + book.getB_name() + "' 대출하시겠습니까? (Y/N): ");
        if(sc.nextLine().trim().equalsIgnoreCase("Y")) {
            db.insertLoan(user.getId(), bno);
            System.out.println("대출 완료!");
        }
    }

	//도서 반납 기능
	public void bookReturn(User user) throws Exception{
		if(db.lbSearch(user).size() == 0) { 
			System.out.println("대출한 책이 없습니다.");
			return;
		}
        //현재 빌린 목록을 먼저 보여줌
        showMyInfo(user);
        
        System.out.print("반납할 책 번호 입력: ");
        String bno = sc.nextLine().trim();
        
        try {
            if(!db.checkMyLoan(user.getId(), bno)) {
                System.out.println("회원님이 빌린 책이 아닙니다.");
                return;
            }
            
            System.out.print("반납하시겠습니까? (Y/N): ");
            if(sc.nextLine().trim().equalsIgnoreCase("Y")) {
                db.returnBook(user.getId(), bno);
                System.out.println("반납 완료!");
            }
        } catch (Exception e) {
            System.out.println("반납 처리 실패: " + e.getMessage());
        }
    }

	//비밀번호 변경 기능
	public void modifyPw(User user) throws Exception{
        System.out.print("현재 비밀번호: ");
        String checkPw = sc.nextLine().trim();
        
        if(!user.getPw().equals(checkPw)) {
            System.out.println("비밀번호가 틀렸습니다.");
            return;
        }
        
        String newPw = validTest("새 비밀번호", 3, 20);
        while(checkPw(newPw));
        
        
        db.updatePw(user.getId(), newPw);
        user.setPw(newPw); // 메모리 상의 정보도 업데이트
        System.out.println("변경되었습니다.");
    }

	// 탈퇴 요청 기능
    public void withdrawal_requests(User user) {
        System.out.print("정말 탈퇴하시겠습니까? (Y/N): ");
        if(sc.nextLine().trim().equalsIgnoreCase("Y")) {
            System.out.print("탈퇴 사유를 입력해주세요: ");
            String reason = sc.nextLine().trim();
            try {
                db.requestWithdrawal(user.getId(), reason);
                user.setReason(reason);
                System.out.println("탈퇴 신청이 접수되었습니다. 관리자 승인 대기중.");
            } catch (Exception e) {
                System.out.println("신청 실패: " + e.getMessage());
            }
        }
    }

	// ---------------- [ 관리자 기능 ] ----------------

	public User admin() {
		User admin = new User("admin", "admin1234");
		return admin;
	}
	
	//도서 등록 기능
	public void registBook() throws Exception {
		Book book;

		// 책 번호 중복 체크 검사
        System.out.println("책 번호를 입력해주세요.");
        String no = sc.nextLine();   
        if(db.bSearch(no) != null) {
            System.out.println("이미 존재하는 책 번호입니다.");
            return;
        }
		System.out.println("책 이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("출판사를 입력해주세요.");
		String pub = sc.nextLine();
		System.out.println("저자를 입력해주세요.");
		String aut = sc.nextLine();

		//분류코드 유효성 검사
		System.out.println("분류코드를 입력해주세요.");
		int cno = sc.nextInt();
		sc.nextLine();
		System.out.print("Y를 입력해 등록 완료를 해주세요 >> ");
		if(sc.nextLine().trim().toUpperCase().equals("Y")) {
			book = new Book(no,name,pub,aut,cno);
		} else {
			return;
		}
		db.bookInsert(book);
	}
	
	//도서 삭제 기능
	public void deleteBook() throws Exception{
		System.out.println("삭제하실 책의 번호를 입력해주세요.");
		String bno = sc.nextLine().trim();
		Book book = db.bSearch(bno);
		if(book==null) {
			System.out.println("해당 번호의 책이 없습니다.");
			return;
		}
		System.out.println(bno + " 을 삭제하시겠습니까?");
		System.out.print("Y를 입력해 삭제를 해주세요 >> ");
		if(sc.nextLine().trim().toUpperCase().equals("Y")) {
			db.bookDelete(book);
		} else {
			return;
		}
		
	}

	//회원 정보 확인 기능
	public void showAllMember() throws Exception{
        ArrayList<User> list = db.getAllUsers();
        for(User u : list) {
            // 관리자 계정은 제외
            if(!u.getId().equals("admin")) {
                    System.out.println(u);
            }
        }
    }

	//대출 및 반납 내역 조회
	public void showLog() throws Exception{
        ArrayList<Log> logs = db.selectAllLogs();
        if(logs.isEmpty()) {
            System.out.println("대출 기록이 없습니다.");
        } 
		else {
            for(Log log : logs) {
                System.out.println(log); // Log.toString() 호출
                System.out.println("-------------------------");
            }
        }
    }

	//탈퇴 요청 확인
	public void check_withdrawal_requests() throws Exception{
        ArrayList<User> list = db.getAllUsers();
        boolean exist = false;
        for(User u : list) {
            // 사유(reason)가 null이 아닌 유저만 출력
            if(u.getReason() != null && !u.getReason().isEmpty()) {
                System.out.println("ID: " + u.getId() + " | 사유: " + u.getReason());
                exist = true;
            }
        }
        if(!exist){
			System.out.println("탈퇴 요청이 없습니다.");
		}
    }

	//탈퇴 처리 기능
	public void delete_member() throws Exception{
        check_withdrawal_requests(); // 요청 목록 먼저 보여주기
        
        System.out.print("삭제할 회원 ID 입력: ");
        String targetId = sc.nextLine().trim();
        
        User target = db.uSearch(targetId);
        if(target == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }
            
        System.out.print(targetId + " 님을 영구 삭제하시겠습니까? (Y/N): ");
        if(sc.nextLine().trim().equalsIgnoreCase("Y")) {
            db.userDelete(targetId); 
            System.out.println("회원 삭제 완료.");
        }
    }
}