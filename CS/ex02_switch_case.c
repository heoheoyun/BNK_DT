#include <stdio.h>

int main(){
	/*
	if~else 문과 다른 형태의 문법
	switch(값){
		case 조건1 : 
				조건1일때 실행문
				break;
		case 조건2 : 
				조건 2일때 실행문
				break; 
		default : 조건에 해당하지 않은 기본 실행문 
	}
	각 조건이 끝날 때 break;를 써서 case를 종료해야함.
 	*/
	int n; 
	printf("Input Number(1~5) : ");
	scanf("%d", &n);
	
	switch(n){
		case 1:
			printf("1입니다.\n");
			break;
		case 2:
			printf("2입니다.\n");
			break;
		case 3:
			printf("3입니다.\n");
			break;
		case 4:
			printf("4입니다.\n");
			break;
		case 5:
			printf("5입니다.\n");
			break;
		default :
			printf("1~5의 숫자가 아닙니다.\n");
	} 
	
	// 1~5의 숫자가 입력되면 유효한 숫자입니다. 아닌 경우 유효하지 않은 숫자입니다. 출력하기
	printf("=======================\n");
	
	int m;
	printf("Input Number(1~5) : ");
	scanf("%d",&m);
	
	switch(m){
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			printf("유효한 숫자입니다.\n");
			break;
		default :
			printf("유효하지 않은 숫자입니다.\n");
	}
	// 90점 이상:A, 80점 이상:B, 70점 이상:C, 60점 이상:D, 그 이하 :F 인 switch문 만들기	
	int score;
	printf("점수를 입력해주세요 : ");
	scanf("%d", &score);
	/*
	if (100>score&&score>=90) printf("A등급입니다.\n");
	else if (90>score&&score>=80) printf("B등급입니다.\n");
	else if (80>score&&score>=70) printf("C등급입니다.\n");
	else if (70>score&&score>=60) printf("D등급입니다.\n");
	else printf("F등급입니다.\n");
	*/
	
	switch(score/10){
		case 10:
		case 9:
			printf("A등급입니다.\n");
			break;
		case 8:
			printf("B등급입니다.\n");
			break;	
		case 7:
			printf("C등급입니다.\n");
			break;
		case 6:
			printf("D등급입니다.\n");
			break;
		default:
			printf("F등급입니다.\n");
	}
	
	// 국어, 영어, 수학 점수 입력 받기.
	// 평균 60점 이상이면 합격
	// 아니면 불합격 코드를 만들기
	
	int korean, english, math;
	double average;
	printf("국영수 과목의 점수를 입력해주세요.\n");
	printf("국어 : ");
	scanf("%d", &korean); 
	printf("영어 : ");
	scanf("%d", &english);
	printf("수학 : ");
	scanf("%d", &math);
	average = (korean + english + math )/3;
	int check = average>=60;
	//if 문으로 구현
	printf("if실행\n");
	if(check) printf("합격\n");
	else printf("불합격\n") ;	
	//switch 구현 
	printf("switch실행\n");
	switch(check) {
		case 1: 
			printf("합격\n");
			break;
		default:
			printf("불합격\n");
			break;
	}
	
	return 0;
}

