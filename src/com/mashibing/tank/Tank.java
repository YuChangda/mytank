package com.mashibing.tank;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.awt.*;
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFrame tf = null;
    public static final int WIDTH=ResourceMgr.tankU.getWidth();
    public static final int HEIGHT=ResourceMgr.tankU.getHeight();
    private boolean living = true;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if(!living) {
            tf.tanks.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        if(!moving) return;
        switch (dir){
            case LEFT:
                x-= SPEED;
                break;
            case UP:
                y-= SPEED;
                break;
            case RIGHT:
                x+= SPEED;
                break;
            case DOWN:
                y+= SPEED;
                break;
        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tf.bulletList.add(new Bullet(bX,bY,dir,tf));
    }

    public void die() {
        this.living = false;
    }
}
