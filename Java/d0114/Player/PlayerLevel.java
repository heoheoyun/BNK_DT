package d0114.Player;

public abstract class PlayerLevel {
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	public final void go(int count) {
		run();
	    jump();
	    turn();
	}
}
