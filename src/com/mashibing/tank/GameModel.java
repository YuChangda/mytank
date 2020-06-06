package com.mashibing.tank;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycd on 2020/6/6 9:18 上午
 */
public class GameModel {
    Tank mytank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    List<Bullet> bulletList = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Expolde> expoldes = new ArrayList<>();
    public GameModel(){
        int tankCount = Integer.valueOf((String) PropertyMgr.get("initTankCount"));
        //初始化地方坦克
        for (int i = 0; i < tankCount; i++) {
            tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量:"+bulletList.size(),10,60);
        g.drawString("敌人的数量:"+tanks.size(),10,80);
        g.drawString("爆炸的数量:"+expoldes.size(),10,100);
        mytank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        for (int i = 0; i < expoldes.size(); i++) {
            expoldes.get(i).paint(g);
        }
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).collideWith(tanks.get(j));
            }
        }


//        for(Iterator<Bullet> it=bulletList.iterator();it.hasNext(); ){
//            Bullet next = it.next();
//            if(!next.live) it.remove();
//        }
    }

    public Tank getMainTank() {
        return mytank;
    }
}
