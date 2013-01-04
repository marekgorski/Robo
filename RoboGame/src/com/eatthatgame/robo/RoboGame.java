package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;
import java.util.ArrayList;

public class RoboGame {

    public static void main(String[] args) {
        
        ArrayList<Contender> contenders = new ArrayList<Contender>();
        Contender contender;
        contender = new Adam();
        contenders.add(contender);
        contender = new BlueRobo();
        contenders.add(contender);
        contender = new HugoRobo();
        contenders.add(contender);
        contender = new JayGundam();
        contenders.add(contender);
        contender = new John();
        contenders.add(contender);
        contender = new NathanRobo();
        contenders.add(contender);
        contender = new RedRobo();
        contenders.add(contender);
        contender = new Tania();
        contenders.add(contender);
        
        int extraContendersNeeded = contenders.size() % 2;
        
        if(extraContendersNeeded > 0) {
            contender = new Contender();
            contender.name = "Unpaid Extra";
            contenders.add(contender);
        }
        
        int contenderCount = 1;
        System.out.println("Contenders entering the league today are:");
        for(Contender c:contenders) {
            System.out.println(contenderCount + ". " + c.name);
            contenderCount++;
        }

        League league = new League(contenders);
        
    }

}


