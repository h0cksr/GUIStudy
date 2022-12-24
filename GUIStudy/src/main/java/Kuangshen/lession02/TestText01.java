package Kuangshen.lession02;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();

//        设置替换编码
        textField.setEchoChar('*');

        add(textField);
//        监听这个文本框输入的文字
        MyActionListener2   myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);

        setVisible(true);
        pack();
    }
}

class MyActionListener2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();//获得一些资源,返回一个对象
        System.out.println(textField.getText());//获得文本框输入的文本
        textField.setText("");//设置文本框内容为空

    }
}