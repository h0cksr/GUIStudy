# Java--Gui编程学习

> 花了一个通宵在B站充电学了一下Java的GUI编程开发, 虽然太难的可能还是实现不了,但是基础的应该是可以满足了,这里挂一下跟着教程记的学习笔记吧
>
> 项目源码见https://github.com/h0cksr/GUIStudy

## AWT

### 容器和面板

#### 容器(窗口)Frame

```
package Kuangshen.lession01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
//        展示多个Frame
        MyFrame myFrame1 = new MyFrame(100,100,200,200,Color.BLACK);
        MyFrame myFrame2 = new MyFrame(300,100,200,200,Color.yellow);
        MyFrame myFrame3 = new MyFrame(100,300,200,200,Color.blue);
        MyFrame myFrame4 = new MyFrame(300,300,200,200,Color.green);
    }
}

class MyFrame extends Frame {
    static int id = 0;//可能存在多个窗口,设置一个计数器
    public MyFrame(int x, int y, int w, int h,Color color) {
        super("MyFrame"+(++id));
        setBounds(x,y,w,h);
        setVisible(true);
        setBackground(color);

    }

}
```

![image-20221225000325843](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225000325843.png)

#### 面板Panel

```java
package Kuangshen.lession01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Panel可以看成是一个空间,但不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Panel panel = new Panel();
//设置布局为空,否则会默认置顶
        frame.setLayout(null);
//设置frame窗口打开位置和背景
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.blue);
//面板的位置是在窗口内的相对坐标
        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.green);
//将面板添加到frame中
        frame.add(panel);

        frame.setVisible(true);

//监听时间,监听窗口关闭事件System.exit(0);
//        适配器模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

```

![image-20221225000249096](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225000249096.png)

### 布局

#### 流式布局FlowLayout

```java
package Kuangshen.lession01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("TestFlowLayout");
        frame.setSize(400,400);
//    组件--按钮
        Button  button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

//    设置流式布局
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
//        将按钮添加上去
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
    }

}
```



![image-20221225001130341](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225001130341.png)

#### 边界布局BorderLayout

```java
package Kuangshen.lession01;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(400,400);

        Button east = new Button("East");
        Button west = new Button("West");
        Button north = new Button("North");
        Button  south = new Button("South");
        Button center = new Button("Center");

        frame.add(center);
        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(north, BorderLayout.NORTH);

        frame.setVisible(true);

    }
}

```

![image-20221225001614900](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225001614900.png)



#### 表格布局GridLayout

```java
package Kuangshen.lession01;

import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(400,400);

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");

//设置frame布局
        frame.setLayout(new GridLayout(3,2));
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack();//Java函数,会选择一个最优的位置自动填充
        frame.setVisible(true);

    }
}
```

![image-20221225003416182](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225003416182.png)

#### 布局管理demo

```java
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
```

![image-20221225003314272](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225003314272.png)

### 组件

#### 标签label

```java
Label label = new Label("welcome");
frame.add(lable);
```



#### Button按钮

```java
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
```

![image-20221225005342333](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225005342333.png)

![image-20221225005355098](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225005355098.png)

#### 输入框 -- 事件监听ActionListener

```java
package Kuangshen.lession02;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

//        监听这个文本框输入的文字
        MyActionListener2   myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);
        setVisible(true);
        pack();
    }
}

class MyActionListener2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();//获得一些资源,返回一个对象
        System.out.println(textField.getText());//获得文本框输入的文本

    }
}
```

![image-20221225010048310](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225010048310.png)

![image-20221225010118742](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225010118742.png)

![image-20221225010124571](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225010124571.png)

##### 清空文本框替换编码(密码输入)

```java
package Kuangshen.lession02;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();

//        设置替换编码
        textField.setEchoChar('*');

        add(textField);
//        监听这个文本框输入的文字
        MyActionListener2   myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);

        setVisible(true);
        pack();
    }
}

class MyActionListener2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();//获得一些资源,返回一个对象
        System.out.println(textField.getText());//获得文本框输入的文本
        textField.setText("");//设置文本框内容为空

    }
}
```

![image-20221225010422822](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225010422822.png)

![image-20221225010415761](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225010415761.png)

### 简易计算器实现

> OOP原则: 组合 > 继承

组合模式的写法:

