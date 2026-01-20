package d0120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface HowLong{
	int len(String s);
}
//8.
class Box<T>{
	private Object data;
	
	Box(T t){
		data = t;
	}
	
	public void setData(T t) {
		data = t;
	}
	
	public Object getData() {
		return data;
	}
	//9.
	public boolean rideBus(Bus bus) {
		System.out.println("버스 탑승 시도");
		if(bus.increase() == 1) return true;
		else return false;
	}
}
class Bus{
	private int bno;
	private int cnt;
	
	Bus(int no){
		bno = no;
		cnt = 0;
	}
	
	public int increase() {
		if (cnt < 30) {
			cnt ++;
			return 1;
		} else {
			return 0;
		}
	}
	public int getBno() {
		return bno;
	}
}
//10.
enum Gender{
	MALE, FEMALE;
}

class Person {
	private String name;
	private int age;
	private Gender gender;
	
	Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "[이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender + "]";
	}
}
public class Exam {
	public static void main(String[] args) {
		//5.
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "James");
		map.put(2, "Ann" );
		map.put(3, "David");
		
		for(int key : map.keySet()) {
			System.out.println(key +" : "+ map.get(key));
		}
		System.out.println("=============================");
		//6.
		List<Double> list = new ArrayList<>();
		list.add(1.1);
		list.add(2.2);
		list.add(3.3);
		System.out.println(list);
		System.out.println("=============================");
		//7.
		HowLong hl;
		hl = s -> s.length();
		System.out.println(hl.len("Hello"));
		System.out.println("=============================");
		//8.
		Box<String> box = new Box<>("Word");
		box.setData("CAT");
		System.out.println(box.getData());
		System.out.println("=============================");
		//9.
		box.rideBus(new Bus(1));
		System.out.println("=============================");
		//10.
		Person p = new Person("허윤", 22, Gender.MALE);
		System.out.println(p);
	}
}
