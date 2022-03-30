package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

class StartTest {
    @Test
    public void testStartShouldReturn202() throws IOException, InterruptedException, IOException {
        Server server = new Server(9875);
        server.start();
        Client client = new Client(9875);
        HttpResponse resp =  client.postRequest(8764, "http://localhost:9875/api/game/start");
        Assertions.assertEquals(202, resp.statusCode());
    }

    @Test
    public void testStartShouldReturn400() throws IOException, InterruptedException {
        Server server = new Server(9888);
        server.start();
        Client client = new Client(9888);
        HttpResponse resp =  client.postRequest(8763, "http://localhost:9888/api/game/start");
        Assertions.assertEquals(400, resp.statusCode());
    }
}
