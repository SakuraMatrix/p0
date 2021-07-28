package http;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
    private PrintWriter writer;
    private Object body;

    public Response(OutputStream outputStream) {
        this.writer = new PrintWriter(outputStream, true);
    }

    public void setBody(Object o) {
        this.body = o;
    }

    public void send() {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html");
        writer.println();
        writer.println(body);
        writer.close();
    }
}
