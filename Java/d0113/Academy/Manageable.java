package d0113.Academy;

public interface Manageable {	
	public void register(String name, int age, String callno);
	public void inquire(String select, Object obj);
	public void modify(String select, int num, Object after);
	public void delete(String name, int age, String callNo);
	public void showAllInfo();
}
