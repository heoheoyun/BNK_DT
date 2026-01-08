package d0105;

public class Ex_array03 {
	
	public static void main(String[] args) {
		
		int x = 12;
		int y = 5;
		
		int[][] arr = new int[x][y];
		
		//1~20 을 스네이크 형식으로 arr에 넣기
		
		boolean flag = true;
		for(int i=0,idx = 1;i<arr.length;i++) {
			if(flag) {
				for(int j=0;j<arr[i].length;j++, idx++) {
				arr[i][j] = idx;
				}
				flag = false;
			} else {
				for(int j=0;j<arr[i].length;j++, idx++) {
					arr[i][arr[i].length-j-1] = idx;
				}
				flag = true;
			}
		}

		for(int i=0;i<arr.length;i++) {
			System.out.print(i+1 + "행 | ");
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%2d",arr[i][j]);
				if(j==arr[i].length -1) continue;
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
}
