package Kuangshen.lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        MyPaint myPaint = new MyPaint();
        myPaint.loadFrame();

    }
}

class MyPaint extends Frame {

    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.setColor(Color.red);
        g.drawOval(100, 100,100,100);
        g.drawOval(300, 100,100,100);

        g.setColor(Color.green);
        g.fillRect(150,200,200,200);
//        养成习惯,用完画笔还原回到最初的颜色


    }
}
