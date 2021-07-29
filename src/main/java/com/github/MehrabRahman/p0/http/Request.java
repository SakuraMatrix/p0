package com.github.MehrabRahman.p0.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private static final Logger log = LoggerFactory.getLogger(Request.class);
    private BufferedReader reader;
    private String path;
    private Map<String, String> params;

    public Request(InputStream inputStream) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.params = new HashMap<>();
        parse();
    }

    private void parse() throws IOException {
        String requestLine = reader.readLine();
        String[] splitRequestLine = requestLine.split(" ");
        this.path = splitRequestLine[1];
        if (path.contains("?")) {
            String[] splitUri = path.split("\\?");
            this.path = splitUri[0];
            String[] args = splitUri[1].split("=");
            params.put(args[0], args[1]);
        }
        log.debug(path);
        log.debug(params.get("tiles"));
    }

    public String getPath() {
        return path;
    }

    public String getParam(String key) {
        return params.get(key);
    }
}
