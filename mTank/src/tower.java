public class tower extends GameMovableElementAdapter {

	private static String Images[] = { "Images/tower.png" };
	private int Lifes;

	private long FirewaitTime = 1600;
	private long lastFireTime = 40;

	public tower(int x, int y, int lifes) {
		super(Images[0], x, y);
		destroyedScore = 100;

		Lifes = lifes;

	}

	public void Step() {
		super.Step();

		if (lastFireTime + FirewaitTime < System.currentTimeMillis()) {

			this.Fire();
			lastFireTime = System.currentTimeMillis();

		}
	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof Bulletup || element instanceof Bulletdown || element instanceof Bulletleft
				|| element instanceof Bulletright) {

			DecreaseTowerLife();
		}
		if (element instanceof mytank) {

			this.Destroy();

			return;
		}

		if (element instanceof enemytank) {
			return;
		}
		// to collide with other elements

	}

	protected void CollideDownBorder() {
		super.CollideDownBorder();
		this.Destroy();
	}

	protected void Fire() {

		if (1 == 1) {// Create new Bullet and shoot up from Right and Left
			enemybulletup b = new enemybulletup(0, 0);
			b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() - b.getHeight() - 1);
			GGame.addNewEntity(b);

		}

		if (1 == 1) {
			enemybulletleft b = new enemybulletleft(0, 0);
			b.setXY(this.getX() - b.getWidth(), this.getY() + 10);
			GGame.addNewEntity(b);

		}

		if (1 == 1) {
			enemybulletright b = new enemybulletright(0, 0);
			b.setXY(this.getX() + this.getWidth() + 1, this.getY() + b.getHeight());
			GGame.addNewEntity(b);

		}

		if (1 == 1) {
			enemybulletdown b = new enemybulletdown(0, 0);
			b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() + this.getHeight() + 1);
			GGame.addNewEntity(b);

		}

		// SoundStore.get().Play(Sounds.Fire);

	}

	protected void DecreaseTowerLife() {

		if (this.Lifes < 2) {
			GGame.IncreaseScore(destroyedScore);
			this.Destroy();
		} else
			this.Lifes--;
	}

}
