package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;
import java.util.ArrayList;

public class RoboGame {

    public static void main(String[] args) {
        
        ArrayList<Contender> contenders = new ArrayList<Contender>();
        Contender contender;
        contender = new Adam();
        contenders.add(contender);
        contender = new JayGundam();
        contenders.add(contender);    

        League league = new League(contenders);
        
    }

}


