public class enemybulletdown extends GameMovableElementAdapter {

	public enemybulletdown(int x, int y) {
		super("Images/enemybullet.png", x, y);

		this.setSpeedX(0);
		this.setSpeedY(3);
		this.setDownDirection();
		this.StartMoving();
	}

	protected void CollideDownBorder() {
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
