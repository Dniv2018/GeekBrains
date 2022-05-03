package Java_Level_02.Lesson_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ServerToClient> clients;
    public void main() {
        Socket socket;
        ServerSocket server;
        clients = new Vector<>();

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            clients.add(new ServerToClient(socket));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
