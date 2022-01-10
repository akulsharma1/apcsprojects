package blackjack;

public class card {
    private String name;
    private String suit;
    private int value;

    public card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}
