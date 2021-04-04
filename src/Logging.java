import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
	private static String msg;
	private static String File;

	public static void Log(String msg, String file, String className, Level level) throws IOException {
		Logger logger = Logger.getLogger(className);
		FileHandler fh;
		try {
			fh = new FileHandler(file);
		} catch (IOException e) {
			Files.createDirectories(Paths.get(file).getParent());
			Files.createFile(Paths.get(file));
			fh = new FileHandler(file);
		}

		logger.addHandler(fh);
		SimpleFormatter sf = new SimpleFormatter();
		fh.setFormatter(sf);
		logger.log(level, msg);
	}
}
