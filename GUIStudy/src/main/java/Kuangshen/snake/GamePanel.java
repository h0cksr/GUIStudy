package Kuangshen.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
//    定义蛇的数据结构
    int length;//蛇的长度
    int[] snakeX = new int[600];//蛇的X坐标
    int[] snakeY = new int[500];//蛇的Y坐标
    String fx;//小蛇前进方向
    boolean isStart = false;//当前游戏状态
    boolean isFail = false;//游戏是否已失败
//    食物坐标
    int foodX;
    int foodY;
    Random random = new Random();

    int score = 0;//游戏成绩
//    定时器
    Timer timer = new Timer(100,this);//100毫秒执行一次

//    构造器
    public GamePanel(){
        init();
//        获得焦点和键盘事件
        setFocusable(true);//获得焦点事件
        addKeyListener(this);//获得见破案监听时间
        timer.start();//游戏一开始定时器就启动

    }

    public void init(){
        length = 3;
        score=0;
        snakeX[0] = 100;snakeY[0] = 100;//蛇的脑袋坐标
        snakeX[1] = 75;snakeY[1] = 100;//第一个身体坐标
        snakeX[2] = 50;snakeY[2] =100;//第二个身体坐标
        fx = "R";
//把食物随机分布在界面上
        foodX = 25+ 25*random.nextInt(34);
        foodY = 25+ 25*random.nextInt(24);

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
//        绘制静态面板
        setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部广告
        g.fillRect(25,75,850,600);//默认游戏界面

//        画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度:"+length,750,35);
         g.drawString("分数:"+score,750,50);


//        画食物
        Data.food.paintIcon(this,g,foodX,foodY);

//        把小蛇画上去
//        画蛇头
        if(fx.equals("R"))Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);//蛇头初始化向右
        else if(fx.equals("L"))Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        else if(fx.equals("U"))Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        else if(fx.equals("D"))Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
//        画蛇身体
        for(int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);//绘制身体坐标
        }

//        游戏状态
        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格重新开始",300,300);
        }

        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
    }


    //键盘监听器事件
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


//        小蛇移动方向更新或者更新游戏状态
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFail){
//                游戏重新开始
                isFail=false;
                init();

            }
            else{
                isStart = !isStart;repaint();
            }
        }
        else if(keyCode==KeyEvent.VK_UP){fx="U";}
        else if(keyCode==KeyEvent.VK_DOWN){fx="D";}
        else if(keyCode==KeyEvent.VK_LEFT){fx="L";}
        else if(keyCode==KeyEvent.VK_RIGHT){fx="R";}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

//事件监听 -- 需要通过固定事件来刷新
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart&&isFail==false){//如果游戏是开始状态,就让小蛇动起来

            for(int i=length-1; i>0;i--){//后一节移动到前一节的位置
                snakeX[i]= snakeX[i-1];
                snakeY[i]= snakeY[i-1];
            }
            if(fx.equals("R")){//            蛇头右移
                snakeX[0] = snakeX[0]+25;
                if(snakeX[0]>850)snakeX[0] = 25;//            边界判断
            }
            else if(fx.equals("L")){//            蛇头左移
                snakeX[0] = snakeX[0]-25;
                if(snakeX[0]<25)snakeX[0] = 850;//            边界判断
            }
            else if(fx.equals("U")){//            蛇头上移
                snakeY[0] = snakeY[0]-25;
                if(snakeY[0]<75)snakeY[0] = 650;//            边界判断
            }
            else if(fx.equals("D")){//            蛇头下移
                snakeY[0] = snakeY[0]+25;
                if(snakeY[0]>650)snakeY[0] = 75;//            边界判断
            }


//            吃食物
            if(snakeX[0]==foodX&&snakeY[0]==foodY){
                length++;//长度+1
                score+=10;//分数+10
//                再次随机生成食物//把食物随机分布在界面上
                foodX = 25+ 25*random.nextInt(34);
                foodY = 25+ 25*random.nextInt(24);
            }

//            失败判定,撞到自己(头和身体重合)就判定为失败
            for(int i=1; i<length;i++){
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i])isFail=true;
            }

            repaint();

        }

    }
}


