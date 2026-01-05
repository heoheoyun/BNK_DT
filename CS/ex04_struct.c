#include <stdio.h>
/*
	구조체	: struct	, 여러 의미있는 자료를 하나로 관리하는 구조 
			
	struct Student{
		char name;
		int age;
		double height;
	}
	
*/

typedef struct human {
	char name;
	int age;
}Human;

int main(){
	
	struct human h1;
	h1.name = 'A';
	h1.age = 23;
	
	struct human h2 = {
		'B', 24
	};
	
	Human h3 = {
		'C', 25
	};
	
	printf("%c, %d\n", h1.name, h1.age);
	
	printf("%c, %d\n", h2.name, h2.age);
	
	printf("%c, %d\n", h3.name, h3.age);
	
	return 0;
}

