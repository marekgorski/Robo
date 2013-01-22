package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class JayGundam extends Contender {
            
    public JayGundam() 
    {
        this.name = "Freedom";
        this.age = 1;
        this.attackPower = 20;
        this.defensePower = 10;
    }
    
    @Override
    public void AI()
    {
        if(getHealth() > 40)
        {
            this.attackPower = 50;
            this.defensePower = 0;
            attack = true;
        }
        else if(getHealth() < 40 && getHealth() > 20)
        {
            this.attackPower = 0;
             this.defensePower = 40;
            attack = false;
        }
        else if(getHealth() < 20 && getHealth() > 1)
        {
            this.attackPower = 50;
            this.defensePower = 0;
            attack = true;
        }
    }
    
    /*
    @Override
    public void AI(Contender opponent) 
    {
        if(getHealth() > opponent.getHealth()) {
            attack = true;
        } else {
            attack = false;
        }
        if(opponent.("Omega")) {
            attack = true;
        } else {
            attack = false;
        }
    }*/
    
}
