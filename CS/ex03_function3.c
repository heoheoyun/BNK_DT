#include <stdio.h>
/*
	int main(){
	
		intro();
	
		menu();
		
		return 0;
	}
	
	형태로 계산기 만들기
	===============
	계산기 V1.0
	===============
	연산자를 선택하세요
	1.+ 	2.-
	3.* 	4./
	
	>>1
	덧셈을 선택했군요! 
	 
	 형태로 코드 구현 
*/
void printLine();
void intro();
int menu();
void calc(int s);

int main(){
	
	intro();
	
	int sel = menu();
	
	while(!sel){
		sel = menu();
	} 
	
	calc(sel);
	 
	return 0;
}


void printLine() {
	printf("===============\n");
}

void intro() {
	printLine();
	printf("  계산기 V1.0  \n");
	printLine();
}
int menu() {
	printf("연산자를 선택하세요.\n");
	printf("1. +\t2. -\n");
	printf("3. x\t4. ÷\n");
	printf(">>");
	int s;
	scanf(" %d",&s);
	
	switch(s){
		case 1:
		case 2:
		case 3:
		case 4: return s;
		default:
			printf("잘못된 연산을 선택했습니다.\n");
			printf("1~4사이의 숫자를 선택해주세요.\n");
			printLine();
			return 0;
	}
		
}
void calc(int s) {
	
	int a; int b;
	printf("수를 입력해 주세요!\n A : ");
	scanf(" %d",&a);
	printf("수를 입력해 주세요!\n B : ");
	scanf(" %d",&b);
	printLine();
	switch(s){
		case 1:
			printf("%3d\n",a+b);
			break;
		case 2:
			printf("%3d\n",a-b);
			break;
		case 3:
			printf("%3d\n",a*b);
			break;
		case 4:
			printf("%3.2f\n",a/(b*1.0));
			break;
		default:
			printf("오류가 발생했습니다.");
	}
}