```java
package Kuangshen.lession02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类
class Calculator extends Frame {
    TextField num1,num2,num3;
    public Calculator(){
        setTitle("Calculator");
//        3个文本框
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);
        num3 = new TextField(20);
//        1个按钮
        Button button1 = new Button("=");
        button1.addActionListener(new MyCalculatorListener(this));

//        1个标签
        Label label1 = new Label("+");

//        布局
        setLayout(new FlowLayout());

        add(num1);
        add(label1);
        add(num2);
        add(button1);
        add(num3);

        pack();
        setVisible(true);

    }
}

//监听器类
class MyCalculatorListener implements ActionListener{
//    获取3个变量
    Calculator calculator = null;
    public MyCalculatorListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e){
//        获取加数和被加数
        int n1 = Integer.parseInt(calculator.num1.getText());
        int n2 = Integer.parseInt(calculator.num2.getText());

//        将相加结果放到第3个文本框
        calculator.num3.setText(""+(n1+n2));

//        清除前面两个输入的文本框
        calculator.num1.setText("");
        calculator.num2.setText("");

    }
}
```

![image-20221225011957345](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225011957345.png)

![image-20221225011931984](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225011931984.png)

使用内部类方法优化

```java
package Kuangshen.lession02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类
class Calculator extends Frame {
    TextField num1,num2,num3;
    public Calculator(){
        setTitle("Calculator");
//        3个文本框
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);
        num3 = new TextField(20);
//        1个按钮
        Button button1 = new Button("=");
        button1.addActionListener(new MyCalculatorListener());

//        1个标签
        Label label1 = new Label("+");

//        布局
        setLayout(new FlowLayout());

        add(num1);
        add(label1);
        add(num2);
        add(button1);
        add(num3);

        pack();
        setVisible(true);

    }

    //监听器类
    class MyCalculatorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
    //        获取加数和被加数
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

    //        将相加结果放到第3个文本框
            num3.setText(""+(n1+n2));

    //        清除前面两个输入的文本框
            num1.setText("");
            num2.setText("");

        }
    }
}
```

### 画笔Paint

```java
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

```

![image-20221225013834592](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225013834592.png)

### 鼠标监听 addMouseListener + MouseAdapter

目的: 实现鼠标画画

![image-20221225020003369](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225020003369.png)

```java
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

```



### 窗口监听 addWindowListener + WindowAdapter

一般常用的就是关闭窗口, 打开窗口, 窗口激活相关的4个函数,其他的基本用不上,这里就是简单设置了函数输出和关闭窗口功能

```java
package Kuangshen.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame(){
        setBackground(Color.blue);
        setBounds(100,100,200,200);
        setVisible(true);
//        addWindowListener(new MyWindowListener());
        this.addWindowListener(
//                匿名内部类
                new WindowAdapter() {
//                    常用的窗口监听时间就是下面四个,更多以其他的可以到WindowAdapter查看
                    
//                    点击关闭窗口南按钮触发
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("windowClosing");
                        setVisible(false);//隐藏窗口
                        System.exit(0);//结束程序
                    }

                    @Override
                    public void windowOpened(WindowEvent e) {
                        System.out.println("windowOpened");
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println("windowClosed");
                    }

//                    激活窗口监听,当鼠标在窗口外移动到窗口内的时候就触发此函数
                    @Override
                    public void windowActivated(WindowEvent e) {
                        System.out.println("windowActivated");
                    }
                }
        );
    }

//    class MyWindowListener extends WindowAdapter {
//        @Override
//        public void windowClosing(WindowEvent e) {
//            setVisible(false);//隐藏窗口
//            System.exit(0);//结束程序
//        }
//    }
}
```

![image-20221225021606747](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225021606747.png)

### 键盘监听 addKeyListener + KeyAdapter

```java
package Kuangshen.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

class KeyFrame extends Frame {
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
//              键盘按下触发事件
            @Override
            public void keyPressed(KeyEvent e) {
//                不需要记住键盘按下的是哪一个键,可以通过VK_XXX查看获取对照键值
                int keycode = e.getKeyCode();
                System.out.println("你按下的键值keycode=" + keycode);
                if(keycode == KeyEvent.VK_UP){
                    System.out.println("你按下了上键");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }
}

```

依次按下abcdefghijk

![image-20221225022509030](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225022509030.png)

## Swing

Swing和AWT其实差不多，只是一些组件和对象类名都需要加上一个J作为类名

但是需要注意的一点是在Swing中如果Label没有执行

### 标准窗口JFrame

