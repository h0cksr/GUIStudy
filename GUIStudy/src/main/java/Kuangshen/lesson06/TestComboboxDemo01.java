package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo01 extends JFrame{
    public TestComboboxDemo01(){
        setVisible(true);
        setTitle("TestComboboxDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("null");
        comboBox.addItem("正在上映");
        comboBox.addItem("已下架");
        comboBox.addItem("即将上映");
        container.add(comboBox);
        pack();
    }

    public static void main(String[] args) {
        new TestComboboxDemo01();
    }
}
