package d0113.TV;

public class TVFactory {
	
	private String brandName;
	
	public TVFactory(String brandName) {
		this.brandName = brandName.toLowerCase();
		
	}
	
	public TV getBrand() {
		if(brandName.equals("samsung")) return new Stv(); 
		else if (brandName.equals("lg")) return new Ltv();
		else return null;
	}
}
