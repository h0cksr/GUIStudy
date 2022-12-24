package Kuangshen.lession01;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        Frame frame = new Frame("testFrame");
        //设置窗口大小
        frame.setSize(400,400);
//        设置背景颜色
        frame.setBackground(new Color(154, 86, 86));
//        设置可见性
        frame.setVisible(true);
//        设置弹出初始位置
        frame.setLocation(200,200);
//        设置窗口大小固定
        frame.setResizable(false);
//

    }
}