```java
package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJFrame2().init();
    }
}


class MyJFrame2 extends JFrame {
    public void init(){
        this.setTitle("JFrameDemo02");
        this.setBounds(10,10,400,300);
        this.setVisible(true);

        //        获得一个容器
        Container container = getContentPane();
        container.setBackground(Color.yellow);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Label label = new Label("Weocome here");
//        让文本标签居中，设置水平对齐
//        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);



    }
}
```

![image-20221225024511242](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225024511242.png)

### 弹窗Dialog

```java
package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    public DialogDemo(){
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JFrame 放东西，容器
        Container container = this.getContentPane();
//       绝对布局
        container.setLayout(null);

//        按钮
        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30,30,200,50);

//        点击这个按钮,弹出一个弹窗
        button.addActionListener(new ActionListener() {//监听器
            @Override
            public void actionPerformed(ActionEvent e) {
//                弹窗
                new MyDialogDemo();
            }
        });

        this.add(button);

    }
    public static void main(String[] args) {
        new DialogDemo();

    }
}

//弹窗的窗口
class MyDialogDemo extends JDialog{
    public MyDialogDemo(){
        this.setVisible(true);
        this.setBounds(100,100,500,500);
//        不需要设置关闭,否则会报错
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Dialog");

        Container container = this.getContentPane();

//        this.setLayout(null);
        Label label = new Label("This is a new Dialog");
        container.add(label);
        label.setBounds(10,10,50,100);
//        pack();


    }
}
```

![image-20221225030303396](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225030303396.png)

### 标签JLabel -- 添加图标

```JAVA
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

```

![image-20221225031953041](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225031953041.png)

```java
package Kuangshen.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame{
    public ImageIconDemo(){
        JLabel label= new JLabel("This is ImageIcon");
//        获取图片的地址
        ImageIcon imageIcon= new ImageIcon("images/h0cksr.png");
//        教程中应该是按照下面这种方式获取标签资源的,但是一直都没有成功,后面直接使用上面的方法直接指定文件名太成功执行
//        这个可能和版本有关>>>>?
//        URL url = ImageIconDemo.class.getResource("ye.jpg");
//        ImageIcon imageIcon = new ImageIcon(url);

        label.setIcon(imageIcon);
//        label.setHorizontalTextPosition(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setBounds(10,10,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}

```

![image-20221225035010593](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225035010593.png)

### 面板JPanel

```java
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

```

![image-20221225040101955](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225040101955.png)

#### 特殊面板JScrollPane

```java
package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame{
    public JScrollDemo(){
        this.setTitle("JScrollDemo");
        this.setVisible(true);
        setBounds(100,100,300,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();

//        文本域
        JTextArea textArea = new JTextArea(20,50);
        textArea.setText("Welcome to the JScrollDemo");

//        Scroll面板
        JScrollPane jscrollPane = new JScrollPane(textArea);
        container.add(jscrollPane);


    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}

```

刚打开的窗口是看不到内容的,需要拖动变化窗口大小才会内容显现出来

刚打开时的状态:

![image-20221225040812181](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225040812181.png)

拖动大小变化后:

![image-20221225040801649](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225040801649.png)

### 按钮

#### 图片按钮

```java
package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JButtonDemo01 extends JFrame {
    public JButtonDemo01(){
        setVisible(true);
        setTitle("JButtonDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        Container container = getContentPane();
//        将一个图片变为图标
        Icon icon = new ImageIcon("images/h0cksr.png");

        JButton button = new JButton();
        button.setIcon(icon);
//        提示文本
        button.setToolTipText("图片按钮");

        container.add(button);
    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}

```

![image-20221225041449147](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225041449147.png)



#### 单选按钮JRadioButton

```java
package Kuangshen.lesson05;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JButtonDemo02 extends JFrame {
    public JButtonDemo02(){
        setVisible(true);
        setTitle("JButtonDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

//      单选框
        JRadioButton jRadioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton03 = new JRadioButton("JRadioButton03");
//        单选框只能选一个,分组,一个组只能选择一个
        ButtonGroup buttonGroup =  new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        buttonGroup.add(jRadioButton03);

        container.add(jRadioButton01,BorderLayout.NORTH);
        container.add(jRadioButton02,BorderLayout.CENTER);
        container.add(jRadioButton03,BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}

```

![image-20221225042052173](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225042052173.png)

#### 多选按钮JCheckBox

