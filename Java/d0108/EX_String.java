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
	}
}
