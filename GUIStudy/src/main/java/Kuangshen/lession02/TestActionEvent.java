package Kuangshen.lession02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {
    public static void main(String[] args) {
        Frame   frame = new Frame("TestActionEvent");

        frame.setSize(400,400);

        Button button = new Button("btn");

        button.addActionListener(new MyActionListener());

        frame.setLayout(new BorderLayout());

        frame.add(button,BorderLayout.CENTER);

        frame.setVisible(true);

    }
}

class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("actionPerformed");
    }

}