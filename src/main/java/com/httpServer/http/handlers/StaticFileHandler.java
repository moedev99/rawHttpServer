package com.httpServer.http.handlers;

import com.httpServer.http.HttpResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class StaticFileHandler {
    private final static Logger LOGGGR = Logger.getLogger(StaticFileHandler.class.getName());


    public void handle(HttpResponse httpResponse) throws IOException {
        Path file = Path.of("public/index.html");
        if (Files.exists(file)){
            String body = Files.readString(file);
            String contentType = Files.probeContentType(file);
            httpResponse.send(200, "Ok", contentType, body);
        }else{
            LOGGGR.info("Error while reading index.html");
            httpResponse.send404();
        }



    }
}
