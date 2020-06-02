package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;

/**
 * Created by ycd on 2020/5/31 4:04 下午
 */
public interface FireStrategy {
    void fire(Tank t);
}
