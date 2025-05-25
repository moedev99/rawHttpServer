package com.httpServer.http;

import com.httpServer.http.handlers.HelloHandler;
import com.httpServer.http.handlers.StaticFileHandler;
import com.httpServer.http.handlers.WelcomeHandler;

import java.io.IOException;
import java.util.logging.Logger;

public class Router {
    private final static Logger LOGGER = Logger.getLogger(Router.class.getName());
    private static HelloHandler helloHandler = new HelloHandler();
    private static WelcomeHandler welcomeHandler = new WelcomeHandler();
    private static StaticFileHandler staticFileHandler = new StaticFileHandler();


    public Router() {

    }

    public static void route(HttpRequest req, HttpResponse res) throws IOException {
        if (req.method.equals(HttpMethod.GET.toString()) && req.path.equals("/hello")){
            helloHandler.handle(res);

        }
        else if (req.method.equals(HttpMethod.POST.toString()) && req.path.equals("/welcome")){
            welcomeHandler.handle(req, res);

        }
        else if (req.method.equals(HttpMethod.GET.toString()) && req.path.equals("/index.html")){
            staticFileHandler.handle(res);

        }
        else{
            LOGGER.info("No method or path was matched");
            res.send404();
        }


    }

}
