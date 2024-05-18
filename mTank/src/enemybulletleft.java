
public class enemybulletleft extends GameMovableElementAdapter {

	public enemybulletleft(int x, int y) {
		super("Images/enemybullet.png", x, y);

		this.setSpeedX(3);
		this.setSpeedY(0);
		this.setLeftDirection();
		this.StartMoving();
	}

	protected void CollideLeftBorder() {
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
