public class enemybulletright extends GameMovableElementAdapter {

	public enemybulletright(int x, int y) {
		super("Images/enemybullet.png", x, y);

		this.setSpeedX(3);
		this.setSpeedY(0);
		this.setRightDirection();
		this.StartMoving();
	}

	protected void CollideRightBorder() {
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
