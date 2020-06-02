package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by ycd on 2020/5/31 4:17 下午
 */
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Stream.of(Dir.values()).forEach(e-> t.tf.gf.createBullet(bX,bY,e,t.group,t.tf));
    }
}
