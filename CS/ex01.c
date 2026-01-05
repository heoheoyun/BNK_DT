#include <stdio.h>							//스탠다드 입출력 모듈 불러오기 

//main 함수 
int main() {  
	/*
	변수 선언 ( 자료형 변수명 = 초기화값; ) 
	대입(할당) 연산자 : 값을 대입하는 하여 주는 연산자 = 
	= : 좌변의 값을 우변의 값으로 선언한다. 
	*/
	
	int n = 100;						//정수 변수 선언 
	int m = n;						//정수 선언 응용 ( 초기화값 지정 ) 
	double r;							//double 선언 (초기화값 미지정 : 더미값이 담김) 
	//int r = n + m;						// + : 합 
	//double r = m/2.0 ;					// / : 나눗셈 
	//int r = n%2;							// % : 나머지 값 연산 
	r = n / (m*1.0);						// 형변환 (int),(float) 등을 활용가능 
	
	/*
	출력문 printf(); -> print + format
	%d : int, %lf : double , \n : 줄바꿈
	*/
	
	printf("hello c~\n"); 					// 문자열 출력 
	printf("%d %d\n", 10, 20);				// 정수 출력, 여러 정수 출력 
	printf("정수 출력: %d\n", n);			// 문자열 + 정수 출력 
	printf("r = %lf\n", r);					// double 출력 
	
	return 0;								//함수 정상적인 종료를 알리기 위해 필요 
}
