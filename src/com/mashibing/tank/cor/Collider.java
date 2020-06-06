package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

/**
 * Created by ycd on 2020/6/6 10:17 上午
 */
public interface Collider {
    boolean collide(GameObject o1,GameObject o2);
}
