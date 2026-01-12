package d0109;

public class Products {
	
	private String name;
	private int quantity;
	private int price;
	
	Products(){
		name = "없음";
		quantity = 0;
		price = 0;
	}
	
	Products(String name, int quantity, int price){
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	String productInfoToString() {
		return " [ 제품명 : "+ name + " ] [ 가격 : " + price + " ]  [ " + isSoldout() + " ] ";
	}
	
	String getName() {
		return name;
	}
	
	void selling() {
		quantity --;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	int getPrice() {
		return price;
	}
	
	String isSoldout() {
		if(quantity>0) return "판매중";
		else return "품절";
	}
	
	void add(int p) {
		quantity += p;
	}
}
