package d0107;

import java.util.Random;

public class Test_Human {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		Human[] humans = { 
				new Human("홍길동", 'M'),
				new Human("임꺽정", 'M'),
				new Human("김여자", 'F'),
				new Human("전남자", 'M'),
				new Human("박여성", 'F')
		};

		
		for(int i=0; i<humans.length; i++) {
			int cigarette = rd.nextInt(40)+1;
			int bottle = rd.nextInt(40)+1;
			
			System.out.println( humans[i].getName() + "님은 " +cigarette + "개비의 흡연," + bottle + "병의 음주를 하였습니다." );
			
			humans[i].smoking(cigarette);
			humans[i].drinking(bottle);	
			
			
			System.out.println(humans[i].infoToString());
			
		}

		
	}
}
