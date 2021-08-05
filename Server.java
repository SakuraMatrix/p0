package projectzero.budgetar;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;
import org.slf4j.*;
import org.slf4j.LoggerFactory;

public class Server {

        public void initialize(int port) {
            int x = 0;
            ArrayList xlist =  new GetData().FileContent().itemList; //   .HttpDisplayList().httpList;
            Iterator xList = xlist.stream().iterator();
            Javalin app = Javalin.create().start(port);
            //ArrayList finalX = x;
            app.get("/", ctx -> ctx.result("Success: Connection Initiated :\n" + xlist));

        }
    }

