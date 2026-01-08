package d0108;

public class Storage {
	
	private Member[] members;
	
	Storage(int size) {
		members = new Member[size];
	}
	
	void save(Member member) {
		for(int i=0; i<members.length; i++) {
			if(members[i] == null) {
				members[i] = member;
				return;
			}
		}
		System.out.println("저장 공간이 부족하여 저장을 못했습니다.");
	}

	void searchName(String name) {
		boolean serched = false;
		for(int i=0; i<members.length; i++) {
			if(members[i] != null && members[i].getName().equals(name)) {
				serched = true;
				showInfo(i);
			}
		}
		if (!serched) System.out.println(name + "의 이름 정보가 존재하지 않습니다.");
	}
	void searchNo(String no) {
		boolean serched = false;
		for(int i=0; i<members.length; i++) {
			if(members[i] != null && members[i].getCallNo().equals(no)) {
				serched = true;
				showInfo(i);
			}
		}
		if (!serched) System.out.println(no + "의 번호 정보가 존재하지 않습니다.");
	}
	void searchGender(String gender) {
		boolean serched = false;
		for(int i=0; i<members.length; i++) {
			if(members[i] != null && members[i].getGender().equals(gender)) {
				serched = true;
				showInfo(i);
			}
		}
		if (!serched) System.out.println(gender + "의 성별 정보가 존재하지 않습니다.");
	}
	void searchAddress(String add) {
		boolean serched = false;
		for(int i=0; i<members.length; i++) {
			if(members[i] != null && members[i].getAddress().equals(add)) {
				serched = true;
				showInfo(i);
			}
		}
		if (!serched) System.out.println(add + "이 주소 정보가 존재 하지 않습니다.");
	}
	
	void showMemberList() {
		for(int i=0; i<members.length; i++) {
			if(members[i] != null) showInfo(i);
		}
	}
	
	void showInfo(int m) {
		System.out.println(members[m]);
	}
}
