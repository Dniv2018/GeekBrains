package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {

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
            inText.clear();
            inText.requestFocus();
        }
        inText.requestFocus();
    }
}
