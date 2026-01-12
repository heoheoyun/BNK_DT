package d0109;

public class Test_VM {
	
	public static void main(String[] args) {
		User user = new User("허윤", 50000);
		VendingMachine vm = new VendingMachine();
			
		vm.registration("음료수", 10, 1500);
		vm.registration("단팥빵", 10, 1300);
		vm.registration("크림빵", 10, 1300);
		vm.registration("껌", 10, 1200);
		vm.registration("제로음료수", 10, 1500);
		vm.registration("초콜릿", 10, 1200);
		
		while(user.goods[2].equals("")){
			vm.showVMInfo();
			user.buyProduct(vm);
			user.showUserInfo();
		}
		System.out.println("소지품이 전부 가득찼음으로 구매를 종료합니다.");
	}
}
