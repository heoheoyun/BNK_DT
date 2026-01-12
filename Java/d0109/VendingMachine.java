package d0109;

public class VendingMachine {
	
	private Products[] products = new Products[12]; 
	private int total_money;
	
	public VendingMachine() {
		for(int i=0; i<products.length; i++) {
			products[i] = new Products();
		}
		total_money = 10000;
	}
	
	void info(int select) {
		System.out.println(products[select].productInfoToString());
	}
	
	int priceInfo(int select) {
		return products[select].getPrice();
	}
	
	String getName(int setect) {
		return products[setect].getName();
	}
	
	boolean sales(int select) {
		if(products[select].getQuantity()==0) return false;
		products[select].selling();
		System.out.println("거스름돈 계산 중..");
		total_money += products[select].getPrice();
		return true;
	}
	
	void registration(String name, int quantity, int price){
		for(int i=0; i < products.length; i++) {
			if(products[i].getName().equals("없음")) {
				products[i] = new Products(name, quantity, price);
				return;
			}
		}
		System.out.println("자판기에 더 이상 제품 등록이 안됩니다.");
	}
	
	void Cancelled(String Name) {
		for(int i=0; i < products.length; i++) {
			if(products[i].getName().equals(Name)) {
				products[i] = new Products();
				return;
			}
		}
	}
	
	void showVMInfo() {
		System.out.println("============ [ 자판기 ] ============");
		for(int i=0; i<products.length;i++) {
			System.out.println((i+1)+ " : " + products[i].productInfoToString());
		}
		System.out.println("====================================");
	}
	
	void secretInfo() {
		System.out.println("============ [ 자판기 ] ============");
		System.out.println("현재 보유액 : "+ total_money);
		System.out.println("====================================");
	}
}
