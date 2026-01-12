package d0109;

import java.util.Scanner;

public class User{
	
	private String name;
	private int money;
	Scanner sc = new Scanner(System.in);
	String[] goods = new String[3];
	
	User(String name, int meony) {
		this.name = name;
		this.money = meony;
		goods[0] = "";
		goods[1] = "";
		goods[2] = "";
	}
	
	void buyProduct(VendingMachine VM) {
		while(true) {
			System.out.println("제품번호를 선택해 주세요.");
			int select;
			select = sc.nextInt() -1;
			sc.nextLine();
			if(!(12>select && select>=0)) {
				System.out.println("없는 번호 입니다.");
				continue;
			}
			VM.info(select);
			System.out.println("지불 금액을 입력해주세요.");
			int payment;
			payment = sc.nextInt();
			sc.nextLine();
			if (payment>=money) {
				System.out.println("가지고 있는 돈 이상을 지불 하셨습니다.");
				break;
			}
			if (payment<VM.priceInfo(select)) {
				System.out.println("상품 가격보다 적은 돈을 내셨습니다.");
				break;
			}
			if(VM.sales(select)) { 
				System.out.println(payment + "원을 내서 구매를 하셨습니다.");
				addItem(VM.getName(select));
				money -= payment;
				System.out.println(payment- VM.priceInfo(select)+ "원의 거스름돈이 나왔습니다.");
				money += payment- VM.priceInfo(select);
				break;
			} else {
				System.out.println("해당 상품은 품절되어 계산이 되지 않았습니다.");
				break;
			}
		}	
	}
	
	void addItem(String goods) {
		for(int i=0; i < this.goods.length; i++) {
			if(this.goods[i].isEmpty()) {
				this.goods[i] = goods;
				return;
			}
		}
		System.out.println(goods + "는 더 이상 물건을 들 수 없어 버립니다.");
	}
	
	void showUserInfo() {
		System.out.println("이름 : " + name + ", 가진 돈 : " + money + " \n 소지품 : [ "+ goods[0]+", " + goods[1]+ ", " + goods[2] +" ]" );
	}
	
}
