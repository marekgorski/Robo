package com.eatthatgame.robo.contenders;
/**
 * @Author Nathan Cooper
 * Date: 21st January 2013
 
 * //Max Power. He's the man with name you want to touch,
    but you mustn't touch! He's name sounds good in your ear, but when you say it,
    you mustn't fear, 'cause his name can be said by anyone. Homer
 */
import com.eatthatgame.robo.Contender;
import java.util.Random;

public class NathanRobo extends Contender {
/**
 * Define the variables extended from the Contender class
 */
    public NathanRobo() {
        this.name = "Max"; 
        this.age = 6;
        this.attackPower = 28;
        this.defensePower = 18;
        
          }

    /**
     * overriding the default AI with a better AI that changes the whether it attacks or defends and the attack strength and 
     *   defence strength according to the robots health during the current round.
     */
    @Override
    public void AI(){
        int RoboHealth = getHealth();
        
        if( RoboHealth < 75 ) {
            System.out.println(name + " Attacks!");
            this.attackPower = 35;
            this.defensePower = 5;
            attack = true;
            
        }
            
        else if( RoboHealth > 75) {
            System.out.println(name + " Attacks!");
            this.attackPower = 40;
            this.defensePower = 5;
            attack = true;
        }
        else if( RoboHealth > 40) {
            System.out.println(name + " Attacks!");
            this.attackPower = 50;
            this.defensePower = 0;
            attack = true;
        }
        
        else if( RoboHealth > 20) {
            System.out.println(name + " Defends!");
            this.attackPower = 5;
            this.defensePower = 40;
            attack = false;
        }

        else {
            System.out.println(name + " Defends!");
            this.attackPower = 5;
            this.defensePower = 40;
            attack = false;
        }
        
        
    }
        /**
     * A Method to get a random boolean for the changeMove Method.
     * @return true/false
     */
    public boolean getRandomBoolean() {
    Random random = new Random();
    return random.nextBoolean();
    }
    /**
     * A method for getting a random attack. But I found that it is tactically useless. I am
     * leaving it here incase I want to use it for something else latter.
     * @return true/false
     */
    public boolean changeMove(){
    boolean lastMove = false;
    if(lastMove = true){
            System.out.println(name + " Defends!");
            lastMove = false;
            return false;
        }
        else{
            System.out.println(name + " Attacks!"); 
            lastMove = true;
            return true;
        }
    }
}
