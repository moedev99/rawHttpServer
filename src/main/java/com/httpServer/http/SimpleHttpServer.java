package com.httpServer.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;


public class SimpleHttpServer
{
    private static final Logger LOGGER = Logger.getLogger(SimpleHttpServer.class.getName());

    public static void main( String[] args )
    {
        var PORT = 8080;
        try(ServerSocket serverSocket = new ServerSocket(PORT); ExecutorService pool = Executors.newVirtualThreadPerTaskExecutor()){

            LOGGER.info("server is running on port: "+PORT);
//            accept connection
            while (true){
                Socket clientSocket = serverSocket.accept();


                pool.submit( () -> handleClient(clientSocket));
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void  handleClient(Socket clientSocket){
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
                ){
            HttpRequest request = HttpRequest.parse(in);
            HttpResponse response = new HttpResponse(out);

            Router.route(request, response);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
