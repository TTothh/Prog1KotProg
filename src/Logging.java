import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.*;

public class Logging {
	public static void Log(String msg, String file, String className, Level level) {
		Path log = Paths.get("Logs\\" + file);
		try {
			if(!Files.isDirectory(log.getParent())) {
				Files.createDirectory(log.getParent());
			}
			if(!Files.exists(log)) {
				Files.createFile(log);
			}

			String msgToWrite = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Date.from(Instant.now())) + " [" + className + "] [" + level + "] : " + msg + "\r\n";

			Files.writeString(log, msgToWrite, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}
