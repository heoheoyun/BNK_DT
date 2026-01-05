#include <stdio.h>

void printLine(char c, int i);

int main(){
	/* scanf("%?", &저장할 곳); //키보드로 입력받는 코드
	
	*/
	int n;
	printf("Input Number(1~9) :");
	scanf("%d", &n); 
	printf("입력받은 값 : %d",n); 
	
	printLine('=', 50);
	
	//if문을 활용해 키보드의 1~5의 숫자이면 1~5라고 알려주는 코드
	//1. 키보드로 입력 받기  
	int a;
	printf("1~5사이의 수를 입력해주세요 : ");
	scanf("%d",&a);
	//2. 입력받은 수 판별하기
	if (a==1) printf("1 입니다.\n");
	else if (a==2) printf("2 입니다.\n");
	else if (a==3) printf("3 입니다.\n");
	else if (a==4) printf("4 입니다.\n");
	else if (a==5) printf("5 입니다.\n");
	else printf("1~5사이의 수가 아닙니다.\n");
	
	printLine('=', 50);
	
	//입력받은 숫자까지 더하는 코드 구현
	int i = 0;	
	printf("1부터 입력받은 수까지 더합니다.\n");
	while(i<1){	
		printf("양의 정수를 입력해주세요 : ");
		scanf("%d", &i);
	}
	int cnt = i;
	int sum = 0;
	while (cnt>0) {
		sum += cnt;
		cnt--;
	}
	printf("1부터 %d까지의 합은 %d입니다", i, sum);
	
	return 0; 
}


void printLine(char c , int i){
	int n;
	printf("\n");
	for(n = 0; n<i; n++){
		printf("%c",c);
	}
	printf("\n");
}
