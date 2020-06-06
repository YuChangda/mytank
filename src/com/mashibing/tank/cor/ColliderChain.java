package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ycd on 2020/6/6 12:26 下午
 */
public class ColliderChain implements Collider{
    List<Collider> colliders = new LinkedList<>();
    public ColliderChain(){
        add(new TankTankCollider());
        add(new BulletTankCollider());
    }
    public void add(Collider collider){
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
