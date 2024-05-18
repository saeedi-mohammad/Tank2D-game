public class ammobox extends GameMovableElementAdapter {

	public ammobox(int x, int y) {
		super("Images/ammobox.png", x, y);
		destroyedScore = 50;

	}

	public void CollideWith(GameElementAdapter element) {
		if (element instanceof mytank) {
			GGame.IncreaseFires(20);
			GGame.IncreaseScore(destroyedScore);
			this.Destroy();
			return;
		}
		super.CollideWith(element);
	}

}
