package Kuangshen.lession02;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        Frame   frame = new Frame("TestActionTwo");
        Button btn = new Button("Start");
        Button btn2 = new Button("stop");

        btn.setActionCommand("action-start");
        btn2.setActionCommand("action-stop");

        btn.addActionListener(new MyMonitor());
        btn2.addActionListener(new MyMonitor());

        frame.add(btn, BorderLayout.NORTH);
        frame.add(btn2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);




    }
}

class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
//        获得按钮的学习
        System.out.println("Button按钮被点击了: msg => "+event.getActionCommand());
        if (event.getActionCommand().equals("action-start")){
            System.out.println("Start...");
        }
        else if (event.getActionCommand().equals("action-stop")){
            System.out.println("Stop...");
            System.exit(0);
        }
    }
}