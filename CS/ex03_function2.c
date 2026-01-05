#include <stdio.h>
/*
	printLine 함수 만들기 
*/

void printLine(char c,int i);

int main(){
	printLine('n',5);
	printLine('-',11);
	printLine('d',10);
	
	int i;
	char c;
	
	printf("줄을 생성할 문자: ");
	scanf(" %c", &c);
	printf("생성할 줄의 길이: ");
	scanf("%d", &i);

	printLine(c,i);
	return 0;
}


void printLine(char c,int i) {
	int n = 0;
	while(n<i) {
    	printf("%c", c);
    	n++;
	}
	printf("\n");
}
