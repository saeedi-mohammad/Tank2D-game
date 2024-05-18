public class Bulletdown extends GameMovableElementAdapter {

	public Bulletdown(int x, int y) {
		super("Images/Bulletdown.png", x, y);

		this.setSpeedX(0);
		this.setSpeedY(4);
		this.setDownDirection();
		this.StartMoving();
	}

	protected void CollideDownBorder() {
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof Beton || element instanceof tower || element instanceof enemytank)
			this.Destroy();
	}

}
