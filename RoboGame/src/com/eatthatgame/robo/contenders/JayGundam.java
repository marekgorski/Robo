package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class JayGundam extends Contender {
            
    public JayGundam() 
    {
        this.name = "Freedom";
        this.age = 1;
        this.attackPower = 40; // DEATH BEAM!!!! Available for kids ages 8+
        this.defensePower = 10;
    }
    
    @Override
    public void AI()
    {
        if(getHealth() > 80)
        {
            attack = true;
        }
        else if(getHealth() < 80 && getHealth() > 50)
        {
            this.attackPower = 20;
            this.defensePower = 20;
            attack = true;
        }
        else if (getHealth() < 50 && getHealth() > 10)
        {
            this.defensePower = 30;
            attack = false;
        }
        else if (getHealth() < 10 && getHealth() > 1)
        {
            //Last stand mode, activated in occurence of extremely low health.
            attackPower = 50;
            defensePower = 0;
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
