 #include <stdio.h>
 
 //제어문 중 조건문 
 
 int main(){
	int m = 101;						
 	/*
	비교연산자 : 값을 비교하는 연산자 
	예) a?b 에서 ? 에 들어가는 연산에 대해서 기술함. a는 b와 ?다.
	!= : 같지 않다, == : 같다, >= , 크거나 같다 , > : 크다 , <= : 작거나 같다, < : 작다 
	조건문 if(조건식){
				조건이 참일 경우 실행문 
			}else{
				조건이 거짓일 경우 실행문 
			}
	*/
	//어느 수가 짝수인지 홀수인지 판단하는 코드 
	if(m%2 == 0) {
		printf("짝수\n"); 
	}else{
		printf("홀수\n");
	}

	//두 수가 주어지면 어떤 수가 큰지를 판별하는 코드 (단, 두 수는 다르다. )
	int p = 5, q = 6;
	if(p>q) {
		printf("n1 : %d\n", p); 
	} else {
		printf("n2 : %d\n", q);
	}
	
	// 123의 100,10,1의 자리수를 출력하는 코드 
	int n = 123;
	int n100 = n/100;
	int remain = n % 100;
	printf("100의 자리 숫자는 %d\n", n100);
	int n10 = remain /10;
	remain = remain%10;
	printf("10의 자리 숫자는 %d\n", n10);
	int n1 = remain;
	printf("1의 자리 숫자는 %d\n", n1);
	
	return 0;								//함수 정상적인 종료를 알리기 위해 필요 
}
