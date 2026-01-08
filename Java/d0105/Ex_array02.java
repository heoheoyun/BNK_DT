package d0105;
/*
 * 2차원 배열 활용해보기
 * 
 * */
public class Ex_array02 {
	
	public static void main(String[] args) {
		
		// 2차원 배열 초기화 및 접근 후 출력
		int[][] A  = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		
		A[1][2] = 10;
		System.out.println(A[1][2]);
		
		//2차원 배열 중첩반복문을 통해 값 넣고 출력
		
		int[][] arr = new int[4][5];
		
		//1~20 순서대로 arr에 넣기
		
		for(int i=0,idx =1;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++,idx++) {
					arr[i][j] = idx;
			}
		}
		
	}
}
