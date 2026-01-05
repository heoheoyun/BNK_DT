#include <stdio.h>
/*
	배열과 포인터 관계 
*/
int main(){
	
	int A[3] = { 1,2,3};
	int *p = A;
	
	printf("%d\n", p); 
	printf("%d\n", A[0]); 
	printf("%d\n", *(p+0)); 
	printf("%d\n", A[1]); 
	printf("%d\n", *(p+1)); 
	printf("%d\n", A[2]); 
	printf("%d\n", *(p+2)); 
	printf("%d\n", p[1]); 
		
	return 0;
}

