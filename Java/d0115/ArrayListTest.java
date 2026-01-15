package d0115;

import java.util.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<String>();
		
		System.out.println("1. 빈 ArrayList 생성 : " + fruits);
		System.out.println("    생성 초기 크기   : " + fruits.size());
		System.out.println("  배열이 비어있는지  : " + fruits.isEmpty());
		
		//요소 추가
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("오렌지");
		fruits.add("포도");
		
		System.out.println("2.요소 추가 후 배열  : " + fruits);
		System.out.println(" 요소 추가 후 크기   : " + fruits.size());
		System.out.println("  배열이 비어있는지  : " + fruits.isEmpty());
		
		//특정 위치에 요소 추가
		fruits.add(1, "배");
		
		System.out.println("3.특정 위치 요소 추가: " + fruits);
		
		//특정 위치의 요소 얻기
		String s = fruits.get(0);
		System.out.println("4-1.특정 위치 값 얻기: " + s);
		
		String sl1 = fruits.get(fruits.size()-1);
		String sl2 = fruits.getLast();
		System.out.println("4-2.특정 위치 값 추가: " +sl1);
		System.out.println("4-3.특정 위치 값 추가: " +sl2);
		
		//특정 위치의 요소 수정
		fruits.set(3, "메론");
		System.out.println("5.특정 위치 요소 수정: " +fruits);
		
		//특정 요소 삭제
		fruits.remove(1);
		System.out.println("6-1. 특정 위치 삭제  : " +fruits);
		fruits.remove("바나나");
		System.out.println("6-2. 요소 지정 삭제  : " + fruits);
		
		//특정 요소 존재 여부
		System.out.print("7.특정 요소 존재 여부: ");
		boolean tf =  fruits.contains("포도");
		if(tf) System.out.println("있어요.");
		else System.out.println("없어요.");
		
		//특정 요소 위치 정보
		System.out.println("8-1. 특정 요소 위치  : "+fruits.indexOf("포도"));
		System.out.println("8-2. 특정 요소 위치  : "+fruits.indexOf("바나나"));
		
		//ArrayList는 중복을 허용한다.
		fruits.add("사과");
		System.out.println("9-1. 중복 가능 확인  : "+fruits);
		System.out.println("9-2.중복 첫 위치 확인: "+fruits.indexOf("사과"));
		System.out.println("9-3.중복 끝 위치 확인: "+fruits.lastIndexOf("사과"));
		
		for(int i = 0; i<fruits.size(); i++) {
			System.out.print(fruits.get(i)+ " ");
		}
		System.out.println();
		for(String x : fruits) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
