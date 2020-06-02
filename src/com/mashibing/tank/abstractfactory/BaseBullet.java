package com.mashibing.tank.abstractfactory;

import java.awt.*;

/**
 * Created by ycd on 2020/5/31 10:59 下午
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank baseTank);
}
