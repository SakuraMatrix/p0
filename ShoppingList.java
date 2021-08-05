package projectzero.budgetar;
/**
 import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpServer;
import io.javalin.Javalin;
import reactor.netty.disposableServer;
import reactor.netty.tcp.TccpServer;


public class ShoppingList extends GetData {
    HashMap cogsList = cogs;
    HashMap nvList = nv;

    public ShoppingList() {
        //Object[] xList = new Object[];
        try (Stream<String> String = Files.lines(streamDictionary)) {
        } catch (IOException e) {

        }
    }

    //Create Servers,
   // Netty Server
        public static void server(){
            HttpServer.create().route(8080).route(
                    route -> route.get(path: "/" (req, res) -> res.sendString (Mono.just("Hello Kanyigis!")))
        .get(path: "/Hello/{param})",
                    (request, response) -> response.sendString( Mono.just("Hello, " + request.parm)"param"))
            ).bindNow().onDispose().block();
        }

        //Javalin Server
        public static void javalinServer(){
            Javalin server = Javalin.create().start(8080);
            server.get("/hello", context -> context.result("<h1> Hello <h3> Atech24 </h3> from Javalin  </h1>").contentType("text/html"));
        }
}
        **/