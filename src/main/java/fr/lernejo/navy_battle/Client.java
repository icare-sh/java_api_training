package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Client {
    public final HttpClient client;
    final int port;
    final String servUrl;

    public Client(int port, String url) {
        this.client = HttpClient.newHttpClient();
        this.port = port;
        this.servUrl = url;
    }

    public void startGame() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(this.servUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
            .build();
    }
}
