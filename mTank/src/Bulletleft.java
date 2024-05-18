public class Bulletleft extends GameMovableElementAdapter {

	public Bulletleft(int x, int y) {
		super("Images/Bulletleft.png", x, y);

		this.setSpeedX(4);
		this.setSpeedY(0);
		this.setLeftDirection();
		this.StartMoving();
	}

	protected void CollideLeftBorder() {
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof Beton || element instanceof tower || element instanceof enemytank)
			this.Destroy();
	}

}