package blackjack;

import java.util.ArrayList;
public class deck {
    private static ArrayList<card> cards = new ArrayList<card>();

    public deck() {
        for (int i = 2; i <= 10; i++) {
            cards.add(new card(Integer.toString(i), "spades", i));
            cards.add(new card(Integer.toString(i), "hearts", i));
            cards.add(new card(Integer.toString(i), "clubs", i));
            cards.add(new card(Integer.toString(i), "diamonds", i));
        }
        
        cards.add(new card("Jack", "spades", 10));
        cards.add(new card("Jack", "hearts", 10));
        cards.add(new card("Jack", "clubs", 10));
        cards.add(new card("Jack", "diamonds", 10));

        cards.add(new card("Queen", "spades", 10));
        cards.add(new card("Queen", "hearts", 10));
        cards.add(new card("Queen", "clubs", 10));
        cards.add(new card("Queen", "diamonds", 10));

        cards.add(new card("King", "spades", 10));
        cards.add(new card("King", "hearts", 10));
        cards.add(new card("King", "clubs", 10));
        cards.add(new card("King", "diamonds", 10));

        cards.add(new card("Ace", "spades", 11));
        cards.add(new card("Ace", "hearts", 11));
        cards.add(new card("Ace", "clubs", 11));
        cards.add(new card("Ace", "diamonds", 11));
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = (int) (Math.random() * cards.size());
            card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public ArrayList<card> getCards() {
        return cards;
    }

    public card getCardFromIndex(int index) {
        return cards.get(index);
    }
}
