import java.awt.event.KeyEvent;

public class mytank extends GameMovableElementAdapter {
	// to firing from both Right and Left sequentially

	private long waitFireTime = 300;
	private long FirelastTime = 0;

	public mytank(int x, int y) {
		super("Images/mytankright.png", x, y);
		setspeed(2);
	}

	public void Reset() {
		this.setXY(22, 540); // set to first status
	}

	// need to get Key Events
	public boolean WantKeyEvents() {
		return true;
	}

	public void KeyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
			StopMoving();
	}

	public void KeyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			if (this.getX() <= 20 && this.getDirection() == DirectionStatus.LEFT) {

			}

			else if (this.getY() <= 20 && this.getDirection() == DirectionStatus.UP) {

			}

			else if (this.getX() + this.getWidth() >= 780 && this.getDirection() == DirectionStatus.RIGHT) {

			}

			else if (this.getY() + this.getHeight() >= 580 && this.getDirection() == DirectionStatus.DOWN) {

			} else
				Fire();

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			setDirection(DirectionStatus.LEFT);
			changeDirectImage(DirectionStatus.LEFT);
			StartMoving();

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			setDirection(DirectionStatus.RIGHT);
			changeDirectImage(DirectionStatus.RIGHT);
			StartMoving();

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			setDirection(DirectionStatus.UP);
			changeDirectImage(DirectionStatus.UP);
			StartMoving();

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			setDirection(DirectionStatus.DOWN);
			changeDirectImage(DirectionStatus.DOWN);
			StartMoving();

		}
	}

	// to collide with other elements
	protected void changeDirectImage(DirectionStatus ds) {

		if (ds == DirectionStatus.UP)
			ChangeImage("Images/mytankup.png");
		if (ds == DirectionStatus.RIGHT)
			ChangeImage("Images/mytankright.png");
		if (ds == DirectionStatus.DOWN)
			ChangeImage("Images/mytankdown.png");
		if (ds == DirectionStatus.LEFT)
			ChangeImage("Images/mytankleft.png");

	}

	protected void Fire() {

		if (GGame.getTotalFires() > 0) {
			if (FirelastTime + waitFireTime < System.currentTimeMillis()) {

				DirectionStatus ds = getsavedirection();

				if (ds == DirectionStatus.UP) {// Create new Bullet and shoot up from Right and Left
					Bulletup b = new Bulletup(0, 0);
					b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() - b.getHeight() - 1);
					GGame.addNewEntity(b);
				}

				if (ds == DirectionStatus.LEFT) {
					Bulletleft b = new Bulletleft(0, 0);
					b.setXY(this.getX() - b.getWidth(), this.getY() + 10);
					GGame.addNewEntity(b);
				}

				if (ds == DirectionStatus.RIGHT) {
					Bulletright b = new Bulletright(0, 0);
					b.setXY(this.getX() + this.getWidth() + 1, this.getY() + b.getHeight());
					GGame.addNewEntity(b);
				}

				if (ds == DirectionStatus.DOWN) {
					Bulletdown b = new Bulletdown(0, 0);
					b.setXY(this.getX() + ((this.getWidth() - b.getWidth()) / 2), this.getY() + this.getHeight() + 1);
					GGame.addNewEntity(b);
				}

				GGame.DecreaseFires(1);
				SoundStore.get().Play(Sounds.Fire);
				FirelastTime = System.currentTimeMillis();
			}
		}
	}

}
