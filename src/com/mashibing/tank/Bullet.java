package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    public static final int WIDTH=ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT=ResourceMgr.bulletD.getHeight();
    private int x,y;
    private Dir dir;
    public boolean living = true;
    private GameModel gm = null;
    private Group group = Group.BAD;
    Rectangle rec = new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group,GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        rec.x = this.x;
        rec.y = this.y;
        rec.width = WIDTH;
        rec.height = HEIGHT;

        gm.bulletList.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!living){
            gm.bulletList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
        }
        move();
    }
    private void move() {
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
        //update rec
        rec.x = x;
        rec.y = y;
        if(x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT){
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        if(this.group ==tank.getGroup()) return;

        //todo new 的对象有点多
        if(rec.intersects(tank.rec)){
            tank.die();
            this.die();
            int ex = tank.getX() + Tank.WIDTH/2 - Expolde.WIDTH/2;
            int ey = tank.getY() + Tank.HEIGHT/2 - Expolde.HEIGHT/2;
            gm.expoldes.add(new Expolde(ex,ey, gm));
        }
    }

    private void die() {
        this.living = false;
    }
}
