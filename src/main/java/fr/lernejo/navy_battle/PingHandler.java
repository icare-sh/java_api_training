package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String st = "OK";
        exchange.sendResponseHeaders(200, st.length());
        try (OutputStream op = exchange.getResponseBody()) {
            op.write(st.getBytes());
        }
    }
}
