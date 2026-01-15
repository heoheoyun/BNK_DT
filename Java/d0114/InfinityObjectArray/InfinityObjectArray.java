package d0114.InfinityObjectArray;

public class InfinityObjectArray {
	
	int size = 0;
	Object[] oArray;
	private int not_fill_idx = 0;
	
	public InfinityObjectArray() {
		size = 3;
		oArray = new Object[size];
	}
	
	public void add(Object obj) {
		System.out.println("추가 : " + obj);
		if(!(size>not_fill_idx)) {
			Object[] temp = oArray;
			size += 3;
			oArray = new Object[size];
			for(int i=0; i<temp.length; i++) {
				oArray[i] = temp[i];
			}
		}
		oArray[not_fill_idx] = obj;
		not_fill_idx++;
	}
	
	public void modify(int idx, Object obj) {
		if(idx>not_fill_idx) {
			System.out.println("채워지지 않은 공간은 수정이 불가능합니다.");
		} else if (idx == not_fill_idx) {
			add(obj);
		} else {
			oArray[idx] = obj;
			System.out.println("["+idx+"] : "+ obj +" 변경 완료");
		}
		System.out.println("==============================");
	}
	
	public void showArray() {
		System.out.println("==============================");
		for(int i=0; i<not_fill_idx; i++) {
			System.out.println("["+i+"] : " + oArray[i]);
		}
		System.out.println("==============================");
	}
	
	public void fPractice() {
		for(int i=0; i<not_fill_idx; i++) {
			System.out.print("["+i+"] : ");
			if(oArray[i] instanceof Parents) {
				Parents p = (Parents) oArray[i];
				p.f();
			}
			else System.out.println("f 함수 없음.");
		}
		System.out.println("==============================");
	}
}
