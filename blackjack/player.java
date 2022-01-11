package blackjack;

public class player {
    private int bankroll;
    private String name;

    public player(String name) {
        this.name = name;
        bankroll = 500;
    }
    public player(String name, int bankroll) {
        this.name = name;
        this.bankroll = bankroll;
    }

    public int getBankroll() {
        return bankroll;
    }

    public String getName() {
        return name;
    }

    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }
}
