package d0108;

import java.util.Random;

public class WordGame {
	// 미리 준비 해놓은 단어 모음
	private String[] wordSet = {"apple", "house", "chair", "water", "bread", "phone", "clock", "happy",
			"smart", "brave", "clear", "quiet", "great", "dance", "write", "laugh",
			"speak", "build", "study", "cloud", "ocean", "earth", "world", "music"};
	
	private String[] sentences = {
            "I am happy to see you",
            "Where is the restroom",
            "The weather is very nice today",
            "Can I have some water please",
            "I will go to bed now"
        };
	
	// 정답 단어 배열
	private char[] word;
	
	// 정답 단어를 가려 놓고 출력 시킬 용도의 배열
	private char[] secretWord;
	
	int getWordLength() {
		return word.length;
	}
	
	void setSecretWord(char[] words) {
		secretWord = new char[words.length];
		
		for(int i=0; i<secretWord.length; i++) {
			if(words[i] == ' ') secretWord[i] = ' ';
			else secretWord[i] = '*';
		}
		
	}
	
	void setSecretWord(String words) {
		secretWord = new char[words.length()];
		
		for(int i=0; i<secretWord.length; i++) {
			if(words.charAt(i) == ' ') secretWord[i] = ' ';
			else secretWord[i] = '*';
		}	
	}
	
	
	void intro() {
		System.out.println("=====================");
		System.out.println("= Select Game Mode! =");
		System.out.println("== ALL  Random : 1 ==");
		System.out.println("==  Set  Word  : 2 ==");
		System.out.println("== Random Word : 3 ==");
		System.out.println("==  Sentences  : 4 ==");
		System.out.println("=====================");
	}
	
	void mode(int select, String words) {
		switch(select) {
			case 1:
				start();
				break;
			case 2:
				start(words);
				break;
			case 3:
				rStart();
				break;
			case 4:
				senStart();
				break;
		}
	}
	
	// 5글자를 전부 랜덤으로 시작하는 메서드
	void start() {
		Random rd = new Random();							// 랜덤 활용
		
		word = new char[5];
		
		System.out.println("Creating Random words...");		// 생성 대기 문구 출력
		for(int i = 0 ;i<word.length;i++) {					// 배열 순서대로
			word[i] = (char)(rd.nextInt(26) + 'a');			// a ~ z 까지 랜덤으로 넣기
		}
		
		setSecretWord(word);
		
		System.out.println("Word Generation Completed");	// 완료 문구 출력
		
	}
	
	// 단어를 미리 설정하여 시작하는 메서드
	void start(String word) {
		
		this.word = new char[5];
		
		for(int i = 0 ;i<this.word.length;i++) {			// 입력받은 문자열을 
			char c = word.charAt(i);
			if('Z' >= c && c >= 'A') c = (char)(c + 32);	// 대문자인지 확인 후 소문자 변환
			this.word[i] = c;								// word 배열에 저장하기
		}
		
		setSecretWord(this.word);
		
		System.out.println("Word set complete!!");			// 배열 생성 완료 문구 출력
	}
	
	// 미리 준비 해놓은 단어 중에서 시작하는 메서드
	void rStart() {
		
		word = new char[5];
		
		Random rd = new Random();							// 랜덤 활용
		
		System.out.println("Creating Random words...");		// 단어 생성 대기 문구 출력
		
		String rWord = wordSet[rd.nextInt(wordSet.length)];	// 미리 준비된 배열중 하나를 랜덤으로 가져와 변수에 저장한다.
		
		for(int i = 0 ;i<word.length;i++) {					// 변수에 저장된 단어를 word 배열에 저장한다.
			word[i] = rWord.charAt(i);
		}
		
		setSecretWord(word);
		
		System.out.println("Word Generation Completed");	// 단어 설정이 완료되었음을 출력한다.
	}
	
	void senStart() {
		
		
		Random rd = new Random();
		
		System.out.println("Creating Random sentences...");		// 문장 생성 대기 문구 출력
		
		String rSen = sentences[rd.nextInt(sentences.length)];		// 미리 준비된 배열중 하나를 랜덤으로 가져와 변수에 저장한다.
		
		word = new char[rSen.length()];
		
		for(int i = 0 ;i<word.length;i++) {					// 변수에 저장된 단어를 word 배열에 저장한다.
			word[i] = rSen.charAt(i);
		}
		
		setSecretWord(word);
		
		System.out.println("Sentences Generation Completed");	// 단어 설정이 완료되었음을 출력한다.
		
	}
	
	//알파벳인지 확인하고 참 거짓으로 반환하는 메서드
	boolean checkAlphabet(char c) {
		return (('Z' >= c && c >= 'A')||('z' >= c && c >= 'a'));
	}
	
	// 입력받은 문자가 정답인지 확인하는 메서드
	// 대문자는 소문자로 변환하여 확인
	// 입력받은 문자가 정답이 맞다면 알파벳 공개
	void checkWord(char c) {
		if('Z' >= c && c >= 'A') c = (char)(c + 32);	// 대문자인지 확인 후 소문자 변환
		for(int i=0; i<word.length; i++) {				// 정답 배열을 순회하며 확인
			if(c == word[i]) {							// 정답과 일치할 경우
				secretWord[i] = word[i];				// 가려져 있던 정답 배열 변경
			}
		}
	}
	
	//모든 알파벳을 밝혀져 끝인지를 반환받는 메서드
	boolean end() {
		for(int i=0; i<secretWord.length; i++) {	// 가려져있는 배열만큼 반복
			if(secretWord[i] == '*') {				// 하나라도 가려져 있다면
				return false;						// 끝이 아님을 반환
			}
		}
		return true;								// 전부다 가려지지 않았을 때 끝이라고 반환
	}
	
	// 현재까지 맞춘 단어를 확인하는 메서드
	void showSecretWord(){
		System.out.print("Secret Word : [ ");
		for(int i=0; i<secretWord.length; i++) {
			System.out.print(secretWord[i]);
		}
		System.out.print(" ]");
	}
}
