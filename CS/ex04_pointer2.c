#include <stdio.h>
/*
	x = 5
	y = -2
	px = #100
	py = #200
	
	px와 py를 통해 x와 y의 차이를 출력하기 
*/
int main(){

	int x = 5, y = -2;
	
	int *px = &x, *py = &y;
	
	printf("%d - %d = %d", *px, *py, *px - *py);
	

	return 0;
}

