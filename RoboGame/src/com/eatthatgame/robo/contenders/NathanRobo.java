package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class NathanRobo extends Contender {

    public NathanRobo() {
        this.name = "Max";
        this.age = 6;
        this.attackPower = 40;
        this.defensePower = 35;
    }
    @Override
    public void AI(){
        if(attack) {
            System.out.println(name + " defends!");
            attack = false;
        } else {
            System.out.println(name + " attacks!");
            attack = true;
        }
    }

}