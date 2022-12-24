package Kuangshen.lession01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Panel可以看成是一个空间,但不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Panel panel = new Panel();
//设置布局为空,否则会默认置顶
        frame.setLayout(null);
//设置frame窗口打开位置和背景
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.blue);
//面板的位置是在窗口内的相对坐标
        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.green);
//将面板添加到frame中
        frame.add(panel);

        frame.setVisible(true);

//监听时间,监听窗口关闭事件System.exit(0);
//        适配器模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
