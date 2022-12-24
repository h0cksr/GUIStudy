package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JButtonDemo01 extends JFrame {
    public JButtonDemo01(){
        setVisible(true);
        setTitle("JButtonDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        Container container = getContentPane();
//        将一个图片变为图标
        Icon icon = new ImageIcon("images/h0cksr.png");

        JButton button = new JButton();
        button.setIcon(icon);
//        提示文本
        button.setToolTipText("图片按钮");

        container.add(button);
    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
