package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;

public class RoboGame {

    public static void main(String[] args) {
        
        Contender contenderA = new Adam();
        Contender contenderB = new JayGundam();

        League league = new League(contenderA, contenderB);
        
    }

}


