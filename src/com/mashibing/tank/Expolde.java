package com.mashibing.tank;

import java.awt.*;

public class Expolde extends GameObject{
    public static final int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT=ResourceMgr.explodes[0].getHeight();
    private int x,y;
    public boolean living = true;
    private GameModel gm = null;
    private int step = 0;

    public Expolde(int x, int y,  GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length){
            gm.remove(this);
        }
    }



}
