package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/**
 * Created by ycd on 2020/6/6 11:51 下午
 */
public class RecDecorator extends GoDecorator{
    public RecDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        super.paint(g);

        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(go.x,go.y,go.getWidth(),go.getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
