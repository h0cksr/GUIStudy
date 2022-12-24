package Windows;

import javax.swing.*;

public class Exam02 extends JDialog {

    public Exam02(){
        this.setSize(480,320);//set size of window
        this.setTitle("My Frist Window 02");//set the title
        this.setResizable(false);//Do not change the window size
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  //close application when window is closed
        this.setLocationRelativeTo(null);// window Locate to Ceter
        this.setIconImage(new ImageIcon("images/1.jpg").getImage());// set the images to be Icon
        this.setVisible(false);// window open to view
    }

    public static void main(String[] args) {
        new Exam02();
    }
}
