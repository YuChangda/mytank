package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;

/**
 * Created by ycd on 2020/5/31 4:06 下午
 */
public class DefaultFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        t.tf.gf.createBullet(bX,bY,t.dir,t.group,t.tf);
    }
}
