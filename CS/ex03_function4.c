#include <stdio.h>
#include <stdlib.h>
#include <time.h> 
/*
	숫자 맞추기 게임 만들기  
*/

void printLine();
void intro();
int setting();
void game(int target);


int main(){

	intro();
	
	game(setting());
	
	return 0;
}


void printLine() {
	printf("============================\n");
}

void intro() {
	printLine();
	printf("  숫자 맞추기 게임  V1.0  \n");
	printf(" 1~10사의 숫자를 맞추세요! \n");
	printLine();
}

int setting(){
	
	srand(time(NULL));
	
	int target = (rand()%10) + 1;
	
	return target;
}

void game(int target) {
	
	int ans=-1;
	int count = 0;
	
	printf("    숫자가 정해졌습니다!\n");
	
	while(target != ans) {
		printLine(); 
		printf(">> ");
		scanf(" %d", &ans); 
		count++;
	}
	printLine();
	printf("\n정답을 맞추셨습니다!\n");
	printf("정답 : %d, 시도 : %d 회\n", target, count);
}
