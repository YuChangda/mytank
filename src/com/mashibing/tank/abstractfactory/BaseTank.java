package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;

import java.awt.*;

/**
 * Created by ycd on 2020/5/31 10:58 下午
 */
public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rec = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup() {
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
