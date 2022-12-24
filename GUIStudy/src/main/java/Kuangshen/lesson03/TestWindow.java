package Kuangshen.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame(){
        setBackground(Color.blue);
        setBounds(100,100,200,200);
        setVisible(true);
//        addWindowListener(new MyWindowListener());
        this.addWindowListener(
//                匿名内部类
                new WindowAdapter() {
//                    常用的窗口监听时间就是下面四个,更多以其他的可以到WindowAdapter查看

//                    点击关闭窗口南按钮触发
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("windowClosing");
                        setVisible(false);//隐藏窗口
                        System.exit(0);//结束程序
                    }

                    @Override
                    public void windowOpened(WindowEvent e) {
                        System.out.println("windowOpened");
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println("windowClosed");
                    }

//                    激活窗口监听,当鼠标在窗口外移动到窗口内的时候就触发此函数
                    @Override
                    public void windowActivated(WindowEvent e) {
                        System.out.println("windowActivated");
                    }
                }
        );
    }

//    class MyWindowListener extends WindowAdapter {
//        @Override
//        public void windowClosing(WindowEvent e) {
//            setVisible(false);//隐藏窗口
//            System.exit(0);//结束程序
//        }
//    }
}