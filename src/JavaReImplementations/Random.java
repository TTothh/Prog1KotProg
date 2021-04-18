package JavaReImplementations;

public class Random {
	public Random() {}

	public int NextRandom(int min, int max) {
		java.util.Random r = new java.util.Random();
		int delta = max - min;
		return r.nextInt(delta) + min;
	}
}
