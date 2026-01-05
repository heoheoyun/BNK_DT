#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
	가위바위보 게임 만들기 
	랜덤함수를 활용 
	나의 입력을 받아 결과를 받아내기
	
	1. 가위바위보 1회 진행
	
	2. 여러번 진행하는 것
	
	3. 가위바위보 진행 전적 출력하는 것 
	 
	4. 함수를 사용해보기. 
	
	5. 구조체를 활용해 전적 구현.	

*/

typedef struct Player{
	int games;
	int win;
	int lose;
	int draw;
}Player;

void printLine();
void intro();
int Csetting();
int Psetting();
int verdict(int RPSc ,int RPSp);
Player result(Player player, int verdict);
void status(Player player);
void run(Player player);


int main(){
	
	Player player = {
		0,0,0,0
	};

	run(player);
	
	return 0;
}


void printLine() {
	printf("===============\n");
}

void intro() {
	printLine(); 
	printf("      가위바위보 게임      \n");
	printf("컴퓨터와 게임을 시작합니다.\n");
	printf("제시된 선택지를 입력하세요!\n"); 
	printLine();
	printf("몇 번을 진행 하시겠습니까?!\n"); 
	printLine();
}

int Csetting() {
	srand(time(NULL));
	
	return ((rand()%3) + 1);
}

int Psetting(){
	
	int RPSp;
	
	while(1) {
		printf("     다음 중 골라주세요!     \n");
		printf("가위 : 1 | 바위 : 2 | 보 : 3 \n");
		printLine();
		printf(">>");
		scanf(" %d", &RPSp);
		switch(RPSp) {
			case 1: 
			case 2:
			case 3:
				return RPSp;
			default:
				printf("다시 입력해주세요!\n");
		}
	}
}

int verdict(int RPSc ,int RPSp){
	
	if ( RPSp == 1) {
		if( RPSc == 1) return 1;
		if( RPSc == 2) return 0;
		if( RPSc == 3) return 2;
	}
	
	if ( RPSp == 2) {
		if( RPSc == 1) return 2;
		if( RPSc == 2) return 1;
		if( RPSc == 3) return 0;
	}
	
	if ( RPSp == 3) {
		if( RPSc == 1) return 0;
		if( RPSc == 2) return 2;
		if( RPSc == 3) return 1;
	}

}

Player result(Player player, int verdict){
	
	switch(verdict) {
		case 0 :
			printf("패배하였습니다.\n");
			player.lose ++;
			break;
		case 1 :
			printf("비겼습니다.\n");
			player.draw ++;
			break;
		case 2 :
			printf("승리하였습니다.\n");
			player.win++;
			break;
	}
	
	return player;
}

void status(Player player) {
	printf("\n");
	printLine();
	printf("총 %d회 가위바위보 결과\n", player.games);
	printf("게임 횟수 : %3d회\n",player.games);
	printf("이긴 횟수 : %3d회\n",player.win);
	printf("비긴 횟수 : %3d회\n",player.draw);
	printf(" 진 횟수  : %3d회\n",player.lose);
	printf("최종 승률 : %3.2f%%\n",100*player.win/(player.games * 1.0));
	printLine();
}

void run(Player player){
	
	intro();
	
	int game;
	int n = 0;
	scanf(" %d", &game);
	
	while(game<1) {
		printf("0보다 큰 숫자를 입력하세요!\n");
		scanf(" %d", &game);
		printf(">>");
	}
	
	while(n<game) {
		int RPSc = Csetting();
		int RPSp = Psetting();
		player = result(player, verdict(RPSc, RPSp)); 
		player.games++;
		n++;
	}
 
 	status(player);
}

