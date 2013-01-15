package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class Adam extends Contender {

    public Adam() {
        this.name = "Awesom-O";
        this.age = 19;
    }

    @Override
    public void AI()
    {
        
        if(getHealth() >= 60){
            System.out.println(name + " attacks!");
            attack = true;
            attackPower = 50;
            defensePower = 0;
        }
        
        else if (getHealth() < 60 )
        {
            System.out.println(name + " defends!");
            attack = false;
            attackPower = 0;
            defensePower = 20;
        }
    }
}
