package JavaReImplementations;

public class Random {
	public Random() {}

	public int NextRandom(int min, int max) {
		java.util.Random r = new java.util.Random();
		int delta = (max + 1) - min; //beacuse java random goes from 1 to value
		return r.nextInt(delta) + min;
	}
}
