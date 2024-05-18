import java.awt.font.NumericShaper.Range;
import java.util.Random;

public class enemytank extends GameMovableElementAdapter {

	public int isinnear = 0;
	AlertArea B;

	private String status = "left";
	private int speed; // Speed in All Direction
	private DirectionStatus DS; // (RIGHT,LEFT,UP,DOWN)
	private DirectionStatus savedirection;

	public enemytank(int x, int y) {
		super("Images/enemytankdown.png", x, y);
		B = new AlertArea(this.getX(), this.getY());
		destroyedScore = 100;
		this.speed = 1;
		this.StartMoving();
	}

	private long waitDirectTime = 300;
	private long DirectlastTime = 0;

	private long waitFireTime = 850;
	private long FirelastTime = 0;

	private long waitTime = 50;
	private long lastTime = 0;
	private long waitTime2 = 1000;
	private long lastTime2 = 0;

	int i = 1;
	int j = 1;
	int k = 1;

	public void Step() {
		super.Step();

		// enemy tank X and Y
		int X = this.getX() + (this.getWidth() / 2);
		int Y = this.getY() + (this.getHeight() / 2);

		// Radius
		int H = 200;

		// Checking is in enemy tank area or no
		int v = 0;

		//
		if (waitTime + lastTime < System.currentTimeMillis())
			if (((Y - Levels.my_tank.getY() < H && Y - Levels.my_tank.getY() > -H)
					&& (X - Levels.my_tank.getX() < H && X - Levels.my_tank.getX() > -H))
					|| ((Levels.my_tank.getX() - X < H && Levels.my_tank.getX() - X > -H)
							&& (Levels.my_tank.getY() - Y < H && Levels.my_tank.getY() - Y > -H)))
				this.inAlertArea(1);
			else
				v = 1;
		if (waitTime2 + lastTime2 < System.currentTimeMillis()) {
			if (v == 1)
				this.inAlertArea(2);
		}
		StartMoving();
		if (waitDirectTime + DirectlastTime < System.currentTimeMillis()) {

			j = B.getisinAlertArea();
			k = this.getisinAlertArea();

			if (j == 1 || k == 1) {

				i = (int) (Math.random() * 2.9);
				if (i == 1) {
					if (this.getY() > Levels.my_tank.getY()) {
						this.setsavedirection(DirectionStatus.UP);
						this.setDirection(getsavedirection());
						changeDirectImage();
						StartMoving();
					}

					else if (this.getY() < Levels.my_tank.getY()) {
						this.setsavedirection(DirectionStatus.DOWN);
						this.setDirection(getsavedirection());
						changeDirectImage();
						StartMoving();
					}

				}

				if (i == 2) {
					if (this.getX() > Levels.my_tank.getX()) {
						this.setsavedirection(DirectionStatus.LEFT);
						this.setDirection(getsavedirection());
						changeDirectImage();
						StartMoving();
					}

					else if (this.getX() < Levels.my_tank.getX()) {
						this.setsavedirection(DirectionStatus.RIGHT);
						this.setDirection(getsavedirection());
						changeDirectImage();
						StartMoving();

					}

				}

			}

			else if (j == 2 || k == 2) {
				setsavedirection((int) (Math.random() * 4));
				changeDirectImage();
				setDirection(getsavedirection());
			}

			DirectlastTime = System.currentTimeMillis();

		}

		if (FirelastTime + waitFireTime < System.currentTimeMillis())
			if (this.getX() <= 15 && this.getsavedirection() == DirectionStatus.LEFT) {

			}

			else if (this.getY() <= 15 && this.getsavedirection() == DirectionStatus.UP) {

			}

			else if (this.getX() + this.getWidth() >= 785 && this.getsavedirection() == DirectionStatus.RIGHT) {

			}

			else if (this.getY() + this.getHeight() >= 585 && this.getsavedirection() == DirectionStatus.DOWN) {

			} else {
				this.Fire();
				FirelastTime = System.currentTimeMillis();
			}
	}

	public void CollideWith(GameElementAdapter element) {

		if ((element instanceof Bulletup) || (element instanceof Bulletdown) || (element instanceof Bulletleft)
				|| (element instanceof Bulletright)) {

			this.Destroy();

		}

		if (element instanceof Beton) {
			StopMoving();
			goBack();
		}

		if (element instanceof mytank) {
			SoundStore.get().Play(Sounds.Explosion);
			this.Destroy();
			GGame.DecreaseLive();

		}

		// to collide with other elements

	}

	protected void changeDirectImage() {

		if (savedirection == DirectionStatus.UP)
			ChangeImage("Images/enemytankup.png");
		if (savedirection == DirectionStatus.RIGHT)
			ChangeImage("Images/enemytankright.png");
		if (savedirection == DirectionStatus.DOWN)
			ChangeImage("Images/enemytankdown.png");
		if (savedirection == DirectionStatus.LEFT)
			ChangeImage("Images/enemytankleft.png");

	}

	protected void Fire() {

		DirectionStatus ds = getsavedirection();

		// Create new Bullet and shoot up from Right and Left
		if (ds == DirectionStatus.UP) {
			enemybulletup b = new enemybulletup(0, 0);
			b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() - b.getHeight() - 1);
			GGame.addNewEntity(b);
		}

		if (ds == DirectionStatus.LEFT) {
			enemybulletleft b = new enemybulletleft(0, 0);
			b.setXY(this.getX() - b.getWidth(), this.getY() + 10);
			GGame.addNewEntity(b);
		}

		if (ds == DirectionStatus.RIGHT) {
			enemybulletright b = new enemybulletright(0, 0);
			b.setXY(this.getX() + this.getWidth() + 1, this.getY() + b.getHeight());
			GGame.addNewEntity(b);
		}

		if (ds == DirectionStatus.DOWN) {
			enemybulletdown b = new enemybulletdown(0, 0);
			b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() + this.getHeight() + 1);
			GGame.addNewEntity(b);
		}

		SoundStore.get().Play(Sounds.Fire);
	}

	protected void setDirection(DirectionStatus DS) {

		DirectionStatus ds = DS;

		if (ds == DirectionStatus.LEFT) {
			setsavedirection(ds);
			setSpeedX(speed);
			setSpeedY(0);
			setLeftDirection();
		}

		if (ds == DirectionStatus.RIGHT) {
			setsavedirection(ds);
			setSpeedX(speed);
			setSpeedY(0);
			setRightDirection();
		}

		if (ds == DirectionStatus.DOWN) {
			setsavedirection(ds);
			setSpeedX(0);
			setSpeedY(speed);
			setDownDirection();
		}

		if (ds == DirectionStatus.UP) {
			setsavedirection(ds);
			setSpeedX(0);
			setSpeedY(speed);
			setUpDirection();
		}

		this.DS = ds;
	}

	protected DirectionStatus getDirection() {
		return DS;
	}

	protected void setsavedirection(int a) {

		if (a == 1)

			this.savedirection = DirectionStatus.UP;
		else if (a == 2)
			this.savedirection = DirectionStatus.RIGHT;
		else if (a == 3)
			this.savedirection = DirectionStatus.DOWN;
		else
			this.savedirection = DirectionStatus.LEFT;
	}

	protected DirectionStatus getsavedirection() {

		return savedirection;
	}

	protected void setsavedirection(DirectionStatus ds) {

		this.savedirection = ds;
	}

	public void inAlertArea(int b) {

		isinnear = b;

	}

	public int getisinAlertArea() {

		return isinnear;

	}

}
