package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo02 extends JFrame{
    public TestComboboxDemo02(){
        setVisible(true);
        setTitle("TestComboboxDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        String[] contents = {"1","2","3","4","5","6","7","8","9"};

        JList jList = new JList(contents);

        container.add(jList);

    }

    public static void main(String[] args) {
        new TestComboboxDemo02();
    }
}
