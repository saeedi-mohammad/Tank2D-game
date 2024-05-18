public class silvercoin extends GameMovableElementAdapter {

	private static String Images[] = { "Images/silver1.png", "Images/silver2.png", "Images/silver3.png",
			"Images/silver4.png", "Images/silver5.png", "Images/silver6.png" };
	private int cImage = 0;
	private long waitTime = 50;
	private long lastTime = 0;

	public silvercoin(int x, int y) {
		super(Images[0], x, y);
		destroyedScore = 100;

		setSpeedX(0);
		setSpeedY(3);
		setDownDirection();
		StopMoving();
	}

	private void nextImage() {
		cImage = (cImage + 1) % 6;
		ChangeImage("Images/silver" + (cImage + 1) + ".png");
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
