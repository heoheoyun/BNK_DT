package d0108;

import java.util.Scanner;

public class Test_Game {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);						// 입력을 위한 스캐너 생성
		WordGame game = new WordGame();								// 단어 맞추기 게임 생성
		
		game.intro();												// 게임 인트로 출력
		
		System.out.print(">> ");									// 모드 선택 문구 출력
		int mode = sc.nextInt();
		String words = "";											// 문자열 미리 만들어두기
		
		while(mode>4 || mode<1) {									// 제공되는 모드 중에서 골라지는지 확인
			System.out.print("Choose 1 ~ 4");						// 아닌 경우 다시 입력 받기
			System.out.print(">> ");
			mode = sc.nextInt();
		}
		
		while(mode==2) {											// 직접 단어를 설정하는 모드일 경우
			System.out.println("Please enter 5characters");			// 직접 단어를 설정하게 지원하기
			System.out.print(">> ");
			words = sc.next();
			if(words.length()==5) continue;
			boolean isAphabet = true;
			for(int i=0; i<game.getWordLength(); i++) {				// 5번째 문자까지만 확인
				if(!game.checkAlphabet(words.charAt(i))){
					isAphabet = false;
					break;
				}
			}
			if(isAphabet) break;
		}
		
		game.mode(mode,words);
																	// 게임 진행
		while(!game.end()) {										// 모든 문자를 맞췄는지 확인 후 아닐 때 반복
			game.showSecretWord();									// 지금까지 맞춘 문자와 가려진 문자 출력
			System.out.println();									// 문자 키보드로 입력
			System.out.print("Input Answer : ");					// 입력을 위한 안내문 출력
			char answer = sc.next().charAt(0);						// 문자 1개를 answer 에 저장
			sc.nextLine();											// 혹시 모를 공백, 엔터 버퍼 처리
			if(!game.checkAlphabet(answer)) {						// answer 가 알파벳인지 확인하기
				System.out.println("Enter the alphabet only!");		// 아니라면 경고문 출력 후
				continue;											// 다시 시작
			}
			game.checkWord(answer);									// answer 로 단어 확인
		}
		
		System.out.println("completed!!");
		System.out.println("=====================");
		System.out.print("Result - ");
		game.showSecretWord();
		
		sc.close();
	}
}
