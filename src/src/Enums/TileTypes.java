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
	GEYSER;

	public String getValue(TileTypes tile) {
		switch (tile) {
			case SEA -> { return "🌊"; }
			case CAVE -> { return "🕳"; }
			case LAKE -> { return "♒"; }
			case ALTAR -> { return "⛩"; }
			case GRASS -> { return "🟩"; }
			case GEYSER -> { return "🏔"; }
			case JUNGLE -> { return "🌳"; }
			case VOLCANO -> { return "🌋"; }
			case VILLAGE -> { return "⛪"; }
			case MOUNTAIN -> { return "🗻"; }
			case PLAYERSHIP -> { return "🚢"; }
			case GOLDENPYRAMID -> { return "🛕"; }
			default -> { return "🅱"; }
		}
	}
}