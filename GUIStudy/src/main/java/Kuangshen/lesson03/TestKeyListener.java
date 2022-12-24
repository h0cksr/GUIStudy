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
