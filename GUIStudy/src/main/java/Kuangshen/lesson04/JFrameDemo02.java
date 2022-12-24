package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJFrame2().init();
    }
}


class MyJFrame2 extends JFrame {
    public void init(){
        this.setTitle("JFrameDemo02");
        this.setBounds(10,10,400,300);
        this.setVisible(true);

        //        获得一个容器
        Container container = getContentPane();
        container.setBackground(Color.yellow);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Label label = new Label("Weocome here");
//        让文本标签居中，设置水平对齐
//        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);



    }
}