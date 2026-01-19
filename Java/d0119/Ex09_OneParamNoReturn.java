package d0119;

interface Singable{
	void sing(String song);
}

public class Ex09_OneParamNoReturn {
	
	public static void main(String[] args) {
		Singable s;
		
		s = new Singable() {
			
			@Override
			public void sing(String song) {
				System.out.println(song);
			}
		};
		
		s.sing("내가 만약 하늘이라면~");
		
		s = (String song) -> {
			System.out.println(song);
		};
		
		s.sing("그대 얼굴에 물들고 싶어~~");
		
		s = (song) -> {
			System.out.println(song);
		};
		
		s.sing("불게 물든 저녁 저 노을처럼~~");
		
		s = (song) -> System.out.println(song);
		
		s.sing("나 그대 뺨에 물들고 싶어~~");
		
		s = song -> System.out.println(song);
		
		s.sing("블라블라~~");
	}
}
