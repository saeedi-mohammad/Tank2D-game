public class ammo extends GameMovableElementAdapter {

	public ammo(int x, int y) {
		super("Images/ammo.png", x, y);
		destroyedScore = 20;

	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof mytank) {
			GGame.IncreaseFires(15);
			GGame.IncreaseScore(destroyedScore);
			this.Destroy();
			return;
		}
		super.CollideWith(element);
	}

}