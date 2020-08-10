package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.SubGames;

public class BlackJackGame {
    public static int player_random1 = 100;
    public static int player_random2 = 100;
    public static int dealer_random1 = 100;
    public static int dealer_random2 = 100;
    public static int player_total;
    public static int dealer_total;
    // Used to denote that we are in game right now, user may choose to continue playing at end
    private static boolean GAME_LOOP_IN_PROGRESS = false;

    private static boolean PLAYER_WINS = true;

    public static void playBlackJack() {
        if (Attributes.player.getsGold() >= 1) {
            Attributes.player.takesGold(1);
            GAME_LOOP_IN_PROGRESS = true;
            Attributes.currentSubGame = SubGames.BLACKJACK;
            initGame();
            mainLoop();
        } else {
            MyMethods.setMessage("You don't have enough Gold to play");
            MyMethods.setMessage2(" ");
            MyMethods.setMessage3(" ");
        }
    }

    private static void initGame() {
        while (player_random1 >= 12 || player_random2 >= 12 || player_random1 < 3 || player_random2 < 3) {
            player_random1 = (int) (Math.random() * 100);
            player_random2 = (int) (Math.random() * 100);
        }
        player_total = player_random1 + player_random2;

        // Dealer cards
        while (dealer_random1 >= 12 || dealer_random2 >= 12 || dealer_random1 < 3 || dealer_random2 < 3) {
            dealer_random1 = (int) (Math.random() * 100);
            dealer_random2 = (int) (Math.random() * 100);
        }
    }

    private static void mainLoop() {
        int dealer_total = dealer_random1 + dealer_random2;
        boolean hidden = Math.random() < 0.5; // to decide whether to hide one card or not
        if (player_total == 21) {
            MyMethods.setMessage("Blackjack! Player Wins!");
            return;
        } else {
            System.out.println();
            System.out.println("hand1");
            MyMethods.setMessage("You get a: " + player_random1 + " and a: " + player_random2 + " Your total is: " + player_total);
            if (hidden == true) {
                MyMethods.setMessage2("The dealer has a " + dealer_random1 + " showing and a hidden card. His total is hidden too");
            } else {
                MyMethods.setMessage2("The dealer has a " + dealer_random1 + " showing  and a " + dealer_random2 + ". Dealer Total is: " + dealer_total);
                if (dealer_total == 21) {
                    MyMethods.setMessage3("Blackjack! Dealer Wins!");
                    return;
                }
            }
            MyMethods.setMessage3("Would you like to Hit[Y] or Stay[N]");
        }
    }

    public static void decisionRouting(boolean tf) {
        if(Attributes.currentSubGame != SubGames.BLACKJACK) {
            // we are not currently in a blackjack session so ignore any commands routed here
            return;
        }
        if(GAME_LOOP_IN_PROGRESS) {
            hitDecision(tf);
        } else {
            if(tf){
                playBlackJack();
            } else {
                Attributes.currentSubGame = SubGames.NONE;
                MyMethods.setMessage("Okay thanks for playing");
                MyMethods.setMessage2("Come back anytime for more");
                MyMethods.setMessage3(" ");
            }

        }
    }

    private static void hitDecision(boolean tf) {
        if (tf) {
            System.out.println("player hit next hand");
            int player_random3 = 100;
            while (player_random3 >= 12 || player_random3 < 3) {
                player_random3 = (int) (Math.random() * 100);
            }
            player_total = player_total + player_random3;

            MyMethods.setMessage("You drew a: " + player_random3 + ". Your new total is: " + player_total);
            if (player_total > 21) {
                endGame(!PLAYER_WINS);
                return;
            } else if (player_total == 21) {
                endGame(PLAYER_WINS);
                return;
            }
            MyMethods.setMessage3("Would you like to Hit[Y] or Stay[N]");

        } else {
            System.out.println("Player stayed next hand");
            int dealer_random3 = 100;
            while (dealer_random3 >= 12 || dealer_random3 < 3) {
                dealer_random3 = (int) (Math.random() * 100);
            }
            MyMethods.setMessage("Okay, dealer's turn... His hidden card was: " + dealer_random2 + " and his total was: " + dealer_total);

            if (dealer_total > 16) {
                MyMethods.setMessage2("Dealer stays.");
            } else {
                while (dealer_total <= 16) {
                    dealer_total = dealer_total + dealer_random3;
                    MyMethods.setMessage2("Dealer chooses to hit... He draws a: " + dealer_random3 + ". His total is: " + dealer_total);
                }
            }

            MyMethods.setMessage3("Dealer's total is: " + dealer_total + ". Your total is: " + player_total);
            if ((player_total > dealer_total && player_total < 21) || dealer_total > 21) {
                endGame(PLAYER_WINS);
                return;
            } else if ((dealer_total < 21 && player_total < dealer_total) || player_total > 21) {
                endGame(!PLAYER_WINS);
                return;
            }
        }
    }

    public static void endGame(boolean playerWins) {
        MyMethods.setMessage2(playerWins ? "YOU WIN!" : "Busted! Dealer wins!");
        MyMethods.setMessage3("Would you like to play again [y] or [N]");
        GAME_LOOP_IN_PROGRESS = false;
        if(playerWins) {
            Attributes.player.addsGold(2);
        }
    }
}
