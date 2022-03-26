package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(9876), 0);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        server.createContext("/ping", new HttpHandler());
        server.start();
    }
}
