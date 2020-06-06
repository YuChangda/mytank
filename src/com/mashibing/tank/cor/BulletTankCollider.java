package com.mashibing.tank.cor;

import com.mashibing.tank.*;

/**
 * Created by ycd on 2020/6/6 10:20 上午
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if( o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet)o1;
            Tank t = (Tank)o2;

            if(b.getGroup() ==t.getGroup()) return true;

            if(b.rec.intersects(t.rec)){
                t.die();
                b.die();
                int ex = t.getX() + Tank.WIDTH/2 - Expolde.WIDTH/2;
                int ey = t.getY() + Tank.HEIGHT/2 - Expolde.HEIGHT/2;
                new Expolde(ex,ey);
                return false;
            }
        } else if(o2 instanceof Bullet && o1 instanceof Tank){
            return collide(o2,o1);
        }
        return true;
    }
}
