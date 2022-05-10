package Java_Level_01.Lesson_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JFrame {
    public Window() {
        setTitle("Чат");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 700);
        setResizable(false);


        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new FlowLayout());
        setContentPane(panel);

        JTextArea textArea = new JTextArea(33, 23);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        panel.add(textArea);
        panel.add(new JScrollPane(textArea));

        JTextArea textMessage = new JTextArea(5, 23);
        textMessage.setBackground(Color.GRAY);
        textMessage.setSize(280, 185);
        textMessage.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textMessage.setLineWrap(true);
        textMessage.setWrapStyleWord(true);
        panel.add(textMessage);
        panel.add(new JScrollPane(textMessage));

        textMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.isControlDown() & e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = textMessage.getText();
                    textMessage.setText("");
                    textArea.append(text + "\n");
                    textArea.append("\n" + answer() + "\n\n");
                }
            }
        });

        JButton button = new JButton("Save");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile(textArea);
            }
        });

        setVisible(true);
    }

    private String answer(){
        return "Потрясающе!";
    }

    private void writeToFile(JTextArea textArea){
        try(FileWriter fwr = new FileWriter("chat.txt", true)){
            fwr.write(textArea.getText());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
