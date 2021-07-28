package http;

public interface Handler {
    void service(Request request, Response response);
}