好像单选和多选感觉没什么区别, 如果使用`ButtonGroup`对多选框进行了分组的话也是只能选择一个组内选项

```java
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

```

![image-20221225042346139](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225042346139.png)

### 列表

- 下拉框  :  选择地区,或者一个单一选项
- 列表框  :  列表,展示信息,一般是动态扩容

#### 下拉框JComboBox

```java
package Kuangshen.lesson05;

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

```

![image-20221225042930195](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225042930195.png)

#### 列表框JList

列表框是可以动态扩容或删减的,就是说下面代码中的`contents`数组如果在程序执行过程中发生变化那么显示的内容也会跟随数组内容动态变化

```java
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

```



![image-20221225043256739](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225043256739.png)

### 文本框

#### 普通文本框JTextField

```java
package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        setVisible(true);
        setTitle("TestComboboxDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        JTextField textField01 = new JTextField("文本框01");
        JTextField textField02 = new JTextField("文本框02");

        container.add(textField01,BorderLayout.NORTH);
        container.add(textField02,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}

```

![image-20221225044036531](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225044036531.png)

#### 密码框JPasswordField

```java
package Kuangshen.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame {
    public TestTextDemo02(){
        setVisible(true);
        setTitle("TestComboboxDemo01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

        JPasswordField textField01 = new JPasswordField("密码文本框01");
        JPasswordField textField02 = new JPasswordField("密码文本框02");

        container.add(textField01,BorderLayout.NORTH);
        container.add(textField02,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}

```



![image-20221225044329286](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225044329286.png)

#### 文本域JTextArea

和一般文本框相比主要是可以和`Scroll面板`一起显示有进度条可以拉动

```java
package Kuangshen.lesson06;

//文本域

import javax.swing.*;
import java.awt.*;

public class TestTextDemo03 extends JFrame {
    public TestTextDemo03(){
        setVisible(true);
        setTitle("TestTextDemo03");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        Container container = getContentPane();

//        文本域
        JTextArea jTextArea = new JTextArea(20,50);
        jTextArea.setText("TestComboboxDemo");
//        Scroll面板
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}


```

![image-20221225044948592](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225044948592.png)







## 另一点笔记

