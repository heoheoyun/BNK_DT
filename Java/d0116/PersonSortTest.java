package d0116;

import java.util.Arrays;

public class PersonSortTest {
	
	public static void main(String[] args) {
		
		Person[] persons = new Person[3];
		
		persons[0] = new Person("Lee", 20);
		persons[1] = new Person("Choi", 15);
		persons[2] = new Person("Han", 35);
		
		Arrays.sort(persons);
		for(Person p : persons) {
			System.out.println(p);
		}
	}
}
