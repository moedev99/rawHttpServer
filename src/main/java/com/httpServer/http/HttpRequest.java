package com.httpServer.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    public final String method;
    public final String path;
    public final String httpVersion;
    public final Map<String, String> headers;
    public final String body;

    private HttpRequest(String method, String path,String httpVersion, Map<String, String> headers, String body) {
        this.method = method;
        this.path = path;
        this.httpVersion = httpVersion;
        this.headers = headers;
        this.body = body;

    }

    public static HttpRequest parse(BufferedReader in)throws IOException {
//        read the first line
        String reqParts = in.readLine();
        if (reqParts == null || reqParts.isEmpty()){
            throw new IOException("Empty Request");
        }

        String[] firstLine = reqParts.split(" ");

        var method = firstLine[0];
        var path = firstLine[1];
        var httpVersion = firstLine[2];

//        read headers
        Map<String, String> headers = new HashMap<>();
        String line;
        int contentLength = 0;

        while (!(line = in.readLine()).isEmpty()){
            String[] headerParts = line.split(":", 2);
            if (headerParts.length == 2){
                headers.put(headerParts[0].trim(), headerParts[1].trim());
            }
            if (line.toLowerCase().startsWith("content-length")){
                contentLength = Integer.parseInt(headerParts[1].trim());
            }

        }

//        read the body and parse it
        String body = "";
        if (contentLength > 0){
            char[] bodyChars = new char[contentLength];
            int totalRead = 0;
            while (totalRead < contentLength){
                int read = in.read(bodyChars, 0, contentLength);
                totalRead += read;
            }
            body = new String(bodyChars);
        }

        return new HttpRequest(method, path, httpVersion, headers, body);
    }
}
