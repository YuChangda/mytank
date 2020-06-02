package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
    public GameFactory gf = new RectFactory();
    Tank mytank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    public List<BaseBullet> bulletList = new ArrayList<>();
    public List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplode> expoldes = new ArrayList<>();
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new myKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
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

    class myKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD){
                mytank.setMoving(false);
            }else {
                mytank.setMoving(true);
                if(bL) mytank.setDir(Dir.LEFT);
                if(bU) mytank.setDir(Dir.UP);
                if(bR) mytank.setDir(Dir.RIGHT);
                if(bD) mytank.setDir(Dir.DOWN);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    mytank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
