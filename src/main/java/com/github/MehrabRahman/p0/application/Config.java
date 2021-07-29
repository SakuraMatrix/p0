package com.github.MehrabRahman.p0.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class Config {
    private String[] args;
    private Properties props;
    private Stream<String> streamArgs;
    private Path file;
    private String tiles;
    private boolean server = false;

    public boolean isServer() {
        return server;
    }

    public Path getFile() {
        return file;
    }

    public String getTiles() {
        return tiles;
    }

    public Config(String[] args) {
        this.args = args;
        this.props = new Properties();
        streamArgs = new BufferedReader(new InputStreamReader(System.in)).lines();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--tiles":
                case "-t":
                    props.setProperty("tiles", args[++i]);
                    break;
                case "--file":
                case "-f":
                    props.setProperty("file", args[++i]);
                    break;
                case "--server":
                case "-s":
                    props.setProperty("server", "true");
                    break;
                default:
                    System.err.println("Unknown argument " + args[i]);
                    System.exit(1);
            }
        }

        this.file = Paths.get(props.getProperty("file", "words_alpha.txt"));
        this.tiles = props.getProperty("tiles", "");
        if ("true".equals(props.getProperty("server")))
            this.server = true;
    }
}
