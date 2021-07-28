import application.Context;
import domain.Dictionary;
import domain.Word;
import http.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Scrabble {
    public static void main(String ...args) {
        Logger log = LoggerFactory.getLogger(Scrabble.class);
        log.info("Starting application...");

        // specify a dictionary to scan
        Context appContext = new Context(args);

        // search for words and their anagrams
        System.out.println(appContext.searchTiles());

        // launch a server
        Server server = new Server(8080);
        server.addHandler("/scrabble", (req, res) -> {
            Context serverContext = new Context("words_alpha.txt", req.getParam("tiles"));
            res.setBody(serverContext.searchTiles());
        });
        server.start();
    }
}