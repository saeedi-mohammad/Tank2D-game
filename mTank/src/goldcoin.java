public class goldcoin extends GameMovableElementAdapter {

	private static String Images[] = { "Images/gold1.png", "Images/gold2.png", "Images/gold3.png", "Images/gold4.png",
			"Images/gold5.png", "Images/gold6.png" };
	private int cImage = 0;
	private long waitTime = 50;
	private long lastTime = 0;

	public goldcoin(int x, int y) {
		super(Images[0], x, y);
		destroyedScore = 100;

		setSpeedX(0);
		setSpeedY(3);
		setDownDirection();
		StopMoving();
	}

	private void nextImage() {
		cImage = (cImage + 1) % 6;
		ChangeImage("Images/gold" + (cImage + 1) + ".png");
	}

	public void Step() {
		super.Step();
		if (lastTime + waitTime < System.currentTimeMillis()) {
			this.nextImage();
			lastTime = System.currentTimeMillis();
		}
	}

	protected void CollideDownBorder() {
		super.CollideDownBorder();
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {
		if ((element instanceof Bulletup) || (element instanceof Bulletdown) || (element instanceof Bulletleft)
				|| (element instanceof Bulletright)) {
			return;
		}
		if (element instanceof mytank) {
			GGame.IncreaseScore(destroyedScore);
			this.Destroy();
			return;
		}

		// to collide with other elements
		this.goBack();
		this.StopMoving();
	}
}
