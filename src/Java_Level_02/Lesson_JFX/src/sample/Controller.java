package Java_Level_02.Lesson_JFX.src.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String IP_ADRESS = "localhost";
    int PORT = 8189;


    @FXML
    TextArea dialogTextArea;

    @FXML
    TextField inText;

    @FXML
    Button btnSend;

    public void Send(){
        if (!inText.getText().equals("")){
            ZonedDateTime dateTime = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            dialogTextArea.appendText(dateTime.format(formatter) + "\n");
            dialogTextArea.appendText(inText.getText() + "\n\n");
            try {
                out.writeUTF(inText.getText());
                inText.clear();
                inText.requestFocus();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        //inText.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                        try {
                            while(true) {
                                String str = in.readUTF();
                                if (str.equals("Эхо: /end")) {
                                    dialogTextArea.appendText(str);
                                    break;
                                }
                                dialogTextArea.appendText(str + "\n\n");
                            }
                        } catch (IOException e) {
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
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
