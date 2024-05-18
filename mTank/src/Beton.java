public class Beton extends GameElementAdapter {
	public static final int Beton_20_20 = 0;
	public static final int Beton_20_40 = 1;
	public static final int Beton_20_60 = 2;
	public static final int Beton_40_20 = 3;
	public static final int Beton_60_20 = 4;
	public static final int Beton_50_50 = 5;
	public static final int Beton_120_20 = 6;
	public static final int Beton_20_120 = 7;

	public Beton(int x, int y, int BetonType) {
		super((getBetonType(BetonType)), x, y);
		this.destroyedScore = this.getWidth() * this.getHeight() / 400;
		;
	}

	private static String getBetonType(int type) {
		if (type == Beton_20_20)
			return "Images/Beton-20-20.jpg";
		else if (type == Beton_20_40)
			return "Images/Beton-20-40.jpg";
		else if (type == Beton_20_60)
			return "Images/Beton-20-60.jpg";
		else if (type == Beton_40_20)
			return "Images/Beton-40-20.jpg";
		else if (type == Beton_60_20)
			return "Images/Beton-60-20.jpg";
		else if (type == Beton_50_50)
			return "Images/Beton-50-50.png";
		else if (type == Beton_120_20)
			return "Images/Beton-120-20.png";
		else if (type == Beton_20_120)
			return "Images/Beton-20-120.png";

		return "";
	}

	public void CollideWith(GameElementAdapter him) {
		if ((him instanceof enemybulletright) || (him instanceof enemybulletdown) || (him instanceof enemybulletleft)
				|| (him instanceof enemybulletup)) {

			SoundStore.get().Play(Sounds.Beton);
			him.Destroy();
			return;
		}

		if (him instanceof mytank) {
			((mytank) him).StopMoving();
			((mytank) him).goBack();
			return;
		}
	}

}