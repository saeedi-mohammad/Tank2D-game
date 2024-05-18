
abstract class Levels {
	public static final int FinalLevel = 4;
	public static mytank my_tank;

	public static void SetLevel(GGame game, int level) {
		if (level == 1) {
			// configs of Level 1
			PlayerInfo p = new PlayerInfo();
			p.setLives(4);
			p.setFires(15);
			p.setScore(0);
			p.setPlayerName("MSI");
			p.setCurrentLevel(1);

			game.setPlayerInfo(p);
			LoadMap(game, 1);
		}

		else if (level <= FinalLevel) {
			PlayerInfo p = game.getPlayerInfo();
			p.setCurrentLevel(p.getCurrentLevel() + 1);
			game.setPlayerInfo(p);
			LoadMap(game, level);
		}

	}

	private static void LoadMap(GGame game, int level) {
		if (level == 1)
			LoadMap1(game);
		if (level == 2)
			LoadMap2(game);
		if (level == 3)
			LoadMap3(game);
		if (level == 4)
			LoadMap4(game);

	}

	private static void LoadMap1(GGame game) {
		game.clearEntities();
		// Static parts
		game.setNextEntity(new GBackground(0, 0, 1));
		my_tank = new mytank(5, 535);
		game.setNextEntity(my_tank);
		game.setNextEntity(new AlertArea(190, 95));

		game.setNextEntity(new goldcoin(379, 295));
		game.setNextEntity(new tower(370, 290, 3));
		game.setNextEntity(new enemytank(100, 40));

		// starting place
		game.setNextEntity(new Beton(5, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(25, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(45, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(65, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(85, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(105, 510, Beton.Beton_20_20));

		game.setNextEntity(new Beton(100, 200, Beton.Beton_20_20));
		game.setNextEntity(new Beton(100, 220, Beton.Beton_20_20));
		game.setNextEntity(new Beton(100, 240, Beton.Beton_20_20));
		game.setNextEntity(new Beton(100, 350, Beton.Beton_20_20));
		game.setNextEntity(new Beton(100, 370, Beton.Beton_20_20));
		game.setNextEntity(new Beton(100, 390, Beton.Beton_20_20));

		game.setNextEntity(new Beton(660, 200, Beton.Beton_20_20));
		game.setNextEntity(new Beton(660, 220, Beton.Beton_20_20));
		game.setNextEntity(new Beton(660, 240, Beton.Beton_20_20));
		game.setNextEntity(new Beton(660, 350, Beton.Beton_20_20));
		game.setNextEntity(new Beton(660, 370, Beton.Beton_20_20));
		game.setNextEntity(new Beton(660, 390, Beton.Beton_20_20));

		game.setNextEntity(new Beton(270, 80, Beton.Beton_20_20));
		game.setNextEntity(new Beton(290, 80, Beton.Beton_20_20));
		game.setNextEntity(new Beton(310, 80, Beton.Beton_20_20));
		game.setNextEntity(new Beton(460, 80, Beton.Beton_20_20));
		game.setNextEntity(new Beton(480, 80, Beton.Beton_20_20));
		game.setNextEntity(new Beton(500, 80, Beton.Beton_20_20));

		game.setNextEntity(new Beton(270, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(290, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(310, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(460, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(480, 510, Beton.Beton_20_20));
		game.setNextEntity(new Beton(500, 510, Beton.Beton_20_20));

		// other objects
		game.setNextEntity(new ammo(50, 50));
		game.setNextEntity(new ammo(700, 50));
		game.setNextEntity(new GHeart(380, 200));
		game.setNextEntity(new silvercoin(100, 290));
		game.setNextEntity(new silvercoin(380, 75));
		game.setNextEntity(new silvercoin(650, 290));
		game.setNextEntity(new silvercoin(380, 504));

	}

	private static void LoadMap2(GGame game) {
		game.clearEntities();
		// Static parts
		game.setNextEntity(new GBackground(0, 0, 0));
		my_tank = new mytank(5, 535);
		game.setNextEntity(my_tank);

		// Other Elements (from MAP)
		game.setNextEntity(new AlertArea(188, 70));
		game.setNextEntity(new enemytank(200, 80));
		game.setNextEntity(new enemytank(600, 80));
		game.setNextEntity(new ammo(385, 425));
		game.setNextEntity(new ammobox(385, 140));
		game.setNextEntity(new goldcoin(139, 135));
		game.setNextEntity(new tower(130, 130, 3));
		game.setNextEntity(new goldcoin(609, 425));
		game.setNextEntity(new tower(600, 420, 3));

		game.setNextEntity(new Beton(5, 510, Beton.Beton_60_20));
		game.setNextEntity(new Beton(65, 510, Beton.Beton_60_20));

		game.setNextEntity(new Beton(220, 190, Beton.Beton_20_60));
		game.setNextEntity(new Beton(220, 250, Beton.Beton_20_60));
		game.setNextEntity(new Beton(220, 310, Beton.Beton_20_60));
		game.setNextEntity(new Beton(550, 190, Beton.Beton_20_60));
		game.setNextEntity(new Beton(550, 250, Beton.Beton_20_60));
		game.setNextEntity(new Beton(550, 310, Beton.Beton_20_60));

		game.setNextEntity(new Beton(280, 110, Beton.Beton_60_20));
		game.setNextEntity(new Beton(340, 110, Beton.Beton_60_20));
		game.setNextEntity(new Beton(400, 110, Beton.Beton_60_20));
		game.setNextEntity(new Beton(460, 110, Beton.Beton_60_20));
		game.setNextEntity(new Beton(340, 400, Beton.Beton_20_20));
		game.setNextEntity(new Beton(360, 400, Beton.Beton_20_20));
		game.setNextEntity(new Beton(380, 400, Beton.Beton_20_20));
		game.setNextEntity(new Beton(400, 400, Beton.Beton_20_20));
		game.setNextEntity(new Beton(420, 400, Beton.Beton_20_20));
		game.setNextEntity(new Beton(440, 400, Beton.Beton_20_20));

		game.setNextEntity(new GHeart(765, 428));
		game.setNextEntity(new Beton(740, 395, Beton.Beton_20_20));
		game.setNextEntity(new Beton(760, 395, Beton.Beton_20_20));
		game.setNextEntity(new Beton(780, 395, Beton.Beton_20_20));
		game.setNextEntity(new Beton(740, 465, Beton.Beton_20_20));
		game.setNextEntity(new Beton(760, 465, Beton.Beton_20_20));
		game.setNextEntity(new Beton(780, 465, Beton.Beton_20_20));

		game.setNextEntity(new GHeart(5, 133));
		game.setNextEntity(new Beton(0, 100, Beton.Beton_20_20));
		game.setNextEntity(new Beton(20, 100, Beton.Beton_20_20));
		game.setNextEntity(new Beton(40, 100, Beton.Beton_20_20));
		game.setNextEntity(new Beton(0, 170, Beton.Beton_20_20));
		game.setNextEntity(new Beton(20, 170, Beton.Beton_20_20));
		game.setNextEntity(new Beton(40, 170, Beton.Beton_20_20));

	}

	private static void LoadMap3(GGame game) {
		game.clearEntities();
		// Movable
		game.setNextEntity(new GBackground(0, 0, 1));
		my_tank = new mytank(5, 535);
		game.setNextEntity(my_tank);
		game.setNextEntity(new AlertArea(190, 5));
		game.setNextEntity(new enemytank(10, 10));
		game.setNextEntity(new enemytank(380, 290));
		game.setNextEntity(new enemytank(750, 10));

		game.setNextEntity(new goldcoin(384, 24));
		game.setNextEntity(new tower(375, 20, 2));
		game.setNextEntity(new goldcoin(24, 459));
		game.setNextEntity(new tower(15, 455, 2));
		game.setNextEntity(new goldcoin(743, 374));
		game.setNextEntity(new tower(734, 370, 2));
		game.setNextEntity(new GHeart(390, 385));
		game.addNewEntity(new ammobox(390, 470));

		// Other Elements (from MAP)

		game.setNextEntity(new Beton(0, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(120, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(240, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(360, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(480, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(600, 510, Beton.Beton_120_20));
		game.setNextEntity(new Beton(80, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(200, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(320, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(440, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(560, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(680, 430, Beton.Beton_120_20));
		game.setNextEntity(new Beton(0, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(120, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(240, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(360, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(480, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(600, 350, Beton.Beton_120_20));
		game.setNextEntity(new Beton(120, 100, Beton.Beton_20_40));
		game.setNextEntity(new Beton(120, 140, Beton.Beton_20_40));
		game.setNextEntity(new Beton(120, 180, Beton.Beton_20_40));
		game.setNextEntity(new Beton(120, 220, Beton.Beton_20_40));
		game.setNextEntity(new Beton(390, 100, Beton.Beton_20_40));
		game.setNextEntity(new Beton(390, 140, Beton.Beton_20_40));
		game.setNextEntity(new Beton(390, 180, Beton.Beton_20_40));
		game.setNextEntity(new Beton(390, 220, Beton.Beton_20_40));
		game.setNextEntity(new Beton(680, 100, Beton.Beton_20_40));
		game.setNextEntity(new Beton(680, 140, Beton.Beton_20_40));
		game.setNextEntity(new Beton(680, 180, Beton.Beton_20_40));
		game.setNextEntity(new Beton(680, 220, Beton.Beton_20_40));
	}

	private static void LoadMap4(GGame game) {
		game.clearEntities();
		// Static elements
		game.setNextEntity(new GBackground(0, 0, 3));
		// Movable
		my_tank = new mytank(30, 540);
		game.setNextEntity(my_tank);
		game.setNextEntity(new AlertArea(190, 95));
		game.setNextEntity(new enemytank(60, 40));
		game.setNextEntity(new enemytank(270, 40));
		game.setNextEntity(new enemytank(500, 40));
		game.setNextEntity(new enemytank(720, 40));

		game.setNextEntity(new goldcoin(389, 275));
		game.setNextEntity(new tower(380, 271, 2));

		// Other Elements (from MAP)

		game.setNextEntity(new Beton(20, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(140, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(260, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(380, 1, Beton.Beton_40_20));
		game.setNextEntity(new Beton(420, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(540, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(660, 1, Beton.Beton_120_20));
		game.setNextEntity(new Beton(1, 1, Beton.Beton_20_120));
		game.setNextEntity(new Beton(1, 120, Beton.Beton_20_120));
		game.setNextEntity(new Beton(1, 240, Beton.Beton_20_120));
		game.setNextEntity(new Beton(1, 360, Beton.Beton_20_120));
		game.setNextEntity(new Beton(1, 480, Beton.Beton_20_120));
		game.setNextEntity(new Beton(779, 1, Beton.Beton_20_120));
		game.setNextEntity(new Beton(779, 120, Beton.Beton_20_120));
		game.setNextEntity(new Beton(779, 240, Beton.Beton_20_120));
		game.setNextEntity(new Beton(779, 360, Beton.Beton_20_120));
		game.setNextEntity(new Beton(779, 480, Beton.Beton_20_120));
		game.setNextEntity(new Beton(20, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(140, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(260, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(380, 579, Beton.Beton_40_20));
		game.setNextEntity(new Beton(420, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(540, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(660, 579, Beton.Beton_120_20));
		game.setNextEntity(new Beton(140, 140, Beton.Beton_60_20));
		game.setNextEntity(new Beton(600, 140, Beton.Beton_60_20));
		game.setNextEntity(new Beton(140, 450, Beton.Beton_60_20));
		game.setNextEntity(new Beton(600, 450, Beton.Beton_60_20));
		game.setNextEntity(new Beton(160, 270, Beton.Beton_20_60));
		game.setNextEntity(new Beton(620, 270, Beton.Beton_20_60));

		game.setNextEntity(new ammobox(390, 50));
		game.setNextEntity(new GHeart(30, 30));
		game.setNextEntity(new GHeart(740, 30));
	}

}
