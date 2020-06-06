package com.mashibing.tank;


import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by ycd on 2020/6/6 9:18 上午
 */
public class GameModel {
    Tank mytank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
//    List<Bullet> bulletList = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Expolde> expoldes = new ArrayList<>();
    ColliderChain chain = new ColliderChain();
    private List<GameObject> objects = new ArrayList<>();
    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();
    public GameModel(){
        int tankCount = Integer.valueOf((String) PropertyMgr.get("initTankCount"));
        //初始化地方坦克
        for (int i = 0; i < tankCount; i++) {
            objects.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }
    }
    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量:"+bulletList.size(),10,60);
//        g.drawString("敌人的数量:"+tanks.size(),10,80);
//        g.drawString("爆炸的数量:"+expoldes.size(),10,100);
        mytank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size() ; j++) {
                GameObject o1  = objects.get(i);
                GameObject o2  = objects.get(j);
                chain.collide(o1,o2);
            }
        }
//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bulletList.get(i).collideWith(tanks.get(j));
//            }
//        }


//        for(Iterator<Bullet> it=bulletList.iterator();it.hasNext(); ){
//            Bullet next = it.next();
//            if(!next.live) it.remove();
//        }
    }

    public Tank getMainTank() {
        return mytank;
    }
}
