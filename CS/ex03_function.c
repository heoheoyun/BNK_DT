#include <stdio.h>
/*
	함수	: function 	, 특정한 작업(기능)을 수행하도록 설계된 독립적인 코드 블록
	
	자료형 함수이름(매개변수){
		
		본문 작성 
		
		return; // 자료형에 맞는 리턴값을 지정해 함수 끝내기 
	} 
*/
int add3(int n);
int AaddB(int a, int b);
int AsubB(int a, int b);
int AmulB(int a, int b);
double AdivB(int a, int b);
void AcalcB(int a, int b, char c);

int main(){
	
	//printf("%d\n", add3(2));
	
	int a , b;
	char c;
	
	printf("두 수를 입력해 주세요.\n");
    printf("첫번째 수: ");
    scanf("%d", &a);
    
	printf("\n");
	printf("두번째 수: ");
	scanf("%d",&b);
	
	printf("\n연산자를 선택해주세요.\n");
    printf("(+,-,*,/) 또는 (a,s,m,d)를 입력: ");
    
	scanf(" %c",&c);
	printf("\n");
	
	AcalcB(a,b,c);
		
	return 0;
}

 
//3을 더해주는 함수 정의 
int add3(int n){
	int result = n+3;
	
	return result;
}

// 사칙연산 함수 만들기 

int AaddB(int a, int b){
	return a+b; 
}
int AsubB(int a, int b) {
	return a-b;
}
int AmulB(int a, int b){
	return a*b;
}
double AdivB(int a, int b) {
	return (a/(b*1.0));
}

void AcalcB(int a, int b, char c){
	
	printf("\n--- 결과 ---\n");
	
	switch(c){
		case '+':
		case 'a':
			printf("%d + %d = %2d\n",a,b,a+b);
			break;
		case '-':
		case 's':
			printf("%d - %d = %2d\n",a,b,a-b);
			break;
		case '*':
		case 'm':
			printf("%d x %d = %2d\n",a,b,a*b);
			break;
		case '/':
		case 'd':
			printf("%d ÷%d = %2d\n",a,b,a/b);
			break;
		defalut : 
		printf("오류가 있습니다.");
	}
}




