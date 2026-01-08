package d0106;

public class Ex_NumQ {
	public static void main(String[] args) {
		
		//1. 배열에서 특정 값을 찾는 알고리즘 만들기
		//2. 검색 범위도 그에 맞춰 변경
				
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		int max = arr.length - 1;
		int min = 0;
		int idx = -1;
		
		int target = 20;
		while(min<=max) {
			int mid = (min + max) / 2  ;
			if(arr[mid] == target) {
				idx = mid;
				break;
			} else if (arr[mid]>target) {
				max = mid -1 ;
			} else {
				min = mid +1 ;
			}
		}
		
		if(idx!=-1) {
			System.out.println(target + "을 찾았습니다. 인덱스 " + idx + "번에 존재합니다.");		
		} else {
			System.out.println(target + "을 찾지 못했습니다.");
		}
		
	}
}
