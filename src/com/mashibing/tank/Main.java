package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();
        int tankCount = Integer.valueOf((String) PropertyMgr.get("initTankCount"));
        //初始化地方坦克
        for (int i = 0; i < tankCount; i++) {
            frame.tanks.add(frame.gf.createTank(50+i*80,200,Dir.DOWN,Group.BAD,frame));
        }
        while (true){
            Thread.sleep(50);
            frame.repaint();
        }
    }

}
