package Java_Level_02.Lesson_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerToClient {
    Socket socket;
//    String message;

    DataInputStream in;
    DataOutputStream out;

    public ServerToClient(Socket socket) {
//        message = "";
        this.socket = socket;

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread messageClient = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (!Server.close){
                                    String str = in.readUTF();

                                    if (str.equals("/end")) {
                                        out.writeUTF("Эхо: " + str);
                                        break;
                                    }
                                    System.out.println("Client: " + str);
                                    out.writeUTF("Эхо: " + str);
                            }else{
                                out.writeUTF("Сервер закрыт");
                                break;
                            }

                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }finally {
                        try {
                            in.close();
                            out.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread serverMessage = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
//                        System.out.println("Server.message: " + Server.getMessage());
                        if (!Server.getMessage().equals("")){
                            System.out.println("Server.message: " + Server.getMessage());
                            try {
                                out.writeUTF("Server.message: " + Server.getMessage() + "\n\n");
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                            Server.setMessage("");
                        }
                    }
                }
            });

            messageClient.start();
            serverMessage.setDaemon(true);
            serverMessage.start();

            try {
                serverMessage.join();
                messageClient.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void setMessage(String message) {
//        this.message = message;
//    }
}
