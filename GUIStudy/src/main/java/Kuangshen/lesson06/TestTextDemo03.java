package Kuangshen.lesson06;

//文本域

import javax.swing.*;
import java.awt.*;

public class TestTextDemo03 extends JFrame {
    public TestTextDemo03(){
        setVisible(true);
        setTitle("TestTextDemo03");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

//        文本域
        JTextArea jTextArea = new JTextArea(20,50);
        jTextArea.setText("TestComboboxDemo");
//        Scroll面板
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}

