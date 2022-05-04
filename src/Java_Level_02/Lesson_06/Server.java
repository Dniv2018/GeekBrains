package Java_Level_02.Lesson_06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    private Vector<ServerToClient> clients;
    static boolean close = false;
    Socket socket;

    public static void setMessage(String message) {
        Server.message = message;
    }

    static String message = "";

    public void main() throws IOException {
        ServerSocket server;
//        final Socket[] socket = new Socket[1];
        clients = new Vector<>();

//        InputStream inputStream = System.in;
//        Reader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Scanner scanner = new Scanner(System.in);


        server = new ServerSocket(8189);
        System.out.println("Сервер запущен, ожидаем подключения...");

        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        if (!close){
                            socket = server.accept();
                            System.out.println("Клиент подключился");
                            clients.add(new ServerToClient(socket));
                        }else{
                            break;
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("!!!!!!");
                while (true){
                    String inputString = scanner.nextLine();
//                        String inputString = bufferedReader.readLine();
                    System.out.println("????" + inputString);

                        if (inputString.equals("Close_server")){
                            close =true;
                            break;
                        }else{
                            message = inputString;
                            System.out.println("?: " + message);
//                            for (ServerToClient a: clients) {
//                                a.setMessage(inputString);
//                            }
                        }
                }
            }
        });


        clientThread.start();
        serverThread.start();


        try {
            serverThread.join();
            clientThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
