package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/**
 * Created by ycd on 2020/6/6 11:47 下午
 */
public abstract class GoDecorator extends GameObject {
    GameObject go;

    public GoDecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }
}
