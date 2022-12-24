package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame{
    public JPanelDemo() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,2,10,10));//后面两个参数是间隔

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        JPanel panel4 = new JPanel(new GridLayout(3,2));
        panel1.add(new JButton("panel1-1"));
        panel1.add(new JButton("panel1-2"));
        panel1.add(new JButton("panel1-3"));
        panel2.add(new JButton("panel2-1"));
        panel2.add(new JButton("panel2-2"));
        panel3.add(new JButton("panel3-1"));
        panel3.add(new JButton("panel3-2"));
        panel4.add(new JButton("panel4-1"));
        panel4.add(new JButton("panel4-2"));
        panel4.add(new JButton("panel4-3"));
        panel4.add(new JButton("panel4-4"));
        panel4.add(new JButton("panel4-5"));
        panel4.add(new JButton("panel4-6"));


        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
