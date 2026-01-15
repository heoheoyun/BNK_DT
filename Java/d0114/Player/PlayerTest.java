package d0114.Player;

public class PlayerTest {
	
	public static void main(String[] args) {
		
		Player player = new Player();
		
		player.upgradeLevel(new AdvanceLevel());
		
		player.play(1);
		
		player.upgradeLevel(new SuperLevel());
		
		player.play(1);
	}
}
