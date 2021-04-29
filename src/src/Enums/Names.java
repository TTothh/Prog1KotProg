package src.Enums;

import java.util.List;
import java.util.Random;

/**
 * Nevek Értékei
 */
public enum Names {
	//from: https://medium.com/@barelyharebooks/a-master-list-of-300-fantasy-names-characters-towns-and-villages-47c113f6a90b
	Lydan,
	Syrin,
	Ptorik,
	Joz,
	Varog,
	Gethrod,
	Hezra,
	Feron,
	Ophni,
	Colborn,
	Fintis,
	Gatlin,
	Jinto,
	Hagalbar,
	Krinn,
	Lenox,
	Revvyn,
	Hodus,
	Dimian,
	Paskel,
	Kontas,
	Weston,
	Azamarr,
	Jather,
	Tekren,
	Jareth,
	Adon,
	Zaden,
	Eune,
	Graff,
	Tez,
	Jessop,
	Gunnar,
	Pike,
	Domnhar,
	Baske,
	Jerrick,
	Mavrek,
	Riordan,
	Wulfe,
	Straus,
	Tyvrik,
	Henndar,
	Favroe,
	Whit,
	Jaris,
	Renham,
	Kagran,
	Lassrin,
	Vadim,
	Arlo,
	Quintis,
	Vale,
	Caelan,
	Yorjan,
	Khron,
	Ishmael,
	Jakrin,
	Fangar,
	Roux,
	Baxar,
	Hawke,
	Gatlen,
	Barak,
	Nazim,
	Kadric,
	Paquin,
	Kent,
	Moki,
	Rankar,
	Lothe,
	Ryven,
	Clawsen,
	Pakker,
	Embre,
	Cassian,
	Verssek,
	Dagfinn,
	Ebraheim,
	Nesso,
	Eldermar,
	Rivik,
	Rourke,
	Barton,
	Hemm,
	Sarkin,
	Blaiz,
	Talon,
	Agro,
	Zagaroth,
	Turrek,
	Esdel,
	Lustros,
	Zenner,
	Baashar,
	Dagrod,
	Gentar,
	Feston;

	private static final List<Names> VALUES = List.of(values());
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	/**
	 * Random névvel tér visza
	 * @return String név
	 */

	public static String randomName()  {
		return String.valueOf(VALUES.get(RANDOM.nextInt(SIZE)));
	}
}


