package com.httpServer.http.handlers;

import com.httpServer.http.HttpRequest;
import com.httpServer.http.HttpResponse;

import java.io.IOException;

public class WelcomeHandler {

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {

        var message = "your message ("+httpRequest.body+") was saved!";
        httpResponse.send(201, "Created", "text/plain", "201 - "+message);

    }
}
