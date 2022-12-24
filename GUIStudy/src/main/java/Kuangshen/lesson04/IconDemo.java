package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;

//图标,需要实现类,Frame继承
public class IconDemo extends JFrame implements Icon {
    public static void main(String[] args) {
        new IconDemo().init();
    }
    private int width,height;

    public IconDemo() {}

    public IconDemo(int width,int height){
        this.width = width;
        this.height = height;
    }

    public void init(){
        setBounds(10,10,400,400);
        IconDemo iconDemo = new IconDemo(15,15);
//        图标放在标签,也可以放在按钮上
        JLabel label = new JLabel("IconTest",iconDemo,SwingConstants.CENTER);

        Container container = this.getContentPane();
        container.add(label);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
