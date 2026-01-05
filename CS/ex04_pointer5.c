#include <stdio.h>
/*
	몫과 나머지를 돌려주는 함수를 포인터로 구현하기
	 
	 int *p = (int*)malloc(sizeof(int) * 3);
	 
	 위의 형태로  힙 영역에 동적으로 메모리를 할당할수있다. 
*/

void div(int a, int b,int *p){
	
	p[0] = a/b;
	
	p[1] = a%b;
	
}


int main(){

	int a = 20, b = 7;
	
	int QnR[2];
	
	div(a,b,QnR);
	
	printf("%d ÷ %d 의 몫 : %d, 나머지: %d\n", a,b,QnR[0],QnR[1]);

	return 0;
}

