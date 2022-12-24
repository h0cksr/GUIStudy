package Kuangshen.lession02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类
class Calculator extends Frame {
    TextField num1,num2,num3;
    public Calculator(){
        setTitle("Calculator");
//        3个文本框
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);
        num3 = new TextField(20);
//        1个按钮
        Button button1 = new Button("=");
        button1.addActionListener(new MyCalculatorListener());

//        1个标签
        Label label1 = new Label("+");

//        布局
        setLayout(new FlowLayout());

        add(num1);
        add(label1);
        add(num2);
        add(button1);
        add(num3);

        pack();
        setVisible(true);

    }

    //监听器类
    class MyCalculatorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
    //        获取加数和被加数
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

    //        将相加结果放到第3个文本框
            num3.setText(""+(n1+n2));

    //        清除前面两个输入的文本框
            num1.setText("");
            num2.setText("");

        }
    }
}

