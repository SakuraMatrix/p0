package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private Map<String, Handler> handlers = new HashMap<>();

    public Server(int port) {
        this.port = port;
    }

    public void addHandler(String path, Handler handler) {
        handlers.put(path, handler);
    }

    public void start() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            Socket client;
            while ((client = serverSocket.accept()) != null) {
                Request request = new Request(client.getInputStream());
                Response response = new Response(client.getOutputStream());
                Handler handler = handlers.get(request.getPath());
                handler.service(request, response);
                response.send();
            }
        } catch (IOException ex) {

        }
    }
}
