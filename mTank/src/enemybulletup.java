class enemybulletup extends GameMovableElementAdapter {

	public enemybulletup(int x, int y) {
		super("Images/enemybullet.png", x, y);

		this.setSpeedY(3);
		this.setSpeedX(0);
		this.setUpDirection();
		this.StartMoving();
	}

	protected void CollideUpBorder() {
		this.Destroy();
	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof mytank) {
			GGame.DecreaseLive();
			SoundStore.get().Play(Sounds.Explosion);
			this.Destroy();
		}

		if (element instanceof Bulletup || element instanceof Bulletdown || element instanceof Bulletright
				|| element instanceof Bulletleft) {
			this.Destroy();
			element.Destroy();
		}
	}

}
