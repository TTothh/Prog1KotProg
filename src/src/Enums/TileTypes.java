package src.Enums;

/**
 * A mapokon előforduló mezőtípusok
 */
public enum TileTypes {
	SEA,
	PLAYERSHIP,
	LAKE,
	MOUNTAIN,
	CAVE,
	ALTAR,
	JUNGLE,
	GOLDENPYRAMID,
	GRASS,
	VILLAGE,
	VOLCANO,
	GEYSER,
	DOCK;

	/**
	 * A typushoz tartozó kódokkal tér vissza
	 * @param tile
	 * @return INteger a typushoz tartozó kód
	 */
	public static String getValue(TileTypes tile) {
		switch (tile) {
			case SEA -> { return "a"; }
			case DOCK -> { return "b"; }
			case CAVE -> { return "c"; }
			case LAKE -> { return "d"; }
			case ALTAR -> { return "e"; }
			case GRASS -> { return "f"; }
			case GEYSER -> { return "g"; }
			case JUNGLE -> { return "h"; }
			case VOLCANO -> { return "i"; }
			case VILLAGE -> { return "j"; }
			case MOUNTAIN -> { return "k"; }
			case PLAYERSHIP -> { return "l"; }
			case GOLDENPYRAMID -> { return "m"; }
			default -> { return "missingtexture"; }
		}
	}
}