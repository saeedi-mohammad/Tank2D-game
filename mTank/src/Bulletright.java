public class Bulletright extends GameMovableElementAdapter {

	public Bulletright(int x, int y) {
		super("Images/Bulletright.png", x, y);

		this.setSpeedX(4);
		this.setSpeedY(0);
		this.setRightDirection();
		this.StartMoving();
	}

	protected void CollideRightBorder() {
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {

		if (element instanceof Beton || element instanceof tower || element instanceof enemytank)
			this.Destroy();
	}

}