这是在B站上看另一个教程[Java-GUI编程基础](https://www.bilibili.com/video/BV12K411U7xX)的一点笔记

![image-20221225064156470](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221225064156470.png)

### 边界布局

```java
    public  static void addButton(JFrame  window) throws Exception {
        window.setLayout(new BorderLayout());//可有可无,默认执行的就是这个,边界布局
        //window.setLayout(new FlowLayout());//流式布局

        JButton jButton1 = new JButton("按钮1");
        window.add(jButton1);

        JButton jButton2 = new JButton("按钮2");
        window.add(jButton2,BorderLayout.NORTH);

        JButton jButton3 = new JButton("按钮3");
        window.add(jButton3,BorderLayout.SOUTH);

        JButton jButton4 = new JButton("按钮4");
        window.add(jButton4,BorderLayout.WEST);

        JButton jButton5 = new JButton("按钮5");
        window.add(jButton5,BorderLayout.EAST);
    }
```

![image-20221224220053071](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224220053071.png)

### 流式布局

```java
    public  static void addButton(JFrame  window) throws Exception {
        window.setLayout(new FlowLayout());//流式布局

        JButton jButton1 = new JButton("按钮1");
        window.add(jButton1);

        JButton jButton2 = new JButton("按钮2");
        window.add(jButton2,BorderLayout.NORTH);

        JButton jButton3 = new JButton("按钮3");
        window.add(jButton3,BorderLayout.SOUTH);

        JButton jButton4 = new JButton("按钮4");
        window.add(jButton4,BorderLayout.WEST);

        JButton jButton5 = new JButton("按钮5");
        window.add(jButton5,BorderLayout.EAST);
    }
```

![image-20221224220134512](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224220134512.png)

![image-20221224220131186](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224220131186.png)

#### 布局对齐选择

默认居中对齐, 试一下左对齐:

```java
window.setLayout(new FlowLayout(FlowLayout.LEFT));//流式布局
```

![image-20221224220628422](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224220628422.png)

![image-20221224220556936](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224220556936.png)

### 网格布局

```java
window.setLayout(new GridLayout(3,2,50,50));//网格布局,参数合格式(行数,列数,网格横向间隔,网格纵向间隔),后面两个参数可选,默认无间隔
```

![image-20221224221106605](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224221106605.png)

### 网格袋布局

这个感觉不大玩得来,主要是权重上面的不大好理解是什么作用

```java
package Windows;

import javax.swing.*;
import java.awt.*;

public class MygridBagLayoutFrm extends JFrame{
    public  MygridBagLayoutFrm() throws Exception {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();//约束
        this.setLayout(layout);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        this.add(new JButton("按钮1"),c);
        this.add(new JButton("按钮2"),c);
        this.add(new JButton("按钮3"),c);
        c.gridwidth = GridBagConstraints.REMAINDER;//填充满剩下位置
        this.add(new JButton("按钮4"),c);

        this.setSize(480,320);
        this.setTitle("网格袋布局");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MygridBagLayoutFrm();
    }
}

```

![image-20221224222826011](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224222826011.png)

**另起一行**

```java
        c.weightx = 0.0;
        c.weighty = 0.0;
        this.add(new JButton("按钮5"),c);//当权重为0的时候会另外产生一行,且一个各自填满
```

![image-20221224222904402](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224222904402.png)

新建一个按钮横向占2格,纵向占1格

```java
        c.gridheight = 2;//纵向上占2个格
        c.gridwidth = 1; //横向上占1个格
        c.weightx = 1;//横向扩大的权重是1
        c.weighty = 1;//纵向扩大的权重是1
        this.add(new JButton("按钮8"),c);
```

![image-20221224231027664](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224231027664.png)

添加两个纵向占2格,横向大小填满右侧的格子

```java
        c.gridheight = 1;//纵向占1个格
        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(new JButton("按钮9"),c);
        this.add(new JButton("按钮10"),c);
```

![image-20221224231221885](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224231221885.png)

```java
package Windows;

import javax.swing.*;
import java.awt.*;

public class MygridBagLayoutFrm extends JFrame{
    public  MygridBagLayoutFrm() throws Exception {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();//约束
        this.setLayout(layout);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        this.add(new JButton("按钮1"),c);
        this.add(new JButton("按钮2"),c);
        this.add(new JButton("按钮3"),c);
        c.gridwidth = GridBagConstraints.REMAINDER;//填充满剩下位置
        this.add(new JButton("按钮4"),c);


        c.weightx = 0.0;
        c.weighty = 0.0;
        this.add(new JButton("按钮5"),c);//当权重为0的时候会另外产生一行,且一个各格子填满

        c.gridwidth = 1;
        this.add(new JButton("按钮6"),c);//当权重为1产生一个占1单元格的按钮
        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(new JButton("按钮7"),c);//向右填满

        c.gridheight = 2;//纵向上占2个格
        c.gridwidth = 1; //横向上占1个格
        c.weightx = 1;//横向扩大的权重是1
        c.weighty = 1;//纵向扩大的权重是1
        this.add(new JButton("按钮8"),c);
        c.gridheight = 1;//纵向占1个格
        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(new JButton("按钮9"),c);
        this.add(new JButton("按钮10"),c);


        this.setSize(480,320);
        this.setTitle("网格袋布局");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MygridBagLayoutFrm();
    }
}

```

![image-20221224231333030](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224231333030.png)

### 无布局

直接在生成实例化按钮的时候指定按钮大小和按钮位置(以窗口左上角为原点参考)

```java
package Windows;

import javax.swing.*;
import java.awt.*;

public class NullLayoutFrm extends JFrame{
    public  NullLayoutFrm() throws Exception {
        this.setLayout(null);
        Button b1 = new Button("按钮1");
//        直接指定按钮位置,参数为(距离左上角横向距离,距离左上角纵向距离,按钮横向大小,按钮纵向大小)
        b1.setBounds(10,10,120,30);
        this.add(b1);
        Button b2 = new Button("按钮1");
        b2.setBounds(10,50,120,30);
        this.add(b2);



        this.setSize(480,320);
        this.setTitle("网格袋布局");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new NullLayoutFrm();
    }
}

```



![image-20221224231854530](https://images-1306872001.cos.ap-nanjing.myqcloud.com/img/image-20221224231854530.png)







学习链接:

1. [【狂神说Java】GUI编程入门到游戏实战](https://www.bilibili.com/video/BV1DJ411B75F)(跟完这个就没必要看下面那个了)
2. [Java-GUI编程基础](https://www.bilibili.com/video/BV12K411U7xX)



2022_12_25 星期日06:30
