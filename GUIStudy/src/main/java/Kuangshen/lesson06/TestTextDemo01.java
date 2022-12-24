package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        setVisible(true);
        setTitle("TestTextDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        JTextField textField01 = new JTextField("文本框01");
        JTextField textField02 = new JTextField("文本框02");

        container.add(textField01,BorderLayout.NORTH);
        container.add(textField02,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
