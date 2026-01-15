package d0114.Player;

public class Player {
	
	private PlayerLevel level;
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
		return null;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
	}
	
	public void play(int count) {
		level.go(count);
	}
	
}
