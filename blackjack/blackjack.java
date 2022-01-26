package blackjack;

import java.util.Scanner;
import java.util.ArrayList;
public class blackjack {
    public static int dealerScore;

    public static boolean dealerGot11Ace = false;
    public static deck deck = new deck();

    public static ArrayList<Integer> dealerFirstPlay() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int deckValue = 0;
        int dealerScore = 0;
        
        list.add(0);
        list.add(0); // placeholder
        card card1 = deck.getCardFromIndex(deckValue);
        dealerScore += card1.getValue();
        System.out.println("Dealer draws a " + card1.getName() +" of "+card1.getSuit() + ".");
        deckValue++;
        list.add(dealerScore);


        // card card2 = deck.getCardFromIndex(deckValue);
        // dealerScore += card2.getValue();
        // System.out.println("Dealer draws a " + card2.getName() +" of "+card2.getSuit() + ".");
        // deckValue++;
        list.set(0, deckValue);

        return list;
    }
    public static ArrayList<Integer> dealerSecondPlay(player player, ArrayList<Integer> details) {
        int deckValue = details.get(0);
        int dealerScore = details.get(2);

        card card1 = deck.getCardFromIndex(deckValue);
        dealerScore += card1.getValue();
        System.out.println("Dealer's hidden card was a " + card1.getName() +" of "+card1.getSuit() + ".");
        deckValue++;

        while (dealerScore <= 17) {
            card card = deck.getCardFromIndex(deckValue);
            System.out.println("Dealer draws a " + card.getName() +" of "+card.getSuit() + ".");
            if (card.getValue() == 11) {
                if (dealerScore + 11 > 21) {
                    dealerScore += 1;
                } else {
                    dealerScore += 11;
                }
            } else {
                dealerScore += card.getValue();
            }
            
            deckValue++;
        }
        details.add(dealerScore);
        details.set(0, deckValue);

        return details;
    }
    public static ArrayList<Integer> playerPlays(player player, ArrayList<Integer> details) {
        Scanner input = new Scanner(System.in);
        int playerScore = 0;
        int deckValue = details.get(0);
        // details(0) = current index of deck
        // details(1) = current score of player 
        // details(2) = 1 hit score of dealer
        // details(3) == 2 hit score of dealer
        

        // play 1
        card card1 = deck.getCardFromIndex(deckValue);
        playerScore += card1.getValue();
        System.out.println(player.getName() +" Draws a " + card1.getName() +" of "+card1.getSuit() + ".");
        deckValue++;

        // play 2
        card card2 = deck.getCardFromIndex(deckValue);
        playerScore += card2.getValue();
        System.out.println(player.getName() +" Draws a " + card2.getName() +" of "+card2.getSuit() + ".");
        
        deckValue++;

        System.out.println("Dealer score is: " + details.get(2));
        // play until player busts or chooses to stay
        while (true) {
            System.out.println("Your current score is " + playerScore + ".");
            System.out.println("Press 1 to hit. Press 2 to stand");
            int playerChoice = input.nextInt();
            input.nextLine();
            if (playerChoice == 1) {
                
                card card = deck.getCardFromIndex(deckValue);
                System.out.println(player.getName()+" draws a " + card.getName() +" of "+card.getSuit() + ".");
                if (card.getValue() == 11) {
                    if (playerScore + 11 > 21) {
                        playerScore++;
                    } else {
                        playerScore += 11;
                    }
                } else {
                    playerScore += card.getValue();
                }
                deckValue++;
                if (playerScore > 21) {
                    int dealerOnePlay = details.get(2);
                    details.set(0, deckValue);
                    details.set(1, playerScore);
                    details.set(2, dealerOnePlay);
                    return details;
                }
            } else {
                int dealerOnePlay = details.get(2);
                details.set(0, deckValue);
                details.set(1, playerScore);
                details.set(2, dealerOnePlay);
                return details;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = input.nextLine();
        player player = new player(name, 500);
        while (player.getBankroll() > 0) {
            System.out.println("Your balance is "+ player.getBankroll()+". Press 1 to Play. Press 2 to Quit.");
            int playerChoice = input.nextInt();
            input.nextLine();

            if (playerChoice != 1) {
                break;
            }
            System.out.println("Enter bet");
            int bet = input.nextInt();
            input.nextLine();

            deck.shuffle();
            ArrayList<Integer> details = dealerFirstPlay();
            details = playerPlays(player, details);
            details = dealerSecondPlay(player, details);
            if (details.get(1) > 21) {
                System.out.println(player.getName()+" busted!");
                player.setBankroll(player.getBankroll()-bet);
                continue;
            } else if (details.get(3) > 21) {
                System.out.println(details.get(3));
                System.out.println("Dealer busted!");
                player.setBankroll(player.getBankroll()+(int)(bet * 1.5));
                continue;
            }
            else if (details.get(1) > details.get(3) && details.get(1) <= 21) {
                System.out.println(player.getName()+" wins!");
                player.setBankroll(player.getBankroll()+(int)(bet * 1.5));
                continue;
            } else if (details.get(1) < details.get(3) && details.get(3) <= 21) {
                System.out.println("Dealer wins!");
                player.setBankroll(player.getBankroll()-bet);
                continue;
            } else {
                System.out.println("Tie!");
                continue;
            }
        }
    }
}
