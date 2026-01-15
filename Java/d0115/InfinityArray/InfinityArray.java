package d0115.InfinityArray;

public class InfinityArray<T> {
	
	private Object[] objects;
	private static int increse_size = 1;
	
	public InfinityArray() {
		objects = new Object[0];
	}
	
	public int size() {
		return objects.length;
	}
	
	public boolean isEmpty() {
		return objects.length==0;
	}
	
	public void add(int idx, T obj) {
		Object[] temp = objects;
		objects = new Object[temp.length + increse_size];	
		for(int i = 0, j= 0; i<size();i++) {
			if(i == idx) { 
				objects[i] = obj; 
				continue;
			}
			objects[i] = temp[j];
			j++;
		}
	}
	
	public void add(T obj) {
		add(size(), obj);
	}
	
	public T get(int idx) {
		return (T) objects[idx];
	}
	
	public void set(int idx, T obj) {
		if(idx>=size()) System.out.println("배열 보다 큰 인덱스에 접근할 수 없습니다.");
		else objects[idx] = obj;
	}
	
	public void remove(int idx) {
		Object[] temp = objects;
		objects = new Object[temp.length - 1];	
		for(int i = 0, j= 0; i<size();j++) {
			if(j == idx) { 
				continue;
			}
			objects[i] = temp[j];
			i++;
		}
	}
	
	public void remove(T t) {
		remove(indexOf(t));
	}
	
	public boolean contains(T obj) {
		for(int i=0; i<size(); i++) {
			if(objects[i].equals(obj)) return true;
		}
		return false;
	}
	
	public int indexOf(T obj) {
		for(int i=0; i<size();i++) {
			if(objects[i].equals(obj))return i;
		}		
		return -1;
	}
	
	public int lastIndexOf(T obj) {
		for(int i=size()-1; i>=0; i--) {
			if(objects[i].equals(obj)) return i;
		}
		return -1;
	}
	
	public void showArray() {
		System.out.println("=======================");
		for(int i=0; i<size(); i++) {
			System.out.println("["+i+"] : "+objects[i]);
		}
	}
	@Override
	public String toString() {
		String s = "[";
		for(int i=0; i<size();i++) {
			s += objects[i];
			if(i==size()-1) continue;
			s += ", ";
		}
		s += "]";
		return s;
	}
}
