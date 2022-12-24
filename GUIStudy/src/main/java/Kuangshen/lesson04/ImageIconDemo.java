package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame{
    public ImageIconDemo(){
        JLabel label= new JLabel("This is ImageIcon");
//        获取图片的地址
        ImageIcon imageIcon= new ImageIcon("images/h0cksr.png");
//        教程中应该是按照下面这种方式获取标签资源的,但是一直都没有成功,后面直接使用上面的方法直接指定文件名太成功执行
//        这个可能和版本有关>>>>?
//        URL url = ImageIconDemo.class.getResource("ye.jpg");
//        ImageIcon imageIcon = new ImageIcon(url);

        label.setIcon(imageIcon);
//        label.setHorizontalTextPosition(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setBounds(10,10,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
