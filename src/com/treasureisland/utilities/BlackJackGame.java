//package com.treasureisland.utilities;
//
//import com.treasureisland.Attributes;
//import com.treasureisland.gui.Board;
//
//import java.awt.event.KeyEvent;
//
//public class BlackJackGame {
//    public static int player_random1 = 100;
//    public static int player_random2 = 100;
//    public static int dealer_random1 = 100;
//    public static int dealer_random2 = 100;
//    public static int player_total;
//    public static int dealer_total;
//
//    public static void hitDecision(boolean tf) {
//        while (true) {
//            System.out.println("player hit next hand");
//            int player_random3 = 100;
//            while (player_random3 >= 12 || player_random3 < 3) {
//                player_random3 = (int) (Math.random() * 100);
//            }
//            player_total = player_total + player_random3;
//
//            MyMethods.setMessage("You drew a: " + player_random3 + ". Your new total is: " + player_total);
//            if (player_total > 21) {
//                MyMethods.setMessage2("Busted! Dealer wins!");
//                return;
//            } else if (player_total == 21) {
//                MyMethods.setMessage2("You Win!");
//                return;
//            }
//            MyMethods.setMessage3("Would you like to Hit[Y] or Stay[N]");
//
//        }
//        if (false) {
//            System.out.println("Player stayed next hand");
//            int dealer_random3 = 100;
//            while (dealer_random3 >= 12 || dealer_random3 < 3) {
//                dealer_random3 = (int) (Math.random() * 100);
//            }
//            MyMethods.setMessage("Okay, dealer's turn... His hidden card was: " + dealer_random2 + " and his total was: " + dealer_total);
//
//            if (dealer_total > 16) {
//                MyMethods.setMessage2("Dealer stays.");
//            } else {
//                while (dealer_total <= 16) {
//                    dealer_total = dealer_total + dealer_random3;
//                    MyMethods.setMessage2("Dealer chooses to hit... He draws a: " + dealer_random3 + ". His total is: " + dealer_total);
//                }
//            }
//
//            MyMethods.setMessage3("Dealer's total is: " + dealer_total + ". Your total is: " + player_total);
//
//            if ((player_total > dealer_total && player_total < 21) || dealer_total > 21) {
//                MyMethods.setMessage4("YOU WIN!");
//                return;
//            } else if ((dealer_total < 21 && player_total < dealer_total) || player_total > 21) {
//                MyMethods.setMessage4("Dealer wins!");
//                return;
//            }
//        }
//    }
//
//
//
//    public static void playBlackJack() {
//        if (Attributes.player.getsGold() >= 1) {
//            while (player_random1 >= 12 || player_random2 >= 12 || player_random1 < 3 || player_random2 < 3) {
//                player_random1 = (int) (Math.random() * 100);
//                player_random2 = (int) (Math.random() * 100);
//            }
//
//            player_total = player_random1 + player_random2;
//
//            // Dealer cards
//
//
//            while (dealer_random1 >= 12 || dealer_random2 >= 12 || dealer_random1 < 3 || dealer_random2 < 3) {
//                dealer_random1 = (int) (Math.random() * 100);
//                dealer_random2 = (int) (Math.random() * 100);
//            }
//
//            int dealer_total = dealer_random1 + dealer_random2;
//
//            boolean hidden = Math.random() < 0.5; // to decide whether to hide one card or not
//
//            if (player_total == 21) {
//                MyMethods.setMessage("Blackjack! Player Wins!");
//
//                return;
//
//            }
//            else {
//                System.out.println();
//                System.out.println("hand1");
//                MyMethods.setMessage("You get a: " + player_random1 + " and a: " + player_random2 + " Your total is: " + player_total);
//                if (hidden == true) {
//                    MyMethods.setMessage2("The dealer has a " + dealer_random1 + " showing and a hidden card. His total is hidden too");
//                }
//                else {
//                    MyMethods.setMessage2("The dealer has a " + dealer_random1 + " showing  and a " + dealer_random2 + ". Dealer Total is: " + dealer_total);
//                    if (dealer_total == 21) {
//                        MyMethods.setMessage3("Blackjack! Dealer Wins!");
//                        return;
//                    }
//                }
//                MyMethods.setMessage3("Would you like to Hit[Y] or Stay[N]");
//
//
//            }
//
//
//        }
//        else {
//            MyMethods.setMessage("You don't have enough Gold to play");
//        }
//    }
//
//}
