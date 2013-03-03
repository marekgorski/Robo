package com.eatthatgame.robo;

import java.util.ArrayList;

public class Tournament extends Mode{
    
    ArrayList<ArrayList<Contender>> TournamentGroups = new ArrayList<ArrayList<Contender>>();
    
    public Tournament(ArrayList<Contender> contendersList) {
        super(contendersList);
    }
    
    @Override
    public void matchUp(){
        
        System.out.println("\n===================================================");
        System.out.println("==========Tournament Mode Match Up Begins==========");
        System.out.println("===================================================");
        
        if (contenders.size()<= 0 ) {
            System.out.println("===================================================");
            System.out.println("==============There Are No Contenders==============");
            System.out.println("===================================================");
            
        } else if(contenders.size()>1) {
        
        for(int i=5; i<6 && i>2 ;i--) {
            
            if (contenders.size() % i == 0) {            
                numOfGroups = contenders.size()/i;
                numOfContendersPerGroup = i;
//                System.out.println("i: " + i);
//                System.out.println("numOfContendersPerGroup: " + numOfContendersPerGroup);
//                System.out.println("numOfGroups: " + numOfGroups);
            }
        }
                
        for(int i=0; i<numOfGroups; i++) {
                    
            group = new Group("Group " + i, numOfContendersPerGroup);
            groups.add(group);
            
            for (int j=0; j<numOfContendersPerGroup; j++) {
            randomContenderID = (int) (Math.random()*contenders.size());
            Contender a = (Contender) contenders.remove(randomContenderID);                       

            (groups.get(i)).add(a);
            }
                
            if(i==numOfGroups-1){
                System.out.println("\nGroup Overview:");
                
                for(int k=0; k<numOfGroups; k++) {
                    System.out.println(groups.get(k).getGNumber() + ": " + (groups.get(k)).showG() );
                }
            }
        }
        
            for(int i=0; i<numOfGroups; i++) {
                System.out.println("\n== " + groups.get(i).getGNumber());

                for(int j = 0; j < numOfContendersPerGroup; j++) {
                    System.out.println((j+1) + ": " + groups.get(i).member(j).name);
                }
            }
        }

        for(int i=0; i<numOfGroups; i++) {
            System.out.println("\n== " + groups.get(i).getGNumber() + " Matches:");
            
            for(int k=0, l=1, m=1; k<numOfContendersPerGroup && l<numOfContendersPerGroup; l++, m++) {
                
                if(groups.get(i).member(k).name.length()<4){
                    System.out.println((m) + ": " + groups.get(i).member(k).name + 
                        "\t\t" + "vs" +
                        "\t" + groups.get(i).member(l).name);
                    
                } else if (groups.get(i).member(k).name.length()>=4) {
                    System.out.println((m) + ": " + groups.get(i).member(k).name + 
                        "\t" + "vs" +
                        "\t" + groups.get(i).member((l)).name);
                }
//                System.out.println("k: " + k);
//                System.out.println("l: " + l);
//                System.out.println("m: " + m);               
                               
                if(l==(numOfContendersPerGroup-1)){
                    k++;
                    l=k;
                }
            }
        }
        
        for(int i=0; i<numOfGroups; i++) {
            for(int k=0, l=1, m=1; k<numOfContendersPerGroup && l<numOfContendersPerGroup; l++, m++) {
                super.a = groups.get(i).member(k);
                super.b = groups.get(i).member(l);
                System.out.println("");
                System.out.println("== Battle " + m +": " + a.name + "\t vs \t" + b.name);
                super.battle();
                
                    if(a.alive() == false && b.alive() == true){
                        b.totalPoints += 3;
                        System.out.println(b.name + ": " + "+" + 3 + " points");
                    } else if(a.alive() == true && b.alive() == false) {
                        a.totalPoints += 3;
                        System.out.println(a.name + ": " + a.totalPoints + " points");
                    } else if(a.alive() == false && b.alive() == false) {
                        a.totalPoints +=1;
                        b.totalPoints +=1;
                        System.out.println("== Points: " + 
                                a.name + ": " + a.totalPoints + "\t" +
                                b.name + ": " + b.totalPoints);
                    } else if(a.alive() == true && b.alive() == true && roundCount == MAX_ROUNDS){
                       a.totalPoints +=1;
                       b.totalPoints +=1;
                       System.out.println("== Points: " + 
                               a.name + ": " + a.totalPoints + "\t" +
                               b.name + ": " + b.totalPoints);                         
                    }
                    
                    if(l==(numOfContendersPerGroup-1)){
                        k++;
                        l=k;
                    }                    
            }
        }
        
        for(int i=0; i<numOfGroups; i++) {
            System.out.println("\n== " + groups.get(i).getGNumber());

            for(int j = 0; j < numOfContendersPerGroup; j++) {
                if(groups.get(i).member(j).name.length()<4){
                    System.out.println((j+1) + ": " + groups.get(i).member(j).name + "\t\t" + groups.get(i).member(j).totalPoints);
                } else if(groups.get(i).member(j).name.length()>=4){
                    System.out.println((j+1) + ": " + groups.get(i).member(j).name + "\t" + groups.get(i).member(j).totalPoints);
                }
            }
        }
        
//        for(int i=0; i<numOfGroups; i++) {
//            System.out.println("\n== " + groups.get(i).getGNumber());
//
//            for(int j=0, k=1; j<numOfContendersPerGroup && k<numOfContendersPerGroup; k++) {
//                if(groups.get(i).member(j).totalPoints < groups.get(i).member(k).totalPoints){
//                   //group.swap(groups.get(i), j, k);
//                }
//                
//                if(k==(numOfContendersPerGroup-1)){
//                    j++;
//                    k=j;
//                }
//                System.out.println("==");
//                System.out.println("i: " + i);
//                System.out.println("j: " + j);
//                System.out.println("k: " + k);
//            }
//        }
        
        
//                QUESTION:
//                How can I get the size of the arrayList inside the arrayList if the name I have put its an automatic String?
//                groups.get(i).getGNumber().size()  ,  groups.get(i).gNumber().size
//                ?? all that getGNumber returns is a string with the name of the arrayList inside the arrayList 
//                so the computer doesn't acknowledge that I want the arrayList with that name?

    }      
}