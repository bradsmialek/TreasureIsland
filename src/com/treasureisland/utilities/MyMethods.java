package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.*;
//import sun.security.pkcs11.wrapper.Functions;


import java.sql.Ref;
import java.util.Random;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 5:10 AM
 */
public class MyMethods {

    private static String message = " ";
    private static String message2 = " ";
    private static String message3 = " ";
    private static String message4 = " ";

    public static void initializeTiles(){
        System.out.println(Attributes.currentIsland.toString());
        for (int i = 0; i < Attributes.currentIsland.getHeight()-1; i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth()-1; j++) {
                switch (Attributes.currentIsland.getTile(j,i)) {
                    case PLAYER:
                        Attributes.player.setPos(j, i);
                        break;
//                    case PIRATE:
//                        Attributes.pirates.add(new Pirate("Pirate", x, y, 10, 2, 2));
                    default:
                        break;
                }
            }
        }
    }

    //TODO test me
    public static int getRandomNumber(int n) {
        Random rand = new Random();
//        if ()
        return rand.nextInt(n) +1;
    }

    public static void playerHandler(Directions dir) throws Exception {
        Tile tile = null;

        switch(dir) {
            case UP:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX(), Attributes.player.getPosY()-1);
                break;
            case LEFT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX()-1, Attributes.player.getPosY());
                break;
            case DOWN:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX(), Attributes.player.getPosY()+1);
                break;
            case RIGHT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX()+1, Attributes.player.getPosY());
                break;
        }

        //Handles the player movement
        switch(tile){
            case NOTHING:
                Attributes.player.move(dir);
                // every time player moves previous displayed message will dissapear
                message = " ";
                message2 = " ";
                message3 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
                message2 = " ";
                message3 = " ";
                break;
            case DOCK:
                Attributes.player.move(dir);
                Attributes.currentIsland = new Island(1);
                Attributes.currentMap = new Maps(1);
                message = "You have returned to your Ship!";
                message2 = " ";
                message3 = " ";
                MyMethods.initializeTiles();
                break; //Randomly change floor
            case RUM:
                message = "You found Rum! Do you want to drink it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.RUM_UP;
                break;
            case GOLD:
                Attributes.player.move(dir);
                Attributes.player.addsGold(MyMethods.getRandomNumber(3)+2);
                message = "You picked up gold!";
                message2 = " ";
                message3 = " ";
                break;
            case TREASURE:
                break; //Ask to open chest
            case KEY:
                Attributes.player.move(dir);
                Attributes.player.addsKey();
                message = "You picked up a normal key! Must be something nearby to unlock?";
                message2 = " ";
                message3 = " ";
                break; //Adds a key
            case DOOR:
                break; //Ask to open door
            case PIRATE:
                Attributes.player.damage(MyMethods.getRandomNumber(2));
                message = "You fought a pirate and took damage!";
                message2 = " ";
                message3 = " ";
                break; //Handles encounters with pirates
            case FRIENDLY:
                message = RandomMessage.randomMessageGenerator();
                break; //Handles encounters with pirates
            case MAP:
                message = "Where would you like to sail to?";
                message2 = "Island Two     Island Three";
                message3 = "    [2]             [3]    ";
                locationDecided = LocationDecision.LOCATION;
                break;
            case VENDOR:
                message = "What would you like to Buy?";
                message2 = "list of stuff";
                //Attributes.vendorItems.getAll();
                message3 = Attributes.vendorItems.getAll();
                // deduct from coins depending on item cost
                //itemDecided = itemDecision.ITEMS;  or something like this
                break;
            case BLACKJACK:
                message = "Would you like to play BlackJack for 1 Gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.PLAY_BLACKJACK;
                break;
            case POI:
                PeopleInterest.poiTree(Entity.getPosX(), Entity.getPosY(), Island.getIslandName(Island.getIslandNumber()));

                message = "should tell story";
                message2 = " ";
                message3 = " ";
                break;
            default:
                System.out.println("???");
                break; //If something glitches out
        }
    }


    private enum LocationDecision {
        LOCATION,
        NOWHERE;
    }

    private enum Decision {
        NONE,
        RUM_UP,
        PLAY_BLACKJACK,
        HIT,
        BJ;
    }
    private static LocationDecision locationDecided = LocationDecision.NOWHERE;

    private static Decision decided = Decision.NONE;
    //private static //something location = //whatever

    //DECISION TREE
    public static void decisionTree(boolean yn) {
        System.out.println(yn);
        if (decided == Decision.NONE) {
            return;
        }
        else if(decided == Decision.RUM_UP && yn) {
            Attributes.player.heal(MyMethods.getRandomNumber(5)+3);
            message = "You drank Rum and it gave you health.";
            message2 = "";
            message3 = "";
            Attributes.player.move();//replace tile to .
        }
        else if(decided == Decision.RUM_UP) {
            message = "I'm too drunk already!";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.PLAY_BLACKJACK && yn) {
            if (Attributes.player.getsGold() >= 1) {
                // Player cards
                int player_random1 = 100;
                int player_random2 = 100;

                while (player_random1 >= 12 || player_random2 >= 12 || player_random1 < 3 || player_random2 < 3) {
                    player_random1 = (int) (Math.random() * 100);
                    player_random2 = (int) (Math.random() * 100);
                }

                int player_total = player_random1 + player_random2;

                // Dealer cards
                int dealer_random1 = 100;
                int dealer_random2 = 100;

                while (dealer_random1 >= 12 || dealer_random2 >= 12 || dealer_random1 < 3 || dealer_random2 < 3) {
                    dealer_random1 = (int) (Math.random() * 100);
                    dealer_random2 = (int) (Math.random() * 100);
                }

                int dealer_total = dealer_random1 + dealer_random2;

                boolean hidden = Math.random() < 0.5; // to decide whether to hide one card or not

                if (player_total == 21) {
                    message = "Blackjack! Player Wins!";
                    return;
                } else {
                    System.out.println();
                    message = "You get a: " + player_random1 + " and a: " + player_random2 + " Your total is: " + player_total;
                    if (hidden == true) {
                        message2 = "The dealer has a " + dealer_random1 + " showing and a hidden card. His total is hidden too";
                    } else {
                        message2 = "The dealer has a " + dealer_random1 + " showing  and a " + dealer_random2 + ". Dealer Total is: " + dealer_total;
                        if (dealer_total == 21) {
                            message3 = "Blackjack! Dealer Wins!";
                            return;
                        }
                    }
                    message3 = "Would you like to Hit[Y] or Stay[N]";
                    decided = Decision.HIT;
                }
                while (decided == Decision.HIT && yn) {
                    int player_random3 = 100;
                    while (player_random3 >= 12 || player_random3 < 3) {
                        player_random3 = (int) (Math.random() * 100);
                    }
                    player_total = player_total + player_random3;

                    message = "You drew a: " + player_random3 + ". Your new total is: " + player_total;
                    if (player_total > 21) {
                        message2 = "Busted! Dealer wins!";
                        return;
                    } else if (player_total == 21) {
                        message2 = "You Win!";
                        return;
                    }
                    message3 = "Would you like to Hit[Y] or Stay[N]";

                }
                if (decided == Decision.HIT) {
                    int dealer_random3 = 100;
                    while (dealer_random3 >= 12 || dealer_random3 < 3) {
                        dealer_random3 = (int) (Math.random() * 100);
                    }
                    message = "Okay, dealer's turn... His hidden card was: " + dealer_random2 + " and his total was: " + dealer_total;

                    if (dealer_total > 16) {
                        message2 = "Dealer stays.";
                    } else {
                        while (dealer_total <= 16) {
                            dealer_total = dealer_total + dealer_random3;
                            message2 = "Dealer chooses to hit... He draws a: " + dealer_random3 + ". His total is: " + dealer_total;
                        }
                    }

                    message3 = "Dealer's total is: " + dealer_total + ". Your total is: " + player_total;

                    if ((player_total > dealer_total && player_total < 21) || dealer_total > 21) {
                        message4 = "YOU WIN!";
                        return;
                    } else if ((dealer_total < 21 && player_total < dealer_total) || player_total > 21) {
                        message4 = "Dealer wins!";
                        return;
                    }
                }

            }
            else {
                message = "You don't have enough Gold to play";
            }
        }
        else if (decided == Decision.PLAY_BLACKJACK) {
            message = "I'd rather not lose me Gold...";
            message2 = "";
            message3 = "";
        }

            decided = Decision.NONE;

    }

    //LOCATION TREE
    public static void locationTree(int islandNumber) {
        System.out.println(islandNumber);
        if (locationDecided == LocationDecision.NOWHERE) {
            return;
        }
        else if ( islandNumber == 2) {
            Attributes.currentIsland = new Island(2);
            Attributes.currentMap = new Maps(2);

        }
        else if (islandNumber == 3) {
            Attributes.currentIsland = new Island(3);
            Attributes.currentMap = new Maps(3);
        }
        else {
            message = "I'm fine exploring here.";
        }
        locationDecided = LocationDecision.NOWHERE;
    }


    public static String getMessage() {return message;}

    public static String getMessage2() {return message2;}

    public static String getMessage3() {return message3;}

    public static void checkIsDead() {
        if(Attributes.player.getHealth()<=0) {
            System.out.println("You Died!");
            Attributes.player.setDead();
        }
    }

}


