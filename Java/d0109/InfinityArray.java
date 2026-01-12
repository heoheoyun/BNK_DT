package d0109;

public class InfinityArray {
	int length;
	private int[] array;
	int not_fill_idx = 0;
	private int increase;
	//증가값을 받고 필드 초기화하기
	InfinityArray(int inc) {
		length = 3;
		array = new int[length];
		increase = inc;
	}
	// 비어져있는 칸이 있는지 확인
	boolean checkHasSpace() { return length > not_fill_idx; }
	// 기존의 채워져있는 배열 바로 뒤에 값 삽입하는 메서드
	void insert(int a) {
		if(!checkHasSpace()) add();
		array[not_fill_idx]= a;
		not_fill_idx ++;
	}
	// 배열의 크기를 늘리는 메서드
	void add() {
		int[] tempArray = array;
		length+=increase;
		this.array = new int[length];
		for(int i = 0; i<tempArray.length;i++) {
			array[i] = tempArray[i];
		}
	}
	// 배열의 특정 인덱스 값을 수정하는 메서드
	void modify(int idx, int a) {
		if(idx<not_fill_idx) array[idx] = a;
		else if (idx<length) System.out.println("해당 인덱스는 비어있는 값입니다. insert()로 채운 뒤 수정해주세요.");
		else System.out.println("배열의 크기보다 큰 인덱스 값은 수정이 불가능 합니다.");
	}
	// 배별의 특정 인덱스를 삭제하는 메서드
	void delete(int idx) {
		int[] tempArray = array;
		if(not_fill_idx - 1 <= (length - increase)) length -= increase;
		this.array = new int[length];
		not_fill_idx--;
		for(int i = 0; i<idx;i++) {
			array[i] = tempArray[i];
		}
		for(int i = idx; i<not_fill_idx;i++) {
			array[i] = tempArray[i+1];
		}
	}
	// 배열을 출력하는 메서드
	void printArray() {
		System.out.println("배열 크기 : " + length);
		for(int i=0; i<not_fill_idx;i++) {
			System.out.print("[ "+i+" ] : " + array[i]);
			if((i+1)%4==0&&i+1!=not_fill_idx) System.out.println();
			else System.out.print("\t");
		}
		System.out.println();
	}
}
