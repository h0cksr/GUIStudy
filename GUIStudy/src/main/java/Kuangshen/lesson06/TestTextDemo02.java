package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame {
    public TestTextDemo02(){
        setVisible(true);
        setTitle("TestTextDemo02");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        JPasswordField textField01 = new JPasswordField("密码文本框01");
        JPasswordField textField02 = new JPasswordField("密码文本框02");

        container.add(textField01,BorderLayout.NORTH);
        container.add(textField02,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}
