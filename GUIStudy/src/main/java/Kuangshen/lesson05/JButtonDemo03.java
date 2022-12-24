package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JButtonDemo03 extends JFrame {
    public JButtonDemo03(){
        setVisible(true);
        setTitle("JButtonDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

//      单选框
        JCheckBox JCheckBox01 = new JCheckBox("JCheckBox01");
        JCheckBox JCheckBox02 = new JCheckBox("JCheckBox02");
        JCheckBox JCheckBox03 = new JCheckBox("JCheckBox03");
//        单选框只能选一个,分组,一个组只能选择一个
//        ButtonGroup buttonGroup =  new ButtonGroup();
//        buttonGroup.add(JCheckBox01);
//        buttonGroup.add(JCheckBox02);
//        buttonGroup.add(JCheckBox03);

        container.add(JCheckBox01,BorderLayout.NORTH);
        container.add(JCheckBox02,BorderLayout.CENTER);
        container.add(JCheckBox03,BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
