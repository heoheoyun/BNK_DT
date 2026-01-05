#include <stdio.h>
#include <stdlib.h>		// 랜덤 기능을 활용하기 위해 불러옴 
#include <time.h>		// 시드값초기화를 위해 불러옴 

int main(){
	/*
	1~100 까지 수가 들어가있는 배열 A에서
	최대값과 최소값을 구하는 코드를 만들기 
	
	1. 	10의 크기를 지닌 배열 A, A의 크기를 담은 변수 Alen, 인덱스 접근 용도의 변수 idx 를 0으로 초기화 선언. 
	2. 	idx 와 Alen을 활용해 A의 크기만큼 반복하여 A 배열 인덱스 마다 값을 추가하는 반복문 작성. 
	3. 
		최대값과 최소값이 담길 변수 max, min을 A[0]으로 초기화 선언 
		최대값과 최소값의 인덱스가 담긴 변수  maxI , minI 을  0 으로 초기화 선언
	4.	idx를 1로 재초기화 
	5.	idx와 Alen을 활용해 A의 크기만큼 반복하여 A[idx]가 최대 혹은 최소인지 확인하는 반복문 작성. 
	6.	모든 과정이 완료되었을 경우 결과 출력. 
	*/
	
	//랜덤 배열 선언 
	srand(time(NULL));						// 현재시간 기준으로 시드를 부여한다. 
	
	int R[10] = {0,};
	int Rlen = sizeof(R)/sizeof(R[0]);
	int maxI =0, minI = 0, idx = 0;
	
	printf("배열 R = [ "); 
	while (idx<Rlen) {
		R[idx] = (rand()%100)+1;			// 배열에 랜덤한 값들을 넣는다.
		printf(" %d ", R[idx]);
		idx++;
	}
	printf(" ]\n"); 
	
	int max = R[0], min = R[0];
	idx = 1;
	
	while(idx<Rlen){
		if(min>R[idx]) {
			min = R[idx];
			minI = idx;
		}
		if(R[idx]>max) {
			max = R[idx];
			maxI = idx;
		}
		idx++;
	}
	
	printf("배열 R의 최대값은 %d번째 인덱스 : %d\n", maxI,max);
	printf("배열 R의 최소값은 %d번째 인덱스 : %d\n", minI,min);
	
	// 정해진 배열 선언 
	printf("\n==================================\n\n");				
	int A[10] = {10,7,53,2,91,77,54,32,23,16};						
	int Alen = sizeof(A) / sizeof(A[0]);							
	
	min = A[0], max = A[0];										
	idx = 1, maxI =0, minI = 0;
	
	printf("배열 A = [ "); 
	while(idx<Alen) {
		printf(" %d ", A[idx]);
		if(min>A[idx]) {
			min = A[idx];
			minI = idx;
		}
		if(A[idx]>max) {
			max = A[idx];
			maxI = idx;
		}
		idx++;
	}
	printf(" ]\n"); 												
	
	printf("배열 A의 최대값은 %d번째 인덱스 : %d\n", maxI,max);
	printf("배열 A의 최소값은 %d번째 인덱스 : %d\n", minI,min);
	
	return 0;
}

