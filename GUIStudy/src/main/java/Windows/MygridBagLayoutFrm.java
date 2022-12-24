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
