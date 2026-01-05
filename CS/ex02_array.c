#include <stdio.h>

int main(){
	/*
	배열은 물리적으로 "연속되어있는 공간"에 "동일한 타입"의 저장되어있는 구조 
	배열은 Index로 접근하며 0부터 시작
	int A[n]; 으로 배열 선언
	int B[n] = { 1,2,3 }; 으로 초기화 선언
	int B[2] = ?; 로 index 접근 
	*/
	
	int arr[5] = {1,2,3,4,5};
	int B[5];
	
	printf("%d\n",sizeof(arr)/sizeof(arr[0])); //배열크기 구하기 (java와 python에서는 쉽게하는데....;;) 
	//정방향으로 복사해오기 
	int cnt = 0;
	while(cnt<5) {
		B[cnt] = arr[cnt];
		printf("[%d] : %d\n", cnt, B[cnt]);
		cnt++;
	}
	
	//역방향으로 복사해오기 
	cnt = 0;
	while(cnt<5) {
		B[cnt] = arr[4-cnt];
		printf("[%d] : %d\n", cnt, B[cnt]);
		cnt++;
	}
	
	return 0;
}

