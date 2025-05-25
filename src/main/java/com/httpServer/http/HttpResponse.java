package com.httpServer.http;

import java.io.BufferedWriter;
import java.io.IOException;

public class HttpResponse {
    private BufferedWriter out;

    public HttpResponse(BufferedWriter out){
        this.out = out;
    }

    public void send(int statusCode, String statusText, String contentType, String body) throws IOException {
        out.write("HTTP/1.1 "+ statusCode+ " "+ statusText+"\r\n");
        out.write("Content-Type: "+contentType+"\r\n");
        out.write("Content-Length: "+body.getBytes().length+"\r\n");
        out.write("\r\n");
        out.write(body);
        out.flush();
    }
    public void send404()throws IOException{
        send(404, "Not Found", "text/plain", "404 - Not Found");
    }
    public void send500(String error) throws IOException{
        send(500, "Internal Server Error", "text/plain", "500 - "+ error);
    }
}
