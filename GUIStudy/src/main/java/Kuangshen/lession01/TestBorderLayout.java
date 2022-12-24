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
