package Windows;

import javax.swing.*;
import java.awt.*;

public class Exam01 extends JFrame {
    public  static void createWindow() throws Exception {
        JFrame  window = new JFrame("My Frist Window");//窗口默认名作为参数
        window.setTitle("My Frist Window 01");//手动设置窗口名

//        window.setLocation(100,100);//以屏幕左上角为原点指定窗口位置
        window.setLocationRelativeTo(null);//将窗口打开位置定义为屏幕正中心

        window.setSize(800, 600);//设置窗口大小
//        window.setResizable(false);//设置不可调节窗口大小
//        window.setMinimumSize(new Dimension(200,100));//设置窗口大小的最小值

        //        添加按钮
        addButton(window);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点击关闭按钮的时候是否退出结束程序
        window.setVisible(true);//open window
    }
    public  static void addButton(JFrame  window) throws Exception {
        //window.setLayout(new BorderLayout());//可有可无,默认执行的就是这个,边界布局
        //window.setLayout(new FlowLayout(FlowLayout.LEFT));//流式布局
        window.setLayout(new GridLayout(3,2,50,50));//网格布局,参数合格式(行数,列数,网格横向间隔,网格纵向间隔),后面两个参数可选,默认无间隔

        JButton jButton1 = new JButton("按钮1");
        window.add(jButton1);

        JButton jButton2 = new JButton("按钮2");
        window.add(jButton2,BorderLayout.NORTH);

        JButton jButton3 = new JButton("按钮3");
        window.add(jButton3,BorderLayout.SOUTH);

        JButton jButton4 = new JButton("按钮4");
        window.add(jButton4,BorderLayout.WEST);

        JButton jButton5 = new JButton("按钮5");
        window.add(jButton5,BorderLayout.EAST);

        JButton jButton6 = new JButton("按钮6");
        window.add(jButton6,BorderLayout.EAST);
    }



    public  static void main(String[] args) throws Exception {
        Exam01.createWindow();
//        JDK8 之后添加的流式操作动态调用
//        SwingUtilities.invokeLater(Exam01::createWindow);
    }

}
