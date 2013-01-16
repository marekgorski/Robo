package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;
import java.util.ArrayList;

public class RoboGame {

    public static void main(String[] args) {
        
        ArrayList<Contender> leagueContenders = getContenders();
        
        CareerMode careerMode = new CareerMode(leagueContenders);
        careerMode.matchUp();
        
        //LastManStanding lastManStanding = new LastManStanding(leagueContenders);
        //lastManStanding.matchUp();
        
        //RandomMatchUp randomMatchUp = new RandomMatchUp(leagueContenders);
        //randomMatchUp.matchUp();
        
        //TeamDeathmatch dm = new TeamDeathmatch(leagueContenders);
        //dm.matchUp();
        
        //RandomMatchUp2v2 rand2v2 = new RandomMatchUp2v2(leagueContenders);
        //rand2v2.matchUp();
        
        

        
    }

    private static ArrayList<Contender> getContenders() {
        ArrayList<Contender> contenders = new ArrayList<Contender>();
        Contender contender;
        contender = new Adam();
        contenders.add(contender);
        contender = new BooBoo();
        contenders.add(contender);
        contender = new HugoRobo();
        contenders.add(contender);
        contender = new JayGundam(); // 3
        contenders.add(contender);
        contender = new John();
        contenders.add(contender);
        contender = new NathanRobo(); // 5
        contenders.add(contender);
        contender = new Tania();
        contenders.add(contender);
        contender = new YogiBear();
        contenders.add(contender);
        
        int extraContendersNeeded = contenders.size() % 2;
        
        if(extraContendersNeeded > 0) {
            contender = new Contender();
            contender.name = "Unpaid Extra";
            contenders.add(contender);
        } else if (contenders.isEmpty()) {
            contender = new Contender();
            contender.name = "Bob";
            contenders.add(contender);
            contender = new Contender();
            contender.name = "Joe";
            contenders.add(contender);
        }
        
        int contenderCount = 1;
        System.out.println("Contenders entering the league today are:");
        for(Contender c:contenders) {
            System.out.println(contenderCount + ". " + c.name);
            contenderCount++;
        }
        
        return contenders;
    }

}


