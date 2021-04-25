package src.JavaReImplementations;

import src.Logging;

import java.util.logging.Level;

public class Random {
	public Random() {}

	public int NextRandom(int min, int max) {
		java.util.Random r = new java.util.Random();
		int delta = (max + 1) - min; //because java random goes from 1 to value
		if(delta > 1) {
			return r.nextInt(delta) + min; //TODO should subtract 1 but it breaks things.
		} else {
			System.out.println("wrong random");
			Logging.Log("Wrong values at NextRandom generation: " + min + "|" + max, "Setup.log", getClass().getName(), Level.SEVERE);
			return r.nextInt(Math.abs(delta) + 1);
		}
	}
}
