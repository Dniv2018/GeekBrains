package Java_Level_02.Lesson_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    Socket socket;

    DataInputStream in;
    DataOutputStream out;

    public Network(Socket socket) {
        this.socket = socket;
    }

    void main(){
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Попытка подключения потоков ввода/вывода не удалась");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        String str = inNetwork();
                        if (str.equals("/end")) {
                            outNetwork("Эхо: " + str);
                            break;
                        }
                        System.out.println("Client: " + str);
                        outNetwork("Эхо: " + str);
                    }
                } catch (IOException e) {
                    System.out.println("Связь Network с сервером потеряна");
                }
            }
        }).start();
    }

    void closeNetwork(){
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    String inNetwork() throws IOException {
        return in.readUTF();
    }

    void outNetwork(String str) throws IOException {
        out.writeUTF(str);
    }
}
