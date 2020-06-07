package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

/**
 * Created by ycd on 2020/6/6 5:48 下午
 */
public class BulletWallCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if(b.rec.intersects(w.rec)){
                b.die();
            }
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collide(o2,o1);
        }
        return true;
    }
}