package Kuangshen.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListen {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends Frame {
    ArrayList points;

    //    画画需要画笔,需要监听鼠标当前位置,需要集合来存储这个点
    public  MyFrame(){
        super("title");
        setBounds(200,200,400,300);

//        存鼠标点击的点
        points = new ArrayList<>();

//        鼠标监听器,正对这个窗口
        this.addMouseListener(new MyMouseListener());

        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        画画,监听鼠标事件
        Iterator i = points.iterator();
        while(i.hasNext()) {
            Point point = (Point) i.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x,point.y,10,10);
        }
    }

//    添加一个点到界面上
    public void addPoint(Point point){
        points.add(point);

    }

//    适配器模式
    private class MyMouseListener extends MouseAdapter {
//        鼠标,按下,弹起,按住不放

    @Override
    public void mousePressed(MouseEvent e) {
//        super.mousePressed(e);
        MyFrame frame = (MyFrame)e.getSource();
//        在我们点击鼠标的时候就会在界面上产生一个点,这个点就是鼠标的点
        frame.addPoint(new Point(e.getX(), e.getY()));
        frame.repaint();//刷新,每次点击就重画一次,

    }
}
}
