#include <stdio.h>

int main(){
	/*
	 반복 제어문 연습 
	*/
	
	int cnt = 0;
	
	//반복횟수를 키보드로 입력받아 처리하기
	int input;
	printf("반복 횟수를 정해주세요 : ");
	scanf("%d",&input);
	
	while(cnt < input){
		printf("test...\n");
		cnt++;
	} 
	
	printf("end...\n");
	
	return 0;
}

