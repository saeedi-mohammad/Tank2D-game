public class AlertArea extends GameMovableElementAdapter {
	public static int isinAlertArea = 0;

	public AlertArea(int x, int y) {

		super("Images/AlertArea.png", x, y);

	}

	private long waitTime = 50;
	private long lastTime = 0;
	private long waitTime2 = 1000;
	private long lastTime2 = 0;

	public void Step() {
		super.Step();

		// center
		int X = this.getX() + (this.getWidth() / 2);
		int Y = this.getY() + (this.getHeight() / 2);

		int H = this.getWidth() / 2;
		int i = 0;

		if (waitTime + lastTime < System.currentTimeMillis())
			if (((Y - Levels.my_tank.getY() < H && Y - Levels.my_tank.getY() > -H)
					&& (X - Levels.my_tank.getX() < H && X - Levels.my_tank.getX() > -H))
					|| ((Levels.my_tank.getX() - X < H && Levels.my_tank.getX() - X > -H)
							&& (Levels.my_tank.getY() - Y < H && Levels.my_tank.getY() - Y > -H)))
				inAlertArea(1);
			else
				i = 1;
		if (waitTime2 + lastTime2 < System.currentTimeMillis()) {
			if (i == 1)
				inAlertArea(2);
		}
	}

	public void inAlertArea(int b) {

		isinAlertArea = b;

	}

	public int getisinAlertArea() {

		return isinAlertArea;

	}

}