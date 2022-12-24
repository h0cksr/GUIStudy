package Kuangshen.lession01;

import javax.swing.border.Border;
import java.awt.*;

public class ExDemo {
    public static void main(String[] args) {
//        总frame
        Frame frame = new Frame();
        frame.setSize(400,400);
        frame.setBackground(Color.black);
        frame.setLocation(300,400);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

//        上面
        p1.add(new Button("East-1"),BorderLayout.EAST);
        p1.add(new Button("West-1"),BorderLayout.WEST);
        p2.add(new Button("p2-btn-1"));
        p2.add(new Button("p2-btn-2"));
        p1.add(p2,BorderLayout.CENTER);

//        下面
        p3.add(new Button("East-2"), BorderLayout.EAST);
        p3.add(new Button("West-2"), BorderLayout.WEST);
//        中间四个
        for(int i=0;i<4;i++){
            p4.add(new Button("for-"+i));
        }
        p3.add(p4,BorderLayout.CENTER);
        frame.add(p1);
        frame.add(p3);
    }
}
