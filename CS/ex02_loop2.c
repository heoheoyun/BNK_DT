#include <stdio.h>

int main(){
	/*
	숫자 맞추기
	10번 반복하는 반복문 만들기 
	*/
	int target = 5;
	int count = 10;
	int ans;
	/*
	printf("0~9 사이의 숫자중 정답을 맞추세요!\n");
	while(ans != target) {
		printf("수를 입력해 주세요! (남은 기회 %d회) :", count);
		scanf("%d", &ans);
		if(target == ans){
			printf("%d는 정답입니다!\n", ans);
			break;
		}
		else {
			printf("%d는 정답이 아닙니다.\n", ans);
			count--;
		} 
	}
	if(count!=0) printf("맞추셨습니다!\n");
	*/
	
	/* 무조건 1번은 반복하는 반복문 
	do {
		조건식이 참일 동안 실행. 
	}
	while ( 조건식 ); 
	*/
	do {
		prin
		printf("Input Answer Number(1~10) : ");
		scanf("%d", &ans);
	} while(ans != target);
	printf("정답입니다.\n");
	
	return 0;
}

