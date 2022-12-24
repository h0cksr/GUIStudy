package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JButtonDemo02 extends JFrame {
    public JButtonDemo02(){
        setVisible(true);
        setTitle("JButtonDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

//      单选框
        JRadioButton jRadioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton03 = new JRadioButton("JRadioButton03");
//        单选框只能选一个,分组,一个组只能选择一个
        ButtonGroup buttonGroup =  new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        buttonGroup.add(jRadioButton03);

        container.add(jRadioButton01,BorderLayout.NORTH);
        container.add(jRadioButton02,BorderLayout.CENTER);
        container.add(jRadioButton03,BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
