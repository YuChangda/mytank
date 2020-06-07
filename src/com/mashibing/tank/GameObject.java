package com.mashibing.tank;

import java.awt.*;

/**
 * Created by ycd on 2020/6/6 9:47 上午
 */
public abstract class GameObject {
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
