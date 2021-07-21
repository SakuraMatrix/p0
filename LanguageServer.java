import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class LanguageServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Watching...");
        Path watchTarget = Paths.get(args[0]).toAbsolutePath().normalize();
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey key = watchTarget.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        ProcessBuilder javac = new ProcessBuilder("javac", 
            "-d", System.getProperty("java.io.tmpdir"),
            "-Xlint",
            watchTarget.toString());

        boolean valid = true;
        while (valid) {
            key = watchService.take();
            Thread.sleep(1000);
            System.out.println("\033[H\033[2J");
            key.pollEvents();
            javac.inheritIO().start().waitFor();
            valid = key.reset();
        }
    }
}
