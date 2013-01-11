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
        if(getHealth() > 60)
        {
            attack = true;
        }
        else if (getHealth() < 60 && getHealth() > 50)
        {
            attack = false;
        }
        else if (getHealth() < 50 && getHealth() > 30)
        {
            attack = true;
        }
        else if (getHealth() < 30 && getHealth() > 10)
        {
            attack = false;
        }
        else if (getHealth() < 10 && getHealth() > 1)
        {
            //Last stand mode, activated in occurence of extremely low health.
            attackPower = 30;
            attack = true;
        }
    }
    
}
