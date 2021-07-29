package com.github.MehrabRahman.p0;

import com.github.MehrabRahman.p0.application.Config;
import com.github.MehrabRahman.p0.application.Context;
import com.github.MehrabRahman.p0.domain.Dictionary;
import com.github.MehrabRahman.p0.domain.Word;
import com.github.MehrabRahman.p0.http.Server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Scrabble {
    public static void main(String ...args) {
        Logger log = LoggerFactory.getLogger(Scrabble.class);
        log.info("Starting com.github.MehrabRahman.p0.application...");

        // specify a dictionary to scan
        final Context appContext = new Context(args);
        Config appConfig = appContext.getAppConfig();

        // search for words and their anagrams
        Word tiles = Word.of(appConfig.getTiles());
        Dictionary dictionary = appContext.getDictionary();
        Set<Word> results = dictionary.stream().search(tiles);

        if (appConfig.isServer()) {
            log.info("Launching com.github.MehrabRahman.p0.Scrabble server...");
            // launch a server
            try {
                Server server = appContext.getServer();
                server.addHandler("/scrabble", (req, res) -> {
                    Word httpTiles = Word.of(req.getParam("tiles"));
                    res.setBody(dictionary.stream().search(httpTiles));
                });
                server.start();
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        } else {
            // Print to stdout
            System.out.println(results);
        }

    }
}