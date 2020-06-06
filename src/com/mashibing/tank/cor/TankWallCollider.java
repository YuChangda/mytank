package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

/**
 * Created by ycd on 2020/6/6 10:20 上午
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if( o1 instanceof Wall && o2 instanceof Tank){
            Wall w = (Wall)o1;
            Tank t = (Tank)o2;
            if(t.rec.intersects(w.rec)){
                t.back();
            }
        } else if(o2 instanceof Wall && o1 instanceof Tank){
            return collide(o2,o1);
        }
        return true;
    }
}
