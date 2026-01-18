package d0116.Dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
	
	HashMap<String, String> words = new HashMap<String, String>();
	HashMap<String, Integer> record = new HashMap<String, Integer>();
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	public void add() {
		String engWord, korMean;
		System.out.print("=== 영어 단어를 입력 : ");
		engWord = sc.nextLine().trim().toLowerCase();
		System.out.print("=== 한글 뜻을 입력 : ");
		korMean = sc.nextLine().trim();
		words.put(engWord, korMean);
		record.put(engWord, 0);
		System.out.println(engWord + " : " + korMean);
		System.out.println("등록이 완료 되었습니다.");
		System.out.println("==============================");
	}
	
	public void getAll() {
		System.out.println("등록 단어 모두 조회");
		if(words.isEmpty()) {
			System.out.println("등록 되어 있는 단어가 없습니다.");
			return;
		}
		System.out.println("==============================");
		String[] sorted_word = toArray(words.keySet());
		Arrays.sort(sorted_word);
		for (int i = 0; i<sorted_word.length; i++ ) {
			getBy(sorted_word[i]);
		}
		System.out.println("조회가 끝났습니다.");	
		System.out.println("==============================");
	}
	
	public void getBy(String word) {
		if(!words.containsKey(word)) {
			System.out.println(word+" 단어는 등록되지 않은 단어입니다.");
			return;
		}
		System.out.println("==============================");
		System.out.println("단어 : " + word);
		System.out.println("의미 : " + words.get(word));
		System.out.println("퀴즈를 맞춘 횟수 : " + record.get(word));
		System.out.println("------------------------------");
	}
	
	public void quiz() {
		String quizWord = toArray(words.keySet())[rd.nextInt(words.size())];
		if (words.isEmpty()) {
	        System.out.println("등록된 단어가 없어 퀴즈를 진행할 수 없습니다.");
	        return;
	    }
		System.out.println("===== [ 한영 사전 문제 ] =====");
		System.out.println("Q. "+ quizWord + "의 뜻은? ");
		System.out.print("== 정답 : ");
		String answer = sc.nextLine().trim();
		if(words.get(quizWord).equals(answer)) {
			System.out.println("정답입니다!");
			record.put(quizWord, (record.get(quizWord))+1);
		} else {
			System.out.println("오답입니다!");
		}
		getBy(quizWord);
	}
	
	public String[] toArray(Set<String> set) {
	    return set.toArray(new String[0]);
	}
}
