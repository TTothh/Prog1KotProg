package src.JavaReImplementations;

import src.Logging;

import java.util.logging.Level;

/**
 * Mivel a Java hülye és csak 1-max intervallumban tud generálni ezért írtam egy saját osztályt (this) ami a chad C# módjára tud értékeket elfogadni és 0-max intervallumban tér vissza ahogy azt kéne. Nice job Java
 *
 */
public class Random {
	public Random() {}

	/**
	 * Visszatér random számmal
	 * @param min
	 * @param max
	 * @return
	 */
	public int NextRandom(int min, int max) {
		java.util.Random r = new java.util.Random();
		int delta = (max + 1) - min; //because java random goes from 1 to value
		if(delta > 1) {
			return r.nextInt(delta) + min; //TODO should subtract 1 but it breaks things. I was stupid and now it won't work as intended...
		} else {
			Logging.Log("Wrong values at NextRandom generation: " + min + "|" + max, "Setup.log", getClass().getName(), Level.SEVERE);
			return r.nextInt(Math.abs(delta) + 1);
		}
	}
}
