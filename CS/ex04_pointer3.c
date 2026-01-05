#include <stdio.h>
/*
	swap 함수를 만들기
	
	두 값을 바꾸는 함수 
*/

void swap(int a, int b){
	
	int n = a;
	a = b;
	b = n;
	
	printf("스왑 진행 결과 : a = %d , b = %d\n", a ,b);
}

void pswap(int *a, int *b){
	
	int n = *a;
	*a = *b;
	*b = n;
	
	printf("p스왑 진행 결과 : a = %d , b = %d\n", *a ,*b);
}

int main(){

	int a = 10, b = 20;
	
	printf("스왑 함수 실행 전 : a = %d | b = %d\n", a , b);
	
	swap(a,b);
	
	printf("스왑 함수 실행 후 : a = %d | b = %d\n", a , b);
	
	pswap(&a,&b);
	
	printf("p스왑 함수 실행 후 : a = %d | b = %d", a , b);

	return 0;
}

