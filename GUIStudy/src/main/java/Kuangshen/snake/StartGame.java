package Kuangshen.snake;

import javax.swing.*;
import java.awt.*;

//游戏主启动类
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10,10,900,720);
//        正常游戏都应该在面板上
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}
