package Windows;

import javax.swing.*;
import java.awt.*;

public class NullLayoutFrm extends JFrame{
    public  NullLayoutFrm() throws Exception {
        this.setLayout(null);
        Button b1 = new Button("按钮1");
//        直接指定按钮位置,参数为(距离左上角横向距离,距离左上角纵向距离,按钮横向大小,按钮纵向大小)
        b1.setBounds(10,10,120,30);
        this.add(b1);
        Button b2 = new Button("按钮1");
        b2.setBounds(10,50,120,30);
        this.add(b2);



        this.setSize(480,320);
        this.setTitle("网格袋布局");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new NullLayoutFrm();
    }
}
