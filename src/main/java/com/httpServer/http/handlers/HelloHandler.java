package com.httpServer.http.handlers;

import com.httpServer.http.HttpResponse;

import java.io.IOException;

public class HelloHandler {

    public void handle(HttpResponse res)throws IOException {

        String body = "{"
                + "\"message\": \"Hello, World!\","
                + "\"language\": \"Java\","
                + "\"success\": true"
                + "}";

        res.send(200, "OK", "application/json", body);

    }
}
