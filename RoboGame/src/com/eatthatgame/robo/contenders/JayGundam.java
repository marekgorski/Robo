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
        if(getHealth() > 70)
        {
            this.attackPower = 47;
            this.defensePower = 0;
            attack = true;
        }
        else if(getHealth() < 70 && getHealth() > 50)
        {
            this.attackPower = 57;
            this.defensePower = 0;
            attack = true;
        }
        else if(getHealth() < 50 && getHealth() > 20)
        {
            this.attackPower = 0;
            this.defensePower = 20;
            attack = false;
        }
    }
    
   
    @Override
    public void AI(Contender opponent) 
    {
        if(getHealth() > opponent.getHealth()) {
            attack = true;
        } else {
            attack = false;
        }
    }
    
}
