package com.github.MehrabRahman.p0.application;

import com.github.MehrabRahman.p0.domain.Dictionary;
import com.github.MehrabRahman.p0.domain.Word;
import com.github.MehrabRahman.p0.http.Server;

public class Context {
    private Dictionary dictionary;
    private Word tiles;
    private Config appConfig;
    private Server server;

    public Context(String ...args) {
        this.appConfig = new Config(args);
        this.dictionary = Dictionary.of(appConfig.getFile());
        this.tiles = Word.of(appConfig.getTiles());
        if(appConfig.isServer()) {
            // launch a server
            this.server = new Server(8080);
        }
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public Word getTiles() {
        return tiles;
    }

    public Config getAppConfig() {
        return appConfig;
    }

    public Server getServer() {
        return server;
    }
}
