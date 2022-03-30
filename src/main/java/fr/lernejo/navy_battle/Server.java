package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    public final int port;

    public Server(int port) {
        this.port = port;

    }
    public void ping() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new PingHandler());
        server.start();
    }
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/api/game/start", new StartHandler());
        server.start();
    }
}
