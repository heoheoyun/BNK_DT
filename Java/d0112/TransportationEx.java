package d0112;

public class TransportationEx {
	
	public static void main(String[] args) {
		
		Transportation bus = new Bus();
		Transportation train = new Train();
		
		BusanTravel bt = new BusanTravel();
		
		bt.goBusan(bus);
		bt.goBusan(train);
	}
}
