package fr.lernejo.navy_battle;
import java.io.IOException;


public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {return;}
        Server server = new Server(Integer.parseInt(args[0]));
        server.ping();
        server.start();
        if (args.length == 2) {
           Client client = new Client(Integer.parseInt(args[0]), args[1]);
           client.startGame();
        }
    }
}
