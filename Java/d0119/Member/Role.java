package d0119.Member;

public enum Role {
	ADMIN{
		@Override
		void go() {
			System.out.println("관리자 페이지로 이동합니다.");
		}
	}, MEMBER { 
		@Override
		void go() {
			System.out.println("메인 페이지로 이동합니다.");	
		}
	}, GUEST {
		@Override
		void go() {
			System.out.println("회원가입 페이지로 이동합니다.");
		}
	};
	
	abstract void go();
}
