package Java_Level_02.Lesson_06;

import java.io.IOException;

public class ServerStart {
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
