package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class JayGundam extends Contender {
            
    public JayGundam() 
    {
        this.name = "Freedom";
        this.age = 1;
        this.attackPower = 18; // DEATH BEAM!!!! Available for kids ages 8+
        this.defensePower = 10;
    }
    
    @Override
    public void AI()
    {
        if(getHealth() > 40)
        {
            System.out.println(name + " attacks!");
            attack = true;
        }
        else if (getHealth() < 40 && getHealth() > 20)
        {
            System.out.println(name + " defends!");
            attack = false;
        }
        else if (getHealth() < 5 && getHealth() > 1)
        {
            System.out.println(name + " is self destructing!!!");
            attackPower = 40;
            attack = true;
        }
    }
    
}