package Java_Level_02.Lesson_06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {


    public static void main(String[] args) throws IOException {


        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ServerSocket server = new ServerSocket(8189);
        System.out.println("Сервер запущен, ожидаем подключения...");

        Socket socket = server.accept();
        System.out.println("Клиент подключился");
        Network network = new Network(socket);
        network.main();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String strServerMessage = "";
                while (true){
                    try {
//                        System.out.println("Принимаем сообщение с консоли\n");
                        strServerMessage = bufferedReader.readLine();
//                        System.out.println("Сообщение с консоли: " + strServerMessage + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (strServerMessage.equals("/end")){
                        try {
                            network.outNetwork("Сервер и связь с ним прекращены");
                            network.closeNetwork();
                        } catch (IOException e) {
                            System.out.println("Связь с клиентом потеряна");
                        }
                        break;
                    }else{
                        try {
                            network.outNetwork("Server: " + strServerMessage);
                        } catch (IOException e) {
                            System.out.println("Связь с клиентом потеряна");
                        }
                    }
                }
            }
        }).start();
    }
}
