package d0121;

public class Member {
	private String id;
	private String pw;
	private String name;
	
	
	Member(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	
	Member(String id, String pw, String name){
		this(id, pw);
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "[ ID : " + id +" ]\n[ NAME : " + name +" ]";
	}
	
}
