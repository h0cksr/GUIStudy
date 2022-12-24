package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public static void init(){
//        顶级窗口
        JFrame jf = new JFrame("这是一个JFrame窗口");
        jf.setVisible(true);
        jf.setBackground(Color.yellow);
        jf.setBounds(100,100,200,200);

//        设置文字
        JLabel label = new JLabel("Welcome to here");
        jf.add(label);

//        关闭事件
//        EXIT_ON_CLOSE是退出
//        HIDE_ON_CLOSE是只隐藏而不退出（后台运行）
//        DO_NOTHING_ON_CLOSE是什么都不做
//        DISPOSE_ON_CLOSE是当全部窗口都关闭的时候触发
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public static void main(String[] args) {
        init();
    }
}
