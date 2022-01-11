package blackjack;

import java.util.Scanner;
public class blackjack {
    public static int dealerScore;

    public static void playRound(String name, int balance) {
        Scanner input = new Scanner(System.in);
        final int maxScore = 21;

        int playerCardCounter = 0;
        int dealerCardCounter = 0;
        int deckCounter = 0;

        
        deck cardDeck = new deck();
        cardDeck.shuffle();
        player player = new player(name, balance);

        System.out.println(name+" draws: "+cardDeck.getCardFromIndex(deckCounter).getName()+" of "+cardDeck.getCardFromIndex(deckCounter).getSuit());
        playerCardCounter += cardDeck.getCardFromIndex(deckCounter).getValue();
        deckCounter++;
        System.out.println(name+" draws: "+cardDeck.getCardFromIndex(deckCounter).getName()+" of "+cardDeck.getCardFromIndex(deckCounter).getSuit());
        playerCardCounter += cardDeck.getCardFromIndex(deckCounter).getValue();
        deckCounter++;
        System.out.println("Total value of players cards: "+playerCardCounter);


        System.out.println("Dealer draws: "+cardDeck.getCardFromIndex(deckCounter).getName()+" of "+cardDeck.getCardFromIndex(deckCounter).getSuit());
        dealerCardCounter += cardDeck.getCardFromIndex(deckCounter).getValue();
        System.out.println("Dealer card value: "+dealerCardCounter);
        deckCounter++;
        dealerCardCounter += cardDeck.getCardFromIndex(deckCounter).getValue();
        deckCounter++;
        while (true) {
            System.out.println("Options: \n1. Hit \n2. Stand");
            int option = input.nextInt();
            if (option == 1) {
                System.out.println(name+" draws: "+cardDeck.getCardFromIndex(deckCounter).getName()+" of "+cardDeck.getCardFromIndex(deckCounter).getSuit());
                if (cardDeck.getCardFromIndex(deckCounter).getValue() == -1) {
                    if (playerCardCounter + 11 > maxScore) {
                        playerCardCounter += 1;
                    } else {
                        playerCardCounter += 11;
                    }
                    
                } else {
                    playerCardCounter += cardDeck.getCardFromIndex(deckCounter).getValue();
                }
                deckCounter++;

                if (playerCardCounter > maxScore) {
                    System.out.println(name+" Bust!");
                    break;
                }
            } else if (option == 2) {
                while (true) {
                    System.out.println("Dealer draws: "+cardDeck.getCardFromIndex(deckCounter).getName()+" of "+cardDeck.getCardFromIndex(deckCounter).getSuit());
                    
                    if (dealerCardCounter == 17) {

                    } else if (dealerCardCounter < 17) {

                    } else if (dealerCardCounter > 21){
                        System.out.println("Dealer bust!");
                        break;
                    }
                }
            }
        }


    }
}
