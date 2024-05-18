public class GHeart extends GameMovableElementAdapter {

	public GHeart(int x, int y) {
		super("Images/heartbox.png", x, y);

		destroyedScore = 10;

	}

	public void CollideWith(GameElementAdapter element) {
		if ((element instanceof Bulletup) || (element instanceof Bulletdown) || (element instanceof Bulletleft)
				|| (element instanceof Bulletright)) {
			return;
		}
		if (element instanceof mytank) {
			GGame.IncreaseLive();
			GGame.IncreaseScore(destroyedScore);
			this.Destroy();
			return;
		}

		// to collide with other elements
		this.goBack();
		this.StopMoving();
	}
}
