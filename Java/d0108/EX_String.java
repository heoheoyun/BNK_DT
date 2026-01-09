package d0108;

public class EX_String {
	
	public static void main(String[] args) {
		
		String str1 = "Hello, World!";
		String str2 = "Java Programming";
		String str3 = "   Hello Java    ";
		
		//1. 문자열의 길이 : length()
		System.out.println("1. length(): " + str1.length());
		
		//2. 특정 위치의 문자 반환 : charAt(위치)
		System.out.println("2. charAt(8): " + str1.charAt(8));
		
		//3. 부분 문자열 추출 : substring()
		System.out.println("3. substring(7): " + str1.substring(7));
		System.out.println("4. substring(7, 12): " + str2.substring(7,12));
		
		//4. 문자(열)의 첫번째 위치 찾기 : indexOf()
		System.out.println("5. indexOf('o'): " + str1.indexOf('o'));
		System.out.println("6. indexOf(\"World\"): " + str1.indexOf("World"));
		
		//5. 문자열의 마지막 위치 찾기 : lastIndexOf()
		System.out.println("7. lastIndexOf('o'): " + str1.lastIndexOf('o'));
		
		//6. 대소문자 변환 : toUpperCase(), toLowerCase()
		System.out.println("8. toUpperCase(): " + str1.toUpperCase());
		System.out.println("9. toLowerCase(): " + str1.toLowerCase());
		
		//7. 앞뒤 공백제거 : trim()
		System.out.println("10. trim(): '"+ str3.trim()+"'");

		//8. 문자/문자열 치환 : replace()
		System.out.println("11. replace('1', 'L'): " + str1.replace('1', 'L'));
		System.out.println("12. replace(\"World\", \"Java\"): " + str1.replace("World", "Java"));
		System.out.println(str1);
		
		//9. 문자열 분할 : split()
		String[] words = str1.split(", ");
		System.out.println("13. split(\", \"): ");
		for(String word : words) {
			System.out.println(" - " + word);
		}
		
		//10. 문자열 비교 : equals()
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1.equals(s2));
		
		String s3 = new String("abc");
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		
		//11. 접두사/접미사 확인 : startWith()/endsWith()
		System.out.println("14. startWitch(\"Hello\"): " + str1.startsWith("Hello"));
		System.out.println("15. endsWitch(\"!\"): " + str1.endsWith("!"));
		
		//12. 부분 문자열 포함 : contains()
		System.out.println("16. contains(\"World\") : "+ str1.contains("World"));
		
		//13. 문자열 비교(대소문자 구분없이)	: equalsIgnoreCase()
		String s4 = "hello, world!";
		System.out.println("17. equals(s4) : " + str1.equals(s4));
		System.out.println("18. equalsIgnoreCase(s4) : " + str1.equalsIgnoreCase(s4));
		
		//14. 문자열의 사전적 순서 비교 : compareTo()
		String s5 = "abc";
		String s6 = "bcd";
		System.out.println("19. \"abc\".compareTo(\"bc\") : " + s5.compareTo(s6));
		System.out.println("19.5. \"abc\".compareTo(\"abc\") : " + s5.compareTo(s5));
		System.out.println("20. \"bc\".compareTo(\"abc\") : " + s6.compareTo(s5));
		
		//15. 문자열 연결 : concat()
		System.out.println("21. concat(\" Welcome\") : " + s5.concat(" Welcome"));
		
		//16. 다른 타입을 문자열로 변환 : valueOf()
		int num = 123;
		double b = 12.34;
		System.out.println("22. valueOf(int) : " + String.valueOf(num));
		System.out.println("23. valueOf(double) : "+ String.valueOf(b));
		
		//17. 형식화된 문자열 : format()
		String formatted = String.format("이름: %s, 나이 %d, 키: %.1f", "홍길동", 25, 175.37);
		System.out.println("24. format() : "+formatted);
		
		
	}
}
