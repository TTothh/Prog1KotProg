import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
	public static void Log(String msg, String file, String className, Level level) {
		Logger logger = Logger.getLogger(className);
		FileHandler fh;
		try {
			fh = new FileHandler(file);
		} catch (IOException e) {
			try {
				Files.createDirectories(Paths.get(file).getParent());
				Files.createFile(Paths.get(file));
				fh = new FileHandler(file);
				System.out.println("I dunno at this point.");
				logger.addHandler(fh);
				SimpleFormatter sf = new SimpleFormatter();
				fh.setFormatter(sf);
				logger.log(level, msg);
			} catch (IOException er) {
				System.out.println("Error");
			}
		}

	}
}
