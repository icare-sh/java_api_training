package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {return;}
        Server server = new Server(Integer.parseInt(args[0]));
        server.ping();
        server.start();
        if (args.length == 2) {
            Client client = new Client(Integer.parseInt(args[0]));
            HttpResponse resp = client.postRequest(Integer.parseInt(args[0]), args[1]);
        }
    }
}
