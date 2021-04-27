package src.Enums;

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

	public String getValue(TileTypes tile) {
		switch (tile) {
			case SEA -> { return "sea"; }
			case DOCK -> { return "dock"; }
			case CAVE -> { return "cave"; }
			case LAKE -> { return "lake"; }
			case ALTAR -> { return "altar"; }
			case GRASS -> { return "grass"; }
			case GEYSER -> { return "geyser"; }
			case JUNGLE -> { return "jungle"; }
			case VOLCANO -> { return "volcano"; }
			case VILLAGE -> { return "village"; }
			case MOUNTAIN -> { return "mountain"; }
			case PLAYERSHIP -> { return "Ship"; }
			case GOLDENPYRAMID -> { return "goldenpyramid"; }
			default -> { return "missingtexture"; }
		}
	}
}