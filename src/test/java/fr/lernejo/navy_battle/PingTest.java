package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

class PingTest {
    @Test
    public void testPingRequestOnServerShouldReturn200() throws IOException, InterruptedException {
        Server server = new Server(9876);
        server.ping();
        Client client = new Client(8795);
        HttpResponse resp =  client.postRequest(8765, "http://localhost:9876/ping");
        Assertions.assertEquals(200, resp.statusCode());
    }
}
