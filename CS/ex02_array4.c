#include <stdio.h>

int main(){
	/*
	¹è¿­ ¿¬½À 
	*/
	
	int A[10] = {23,32,14,16,7,9,12,44,41,5};
	int Alen = sizeof(A)/sizeof(A[0]);
	int cnt_a = 0, cnt_o = 0, cnt_e = 0;
	
	while (cnt_a<Alen){
		if(A[cnt_a]%2!=0) {
			cnt_o++;
		}
		else{
			cnt_e++;
		}	
		cnt_a++;
	}
	int ODD[cnt_o];
	int EVEN[cnt_e];
	
	cnt_a = 0, cnt_o = 0, cnt_e = 0;
	
	while (cnt_a<Alen){
		if(A[cnt_a]%2!=0) {
			ODD[cnt_o] = A[cnt_a];
			cnt_o++;
		}
		else{
			EVEN[cnt_e] = A[cnt_a];
			cnt_e++;
		}	
		cnt_a++;
	}
	
	cnt_a = 0;
	printf(" ODD : [ ");
	while(cnt_a < cnt_o) {
		printf(" %2d ", ODD[cnt_a]);
		cnt_a++;
	}
	printf(" ] - È¦¼ö %d°³\n", cnt_o);
	//Â¦¼ö ¹è¿­ Ãâ·Â 
	cnt_a = 0;
	printf("EVEN : [ ");
	while(cnt_a < cnt_e) {
		printf(" %2d ", EVEN[cnt_a]);
		cnt_a++;
	}
	printf(" ] - Â¦¼ö %d°³\n", cnt_e);
	
	
	return 0;
}

