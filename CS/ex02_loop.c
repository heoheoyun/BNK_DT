#include <stdio.h>

//제어문 중 반복문 

int main(){
	/* while 반복문
	while(조건식){
		//조건식이 참인 동안 반복되는 실행문 
	}
	조건식은 0또는 1의 boolean으로 간주함. 
	조건식에 들어갈 변수를 초기화 선언 후 활용.
	반복 중지 필요시 조건식을 만족시키지 않는 방향의 실행문 포함 
	*/
	int x=0;
	int cnt=1;
	while(x<10){
		printf("[%d회] Hello~\n",cnt);
		x++;
		cnt++;
	}
	
	return 0;
}



