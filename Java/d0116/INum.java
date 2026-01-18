package d0116;

public class INum{
	
	private int num;
	
	public INum(int num) {
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		if(!(obj instanceof INum)) return false;
		
		INum temp = (INum) obj;
		return num == temp.num;
	}
}
