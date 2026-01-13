package d0112;

class Mouse{
	public void clickLeft() {
		System.out.println("왼쪽 클릭...");
	}
	
	public void clickRight() {
		System.out.println("오른쪽 클릭...");
	}
}

class WheelMouse extends Mouse{
	public void scroll() {
		System.out.println("스크롤...");
	}
	@Override
	public void clickLeft() {
		System.out.println("휠마우스로 왼쪽 클릭...");
	}
	@Override
	public void clickRight() {
		System.out.println("휠마우스로 오른쪽 클릭...");
	}
}

class OpticalMouse extends Mouse{
	public void clickLeft() {
		System.out.println("광마우스로 왼쪽 클릭...");
	}
	
	public void clickRight() {
		System.out.println("광마우스로 오른쪽 클릭...");
	}
}

public class MouseTest {
	
	public static void main(String[] args) {
		Mouse[] mouse = new Mouse[3];
		mouse[0] = new Mouse();
		mouse[1] = new WheelMouse();
		mouse[2] = new OpticalMouse();
		
		for(int i=0; i<mouse.length; i++) {
			mouse[i].clickLeft();
			mouse[i].clickRight();
		}
		for(int i=0; i<mouse.length; i++) {
			System.out.print("["+ (i+1)+"] : ");
			if(mouse[i] instanceof OpticalMouse) System.out.println("광마우스");
			else if(mouse[i] instanceof WheelMouse) System.out.println("휠마우스");
			else if(mouse[i] instanceof Mouse) System.out.println("일반마우스");
			else System.out.println("해당 사항없음.");
		}
		System.out.println();
		for(int i=0; i<mouse.length; i++) {
			System.out.print("["+ (i+1)+"] : ");
			if(mouse[i] instanceof Mouse) System.out.println("일반마우스");
			else if(mouse[i] instanceof WheelMouse) System.out.println("휠마우스");
			else if(mouse[i] instanceof OpticalMouse) System.out.println("광마우스");
			else System.out.println("해당 사항없음.");
		}
		System.out.println();
		for(int i=0; i<mouse.length; i++) {
			System.out.print("["+ (i+1)+"] : ");
			if(mouse[i].getClass().equals(Mouse.class)) System.out.println("일반마우스");
			else if(mouse[i].getClass().equals(WheelMouse.class)) System.out.println("휠마우스");
			else if(mouse[i].getClass().equals(OpticalMouse.class)) System.out.println("광마우스");
			else System.out.println("해당 사항없음.");
		}
	}
}
