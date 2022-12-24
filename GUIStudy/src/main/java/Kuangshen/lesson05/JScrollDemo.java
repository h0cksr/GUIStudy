package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame{
    public JScrollDemo(){
        this.setTitle("JScrollDemo");
        this.setVisible(true);
        setBounds(100,100,300,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();

//        文本域
        JTextArea textArea = new JTextArea(20,50);
        textArea.setText("Welcome to the JScrollDemo");

//        Scroll面板
        JScrollPane jscrollPane = new JScrollPane(textArea);
        container.add(jscrollPane);


    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
