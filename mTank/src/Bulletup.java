public class Bulletup extends GameMovableElementAdapter {

	public Bulletup(int x, int y) {
		super("Images/Bulletup.png", x, y);

		this.setSpeedX(0);
		this.setSpeedY(4);
		this.setUpDirection();
		this.StartMoving();
	}

	protected void CollideUpBorder() {
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof Beton || element instanceof tower || element instanceof enemytank)
			this.Destroy();
	}

}
