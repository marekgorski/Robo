package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class HugoRobo extends Contender {

    public HugoRobo() {
        this.name = "Omega";
        this.age = 23;
        this.attackPower = 25;
        this.defensePower = 10;
    }
    
     @Override
    public void AI()
    {
        if(getHealth() >= 90)
        {
            this.attackPower = 60;
            this.defensePower = 0;
//            System.out.println(name + " attacks!" + "\n" +
//                    "attackPower: " + this.attackPower + " " +
//                    "health: " + this.getHealth());
            attack = true;
        }
        else if (getHealth() >= 60 && getHealth() < 90)
        {
            this.attackPower = 30;
            this.defensePower = 0;
//            System.out.println(name + " attacks!" + "\n" +
//                    "attackPower: " + this.attackPower + " " +
//                    "health: " + this.getHealth());
            attack = true;
        }
        else if (getHealth() >= 50 && getHealth() < 60)
        {
            this.attackPower = 0;
            this.defensePower = 20;
//            System.out.println(name + " defends!" + "\n" +
//                    "defensePower: " + this.defensePower + " " +
//                    "health: " + this.getHealth());
            attack = false;
        }
        else if (getHealth() >= 30 && getHealth() < 50)
        {
            this.attackPower = 0;
            this.defensePower = 20;
//            System.out.println(name + " defends!" + "\n" +
//                    "defensePower: " + this.defensePower + " " +
//                    "health: " + this.getHealth());
            attack = false;
        }
        else if (getHealth() >= 1 && getHealth() < 30)
        {
            this.attackPower = 0;
            this.defensePower = 30;
//            System.out.println(name + " defends!" + "\n" +
//                    "defensePower: " + this.defensePower + " " +
//                    "health: " + this.getHealth());            
            attack = false;
        }
    }
}

