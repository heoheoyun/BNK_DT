package d0116;

import java.util.HashMap;
import java.util.Map;

public class ExMap {
	
	public static void main(String[] args) {
		
		//맵 생성
		Map<String, Integer> map = new HashMap<>();
//		List<String> list = new ArrayList<String>();
		
		//멥 요소 추가
		map.put("사과", 1500);
		map.put("바나나", 2000);
		map.put("오렌지", 3000);
		map.put("포도", 4000);
		map.put("포도", 3000);
		
		//맵 요소 조회
		Integer price = map.get("포도");
		System.out.println("포도(key)의 값(value)은 " + price + "입니다.");
		
		price = map.getOrDefault("키위", 0);
		System.out.println("키위(key)의 값(value)은 " + price + "입니다.");
		
		//맵의 크기 조회
		System.out.println("맵에 저장된 자료의 개수 : " + map.size());
		//맵이 비어있는지 확인
		System.out.println("맵이 비어 있나요? >> " + map.isEmpty());
		
		//맵 비우기
//		map.clear();
//		//맵의 크기 조회
//		System.out.println("맵에 저장된 자료의 개수 : " + map.size());
//		//맵이 비어있는지 확인
//		System.out.println("맵이 비어 있나요? >> " + map.isEmpty());
		
		for(String key : map.keySet()) {
			System.out.println("key는 "+key+"이고, value는 "+map.get(key)+"입니다.");
		}
		
	}
}
