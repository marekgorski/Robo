package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class YogiBear extends Contender {

    public YogiBear() {
        this.name = "Yogi Bear";
        this.age = 47;
        this.attackPower = 15;
        this.defensePower = 25;
    }

    @Override
    public void AI(){
        System.out.println(name + " attacks!");
        this.attack = true;
    }
    
}
