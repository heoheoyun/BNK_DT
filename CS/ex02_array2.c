#include <stdio.h>

int main(){
	/*
	배열을 이용하는 코드 2 
	*/
	
	//1 .크기가 10인 A 배열 1~10까지 반복문을 통해 순서대로 채우기
	
	int A[10];
	int n = 0;
	int count2 = 0;
	int count3 = 0; 
	
	while(n<10){
		//1 .크기가 10인 A 배열 1~10까지 반복문을 통해 순서대로 채우기
		A[n] = n+1;
		printf("A[%d] = %d", n, A[n]);
		//2. A배열의 짝수 인덱스 갯수 출력하기
		if(A[n]%2==0) {
			printf(" (짝수)");
			count2++;
		}	
		//3. A배열의 3의 배수 인덱스 갯수 출력하기 	
		if(A[n]%3==0) {
			printf(" (3의 배수)");
			count3++;
		}
		printf(" \n"); 
		n++;
	}
	printf("배열 A의 짝수는 %d개 입니다.\n", count2);
	printf("배열 A의 3의 배수는총 %d개 입니다.\n", count3);
	
	return 0;
}

