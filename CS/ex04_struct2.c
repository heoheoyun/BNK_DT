#include <stdio.h>
/*
	구조체 연습
	
	? h = f('Z', 26);
	printf("%c, %d\n", h.name, h.age); //Z, 26이 나오게 하기. 
	
*/

//구조체 선언 
typedef struct human{
	
	char name;
	int age;
	
}Human;	

//f 함수 선언 
Human f(char name, int age){
	
	Human h = {
		name, age
	};
	
	return h;
}


int main(){

	Human h = f('Z', 26);
	
	printf("%c, %d\n", h.name, h.age); // Z, 26
	
	return 0;
}

